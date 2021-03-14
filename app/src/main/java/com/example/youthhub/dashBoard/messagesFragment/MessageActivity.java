package com.example.youthhub.dashBoard.messagesFragment;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.youthhub.R;
import com.example.youthhub.UploadFileDialog;
import com.example.youthhub.resModel.message.ProfileFileUploadResponse;
import com.example.youthhub.retrofit.ApiClient;
import com.example.youthhub.utils.AppUtils;
import com.example.youthhub.utils.Constants;
import com.example.youthhub.utils.FontTypeFace;
import com.example.youthhub.utils.Loader;
import com.example.youthhub.utils.MyToast;
import com.example.youthhub.utils.NetWorkUtil;
import com.example.youthhub.utils.Preference;
import com.google.gson.Gson;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.youthhub.utils.Constants.App_CHAT_USER_ONLINE;

public class MessageActivity extends AppCompatActivity {

    private static final String TAG = MessageActivity.class.getSimpleName();
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.main_image)
    CircleImageView mainImage;
    @BindView(R.id.multi_img_view1)
    View multiImgView1;
    @BindView(R.id.multi_img1)
    CircleImageView multiImg1;
    @BindView(R.id.multi_img_view2)
    View multiImgView2;
    @BindView(R.id.multi_img2)
    CircleImageView multiImg2;
    @BindView(R.id.multi_img_view3)
    View multiImgView3;
    @BindView(R.id.multi_img3)
    CircleImageView multiImg3;
    @BindView(R.id.messager_image_constrain)
    ConstraintLayout messagerImageConstrain;
    @BindView(R.id.online_show)
    ImageView onlineShow;
    @BindView(R.id.messager_name)
    TextView messagerName;
    @BindView(R.id.messager_online)
    TextView messagerOnline;
    @BindView(R.id.receive_msg_name)
    TextView receive_msg_name;
    @BindView(R.id.call)
    ImageView call;
    @BindView(R.id.three_dots)
    ImageView threeDots;
    @BindView(R.id.single_messager_constrain)
    ConstraintLayout singleMessagerConstrain;
    /*    @BindView(R.id.circleImageView)
        CircleImageView circleImageView;
        @BindView(R.id.textView)
        TextView textView;
        @BindView(R.id.circleImageView2)
        CircleImageView circleImageView2;
        @BindView(R.id.textView3)
        TextView textView3;
        @BindView(R.id.textView5)
        TextView textView5;
        @BindView(R.id.circleImageView3)
        CircleImageView circleImageView3;
        @BindView(R.id.textView4)
        TextView textView4;
        @BindView(R.id.projects_image)
        ImageView projectsImage;
        @BindView(R.id.play_btn)
        ImageView playBtn;
        @BindView(R.id.msg)
        TextView msg;
        @BindView(R.id.projects_card)
        CardView projectsCard;*/
    @BindView(R.id.comment_view2)
    View commentView2;
    @BindView(R.id.camera)
    ImageView camera;
    @BindView(R.id.comment_view3)
    View commentView3;
    @BindView(R.id.comment_edittext)
    EditText commentEdittext;
    @BindView(R.id.comment_view4)
    View commentView4;
    @BindView(R.id.cmt_post_btn)
    ImageView cmtPostBtn;
    @BindView(R.id.bottom_constrain)
    ConstraintLayout bottomConstrain;

    @BindView(R.id.messagehistory_recycler)
    RecyclerView messagehistory_recycler;
    @BindView(R.id.no_list_img)
    ImageView noListImg;
    @BindView(R.id.no_list_txt)
    TextView noListTxt;
    @BindView(R.id.refresh)
    SwipeRefreshLayout refresh;

    UploadFileDialog uploadFileDialog;

    Activity activity;
    String access_key;
    @BindView(R.id.btn_no_list_txt)
    Button btnNoListTxt;

    private String authorizations;
    private MessageChatHistoryResponse messageChatHistoryResponse;
    private MessageSendResponse messageSendResponse;
    private Integer page_no;

    private String chat_userid, chat_tousercode, chat_message = "", chat_mediafile = "";
    List<MessageChatHistoryResponse.Data.ChatList> chatLists = new ArrayList<>();
    MessageHistoryAdapter messageHistoryAdapter;

    boolean clearFilter = true;
    Integer filterPageNo = null;

    Integer message_type = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        ButterKnife.bind(this);
        activity = this;

        getBundle();

        uploadFileDialog = new UploadFileDialog(activity, "Profile");

        access_key = Preference.getInstance(activity).getStr(Constants.AccessKey);
        authorizations = "Youthhub " + Preference.getInstance(activity).getStr(Constants.Token);
        //nestedScroll.fullScroll(ScrollView.FOCUS_DOWN);
        //nestedScroll.scrollTo(0,nestedScroll.getBottom());
        callTypeFace();
        callMessageHistoryApi();

        refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Log.d(TAG, "onRefresh: " + page_no);
                if (page_no != null) {
                    page_no = null;
                    chatLists.clear();
                    messageHistoryAdapter.notifyDataSetChanged();
                    messageHistoryAdapter.setLoaded();
                    callMessageHistoryApi();
                    Log.d(TAG, "onRefresh:in " + page_no);
                }
                Log.d(TAG, "onRefresh:out " + page_no);
                refresh.setRefreshing(false);
            }
        });
    }

    private void getBundle() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            chat_userid = bundle.getString(Constants.App_CHAT_ID);
            chat_tousercode = bundle.getString(Constants.App_CHAT_USERCODE);
            if (chat_userid != null) {
         /*       encouragersLists = postLikeResponse.getPostLikeData().getEncouragersList();
                String likes = String.valueOf(encouragersLists.size())+" Likes";
                commentTxt.setText(likes);
                call_adapter(encouragersLists,postLikeResponse.getPostLikeData().getUserMediumPath(),postLikeResponse.getPostLikeData().getUserThumbnailPath());
     */
            }
        }
    }

    private void callTypeFace() {
        messagerName.setTypeface(FontTypeFace.fontBold(this));
    }

    @OnClick({R.id.back, R.id.three_dots, R.id.camera, R.id.cmt_post_btn, R.id.refresh})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                onBackPressed();
                break;
            case R.id.three_dots:
                break;
            case R.id.camera:
                uploadFileDialog.show();
                break;
            case R.id.cmt_post_btn:
                if (!commentEdittext.getText().toString().isEmpty() && commentEdittext.getText().toString() != null) {
                    message_type = 0;
                    callMessageSendApi(message_type);
                } else {
                    MyToast.errorMessage("Please enter the text", activity);
                }
                break;
            case R.id.refresh:

                break;
            case R.id.btn_no_list_txt:

                break;
        }
    }

    private void call_profile_upload_api(File file) {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            Log.d(TAG, "call_profile_upload_api: ");
            RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
            final MultipartBody.Part body = MultipartBody.Part.createFormData("userfile", file.getName(), requestFile);

            Call<ProfileFileUploadResponse> call = ApiClient.getApiInterface().getUploadChatFile(Constants.getApiKey(activity),
                    Constants.getAccessKey(activity),
                    Constants.getToken(activity),
                    body);
            call.enqueue(new Callback<ProfileFileUploadResponse>() {
                @Override
                public void onResponse(@NonNull Call<ProfileFileUploadResponse> call, @NonNull Response<ProfileFileUploadResponse> response) {
                    if (response.isSuccessful()) {
                        Log.d(TAG, "call_profile_upload_api: success");
                        if (response.body() != null) {
                            if (response.body().getStatus() == 1) {
                                uploadFileDialog.closeDialog();
                                ProfileFileUploadResponse profilePicUpload = response.body();
                                message_type = 1;
                                chat_mediafile = profilePicUpload.getData().getFilename();
                                Log.d(TAG, "onResponse: fileupload" + chat_mediafile);
                                callMessageSendApi(message_type);


                               /* Glide.with(activity)
                                        .load(Constants.getLoadGlide(activity, profilePicUpload.getData().getPath_thumb() + profilePicUpload.getData().getFilename()))
                                        .apply(AppUtils.getRequestOptionWithoutOverride())
                                        .into(profileImg);*/
                            } else {
                                MyToast.errorMessage(response.body().getMessage(), activity);
                            }
                        }
                    } else {
                        Log.d(TAG, "call_profile_upload_api: failed");
                        Log.d(Constants.failureResponse + " ProPicUpload", response.toString());
                    }
                    Loader.showLoad(activity, false);
                }

                @Override
                public void onFailure(@NonNull Call<ProfileFileUploadResponse> call, @NonNull Throwable t) {
                    Log.d(Constants.failureResponse + " ProPicUpload", t.toString());
                    Log.d(TAG, "call_profile_upload_api: failed");
                    Loader.showLoad(activity, false);
                }
            });
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case Constants.CAMERA_REQUEST:
                    File file = new File(getFilesDir(), "newImage.jpg");
                    Log.d("", "FileUpload : " + file.getName());
                    call_profile_upload_api(file);
                    break;
                case Constants.GALLERY_REQUEST:
                    Uri selectedFileURI = data.getData();
                    File file1 = new File(AppUtils.getPath(selectedFileURI, activity));
                    Log.d("", "FileUpload : " + file1.getName());
                    call_profile_upload_api(file1);
                    break;
            }
        }
    }

    private void callMessageHistoryApi() {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);

            final String pageno;
            if (page_no == null) {
                pageno = "";
            } else {
                pageno = String.valueOf(page_no);
            }
            final String to_user_code = chat_tousercode;
            final String chat_id = chat_userid;
            Log.d(TAG, "callMessageApi: " + Constants.getApiKey(activity));
            Log.d(TAG, "callMessageApi:access_key " + access_key);
            Log.d(TAG, "callMessageApi: authorizations" + authorizations);
            Log.d(TAG, "callMessageApi:pageno " + pageno);
            Log.d(TAG, "callMessageApi:to_user_code " + to_user_code);
            Log.d(TAG, "callMessageApi:chat_id " + chat_id);

            Call<MessageChatHistoryResponse> responseCall = ApiClient.getApiInterface().getChatListHistory(Constants.getApiKey(activity),
                    access_key, authorizations, pageno, to_user_code, chat_id);
            responseCall.enqueue(new Callback<MessageChatHistoryResponse>() {
                @Override
                public void onResponse(@NonNull Call<MessageChatHistoryResponse> call, @NonNull Response<MessageChatHistoryResponse> response) {


                    if (response.isSuccessful()) {
                        messageChatHistoryResponse = response.body();
                        Log.d(TAG, "onResponse: " + new Gson().toJson(messageChatHistoryResponse));

                        if (messageChatHistoryResponse != null) {
                            if (messageChatHistoryResponse.getData().getUser_info().get(0).getUser_online_status().equals(App_CHAT_USER_ONLINE)) {
                                onlineShow.setVisibility(View.VISIBLE);
                            } else {
                                onlineShow.setVisibility(View.GONE);
                            }

                            mainImage.setBackground(activity.getResources().getDrawable(R.drawable.textview_circle2));
                            Log.d(TAG, "onResponse: messageChatHistoryResponse" + messageChatHistoryResponse.getData().getUser_info().get(0).getUm_profile_picture());
                            if (messageChatHistoryResponse.getData().getUser_info().get(0).getUm_profile_picture() != null && !messageChatHistoryResponse.getData().getUser_info().get(0).getUm_profile_picture().isEmpty()) {

                                mainImage.setVisibility(View.VISIBLE);
                                //invisible because text constrained to msg text
                                receive_msg_name.setVisibility(View.GONE);

                                Glide.with(activity)
                                        .load(Constants.getLoadGlide(activity, messageChatHistoryResponse.getData().getUser_info().get(0).getUm_profile_picture()))
                                        .apply(AppUtils.getRequestOption())
                                        .into(mainImage);
                            } else {
                                mainImage.setVisibility(View.GONE);
                                receive_msg_name.setVisibility(View.VISIBLE);
                                receive_msg_name.setText(messageChatHistoryResponse.getData().getUser_info().get(0).getUsername_code());

                            }
                            messagerName.setText(messageChatHistoryResponse.getData().getUser_info().get(0).getUm_name());
                            messagerOnline.setText(messageChatHistoryResponse.getData().getUser_info().get(0).getLast_seen());
                            if (messageChatHistoryResponse.getStatus() == 1) {
                                if (noListImg != null && noListTxt != null) {
                                    noListImg.setVisibility(View.GONE);
                                    noListTxt.setVisibility(View.GONE);
                                    btnNoListTxt.setVisibility(View.GONE);
                                    Log.d(TAG, "onResponse:1 mgview");
                                }else{
                                    Log.d(TAG, "onResponse:2 mgview");
                                }
//Set Text Data
                                if (page_no == null) {
                                    chatLists.addAll(messageChatHistoryResponse.getData().getChat_list());
                                    call_adapter(messageChatHistoryResponse, chatLists);

                                } else {
                                    Log.d(TAG, "onResponse: size" + messageChatHistoryResponse.getData().getChat_list().size());
                                    for (int i = messageChatHistoryResponse.getData().getChat_list().size() - 1; i > 0; i--) {
                                        Log.d(TAG, "onResponse: i" + i);

                                        chatLists.add(0, messageChatHistoryResponse.getData().getChat_list().get(i));
                                    }
                                    //chatLists.addAll(messageChatHistoryResponse.getData().getChat_list());

                                    messageHistoryAdapter.addAll(chatLists);
                                    messageHistoryAdapter.setLoaded();
                                    Log.d(TAG, "onResponse: position" + messagehistory_recycler.getAdapter().getItemCount());

                                }
                                page_no = messageChatHistoryResponse.getNextpage();
                            } else {
                                if (!messageChatHistoryResponse.getMessage().isEmpty() && messageChatHistoryResponse.getMessage() != null) {
                                    if (noListImg != null && noListTxt != null) {
                                        noListImg.setVisibility(View.VISIBLE);
                                        noListTxt.setVisibility(View.VISIBLE);
                                        btnNoListTxt.setVisibility(View.GONE);

                                        chatLists.clear();
                                        Log.d(TAG, "onResponse: mgview");
                                        //   messageHistoryAdapter.addAll(chatLists);
                                        // messageHistoryAdapter.setLoaded();

                                        Glide.with(activity)
                                                .load(Constants.getLoadGlide(activity, messageChatHistoryResponse.getStatus_img()))
                                                .apply(AppUtils.getRequestOption())
                                                .into(noListImg);

                                        noListTxt.setText(messageChatHistoryResponse.getMessage());
                                    }else{
                                        Log.d(TAG, "onResponse: mgview1");
                                    }
                                    //MyToast.normalMessage(galleryResponse.getMessage(), activity);
                                } else {
                                    if (noListImg != null && noListTxt != null) {
                                        noListImg.setVisibility(View.GONE);
                                        noListTxt.setVisibility(View.GONE);
                                        btnNoListTxt.setVisibility(View.GONE);
                                        Log.d(TAG, "onResponse: 2mgview");
                                    }else{
                                        Log.d(TAG, "onResponse: 2mgview1");
                                    }
                                }

                                page_no = null;
                            }
                        }
                    } else {
                        Log.d(Constants.failureResponse + " MessageList", response.toString());
                    }
                    Loader.showLoad(activity, false);
                }

                @Override
                public void onFailure(@NonNull Call<MessageChatHistoryResponse> call, @NonNull Throwable t) {
                    callMessageHistoryApi();
                    Log.d(Constants.failureResponse + " ChatHistoryList", t.toString());
                    //MyToast.errorMessage(getResources().getString(R.string.error_msg), activity);
                    Loader.showLoad(activity, false);
                }
            });
        }
    }

    @Override
    protected void onResume() {
        if (page_no != null) {
            page_no = null;
            chatLists.clear();
            messageHistoryAdapter.notifyDataSetChanged();
            messageHistoryAdapter.setLoaded();
            callMessageHistoryApi();
            Log.d(TAG, "onResume:in " + page_no);
        }
        Log.d(TAG, "onResume: d");
        super.onResume();
    }

    private void callMessageSendApi(Integer message_type) {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            if (message_type == 0) {
                chat_message = commentEdittext.getText().toString();
                chat_mediafile = "";
            } else {
                chat_message = "";
            }
            Call<MessageSendResponse> responseCall = ApiClient.getApiInterface().sendMessage(Constants.getApiKey(activity),
                    access_key, authorizations, chat_mediafile, chat_message, chat_tousercode, chat_userid);
            responseCall.enqueue(new Callback<MessageSendResponse>() {
                @Override
                public void onResponse(@NonNull Call<MessageSendResponse> call, @NonNull Response<MessageSendResponse> response) {


                    if (response.isSuccessful()) {
                        messageSendResponse = response.body();
                        Log.d(TAG, "onResponse: " + new Gson().toJson(messageSendResponse));

                        if (messageSendResponse != null) {
                            if (messageSendResponse.getStatus() == 1) {
                                chatLists.addAll(messageSendResponse.getData().getChat_list());
                                if (chatLists.size()==1) {

                                    call_adapter(messageChatHistoryResponse, chatLists);
                                }
                                Log.d(TAG, "onResponse: "+chatLists.size());

                                messageHistoryAdapter.addAll(chatLists);
                                messageHistoryAdapter.setLoaded();
                                messagehistory_recycler.smoothScrollToPosition(messagehistory_recycler.getAdapter().getItemCount() - 1);
                                commentEdittext.setText("");
                            } else {

                            }
                        }
                    } else {
                        Log.d(Constants.failureResponse + " MessageList", response.toString());
                    }
                    Loader.showLoad(activity, false);
                }

                @Override
                public void onFailure(@NonNull Call<MessageSendResponse> call, @NonNull Throwable t) {
                    callMessageSendApi(message_type);
                    Log.d(Constants.failureResponse + " SendMessage", t.toString());
                    //MyToast.errorMessage(getResources().getString(R.string.error_msg), activity);
                    Loader.showLoad(activity, false);
                }
            });
        }
    }

    private void call_adapter(MessageChatHistoryResponse messageChatHistoryResponse, List<MessageChatHistoryResponse.Data.ChatList> chatLists) {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity);
        linearLayoutManager.setStackFromEnd(true);
        if (messagehistory_recycler != null) {
            messagehistory_recycler.setLayoutManager(linearLayoutManager);
            messageHistoryAdapter = new MessageHistoryAdapter(messagehistory_recycler, chatLists, activity,
                    messageChatHistoryResponse.getStatus_img(),
                    messageChatHistoryResponse.getData().getUser_thumbnail_path(),
                    messageChatHistoryResponse.getData().getThumbnail_path());
            messagehistory_recycler.setAdapter(messageHistoryAdapter);

            messagehistory_recycler.setVisibility(View.VISIBLE);
            noListImg.setVisibility(View.GONE);
            noListTxt.setVisibility(View.GONE);
            //   messageHistoryAdapter.setOnLoadMoreListener(this::onLoadMore);
            /*    messageAdapter.setPassDataListener((eventList, viewPage, position) -> {
             *//* if (viewPage) {
                    call_event_api(eventList.getCode());
                } else {
                    if (position >= 0) {
                        call_count_status_api(eventList.getCode(), eventList.getParticipantCurrentStatus(), position);
                    }
                }*//*
            });*/
        }
    }

    private void onLoadMore() {
        if (clearFilter) {
            if (page_no != null) {
                callMessageHistoryApi();
            }
        } else {
            if (filterPageNo != null) {
                Log.d(TAG, "onLoadMore: ");
                //callMessageFilterApi(searchName, clearFilter, true);
            }
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition(R.anim.stay, R.anim.activity_slide_down);
    }
}
