package com.example.youthhub.profile.profileTabSubViews;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.youthhub.R;
import com.example.youthhub.resModel.profile.BasicResponse;
import com.example.youthhub.resModel.profile.profileexperience.add.update.ProfileExperienceUpdateResponse;
import com.example.youthhub.resModel.profile.profileexperience.add.updatemaster.ProfileUpdateMasterResponse;
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

public class ExperienceAdapter extends RecyclerView.Adapter<ExperienceAdapter.MyViewHolder> implements ExperienceDialog.OnUpdatePassDataListener {

    Activity activity;
    ProfileInfoResp profileInfoResp;
    ExperienceKeyAdapter experienceKeyAdapter;

    private BasicResponse basicResponse;
    ProfileAddMasterResponse profileAddMasterResponse;
    private ProfileUpdateMasterResponse profileUpdateMasterResponse;
    public static final String TAG_WISHLIST_SELECT = "select_explist";


    private String mestartDatetxt = null;
    private String meendDatetxt = null;
    private String mjobDesignationtxt = null;
    private String mjobTitletxt = null;
    private String mjobTypeId = null;
    private String mjobDescriptiontxt = null;
    private String mresponability = null;
    private String meisinprocess = "0";
    private String mjobId = null;
    private boolean mb = false;
    private ProfileExperienceUpdateResponse profileExperienceUpdateResponse;
    String userType = "";
    int position =0;

