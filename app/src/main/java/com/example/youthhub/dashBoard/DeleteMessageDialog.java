package com.example.youthhub.dashBoard;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.example.youthhub.R;
import com.example.youthhub.resModel.CommonNewResponse;
import com.example.youthhub.resModel.CommonRes;
import com.example.youthhub.resModel.event.discussion.DiscussionAdd;
import com.example.youthhub.resModel.explore.exploreDiscussion.ExploreDiscussionAdd;
import com.example.youthhub.resModel.profile.BasicResponse;
import com.example.youthhub.retrofit.ApiClient;
import com.example.youthhub.utils.Constants;
import com.example.youthhub.utils.FontTypeFace;
import com.example.youthhub.utils.Loader;
import com.example.youthhub.utils.MyToast;
import com.example.youthhub.utils.NetWorkUtil;
import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.youthhub.profile.ProfileInfoDialog.TAG;

public class DeleteMessageDialog extends Dialog {

    Activity activity;
    @BindView(R.id.dialog_title)
    TextView dialogTitle;
    @BindView(R.id.delete_txt)
    TextView deleteTxt;
    @BindView(R.id.view8)
    View view8;
    @BindView(R.id.yes_btn)
    TextView yesBtn;
    @BindView(R.id.view6)
    View view6;
    @BindView(R.id.cancel_btn)
    TextView cancelBtn;

    private OnDeleteListener onDeleteListener;
    private String code;
    private String feedId;
    private String topicId;
    private String from;
    private BasicResponse basicResponse;

    public DeleteMessageDialog(Activity activity, String from, String code, String feedId, String topicId) {
        super(activity);
        this.activity = activity;
        this.from = from;
        this.code = code;
        this.feedId = feedId;
        this.topicId = topicId;
    }

