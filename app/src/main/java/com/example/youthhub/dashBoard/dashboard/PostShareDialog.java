package com.example.youthhub.dashBoard.dashboard;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.youthhub.R;
import com.example.youthhub.resModel.post.postList.PostListResponse;
import com.example.youthhub.resModel.profilepostlist.PostDashboardListResponse;
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

public class PostShareDialog extends Dialog {

    Activity activity;
    @BindView(R.id.share_txt_title)
    TextView shareTxtTitle;
    @BindView(R.id.share_comment)
    EditText shareComment;
    @BindView(R.id.public_btn)
    RadioButton publicBtn;
    @BindView(R.id.followers_btn)
    RadioButton followersBtn;
    @BindView(R.id.apply_btn)
    Button applyBtn;
    @BindView(R.id.dialog_close)
    ImageView dialogClose;

    private String pmCode;
    private OnPassShareData onPassShareData;

    public void setOnPassShareData(OnPassShareData onPassShareData) {
        this.onPassShareData = onPassShareData;
    }


    public PostShareDialog(Activity activity, String pmCode) {
        super(activity);
        this.activity = activity;
        this.pmCode = pmCode;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.post_share_dialog);
        ButterKnife.bind(this);
        CallTypeFace();
    }

    private void CallTypeFace() {
        shareTxtTitle.setTypeface(FontTypeFace.fontBold(activity));
        applyBtn.setTypeface(FontTypeFace.fontBold(activity));
    }

    @OnClick({R.id.public_btn, R.id.followers_btn, R.id.apply_btn, R.id.dialog_close})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.public_btn:
                followersBtn.setChecked(false);
                break;
            case R.id.followers_btn:
                publicBtn.setChecked(false);
                break;
            case R.id.apply_btn:
                validate();
                break;
            case R.id.dialog_close:
               dismiss();
                break;
        }
    }

    private void validate() {
      /*  if (shareComment.getText().toString().isEmpty()) {
            MyToast.errorMessage("Share Field is mandatory", activity);
        } else {*/
            String shareType;
            if (publicBtn.isChecked()) {
                shareType = "1";
            } else {
                shareType = "2";
            }
            call_post_share_api(shareType);
       // }
    }

    private void call_post_share_api(String shareType) {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            Call<PostDashboardListResponse> call = ApiClient.getApiInterface().getPostShare(Constants.getApiKey(activity), Constants.getAccessKey(activity),
                    Constants.getToken(activity),
                    pmCode,
                    shareType,
                    shareComment.getText().toString());

            call.enqueue(new Callback<PostDashboardListResponse>() {
                @Override
                public void onResponse(@NonNull Call<PostDashboardListResponse> call, @NonNull Response<PostDashboardListResponse> response) {
                    if (response.isSuccessful()) {
                        if (response.body() != null) {
                            if (response.body().getStatus() == 1) {
                                onPassShareData.onPassShareData(response.body());
                                dismiss();
                            } else {
                                MyToast.errorMessage(response.body().getMessage(), activity);
                            }
                        }
                    } else {
                        Log.d(Constants.failureResponse + " PostShare", response.toString());
                    }
                    Loader.showLoad(activity, false);
                }

                @Override
                public void onFailure(@NonNull Call<PostDashboardListResponse> call, @NonNull Throwable t) {
                    call_post_share_api(shareType);
                    Log.d(Constants.failureResponse + " PostShare", t.toString());
                    Loader.showLoad(activity, false);
                }
            });

        }
    }

    public interface OnPassShareData {
        void onPassShareData(PostDashboardListResponse postListResponse);
    }

}
