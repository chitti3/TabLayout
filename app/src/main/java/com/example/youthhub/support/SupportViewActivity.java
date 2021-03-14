package com.example.youthhub.support;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.youthhub.R;
import com.example.youthhub.UploadFileDialog;
import com.example.youthhub.resModel.CommonRes;
import com.example.youthhub.resModel.jobs.applyJob.GetFileUpload;
import com.example.youthhub.resModel.supportRes.view.HelpdeskDetail;
import com.example.youthhub.resModel.supportRes.view.HelpdeskInfo;
import com.example.youthhub.resModel.supportRes.view.SupportListView;
import com.example.youthhub.retrofit.ApiClient;
import com.example.youthhub.utils.Constants;
import com.example.youthhub.utils.FontTypeFace;
import com.example.youthhub.utils.Loader;
import com.example.youthhub.utils.MyToast;
import com.example.youthhub.utils.NetWorkUtil;

import java.io.File;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SupportViewActivity extends AppCompatActivity {

    @BindView(R.id.back_arrow)
    ImageView backArrow;
    @BindView(R.id.ticket_id_txt)
    TextView ticketIdTxt;
    @BindView(R.id.ticket_id)
    TextView ticketId;
    @BindView(R.id.date_txt)
    TextView dateTxt;
    @BindView(R.id.date)
    TextView date;
    @BindView(R.id.replies_txt)
    TextView repliesTxt;
    @BindView(R.id.replies)
    TextView replies;
    @BindView(R.id.cancel_btn)
    Button cancelBtn;
    @BindView(R.id.open_recycler)
    RecyclerView openRecycler;
    @BindView(R.id.reply_title)
    TextView replyTitle;
    @BindView(R.id.reply)
    EditText reply;
    @BindView(R.id.attach_file_txt)
    TextView attachFileTxt;
    @BindView(R.id.attach_file)
    TextView attachFile;
    @BindView(R.id.submit_btn)
    Button submitBtn;
    @BindView(R.id.bottom_constrain)
    ConstraintLayout bottomConstrain;

    Activity activity;

    UploadFileDialog uploadFileDialog;
    SupportViewAdapter supportViewAdapter;
    String ticketCode;
    HelpdeskInfo helpdeskInfo = null;

    String fileName = "";

    List<HelpdeskDetail> helpdeskDetails = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open);
        activity = this;
        ButterKnife.bind(this);
        callTypeFace();
        call_adapter();

        if (getIntent() != null) {
            ticketCode = getIntent().getStringExtra("TicketCode");
            call_view_api();
        }
        uploadFileDialog = new UploadFileDialog(activity,"Support");
    }

    private void call_view_api() {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            Call<SupportListView> listViewCall = ApiClient.getApiInterface().getListView(Constants.getApiKey(activity),Constants.getAccessKey(activity), Constants.getToken(activity), ticketCode);
            listViewCall.enqueue(new Callback<SupportListView>() {
                @Override
                public void onResponse(@NonNull Call<SupportListView> call, @NonNull Response<SupportListView> response) {
                    if (response.isSuccessful()) {
                        if (response.body() != null) {
                            if (response.body().getStatus() == 1) {
                                updateUi(response.body());
                            } else {
                                MyToast.errorMessage(response.body().getMessage(), activity);
                            }
                        } else {
                            Log.d(Constants.failureResponse + " SupportView", response.toString());
                        }
                    }
                    Loader.showLoad(activity, false);
                }

                @Override
                public void onFailure(@NonNull Call<SupportListView> call, @NonNull Throwable t) {
                    Log.d(Constants.failureResponse + " SupportView", t.toString());
                    Loader.showLoad(activity, false);
                }
            });
        }
    }

    private void updateUi(SupportListView supportListView) {

        helpdeskInfo = supportListView.getViewData().getHelpdeskInfo();
        helpdeskDetails = supportListView.getViewData().getHelpdeskDetail();

        if (helpdeskInfo != null) {
            ticketId.setText(helpdeskInfo.getHmCode());
            date.setText(helpdeskInfo.getHmDate());
            replies.setText(helpdeskInfo.getHmUserReplies());

            switch (helpdeskInfo.getHmSmStatusId()) {
                case "38":
                case "39":
                    cancelBtn.setVisibility(View.VISIBLE);
                    bottomConstrain.setVisibility(View.VISIBLE);
                    break;
                case "40":
                case "41":
                case "42":
                    cancelBtn.setVisibility(View.VISIBLE);
                    bottomConstrain.setVisibility(View.VISIBLE);
                    break;
                case "46":
                    cancelBtn.setVisibility(View.GONE);
                    bottomConstrain.setVisibility(View.GONE);
                    break;
            }
        }
        if (helpdeskDetails != null) {
            supportViewAdapter.addAll(helpdeskDetails, supportListView.getViewData().getUserThumbnailPath());
        }
    }

    private void call_adapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity);
        openRecycler.setLayoutManager(linearLayoutManager);
        supportViewAdapter = new SupportViewAdapter(activity);
        openRecycler.setAdapter(supportViewAdapter);
        supportViewAdapter.notifyDataSetChanged();
    }

    private void callTypeFace() {
        ticketId.setTypeface(FontTypeFace.fontBold(activity));
        cancelBtn.setTypeface(FontTypeFace.fontBold(activity));
        replyTitle.setTypeface(FontTypeFace.fontSemiBold(activity));
        attachFileTxt.setTypeface(FontTypeFace.fontSemiBold(activity));
        submitBtn.setTypeface(FontTypeFace.fontBold(activity));
    }

    @OnClick({R.id.back_arrow, R.id.cancel_btn, R.id.attach_file, R.id.submit_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back_arrow:
                onBackPressed();
                break;
            case R.id.cancel_btn:
                AlertDialog.Builder builder = new AlertDialog.Builder(SupportViewActivity.this);
                builder.setMessage("Do you want to Cancel this Ticket ?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                call_cancel_api();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.setTitle("Cancel Ticket");
                alert.show();
                break;
            case R.id.attach_file:
                uploadFileDialog.show();
                break;
            case R.id.submit_btn:
                validate();
                break;
        }
    }

    private void validate() {
        if (reply.getText().toString().isEmpty()) {
            MyToast.errorMessage("Description Field is Mandatory", activity);
        } else {
            call_reply_api();
        }
    }

    private void call_reply_api() {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            Call<SupportListView> call = ApiClient.getApiInterface().getReply(Constants.getApiKey(activity),Constants.getAccessKey(activity),
                    Constants.getToken(activity),
                    ticketCode,
                    reply.getText().toString(),
                    fileName,
                    helpdeskInfo.getHmSmStatusId());
            call.enqueue(new Callback<SupportListView>() {
                @Override
                public void onResponse(@NonNull Call<SupportListView> call, @NonNull Response<SupportListView> response) {
                    if (response.isSuccessful()) {
                        if (response.body() != null) {
                            if (response.body().getStatus() == 1) {
                                update_adapter(response.body());
                            } else {
                                MyToast.errorMessage(response.body().getMessage(), activity);
                            }
                        }
                    } else {
                        Log.d(Constants.failureResponse, response.toString());
                    }
                    Loader.showLoad(activity, false);
                }

                @Override
                public void onFailure(@NonNull Call<SupportListView> call, @NonNull Throwable t) {
                    Log.d(Constants.failureResponse, t.toString());
                    Loader.showLoad(activity, false);
                }
            });
        }

    }

    private void update_adapter(SupportListView body) {
        helpdeskDetails.add(0, body.getViewData().getHelpdeskDetail().get(0));
        supportViewAdapter.addAll(helpdeskDetails, body.getViewData().getUserThumbnailPath());
        reply.setText("");
        attachFile.setText("");
        openRecycler.smoothScrollToPosition(0);
    }

    private void call_cancel_api() {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            Call<CommonRes> call = ApiClient.getApiInterface().getCancelRes(Constants.getApiKey(activity),Constants.getAccessKey(activity), Constants.getToken(activity), ticketCode);
            call.enqueue(new Callback<CommonRes>() {
                @Override
                public void onResponse(@NonNull Call<CommonRes> call, @NonNull Response<CommonRes> response) {
                    if (response.isSuccessful()) {
                        if (response.body() != null) {
                            if (response.body().getStatus() == 1) {
                                cancelBtn.setVisibility(View.GONE);
                                bottomConstrain.setVisibility(View.GONE);
                                MyToast.normalMessage(response.body().getMessage(), activity);
                            } else {
                                MyToast.errorMessage(response.body().getMessage(), activity);
                            }
                        }
                    } else {
                        Log.d(Constants.failureResponse + " TicketCancel", response.toString());
                    }
                    Loader.showLoad(activity, false);
                }

                @Override
                public void onFailure(@NonNull Call<CommonRes> call, @NonNull Throwable t) {
                    Log.d(Constants.failureResponse + " TicketCancel", t.toString());
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
                    call_Api(file);
                    break;
                case Constants.GALLERY_REQUEST:
                    Uri selectedFileURI = data.getData();
                    File file1 = new File(getPath(selectedFileURI));
                    Log.d("", "FileUpload : " + file1.getName());
                    call_Api(file1);
                    break;
                case Constants.FILE_REQUEST:
                    Uri selectedFileURI1 = data.getData();
                    File file2 = new File(getPath(selectedFileURI1));
                    Log.d("", "FileUpload : " + file2.getName());
                    call_Api(file2);
                    break;
            }
        }
    }

    private void call_Api(File file) {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);

            RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
            final MultipartBody.Part body = MultipartBody.Part.createFormData("upload_file", file.getName(), requestFile);

            Call<GetFileUpload> call = ApiClient.getApiInterface().getFileUploadName(Constants.getApiKey(activity),
                    Constants.getAccessKey(activity),
                    Constants.getToken(activity),
                    body);

            call.enqueue(new Callback<GetFileUpload>() {
                @Override
                public void onResponse(@NonNull Call<GetFileUpload> call, @NonNull Response<GetFileUpload> response) {
                    if (response.isSuccessful()) {
                        if (response.body() != null) {
                            if (response.body().getStatus() == 1) {
                                uploadFileDialog.closeDialog();
                                fileName = response.body().getFileUploadData().getFileName();
                                attachFile.setText(fileName);
                            } else {
                                MyToast.normalMessage(response.body().getMessage(), activity);
                            }
                        }
                    } else {
                        Log.d(Constants.failureResponse+ " FileUpload", response.toString());
                    }
                    Loader.showLoad(activity, false);
                }

                @Override
                public void onFailure(@NonNull Call<GetFileUpload> call, @NonNull Throwable t) {
                    Log.d(Constants.failureResponse+ " FileUpload", t.toString());
                    Loader.showLoad(activity, false);
                    MyToast.errorMessage(t.toString(), activity);
                }
            });

        }
    }

    public String getPath(Uri uri) {
        String[] projection = {MediaStore.Images.Media.DATA};
        Cursor cursor = managedQuery(uri, projection, null, null, null);
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        return cursor.getString(column_index);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition(R.anim.stay, R.anim.activity_slide_down);
    }
}
