package com.example.youthhub.dashBoard.dashboard;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.youthhub.R;
import com.example.youthhub.resModel.CommonRes;
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

public class PostUpdateDialog extends Dialog {

    Activity activity;
    @BindView(R.id.desc_txt)
    TextView descTxt;
    @BindView(R.id.desc)
    EditText desc;
    @BindView(R.id.apply_btn)
    Button applyBtn;

    private String post_code;
    private String description;
    private String from;
    private OnPassValueListener onPassValueListener;

    void setOnPassValueListener(OnPassValueListener onPassValueListener){
        this.onPassValueListener = onPassValueListener;
    }

    PostUpdateDialog(Activity activity, String post_code, String description, String from) {
        super(activity);
        this.activity = activity;
        this.post_code = post_code;
        this.description = description;
        this.from = from;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.post_update_dialog);
        ButterKnife.bind(this);
        CallTypeFace();
        switch (from){
            case "Update":
                descTxt.setText(activity.getString(R.string.post_description));
                desc.setText(description);
                break;
            case "Report":
                descTxt.setText(activity.getString(R.string.post_report));
                break;
        }
    }

    private void CallTypeFace() {
        descTxt.setTypeface(FontTypeFace.fontBold(activity));
        applyBtn.setTypeface(FontTypeFace.fontBold(activity));
    }

    @OnClick(R.id.apply_btn)
    public void onViewClicked() {
        validate();
    }

    private void validate() {
        if (desc.getText().toString().isEmpty()){
            MyToast.errorMessage(descTxt.getText().toString()+" field is mandatory",activity);
        }else {
            switch (from){
                case "Update":
                    call_post_update_api();
                    break;
                case "Report":
                    call_post_report_api();
                    break;
            }
        }
    }

    private void call_post_report_api() {
        if(NetWorkUtil.isNetworkConnected(activity)){
            Loader.showLoad(activity,true);
            String postDescription = desc.getText().toString();
            Call<CommonRes> call = ApiClient.getApiInterface().getPostReport(Constants.getApiKey(activity),Constants.getAccessKey(activity),
                    Constants.getToken(activity),
                    post_code,
                    postDescription);

            call.enqueue(new Callback<CommonRes>() {
                @Override
                public void onResponse(@NonNull Call<CommonRes> call, @NonNull Response<CommonRes> response) {
                    if(response.isSuccessful()){
                        if (response.body() != null) {
                            if(response.body().getStatus()==1){
                                onPassValueListener.onReportData(true);
                                MyToast.normalMessage(response.body().getMessage(),activity);
                                dismiss();
                            }else {
                                MyToast.errorMessage(response.body().getMessage(),activity);
                            }
                        }
                    }else {
                        Log.d(Constants.failureResponse+" PostReport",response.toString());
                    }
                    Loader.showLoad(activity,false);
                }

                @Override
                public void onFailure(@NonNull Call<CommonRes> call, @NonNull Throwable t) {
                    Log.d(Constants.failureResponse+" PostReport",t.toString());
                    Loader.showLoad(activity,false);
                }
            });

        }
    }

    private void call_post_update_api() {
        if(NetWorkUtil.isNetworkConnected(activity)){
            Loader.showLoad(activity,true);
            String postDescription = desc.getText().toString();
            Call<CommonRes> call = ApiClient.getApiInterface().getPostUpdate(Constants.getApiKey(activity),Constants.getAccessKey(activity),
                    Constants.getToken(activity),
                    post_code,
                    postDescription);

            call.enqueue(new Callback<CommonRes>() {
                @Override
                public void onResponse(@NonNull Call<CommonRes> call, @NonNull Response<CommonRes> response) {
                    if(response.isSuccessful()){
                        if (response.body() != null) {
                            if(response.body().getStatus()==1){
                                onPassValueListener.onPassData(postDescription);
                                MyToast.normalMessage(response.body().getMessage(),activity);
                                dismiss();
                            }else {
                                MyToast.errorMessage(response.body().getMessage(),activity);
                            }
                        }
                    }else {
                        Log.d(Constants.failureResponse+" PostUpdate",response.toString());
                    }
                    Loader.showLoad(activity,false);
                }

                @Override
                public void onFailure(@NonNull Call<CommonRes> call, @NonNull Throwable t) {
                    Log.d(Constants.failureResponse+" PostUpdate",t.toString());
                    Loader.showLoad(activity,false);
                }
            });

        }
    }

    public interface OnPassValueListener{
        void onPassData(String description);
        void onReportData(boolean reported);
    }

}