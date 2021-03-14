package com.example.youthhub.profile.profileTabSubViews;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.youthhub.R;
import com.example.youthhub.resModel.profile.BasicResponse;
import com.example.youthhub.resModel.profile.profileeducation.ProfileAddEducationResponse;
import com.example.youthhub.resModel.profile.profileeducation.update.ProfileUpdateEducationResponse;
import com.example.youthhub.resModel.profile.profileeducation.updatesuccess.ProfileUpdatedSuccessResponse;
import com.example.youthhub.resModel.profile.profileinfo.ProfileInfoResp;
import com.example.youthhub.resModel.profile.profilemaster.ProfileAddMasterResponse;
import com.example.youthhub.retrofit.ApiClient;
import com.example.youthhub.utils.Constants;
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


public class EducationAdapter extends RecyclerView.Adapter<EducationAdapter.MyViewHolder> implements EducationDialog.OnUpdatePassDataListener{

    Activity activity;
    ProfileInfoResp profileInfoResp;
    Context context;
    private BasicResponse basicResponse;
    ProfileAddMasterResponse profileAddMasterResponse;
    private ProfileUpdateEducationResponse profileUpdateEducationResponse;
    private String qualificaionId = null;
    private boolean isLoading = false;

    //Education
    String mregionId = null, morganizationCategoryId = null, mnceaId = null, mqualificationCategoryId = null, mquaProviderId = null,
            mquaTitlePassId = null,
            mtitleQualificationId = null, mstartDateId = null, mendDateId = null, mqualificationedt = null, mqualificationId = null,isinprocessedu=null;
    private boolean mb = false;
    private ProfileUpdatedSuccessResponse profileUpdatedSuccessResponse;
    private int mposition;
    String userType = "";

