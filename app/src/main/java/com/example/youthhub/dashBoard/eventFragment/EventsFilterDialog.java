package com.example.youthhub.dashBoard.eventFragment;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.youthhub.R;
import com.example.youthhub.utils.FontTypeFace;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EventsFilterDialog extends Dialog {

    Activity activity;
    @BindView(R.id.filter_txt)
    TextView filterTxt;
    @BindView(R.id.dialog_close)
    ImageView dialogClose;
    @BindView(R.id.title_search)
    EditText titleSearch;
    @BindView(R.id.posted_by_search)
    EditText postedBySearch;
    @BindView(R.id.all_event_radio_btn)
    RadioButton allEventRadioBtn;
    @BindView(R.id.my_location_radio_btn)
    RadioButton myLocationRadioBtn;
    @BindView(R.id.apply_btn)
    Button applyBtn;
    @BindView(R.id.clear_btn)
    Button clearBtn;

    private OnPassDataListener onPassDataListener;

    void setOnPassDataListener(OnPassDataListener onPassDataListener){
        this.onPassDataListener = onPassDataListener;
    }

    EventsFilterDialog(Activity activity) {
        super(activity);
        this.activity = activity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.event_filter_dialog);
        ButterKnife.bind(this);
        callTypeFace();
    }

    private void callTypeFace() {
        filterTxt.setTypeface(FontTypeFace.fontBold(activity));
        applyBtn.setTypeface(FontTypeFace.fontBold(activity));
        clearBtn.setTypeface(FontTypeFace.fontBold(activity));
    }

    @OnClick({R.id.dialog_close, R.id.all_event_radio_btn, R.id.my_location_radio_btn, R.id.apply_btn, R.id.clear_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.dialog_close:
                dismiss();
                break;
            case R.id.all_event_radio_btn:
                myLocationRadioBtn.setChecked(false);
                break;
            case R.id.my_location_radio_btn:
                allEventRadioBtn.setChecked(false);
                break;
            case R.id.apply_btn:
                sendDatas();
                dismiss();
                break;
            case R.id.clear_btn:
                clear_all();
                break;
        }
    }

    private void clear_all() {
        titleSearch.setText("");
        postedBySearch.setText("");
    }

    private void sendDatas() {
        String ismyEvent;
        if(allEventRadioBtn.isChecked()){
            ismyEvent="1";
        }else {
            ismyEvent="2";
        }
        onPassDataListener.passData(titleSearch.getText().toString(),postedBySearch.getText().toString(),ismyEvent, false);
    }

    public interface OnPassDataListener{
        void passData(String title,String postBy,String isMyEvent,boolean clear);
    }

}