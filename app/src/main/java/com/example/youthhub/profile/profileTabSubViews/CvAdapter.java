package com.example.youthhub.profile.profileTabSubViews;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.youthhub.R;
import com.example.youthhub.resModel.profile.BasicResponse;
import com.example.youthhub.resModel.profile.attachcv.ProfileAttachCVMasterResponse;
import com.example.youthhub.resModel.profile.profileinfo.ProfileInfoResp;
import com.example.youthhub.retrofit.ApiClient;
import com.example.youthhub.utils.Constants;
import com.example.youthhub.utils.DownloadTask;
import com.example.youthhub.utils.FontTypeFace;
import com.example.youthhub.utils.Loader;
import com.example.youthhub.utils.MyToast;
import com.example.youthhub.utils.NetWorkUtil;
import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.youthhub.profile.ProfileFragment.TAG;

public class CvAdapter extends RecyclerView.Adapter<CvAdapter.MyViewHolder> {

    Activity activity;
    ProfileInfoResp profileInfoResp;
    private BasicResponse basicResponse;
    ProfileAttachCVMasterResponse profileAttachCVMasterResponse;
String userType="";
    public CvAdapter(Activity activity, ProfileInfoResp profileInfoResp, ProfileAttachCVMasterResponse profileAttachCVMasterResponse, String userType) {
        this.activity = activity;
        this.profileInfoResp = profileInfoResp;
        this.profileAttachCVMasterResponse = profileAttachCVMasterResponse;
        this.userType = userType;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cv_adapter, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int i) {
        callTypeFace(holder);
        holder.cvDelete.setVisibility(View.VISIBLE);

        holder.cvTitle.setText(profileInfoResp.getData().getUserCv().get(i).getUcvTitle());
        holder.cvDate.setText(profileInfoResp.getData().getUserCv().get(i).getUcvCreatedOn());
        holder.resume.setText(profileInfoResp.getData().getUserCv().get(i).getUcvTypeName());

        holder.cvDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call_delete_cv_api(profileInfoResp.getData().getUserCv().get(i).getUcvCvId());
                removeAt(i);
            }
        });
        Log.d(TAG, "onBindViewHolder:getUcvFileName "+profileInfoResp.getData().getUserCv().get(i).getUcvFileName());
        holder.cvDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (profileInfoResp.getData().getUserCv().get(i).getUcvFileName()!=null){
                    String cvpath = profileInfoResp.getData().getCvPath();
                    new DownloadTask(activity,cvpath+profileInfoResp.getData().getUserCv().get(i).getUcvFileName());
                }
            }
        });
        if (profileInfoResp.getData().getUserCv().get(i).getUcvFileName()!=null){
            holder.cvDownload.setVisibility(View.VISIBLE);
        }else {
            holder.cvDownload.setVisibility(View.GONE);
        }


        if (userType.equalsIgnoreCase("1")) {
            holder.cvDelete.setVisibility(View.VISIBLE);
        } else {
            holder.cvDelete.setVisibility(View.INVISIBLE);
        }
    }

    private void callTypeFace(MyViewHolder holder) {
        holder.cvTitle.setTypeface(FontTypeFace.fontBold(activity));
        holder.cvDate.setTypeface(FontTypeFace.fontMedium(activity));
    }

    @Override
    public int getItemCount() {
        return profileInfoResp.getData().getUserCv().size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {


        @BindView(R.id.cv_title)
        TextView cvTitle;
        @BindView(R.id.cv_date)
        TextView cvDate;
        @BindView(R.id.resume)
        TextView resume;
        @BindView(R.id.cv_download)
        TextView cvDownload;
        @BindView(R.id.cv_delete)
        ImageView cvDelete;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    private void call_delete_cv_api(String cv_id) {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            Call<BasicResponse> call = ApiClient.getApiInterface().deleteCV(Constants.getApiKey(activity), Constants.getAccessKey(activity),
                    Constants.getToken(activity),cv_id
            );

            call.enqueue(new Callback<BasicResponse>() {
                @Override
                public void onResponse(@NonNull Call<BasicResponse> call, @NonNull Response<BasicResponse> response) {
                    if (response.isSuccessful()) {
                        //   Log.d(TAG, "onResponse:ProfileYouthInfoResponse 1 ");
                        if (response.body() != null) {
                            if (response.body().getStatus() == 1) {
                                basicResponse = response.body();

                                MyToast.normalMessage(response.body().getMessage(), activity);
                            } else {
                                //     Log.d(TAG, "onResponse:ProfileYouthInfoResponse else "+new Gson().toJson(profileInfoResp));
                                Log.d(TAG, "onResponse:failure "+new Gson().toJson(response.body()));
                                MyToast.errorMessage(response.body().getMessage(), activity);
                            }

                        }
                    } else {
                        Log.d(Constants.failureResponse, " profile_info_update" + response.toString());
                    }
                    Loader.showLoad(activity, false);
                }

                @Override
                public void onFailure(@NonNull Call<BasicResponse> call, @NonNull Throwable t) {
                    call_delete_cv_api(cv_id);
                    Log.d(Constants.failureResponse, " profile_info_update" + t.toString());
                    Loader.showLoad(activity, false);
                }
            });

        }
    }
    public void removeAt(int position) {
        profileInfoResp.getData().getUserCv().remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, profileInfoResp.getData().getUserCv().size());
    }
}