    public EducationAdapter(Activity activity, ProfileInfoResp profileInfoResp, ProfileAddMasterResponse profileAddMasterResponse, String userType) {
        this.activity = activity;
        this.profileInfoResp = profileInfoResp;
        this.profileAddMasterResponse = profileAddMasterResponse;
        this.userType = userType;
        context = activity;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.education_adapter, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int i) {
        callTypeFace(holder);
        String year = "";
        holder.eduDelete.setVisibility(View.VISIBLE);
        if (!profileInfoResp.getData().getEducation().get(i).getDiffYear().equals("0")) {
            year = year + profileInfoResp.getData().getEducation().get(i).getDiffYear() + " yrs ";
        }
        if (!profileInfoResp.getData().getEducation().get(i).getDiffMonth().equals("0")) {
            year = year + profileInfoResp.getData().getEducation().get(i).getDiffMonth() + " mon ";
        }
        holder.eduTitle.setText(profileInfoResp.getData().getEducation().get(i).getQauTitle());
        holder.eduDate.setText(profileInfoResp.getData().getEducation().get(i).getQauStartDate() + " - " + profileInfoResp.getData().getEducation().get(i).getQauEndDate());
        holder.eduPosition.setText(profileInfoResp.getData().getEducation().get(i).getQapName());
        holder.eduYears.setText(year);
        holder.eduDesc.setText(profileInfoResp.getData().getEducation().get(i).getQauDescription());
        holder.eduDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call_delete_eduction_api(profileInfoResp.getData().getEducation().get(i).getQauQualificationId());
                removeAt(i);
            }
        });

        holder.educationCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: asd");
                call_educationUpdateMaster(profileInfoResp.getData().getEducation().get(i).getQauQualificationId(), EducationAdapter.this,i);

            }
        });

        if (userType.equalsIgnoreCase("1")){
            holder.eduDelete.setVisibility(View.VISIBLE);
        }else{
            holder.eduDelete.setVisibility(View.INVISIBLE);
        }

    }

    private void callTypeFace(MyViewHolder holder) {
        holder.eduTitle.setTypeface(FontTypeFace.fontBold(activity));
        holder.eduDate.setTypeface(FontTypeFace.fontMedium(activity));
    }

    @Override
    public int getItemCount() {
        return profileInfoResp.getData().getEducation().size();
    }




    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.edu_title)
        TextView eduTitle;
        @BindView(R.id.edu_date)
        TextView eduDate;
        @BindView(R.id.edu_position)
        TextView eduPosition;
        @BindView(R.id.edu_years)
        TextView eduYears;
        @BindView(R.id.edu_desc)
        TextView eduDesc;
        @BindView(R.id.edu_delete)
        ImageView eduDelete;
        @BindView(R.id.education_card)
        ConstraintLayout educationCard;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    private void call_delete_eduction_api(String education_id) {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            Call<BasicResponse> call = ApiClient.getApiInterface().deleteEduction(Constants.getApiKey(activity), Constants.getAccessKey(activity),
                    Constants.getToken(activity), education_id
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
                                Log.d(TAG, "onResponse:failure " + new Gson().toJson(response.body()));
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
                    call_delete_eduction_api(education_id);
                    Log.d(Constants.failureResponse, " profile_info_update" + t.toString());
                    Loader.showLoad(activity, false);
                }
            });

        }
    }


    private void call_educationUpdateMaster(String qualification_id, EducationAdapter educationAdapter, int position) {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            Call<ProfileUpdateEducationResponse> call = ApiClient.getApiInterface().updateMasterEducation(Constants.getApiKey(activity), Constants.getAccessKey(activity),
                    Constants.getToken(activity),
                    qualification_id);

            call.enqueue(new Callback<ProfileUpdateEducationResponse>() {
                @Override
                public void onResponse(@NonNull Call<ProfileUpdateEducationResponse> call, @NonNull Response<ProfileUpdateEducationResponse> response) {
                    if (response.isSuccessful()) {
                        //   Log.d(TAG, "onResponse:ProfileYouthInfoResponse 1 ");
                        if (response.body() != null) {
                            if (response.body().getStatus() == 1) {
                                profileUpdateEducationResponse = response.body();
                                Log.d(TAG, "onResponse:educationUpdateMaster " + new Gson().toJson(profileUpdateEducationResponse));
                                //       update_ui(profileInfoMaster);
                                EducationDialog educationDialog = new EducationDialog(activity,profileUpdateEducationResponse.getData().getEducation().get(0),profileAddMasterResponse,true,position);
                                educationDialog.setOnUpdatePassDataListener(educationAdapter);
                                educationDialog.show();

                            } else {
                                Log.d(TAG, "onResponse:educationUpdateMaster else ");

                                //  MyToast.errorMessage(response.body().getMessage(), activity);
                            }

                        }
                    } else {
                        Log.d(Constants.failureResponse + " ProfileInfo", response.toString());
                        Loader.showLoad(activity, false);
                    }
                    Loader.showLoad(activity, false);
                }

                @Override
                public void onFailure(@NonNull Call<ProfileUpdateEducationResponse> call, @NonNull Throwable t) {
                    call_educationUpdateMaster(qualification_id,educationAdapter, position);
                    Log.d(Constants.failureResponse + " ProfileInfo", t.toString());
                    Loader.showLoad(activity, false);
                }
            });

        }
    }


    private void call_update_education_api(boolean mfilter, int mposition) {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            Call<ProfileUpdatedSuccessResponse> call = ApiClient.getApiInterface().updateEducation(Constants.getApiKey(activity), Constants.getAccessKey(activity),
                    Constants.getToken(activity),
                    mqualificationId, mregionId, morganizationCategoryId, mquaProviderId, mquaTitlePassId, mqualificationedt, mnceaId
                    , mqualificationCategoryId, mstartDateId, mendDateId, isinprocessedu
            );

            call.enqueue(new Callback<ProfileUpdatedSuccessResponse>() {
                @Override
                public void onResponse(@NonNull Call<ProfileUpdatedSuccessResponse> call, @NonNull Response<ProfileUpdatedSuccessResponse> response) {
                    if (response.isSuccessful()) {
                        //   Log.d(TAG, "onResponse:ProfileYouthInfoResponse 1 ");
                        if (response.body() != null) {
                            if (response.body().getStatus() == 1) {
                                profileUpdatedSuccessResponse = response.body();
                                profileInfoResp.getData().getEducation().set(mposition,profileUpdatedSuccessResponse.getData().getEducation().get(0));
                                EducationAdapter.this.notifyDataSetChanged();
                                MyToast.normalMessage("Education updated successfully", activity);
                            } else {
                                //     Log.d(TAG, "onResponse:ProfileYouthInfoResponse else "+new Gson().toJson(profileInfoResp));
                                Log.d(TAG, "onResponse:failure " + new Gson().toJson(response.body()));
                                MyToast.errorMessage(response.body().getMessage(), activity);
                            }

                        }
                    } else {
                        Log.d(Constants.failureResponse, " profile_info_update" + response.toString());
                    }
                    Loader.showLoad(activity, false);
                }

                @Override
                public void onFailure(@NonNull Call<ProfileUpdatedSuccessResponse> call, @NonNull Throwable t) {
                    call_update_education_api(mfilter, mposition);
                    Log.d(Constants.failureResponse, " profile_info_update" + t.toString());
                    Loader.showLoad(activity, false);
                }
            });

        }
    }




    @Override
    public void onUpdatePassData(String qualicationId, String regionId, String organizationCategoryId, String nceaId, String qualificationCategoryId, String quaProviderId, String quaTitlePassId, String titleQualificationId, String startDateId, String endDateId, String qualificationedt,String isinprocess,int position, boolean b) {
        mqualificationId = qualicationId;
        mregionId = regionId;
        morganizationCategoryId = organizationCategoryId;
        mnceaId = nceaId;
        mqualificationCategoryId = qualificationCategoryId;
        mquaProviderId = quaProviderId;
        mquaTitlePassId = quaTitlePassId;
        mtitleQualificationId = titleQualificationId;
        mstartDateId = startDateId;
        mendDateId = endDateId;
        mqualificationedt = qualificationedt;
        isinprocessedu = isinprocess;
        mposition = position;
        mb = b;
        call_update_education_api(true,mposition);
    }

    public void removeAt(int position) {
        profileInfoResp.getData().getEducation().remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, profileInfoResp.getData().getEducation().size());
    }

}