    public void setOnDeleteListener(OnDeleteListener onDeleteListener) {
        this.onDeleteListener = onDeleteListener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.delete_message);
        ButterKnife.bind(this);
        callTypeFace();
        switch (from) {
            case "Explore":
                break;
            case "Event":
                break;
            case "Comment":
                break;
            case "Post":
                deleteTxt.setText("Are you sure to delete this Post");
                break;
            case "wishlist":
                deleteTxt.setText("Are you sure to delete this wishlist item?");
                break;
        }
    }

    private void callTypeFace() {
        dialogTitle.setTypeface(FontTypeFace.fontBold(activity));
        yesBtn.setTypeface(FontTypeFace.fontBold(activity));
        cancelBtn.setTypeface(FontTypeFace.fontBold(activity));
    }

    @OnClick({R.id.yes_btn, R.id.cancel_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.yes_btn:
                if (from.equals("Explore")) {
                    explore_delete_msg_api();
                } else if (from.equals("Event")) {
                    event_delete_msg_api();
                } else if (from.equals("Comment")) {
                    comment_delete_api();
                } else if (from.equals("wishlist")) {
                    call_delete_wishlist_api(code);
                } else {
                    post_delete_api();
                }
                break;
            case R.id.cancel_btn:
                dismiss();
                break;
        }
    }

    private void call_delete_wishlist_api(String wishlish_id) {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            Call<BasicResponse> call = ApiClient.getApiInterface().deleteWishlist(Constants.getApiKey(activity), Constants.getAccessKey(activity),
                    Constants.getToken(activity), wishlish_id
            );

            call.enqueue(new Callback<BasicResponse>() {
                @Override
                public void onResponse(@NonNull Call<BasicResponse> call, @NonNull Response<BasicResponse> response) {
                    if (response.isSuccessful()) {
                        //   Log.d(TAG, "onResponse:ProfileYouthInfoResponse 1 ");
                        if (response.body() != null) {
                            if (response.body().getStatus() == 1) {
                                basicResponse = response.body();
                                onDeleteListener.OnDelete(true);
                                MyToast.normalMessage(response.body().getMessage(), activity);
                            } else {
                                //     Log.d(TAG, "onResponse:ProfileYouthInfoResponse else "+new Gson().toJson(profileInfoResp));
                                Log.d(TAG, "onResponse:failure " + new Gson().toJson(response.body()));
                                MyToast.errorMessage(response.body().getMessage(), activity);
                            }

                        }
                    } else {
                        Log.d(Constants.failureResponse, " profile_info_update" + response.toString());
                    }
                    dismiss();
                    Loader.showLoad(activity, false);
                }

                @Override
                public void onFailure(@NonNull Call<BasicResponse> call, @NonNull Throwable t) {
                    call_delete_wishlist_api(wishlish_id);
                    Log.d(Constants.failureResponse, " profile_info_update" + t.toString());
                    Loader.showLoad(activity, false);
                }
            });

        }
    }

    private void post_delete_api() {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            Call<CommonRes> call = ApiClient.getApiInterface().getPostDelete(Constants.getApiKey(activity), Constants.getAccessKey(activity),
                    Constants.getToken(activity),
                    code);

            call.enqueue(new Callback<CommonRes>() {
                @Override
                public void onResponse(@NonNull Call<CommonRes> call, @NonNull Response<CommonRes> response) {
                    if (response.isSuccessful()) {
                        if (response.body() != null) {
                            if (response.body().getStatus() == 1) {
                                onDeleteListener.OnDelete(true);
                            } else {
                                MyToast.errorMessage(response.body().getMessage(), activity);
                            }
                        }
                    } else {
                        Log.d(Constants.failureResponse + " PostDelete", response.toString());
                    }
                    dismiss();
                    Loader.showLoad(activity, false);
                }

                @Override
                public void onFailure(@NonNull Call<CommonRes> call, @NonNull Throwable t) {
                    Log.d(Constants.failureResponse + " PostDelete", t.toString());
                    Loader.showLoad(activity, false);
                }
            });

        }
    }

    private void comment_delete_api() {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            Call<CommonNewResponse> call = ApiClient.getApiInterface().getCommentDelete(Constants.getApiKey(activity), Constants.getAccessKey(activity),
                    Constants.getToken(activity),
                    code,
                    feedId);

            call.enqueue(new Callback<CommonNewResponse>() {
                @Override
                public void onResponse(@NonNull Call<CommonNewResponse> call, @NonNull Response<CommonNewResponse> response) {
                    if (response.isSuccessful()) {
                        if (response.body() != null) {
                            if (response.body().getStatus() == 1) {
                                onDeleteListener.OnDelete(true);
                            } else {
                                MyToast.errorMessage(response.body().getMessage(), activity);
                            }
                        }
                    } else {
                        Log.d(Constants.failureResponse + " DeleteComment", response.toString());
                    }
                    dismiss();
                    Loader.showLoad(activity, false);
                }

                @Override
                public void onFailure(@NonNull Call<CommonNewResponse> call, @NonNull Throwable t) {
                    Log.d(Constants.failureResponse + " DeleteComment", t.toString());
                    MyToast.errorMessage(activity.getResources().getString(R.string.error_msg), activity);
                    Loader.showLoad(activity, false);
                    dismiss();
                }
            });

        }
    }

    private void explore_delete_msg_api() {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            Call<ExploreDiscussionAdd> call = ApiClient.getApiInterface().getExploreDiscussionDelete(Constants.getApiKey(activity), Constants.getAccessKey(activity), Constants.getToken(activity), code, topicId, feedId);
            call.enqueue(new Callback<ExploreDiscussionAdd>() {
                @Override
                public void onResponse(@NonNull Call<ExploreDiscussionAdd> call, @NonNull Response<ExploreDiscussionAdd> response) {
                    if (response.isSuccessful()) {
                        if (response.body() != null) {
                            if (response.body().getStatus() == 1) {
                                onDeleteListener.OnDelete(true);
                            } else {
                                MyToast.errorMessage(response.body().getMessage(), activity);
                            }
                        }
                    } else {
                        Log.d(Constants.failureResponse + " DeleteExplore", response.toString());
                    }
                    dismiss();
                    Loader.showLoad(activity, false);
                }

                @Override
                public void onFailure(@NonNull Call<ExploreDiscussionAdd> call, @NonNull Throwable t) {
                    Log.d(Constants.failureResponse + " DeleteExplore", t.toString());
                    dismiss();
                    MyToast.errorMessage(activity.getResources().getString(R.string.error_msg), activity);
                    Loader.showLoad(activity, false);
                }
            });
        }
    }

    private void event_delete_msg_api() {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            Call<DiscussionAdd> discussionAddCall = ApiClient.getApiInterface().getDeleteMsg(Constants.getApiKey(activity), Constants.getAccessKey(activity), Constants.getToken(activity), code, feedId);
            discussionAddCall.enqueue(new Callback<DiscussionAdd>() {
                @Override
                public void onResponse(@NonNull Call<DiscussionAdd> call, @NonNull Response<DiscussionAdd> response) {
                    if (response.isSuccessful()) {
                        if (response.body() != null) {
                            if (response.body().getStatus() == 1) {
                                onDeleteListener.OnDelete(true);
                            } else {
                                MyToast.errorMessage(response.body().getMessage(), activity);
                            }
                        }
                    } else {
                        Log.d(Constants.failureResponse + " DeleteEvent", response.toString());
                    }
                    dismiss();
                    Loader.showLoad(activity, false);
                }

                @Override
                public void onFailure(@NonNull Call<DiscussionAdd> call, @NonNull Throwable t) {
                    Log.d(Constants.failureResponse + " DeleteEvent", t.toString());
                    dismiss();
                    MyToast.errorMessage(activity.getResources().getString(R.string.error_msg), activity);
                    Loader.showLoad(activity, false);
                }
            });
        }
    }

    public interface OnDeleteListener {
        void OnDelete(boolean deleted);
    }

}