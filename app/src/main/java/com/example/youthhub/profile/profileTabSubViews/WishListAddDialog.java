package com.example.youthhub.profile.profileTabSubViews;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatSpinner;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.youthhub.R;

import com.example.youthhub.resModel.profile.profilemaster.ProfileAddMasterResponse;
import com.example.youthhub.resModel.profile.profilemaster.WishlistItem;
import com.example.youthhub.utils.FontTypeFace;
import com.example.youthhub.utils.MyToast;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.youthhub.profile.ProfileFragment.TAG;

public class WishListAddDialog extends Dialog {

    Activity activity;
    @BindView(R.id.wish_list_txt)
    TextView wishListTxt;
    @BindView(R.id.category_txt)
    TextView categoryTxt;
    @BindView(R.id.category_spinner)
    AppCompatSpinner categorySpinner;
    @BindView(R.id.apply_btn)
    Button applyBtn;
    @BindView(R.id.cancel_btn)
    Button cancelBtn;
    ProfileAddMasterResponse profileAddMasterResponse;
    WishlistItem wishlistItempassData = null;
    Integer wishlistposition =null;
     String wishlistid = null;
    OnPassDataListener onPassDataListener;

    public WishListAddDialog(Activity activity, ProfileAddMasterResponse profileAddMasterResponse) {
        super(activity);
        this.activity = activity;
        this.profileAddMasterResponse = profileAddMasterResponse;
    }

    public WishListAddDialog(Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.wish_list_add_dialog);
        ButterKnife.bind(this);
        callTypeFace();
        updateUi(profileAddMasterResponse);


    }

    private void updateUi(ProfileAddMasterResponse profileAddMasterResponse) {
        wishlist_spinner_load(profileAddMasterResponse);
    }

    private void wishlist_spinner_load(ProfileAddMasterResponse profileAddMasterResponse) {
        List<WishlistItem> wishlistItems = new ArrayList<>();


        WishlistItem wishlistItem = new WishlistItem();
        wishlistItem.setWitTagId(null);
        wishlistItem.setWitName(activity.getResources().getString(R.string.select_wishlist));
        wishlistItems.add(wishlistItem);

        wishlistItems.addAll(profileAddMasterResponse.getData().getWishlist());
        if (wishlistItems.size() > 0) {
            ArrayAdapter<WishlistItem> adapter = new ArrayAdapter<WishlistItem>(activity, R.layout.spinner_text, wishlistItems) {
                @Override
                public boolean isEnabled(int position) {
                    if (position == 0) {
                        // Disable the first item from Spinner
                        // First item will be use for hint
                        return false;
                    } else {
                        return true;
                    }
                }

                @Override
                public View getDropDownView(int position, View convertView,
                                            ViewGroup parent) {
                    View view = super.getDropDownView(position, convertView, parent);
                    TextView tv = (TextView) view;
                    if (position == 0) {
                        // Set the hint text color gray
                        tv.setTextColor(ContextCompat.getColor(activity, R.color.grey));
                    } else {
                        tv.setTextColor(ContextCompat.getColor(activity, R.color.black));
                    }
                    return view;
                }
            };
            adapter.setDropDownViewResource(R.layout.spinner_text);
            categorySpinner.setAdapter(adapter);
            // Log.d("ProfileFilter", "regionListItems_spinner_load: " + new Gson().toJson(regionListItems));
            /*for (int i = 0; i < wishlistItems.size(); i++) {
                if (wishlistItems.get(i).getWitName().equalsIgnoreCase(profileInfoMaster.getData().getYouthInfo().getYthVisaTypeName())) {
                    int spinnerPosition = adapter.getPosition(wishlistItems.get(i));
                    categorySpinner.setSelection(spinnerPosition);
                }
            }*/
            categorySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    wishlistposition = position;
                    if (position > 0) {
                        wishlistItempassData = (WishlistItem) parent.getSelectedItem();
                    } else {
                        wishlistItempassData = null;
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }
    }

    private void callTypeFace() {
        wishListTxt.setTypeface(FontTypeFace.fontBold(activity));
        categoryTxt.setTypeface(FontTypeFace.fontBold(activity));
        applyBtn.setTypeface(FontTypeFace.fontBold(activity));
        cancelBtn.setTypeface(FontTypeFace.fontBold(activity));
    }

    @OnClick({R.id.apply_btn, R.id.cancel_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.apply_btn:
                addWishlist();
                break;
            case R.id.cancel_btn:
                dismiss();
                break;
        }
    }

    private void addWishlist() {

        if (wishlistItempassData != null){
            wishlistid = wishlistItempassData.getWitTagId();

        }


        onPassDataListener.onPassData(wishlistid,true);
        dismiss();
    }

    public interface OnPassDataListener {
        void onPassData(String wishlistid,
                        boolean filter);
    }

     void setOnPassDataListener(OnPassDataListener onPassDataListener) {
        this.onPassDataListener = onPassDataListener;
    }
}