    public ExperienceAdapter(Activity activity, ProfileInfoResp profileInfoResp,
                             ProfileAddMasterResponse profileAddMasterResponse, String userType) {
        this.activity = activity;
        this.profileInfoResp = profileInfoResp;
        this.profileAddMasterResponse = profileAddMasterResponse;
        this.userType = userType;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.experience_adapter, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int i) {
        callTypeFace(holder);
        holder.expDelete.setVisibility(View.VISIBLE);
        holder.expTitle.setText(profileInfoResp.getData().getExperience().get(i).getEmuDesignation());
        holder.expDate.setText(profileInfoResp.getData().getExperience().get(i).getStartDate() + "-" + profileInfoResp.getData().getExperience().get(i).getEndDate());
        holder.expPosition.setText(profileInfoResp.getData().getExperience().get(i).getEmuJtTypeName());
        holder.expYears.setText(profileInfoResp.getData().getExperience().get(i).getDiffYear());
        holder.expDesc.setText(profileInfoResp.getData().getExperience().get(i).getEmuDescription());

        if (profileInfoResp.getData().getExperience().get(i).getEmuResponsibilities().size()==0){
            holder.txtKeyresponability.setVisibility(View.GONE);
        }else{
            holder.txtKeyresponability.setVisibility(View.VISIBLE);
        }
        experienceKeyAdapter = new ExperienceKeyAdapter(activity, profileInfoResp.getData().getExperience().get(i).getEmuResponsibilities());
        holder.exprecycleResponability.setAdapter(experienceKeyAdapter);
        LinearLayoutManager wishList_LayoutManager = new LinearLayoutManager(activity);
        holder.exprecycleResponability.setLayoutManager(wishList_LayoutManager);
        experienceKeyAdapter.notifyDataSetChanged();

        holder.expDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call_delete_experience_api(profileInfoResp.getData().getExperience().get(i).getEmuEmploymentId());
                removeAt(i);
            }
        });

        holder.experienceCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call_update_experience_master_api(profileInfoResp.getData().getExperience().get(i).getEmuEmploymentId(), ExperienceAdapter.this, i);
               // updateAt(i);
                // removeAt(i);
            }
        });

        if (userType.equalsIgnoreCase("1")){
            holder.expDelete.setVisibility(View.VISIBLE);
        }else{
            holder.expDelete.setVisibility(View.INVISIBLE);
        }
    }

    private void callTypeFace(MyViewHolder holder) {
        holder.expTitle.setTypeface(FontTypeFace.fontBold(activity));
        holder.expDate.setTypeface(FontTypeFace.fontMedium(activity));
    }

    @Override
    public int getItemCount() {
        return profileInfoResp.getData().getExperience().size();
    }

    @Override
    public void onUpdatePassData(String jobId, String jobTitletxt, String jobTypeId, String jobDesignationtxt,
                                 String jobDescriptiontxt, String startDatetxt, String endDatetxt, String isinprocess,
                                 String responability,int aposition, boolean b) {
        mjobId = jobId;
        mjobTitletxt = jobTitletxt;
        mjobTypeId = jobTypeId;
        mjobDesignationtxt = jobDesignationtxt;
        mjobDescriptiontxt = jobDescriptiontxt;
        mestartDatetxt = startDatetxt;
        meendDatetxt = endDatetxt;
        meisinprocess = isinprocess;
        mresponability = responability;
        position = aposition;
        mb = b;
        call_update_experience_api(true,position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.exp_title)
        TextView expTitle;
        @BindView(R.id.exp_date)
        TextView expDate;
        @BindView(R.id.exp_position)
        TextView expPosition;
        @BindView(R.id.exp_years)
        TextView expYears;
        @BindView(R.id.exp_desc)
        TextView expDesc;
        @BindView(R.id.exp_delete)
        ImageView expDelete;
        @BindView(R.id.exprecycle_responability)
        RecyclerView exprecycleResponability;
        @BindView(R.id.txt_keyresponability)
        TextView txtKeyresponability;
        @BindView(R.id.experience_card)
        ConstraintLayout experienceCard;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    private void call_delete_experience_api(String experience_id) {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            Call<BasicResponse> call = ApiClient.getApiInterface().deleteExperience(Constants.getApiKey(activity), Constants.getAccessKey(activity),
                    Constants.getToken(activity), experience_id
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
                    call_delete_experience_api(experience_id);
                    Log.d(Constants.failureResponse, " profile_info_update" + t.toString());
                    Loader.showLoad(activity, false);
                }
            });

        }
    }



    private void call_update_experience_api(boolean mfilter, int position) {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            Call<ProfileExperienceUpdateResponse> call = ApiClient.getApiInterface().updateExperience(Constants.getApiKey(activity), Constants.getAccessKey(activity),
                    Constants.getToken(activity),mjobId,
                    mjobTitletxt, mjobDesignationtxt, mjobDescriptiontxt, mjobTypeId, mestartDatetxt, meendDatetxt
                    , meisinprocess,mresponability);

            call.enqueue(new Callback<ProfileExperienceUpdateResponse>() {
                @Override
                public void onResponse(@NonNull Call<ProfileExperienceUpdateResponse> call, @NonNull Response<ProfileExperienceUpdateResponse> response) {
                    if (response.isSuccessful()) {
                        //   Log.d(TAG, "onResponse:ProfileYouthInfoResponse 1 ");
                        if (response.body() != null) {
                            if (response.body().getStatus() == 1) {
                                profileExperienceUpdateResponse = response.body();
                                profileInfoResp.getData().getExperience().set(position,profileExperienceUpdateResponse.getData().getExperience().get(0));
                                ExperienceAdapter.this.notifyDataSetChanged();
                                MyToast.normalMessage("Experience update successfully", activity);
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
                public void onFailure(@NonNull Call<ProfileExperienceUpdateResponse> call, @NonNull Throwable t) {
                    call_update_experience_api(mfilter, position);
                    Log.d(Constants.failureResponse, " profile_info_update" + t.toString());
                    Loader.showLoad(activity, false);
                }
            });

        }
    }


    private void call_update_experience_master_api(String qualification_id, ExperienceAdapter experienceAdapter, int position) {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            Call<ProfileUpdateMasterResponse> call = ApiClient.getApiInterface().updateMasterExperience(Constants.getApiKey(activity), Constants.getAccessKey(activity),
                    Constants.getToken(activity),
                    qualification_id);
            Log.d(TAG, "educationUpdateMaster: "+qualification_id);
            Log.d(TAG, "educationUpdateMaster:position "+position);
          //  Log.d(TAG, "call_update_experience_master_api: "+qualification_id);
            call.enqueue(new Callback<ProfileUpdateMasterResponse>() {
                @Override
                public void onResponse(@NonNull Call<ProfileUpdateMasterResponse> call, @NonNull Response<ProfileUpdateMasterResponse> response) {
                    Log.d(TAG, "onResponse:educationUpdateMaster res" );
                    if (response.isSuccessful()) {
                        //   Log.d(TAG, "onResponse:ProfileYouthInfoResponse 1 ");
                        Log.d(TAG, "onResponse:educationUpdateMaster response" );

                        if (response.body() != null) {
                            if (response.body().getStatus() == 1) {
                                Log.d(TAG, "onResponse:educationUpdateMaster response.body()" + new Gson().toJson(response.body()));

                                profileUpdateMasterResponse = response.body();
                                Log.d(TAG, "onResponse:educationUpdateMaster " + new Gson().toJson(profileUpdateMasterResponse.getData().getExperience().get(0)));

                                //       update_ui(profileInfoMaster);
                                ExperienceDialog experienceDialog = new ExperienceDialog(activity, profileUpdateMasterResponse.getData().getExperience().get(0), profileAddMasterResponse, true, position);
                                experienceDialog.setOnUpdatePassDataListener(experienceAdapter);
                                experienceDialog.show();

                            } else {
                                Log.d(TAG, "onResponse:educationUpdateMaster else ");

                                //  MyToast.errorMessage(response.body().getMessage(), activity);
                            }

                        }
                    } else {
                        Log.d(Constants.failureResponse , " educationUpdateMaster"+ response.toString());
                        Loader.showLoad(activity, false);
                    }
                    Loader.showLoad(activity, false);
                }

                @Override
                public void onFailure(@NonNull Call<ProfileUpdateMasterResponse> call, @NonNull Throwable t) {
                    call_update_experience_master_api(qualification_id, experienceAdapter, position);
                    Log.d(Constants.failureResponse , " educationUpdateMaster"+ t.toString());
                    Loader.showLoad(activity, false);
                }
            });

        }
    }


    public void removeAt(int position) {
        profileInfoResp.getData().getExperience().remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, profileInfoResp.getData().getExperience().size());
    }
    public void updateAt(int position) {
        profileInfoResp.getData().getExperience().remove(position);
        //notifyItemRemoved(position);
        notifyItemChanged(position, profileInfoResp.getData().getExperience().size());
    }
}
