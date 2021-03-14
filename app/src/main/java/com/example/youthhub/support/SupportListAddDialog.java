package com.example.youthhub.support;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.youthhub.R;
import com.example.youthhub.UploadFileDialog;
import com.example.youthhub.resModel.supportRes.raiseticket.SupportRaiseTicket;
import com.example.youthhub.retrofit.ApiClient;
import com.example.youthhub.utils.AppUtils;
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

public class SupportListAddDialog extends Dialog {

    private Activity activity;
    private OnPassDataListener onPassDataListener;

    @BindView(R.id.add_ticket_textview)
    TextView addTicketTextview;
    @BindView(R.id.dialog_close)
    ImageView dialogClose;
    @BindView(R.id.subject_textview)
    TextView subjectTextview;
    @BindView(R.id.subject)
    EditText subject;
    @BindView(R.id.description_textview)
    TextView descriptionTextview;
    @BindView(R.id.description)
    EditText description;
    @BindView(R.id.attach_file_textview)
    TextView attachFileTextview;
    @BindView(R.id.attach_file)
    TextView attachFile;
    @BindView(R.id.submit_btn)
    Button submitBtn;

    private SupportRaiseTicket supportRaiseTicket;
    private String subject1 = "";
    private String description1 = "";
    private String fileName="";
    private UploadFileDialog uploadFileDialog;

    SupportListAddDialog(Activity activity) {
        super(activity);
        this.activity = activity;
    }

    public void newInstance(SupportRaiseTicket supportRaiseTicket){
        this.supportRaiseTicket = supportRaiseTicket;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.support_add_dialog);
        ButterKnife.bind(this);
        callTypeFace();
        uploadFileDialog = new UploadFileDialog(activity, "Support");
    }

    private void callTypeFace() {
        addTicketTextview.setTypeface(FontTypeFace.fontBold(activity));
        subjectTextview.setTypeface(FontTypeFace.fontBold(activity));
        descriptionTextview.setTypeface(FontTypeFace.fontBold(activity));
        attachFileTextview.setTypeface(FontTypeFace.fontBold(activity));
        submitBtn.setTypeface(FontTypeFace.fontBold(activity));

        AppUtils.textAddAstreik(subjectTextview, "Subject");
        AppUtils.textAddAstreik(descriptionTextview, "Message");
    }

    @OnClick({R.id.dialog_close, R.id.submit_btn,R.id.attach_file})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.dialog_close:
                dismiss();
                break;
            case R.id.submit_btn:
                pass_Data();
                break;
            case R.id.attach_file:
                uploadFileDialog.show();
                break;
        }
    }

    private void call_support_raise_ticket_api() {
        subject1 = subject.getText().toString();
        description1 = description.getText().toString();
       // fileName=uploadFile.getPostAddMasterData().getFileName();

        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            Call<SupportRaiseTicket> supportRaiseTicketCall = ApiClient.getApiInterface().getSupportRaiseTicket(Constants.getApiKey(activity),
                    Constants.getAccessKey(activity),
                    Constants.getToken(activity),
                    subject1,
                    description1,
                    fileName);

            supportRaiseTicketCall.enqueue(new Callback<SupportRaiseTicket>() {
                @Override
                public void onResponse(@NonNull Call<SupportRaiseTicket> call, @NonNull Response<SupportRaiseTicket> response) {
                    if (response.isSuccessful()) {
                        if (response.body() != null) {
                            if (response.body().getStatus() == 1) {
                                onPassDataListener.onPassData();
                                subject.setText("");
                                description.setText("");
                                attachFile.setText("");
                                dismiss();
                            }
                        }
                    } else {
                        Log.d(Constants.failureResponse + "Raise Ticket", response.toString());
                    }
                    Loader.showLoad(activity, false);
                }

                @Override
                public void onFailure(@NonNull Call<SupportRaiseTicket> call, @NonNull Throwable t) {
                    Log.d(Constants.failureResponse + "Raise Ticket", t.toString());
                    Loader.showLoad(activity, false);
                }
            });
        }
    }

    private void pass_Data() {

        if (subject.getText().toString().trim().isEmpty()) {
            MyToast.errorMessage("Subject " + activity.getResources().getString(R.string.empty), activity);
        } else if (subject.getText().toString().trim().length()<4) {
            MyToast.errorMessage("Subject should be 5 character minimum " , activity);
        }  else if (description.getText().toString().trim().isEmpty()) {
            MyToast.errorMessage("Description " + activity.getResources().getString(R.string.empty), activity);
        } else {
            call_support_raise_ticket_api();
        }
    }

    void getData(String file_name){
        if(file_name!=null){
            uploadFileDialog.closeDialog();
            attachFile.setText(file_name);
            fileName = file_name;
        }
    }

    public interface OnPassDataListener {
        void onPassData();
    }

    void setOnPassDataListener(OnPassDataListener onPassDataListener) {
        this.onPassDataListener = onPassDataListener;
    }
}
