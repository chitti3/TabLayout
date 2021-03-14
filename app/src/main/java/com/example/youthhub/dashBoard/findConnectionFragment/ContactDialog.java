package com.example.youthhub.dashBoard.findConnectionFragment;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.youthhub.R;
import com.example.youthhub.utils.FontTypeFace;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ContactDialog extends Dialog {
    Activity activity;
    @BindView(R.id.filter_txt)
    TextView filterTxt;
    @BindView(R.id.dialog_close)
    ImageView dialogClose;
    @BindView(R.id.title_search)
    EditText titleSearch;
    @BindView(R.id.apply_btn)
    Button applyBtn;
    @BindView(R.id.clear_btn)
    Button clearBtn;

    private OnPassDataListener onPassDataListener;

    public void setOnPassDataListener(OnPassDataListener onPassDataListener){
        this.onPassDataListener = onPassDataListener;
    }

    public ContactDialog(Activity activity) {
        super(activity);
        this.activity = activity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.contact_dialog);
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

    }

    @OnClick({R.id.dialog_close, R.id.apply_btn, R.id.clear_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.dialog_close:
                dismiss();
                break;
            case R.id.apply_btn:
                sendDatas();
                titleSearch.setText("");
                dismiss();
                break;
            case R.id.clear_btn:
                clear_all();
                dismiss();
                break;
        }
    }

    private void sendDatas() {

        onPassDataListener.passData(titleSearch.getText().toString(), false);
    }

    public interface OnPassDataListener{
        void passData(String title,boolean clear);
    }
}
