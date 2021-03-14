package com.example.youthhub.support;


import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatSpinner;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.youthhub.R;
import com.example.youthhub.resModel.supportRes.listmaster.FilterSubcategory;
import com.example.youthhub.resModel.supportRes.listmaster.SupportListMaster;
import com.example.youthhub.utils.FontTypeFace;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SupportListFilterDialog extends Dialog {


    @BindView(R.id.filter_title)
    TextView filterTitle;
    @BindView(R.id.dialog_close)
    ImageView dialogClose;
    @BindView(R.id.filter_search)
    EditText filterSearch;
    @BindView(R.id.status_txt)
    TextView statusTxt;
    @BindView(R.id.status)
    AppCompatSpinner status;
    @BindView(R.id.apply_btn)
    Button applyBtn;
    @BindView(R.id.clear_btn)
    Button clearBtn;

    private SupportListMaster supportListMaster;
    private Activity activity;
    private OnPassDataListener onPassDataListener;
    private FilterSubcategory filterSubcategoryId = null;

    SupportListFilterDialog(Activity activity) {
        super(activity);
        this.activity = activity;
    }

    public void newInstance(SupportListMaster supportListMaster) {
        this.supportListMaster=supportListMaster;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.support_filter_dialog);
        ButterKnife.bind(this);
        callTypeFace();
        init_sub_category_spinner_load();
        sub_category_spinner_load();
    }

    private void init_sub_category_spinner_load() {
        List<String> list = new ArrayList<>();
        list.add(activity.getResources().getString(R.string.select_filter_sub_category));
        ArrayAdapter<String> adapter = new ArrayAdapter<>(activity, R.layout.spinner_text, list);
        adapter.setDropDownViewResource(R.layout.spinner_text);
        status.setAdapter(adapter);
    }

    private void sub_category_spinner_load() {

        List<FilterSubcategory> supportSubcategories = new ArrayList<>();

        final FilterSubcategory Subcategory = new FilterSubcategory();
        Subcategory.setId(null);
        Subcategory.setName(activity.getResources().getString(R.string.select_filter_sub_category));
        supportSubcategories.add(Subcategory);

        supportSubcategories.addAll(supportListMaster.getSupportListMasterData().getFilterSubcategory());

        ArrayAdapter<FilterSubcategory> adapter = new ArrayAdapter<FilterSubcategory>(activity, R.layout.spinner_text, supportSubcategories) {
            @Override
            public boolean isEnabled(int position) {
                return position != 0;
            }

            @Override
            public View getDropDownView(int position, View convertView,
                                        @NonNull ViewGroup parent) {
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
        status.setAdapter(adapter);
        status.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position > 0) {
                    filterSubcategoryId = (FilterSubcategory) parent.getSelectedItem();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
            private void callTypeFace() {
                filterTitle.setTypeface(FontTypeFace.fontBold(activity));
                statusTxt.setTypeface(FontTypeFace.fontBold(activity));
                applyBtn.setTypeface(FontTypeFace.fontBold(activity));
                clearBtn.setTypeface(FontTypeFace.fontBold(activity));
                filterSearch.setTypeface(FontTypeFace.fontBold(activity));
            }

    @OnClick({R.id.apply_btn, R.id.clear_btn, R.id.dialog_close})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.apply_btn:
                pass_Data();
                break;
            case R.id.clear_btn:
                clear_all();
                break;
            case R.id.dialog_close:
                dismiss();
                break;
        }
    }
        private void clear_all() {
           filterSearch.getText().clear();
           filterSubcategoryId=null;
           status.getAdapter().isEmpty();
           init_sub_category_spinner_load();
           sub_category_spinner_load();

        }

    private void pass_Data() {
        String search = "";
        String subCategoryId = "";

        if (!filterSearch.getText().toString().isEmpty()) {
            search = filterSearch.getText().toString();
        }

        if (filterSubcategoryId != null) {
            subCategoryId = filterSubcategoryId.getId().toString();
        }

        onPassDataListener.onPassData( true,subCategoryId,search);
        dismiss();
    }



    public interface OnPassDataListener {
        void onPassData( boolean filter,String subCategoryId,String search);
    }

    void setOnPassDataListener(OnPassDataListener onPassDataListener) {
        this.onPassDataListener = onPassDataListener;
    }
}