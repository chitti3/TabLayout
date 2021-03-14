package com.example.youthhub.dashBoard.dashboard;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.example.youthhub.R;
import com.example.youthhub.dashBoard.DeleteMessageDialog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProfileReportEditDialog extends Dialog implements PostUpdateDialog.OnPassValueListener,DeleteMessageDialog.OnDeleteListener{

    Activity activity;
    @BindView(R.id.report_txt)
    TextView reportTxt;
    @BindView(R.id.edit_txt)
    TextView editTxt;
    @BindView(R.id.delete_txt)
    TextView deleteTxt;

    private String type;
    private String post_code;
    private String description;

    private OnPassValueListener onPassValueListener;

    public void setOnPassValueListener(OnPassValueListener onPassValueListener){
        this.onPassValueListener = onPassValueListener;
    }

    public ProfileReportEditDialog(Activity activity, String post_code, String description, String type) {
        super(activity);
        this.activity = activity;
        this.post_code = post_code;
        this.description = description;
        this.type = type;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.profile_report_edit_dialog);
        ButterKnife.bind(this);
        switch (type) {
            case "EditDelete":
                editTxt.setVisibility(View.VISIBLE);
                deleteTxt.setVisibility(View.VISIBLE);
                reportTxt.setVisibility(View.GONE);
                break;
            case "Report":
                editTxt.setVisibility(View.GONE);
                deleteTxt.setVisibility(View.GONE);
                reportTxt.setVisibility(View.VISIBLE);
                break;
        }
    }

    @OnClick({R.id.report_txt, R.id.edit_txt, R.id.delete_txt})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.report_txt:
                PostUpdateDialog postReportDialog = new PostUpdateDialog(activity, post_code,description,"Report");
                postReportDialog.setOnPassValueListener(this);
                postReportDialog.show();
                break;
            case R.id.edit_txt:
                PostUpdateDialog postUpdateDialog = new PostUpdateDialog(activity, post_code,description,"Update");
                postUpdateDialog.setOnPassValueListener(this);
                postUpdateDialog.show();
                break;
            case R.id.delete_txt:
                DeleteMessageDialog deleteMessageDialog = new DeleteMessageDialog(activity,"Post" ,post_code, null,null);
                deleteMessageDialog.setOnDeleteListener(this);
                deleteMessageDialog.show();
                break;
        }
    }

    @Override
    public void onPassData(String description) {
        onPassValueListener.onPassDescData(description);
        dismiss();
    }

    @Override
    public void onReportData(boolean reported) {
        onPassValueListener.onPassReportData(reported);
        dismiss();
    }

    @Override
    public void OnDelete(boolean deleted) {
        onPassValueListener.onPassDeleteData(deleted);
        dismiss();
    }

    public interface OnPassValueListener{
        void onPassDescData(String description);
        void onPassDeleteData(boolean deleted);
        void onPassReportData(boolean deleted);
    }

}
