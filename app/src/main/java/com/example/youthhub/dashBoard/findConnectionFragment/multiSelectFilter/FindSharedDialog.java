package com.example.youthhub.dashBoard.findConnectionFragment.multiSelectFilter;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.youthhub.R;
import com.example.youthhub.dashBoard.findConnectionFragment.FindConnectionAdapter;
import com.example.youthhub.resModel.connection.shared.SharedProfileResponse;
import com.example.youthhub.retrofit.ApiClient;
import com.example.youthhub.utils.Constants;
import com.example.youthhub.utils.FontTypeFace;
import com.example.youthhub.utils.Loader;
import com.example.youthhub.utils.MyToast;
import com.example.youthhub.utils.NetWorkUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FindSharedDialog extends Dialog {
    Activity activity;
    @BindView(R.id.filter_txt)
    TextView filterTxt;
    @BindView(R.id.dialog_close)
    ImageView dialogClose;

    @BindView(R.id.apply_btn)
    Button applyBtn;
    @BindView(R.id.clear_btn)
    Button clearBtn;
    @BindView(R.id.title_search)
    TextView titleSearch;

    private OnPassDataListener onPassDataListener;
    boolean completed = false;
    String usercodedata = "";
    Button shared;
    public FindSharedDialog(Activity activity, String usercodedata, Button shared) {
        super(activity);
        this.activity = activity;
        this.usercodedata = usercodedata;
        this.shared = shared;

    }

    public void setOnPassDataListener(OnPassDataListener onPassDataListener) {
        this.onPassDataListener = onPassDataListener;
    }

    public FindSharedDialog(Activity activity) {
        super(activity);
        this.activity = activity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.shared_dialog);
        ButterKnife.bind(this);
        callTypeFace();
        clear_all();
    }

    private void callTypeFace() {
        filterTxt.setTypeface(FontTypeFace.fontBold(activity));
        applyBtn.setTypeface(FontTypeFace.fontBold(activity));
        clearBtn.setTypeface(FontTypeFace.fontBold(activity));
    }

    private void clear_all() {
        titleSearch.setText("");
if (completed){
    filterTxt.setText("Success : Shared Profile");
    titleSearch.setText("Your profile has now been shared successfully and the navigator will get back to you shortly.");
    applyBtn.setText("OK");
}
    }

    @OnClick({R.id.dialog_close, R.id.apply_btn, R.id.clear_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.dialog_close:
                dismiss();
                break;
            case R.id.apply_btn:
                if (!completed)
                    call_shared_profile();

                break;
            case R.id.clear_btn:
                clear_all();
                dismiss();
                break;
        }
    }


    private void call_shared_profile() {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            Call<SharedProfileResponse> call = ApiClient.getApiInterface().sharedProfile(Constants.getApiKey(activity), Constants.getAccessKey(activity), Constants.getToken(activity),
                    usercodedata);
            call.enqueue(new Callback<SharedProfileResponse>() {


                @Override
                public void onResponse(Call<SharedProfileResponse> call, Response<SharedProfileResponse> response) {
                    if (response.isSuccessful()) {
                        if (response.body() != null) {
                            if (response.body().getStatus() == 1) {
                                shared.setText("Shared");
                                // connectionListMaster = response.body();
                                // shared.setText("Shared");
                          /*      findSharedDialog = new FindSharedDialog(activity,true);
                                findSharedDialog.setOnPassDataListener(FindConnectionAdapter.this);
                                findSharedDialog.show();*/
                                onPassDataListener.passData(true);
                                dismiss();
                            } else {
                                MyToast.errorMessage(response.body().getMessage(), activity);
                            }
                        }
                    } else {
                        Log.d(Constants.failureResponse + " ConListMaster", response.toString());
                    }
                    Loader.showLoad(activity, false);
                }

                @Override
                public void onFailure(@NonNull Call<SharedProfileResponse> call, @NonNull Throwable t) {
                    call_shared_profile();
                    Log.d(Constants.failureResponse + " ConListMaster", t.toString());
                    Loader.showLoad(activity, false);
                }
            });
        }
    }


    private void share() {

        onPassDataListener.passData(false);
    }

    public interface OnPassDataListener {
        void passData(boolean clear);
    }
}
