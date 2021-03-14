package com.example.youthhub.support;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.youthhub.R;
import com.example.youthhub.resModel.jobs.applyJob.GetFileUpload;
import com.example.youthhub.resModel.supportRes.SupportList;
import com.example.youthhub.resModel.supportRes.SupportURL;
import com.example.youthhub.resModel.supportRes.listmaster.SupportListMaster;
import com.example.youthhub.resModel.supportRes.raiseticket.SupportRaiseTicket;
import com.example.youthhub.retrofit.ApiClient;
import com.example.youthhub.utils.AppUtils;
import com.example.youthhub.utils.Constants;
import com.example.youthhub.utils.FontTypeFace;
import com.example.youthhub.utils.Loader;
import com.example.youthhub.utils.MyToast;
import com.example.youthhub.utils.NetWorkUtil;

import java.io.File;
import java.util.ArrayList;
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

public class SupportListActivity extends AppCompatActivity implements SupportListAdapter.OnLoadMoreListener, SupportListFilterDialog.OnPassDataListener, SupportListAddDialog.OnPassDataListener {

    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.filter)
    TextView filter;
    @BindView(R.id.support_recycler)
    RecyclerView supportRecycler;
    @BindView(R.id.no_list_img)
    ImageView noListImg;
    @BindView(R.id.no_list_txt)
    TextView noListTxt;

    SupportListAdapter supportListAdapter;
    Activity activity;
    SupportURL supportURL;
    List<SupportList> supportURLList = new ArrayList<>();
    Integer page_no = null;
    SupportListMaster supportListMaster = null;
    String searchName = "";
    String subCategoryId = "";
    SupportRaiseTicket supportRaiseTicket;
    SupportListFilterDialog supportListFilterDialog;
    String fileName = "";
    SupportListAddDialog supportListAddDialogue;
    boolean goToTopRecycler = false;
    @BindView(R.id.back_arrow)
    ImageView backArrow;
    @BindView(R.id.add)
    ImageView add;
    @BindView(R.id.refresh)
    SwipeRefreshLayout refresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support);
        ButterKnife.bind(this);
        activity = this;
        call_adapter();
        callTypeFace();
        call_supportlist_api(false);
        call_support_list_master_api();
        supportListFilterDialog = new SupportListFilterDialog(activity);
        supportListAddDialogue = new SupportListAddDialog(activity);
        refresh.setOnRefreshListener(() -> {
            page_no = null;
            subCategoryId = "";
            searchName = "";
            supportURLList.clear();
            supportListAdapter.notifyDataSetChanged();
            supportListAdapter.setLoaded();
            call_supportlist_api(false);
            refresh.setRefreshing(false);
        });
    }

    private void call_support_list_master_api() {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            Call<SupportListMaster> call = ApiClient.getApiInterface().getSupportListMaster(Constants.getApiKey(activity), Constants.getAccessKey(this), Constants.getToken(this));
            call.enqueue(new Callback<SupportListMaster>() {
                @Override
                public void onResponse(@NonNull Call<SupportListMaster> call, @NonNull Response<SupportListMaster> response) {
                    if (response.isSuccessful()) {
                        if (response.body() != null) {
                            if (response.body().getStatus() == 1) {
                                supportListMaster = response.body();
                            }
                        }
                    } else {
                        Log.d(Constants.failureResponse + " Filter", response.toString());
                    }
                    Loader.showLoad(activity, false);
                }

                @Override
                public void onFailure(@NonNull Call<SupportListMaster> call, @NonNull Throwable t) {
                    Log.d(Constants.failureResponse + " Filter", t.toString());
                    Loader.showLoad(activity, false);
                }
            });
        }
    }

    public void call_supportlist_api(final boolean filter) {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            final String pageNo;
            if (filter) {
                page_no = null;
            }

            if (page_no == null) {
                pageNo = "";
            } else {
                pageNo = String.valueOf(page_no);
            }
            Call<SupportURL> supportListCall = ApiClient.getApiInterface().getSupportList(Constants.getApiKey(activity),
                    Constants.getAccessKey(activity),
                    Constants.getToken(activity),
                    pageNo,
                    subCategoryId,
                    searchName);
            supportListCall.enqueue(new Callback<SupportURL>() {
                @Override
                public void onResponse(@NonNull Call<SupportURL> call, @NonNull Response<SupportURL> response) {
                    if (response.isSuccessful()) {
                        supportURL = response.body();
                        if (supportURL != null) {
                            if (supportURL.getStatus() == 1) {
                                noListImg.setVisibility(View.GONE);
                                noListTxt.setVisibility(View.GONE);
                                updateUi(supportURL, pageNo);
                            } else {
                                no_list(supportURL);
                            }
                        }
                    } else {
                        Log.d(Constants.failureResponse + " SupportList", response.toString());
                    }
                    Loader.showLoad(activity, false);
                }

                @Override
                public void onFailure(@NonNull Call<SupportURL> call, @NonNull Throwable t) {
                    call_supportlist_api(false);
                    Log.d(Constants.failureResponse + " SupportList", t.toString());
                    Loader.showLoad(activity, false);
                }
            });
        }
    }

    private void updateUi(SupportURL supportURL, String pageNo) {
        if (pageNo.isEmpty()) {
            supportURLList = supportURL.getData().getHelpdesklist();
        } else {
            supportURLList.addAll(supportURL.getData().getHelpdesklist());
        }

        supportListAdapter.addAll(supportURLList);
        supportListAdapter.setLoaded();
        if (goToTopRecycler) {
            supportRecycler.smoothScrollToPosition(0);
            goToTopRecycler = false;
        }
        page_no = supportURL.getNextpage();
    }

    private void no_list(SupportURL supportURL) {
        if (!supportURL.getMessage().isEmpty()) {
            noListImg.setVisibility(View.VISIBLE);
            noListTxt.setVisibility(View.VISIBLE);

            supportURLList.clear();
            supportListAdapter.addAll(supportURLList);
            supportListAdapter.setLoaded();

            Glide.with(activity)
                    .load(Constants.getLoadGlide(activity, supportURL.getStatusimg()))
                    .apply(AppUtils.getRequestOptionWithoutOverride())
                    .into(noListImg);

            noListTxt.setText(supportURL.getMessage());
            //MyToast.normalMessage(discussionListResponse.getMessage(), activity);
        } else {
            noListImg.setVisibility(View.GONE);
            noListTxt.setVisibility(View.GONE);
        }
        page_no = null;
    }


    private void callTypeFace() {
        title.setTypeface(FontTypeFace.fontBold(this));
        filter.setTypeface(FontTypeFace.fontRegular(this));
    }

    private void call_adapter() {
        supportRecycler.setLayoutManager(new LinearLayoutManager(activity));
        supportListAdapter = new SupportListAdapter(activity, supportRecycler);
        supportListAdapter.setOnLoadMoreListener(this);
        supportRecycler.setAdapter(supportListAdapter);
    }

    @OnClick({R.id.back_arrow, R.id.add, R.id.filter})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back_arrow:
                onBackPressed();
                break;
            case R.id.add:
                supportListAddDialogue.newInstance(supportRaiseTicket);
                supportListAddDialogue.setOnPassDataListener(this);
                supportListAddDialogue.show();
                break;
            case R.id.filter:
                if (supportListMaster != null) {
                    supportListFilterDialog.newInstance(supportListMaster);
                    supportListFilterDialog.setOnPassDataListener(this);
                    supportListFilterDialog.show();
                }
                break;
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

    public String getPath(Uri uri) {
        String[] projection = {MediaStore.Images.Media.DATA};
        Cursor cursor = managedQuery(uri, projection, null, null, null);
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        return cursor.getString(column_index);
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
                                fileName = response.body().getFileUploadData().getFileName();
                                supportListAddDialogue.getData(fileName);
                                //attachFile.setText(fileName);
                            } else {
                                MyToast.normalMessage(response.body().getMessage(), activity);
                            }
                        }
                    } else {
                        Log.d(Constants.failureResponse + " FileUpload", response.toString());
                    }
                    Loader.showLoad(activity, false);
                }

                @Override
                public void onFailure(@NonNull Call<GetFileUpload> call, @NonNull Throwable t) {
                    Log.d(Constants.failureResponse + " FileUpload", t.toString());
                    Loader.showLoad(activity, false);
                    MyToast.errorMessage(t.toString(), activity);
                }
            });

        }
    }

    @Override
    public void onLoadMore() {
        if (page_no != null) {
            call_supportlist_api(false);
        }
    }

    @Override
    public void onPassData(boolean filter, String subCategory, String search) {
        searchName = search;
        subCategoryId = subCategory;
        call_supportlist_api(filter);
    }

    @Override
    public void onPassData() {
        searchName = "";
        subCategoryId = "";
        goToTopRecycler = true;
        call_supportlist_api(true);
    }

}