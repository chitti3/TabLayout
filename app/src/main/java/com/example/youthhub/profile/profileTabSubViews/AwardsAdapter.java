package com.example.youthhub.profile.profileTabSubViews;

import android.app.Activity;
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
import com.example.youthhub.resModel.profile.profileawards.ProfileAwardsAddResponse;
import com.example.youthhub.resModel.profile.profileinfo.ProfileInfoResp;
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

public class AwardsAdapter extends RecyclerView.Adapter<AwardsAdapter.MyViewHolder> implements AwardsDialog.OnUpdatePassDataListener {

    Activity activity;
    ProfileInfoResp profileInfoResp;
    public static final String TAG = "AwardsAdapter";
    private BasicResponse basicResponse;
    //Awards
    private String mawardsid = null;
    private String mtitletxt = null;
    private String moccupationtxt = null;
    private String madescriptiontxt = null;
    private String missuedBytxt = null;
    private String mdateSpinnertxt = null;
    private boolean mb = false;
    private ProfileAwardsAddResponse profileAwardsAddResponse;
    String userType = "";
    int updateposition = 0;

    public AwardsAdapter(Activity activity, ProfileInfoResp profileInfoResp, String userType) {
        this.activity = activity;
        this.profileInfoResp = profileInfoResp;
        this.userType = userType;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.awards_adapter, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int i) {
        callTypeFace(holder);

        holder.awardsDelete.setVisibility(View.VISIBLE);

        holder.awardsTitle.setText(profileInfoResp.getData().getAchievement().get(i).getAcuTitle());
        holder.awardsDate.setText(profileInfoResp.getData().getAchievement().get(i).getIssuedYear());
        holder.awardsPlace.setText(profileInfoResp.getData().getAchievement().get(i).getAcuProviderName());
        holder.awardsRecieved.setText(profileInfoResp.getData().getAchievement().get(i).getAcuOccupation());
        holder.awardsDesc.setText(profileInfoResp.getData().getAchievement().get(i).getAcuDescription());
        holder.awardsDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call_delete_achievement_api(profileInfoResp.getData().getAchievement().get(i).getAcuAchievementId());
                removeAt(i);
            }
        });

        holder.awardsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call_update_awards_master_api(profileInfoResp.getData().getAchievement().get(i).getAcuAchievementId(), AwardsAdapter.this, i);
                // removeAt(i);
            }
        });

        if (userType.equalsIgnoreCase("1")) {
            holder.awardsDelete.setVisibility(View.VISIBLE);
        } else {
            holder.awardsDelete.setVisibility(View.INVISIBLE);
        }
    }

    private void callTypeFace(MyViewHolder holder) {
        holder.awardsTitle.setTypeface(FontTypeFace.fontBold(activity));
        holder.awardsDate.setTypeface(FontTypeFace.fontMedium(activity));
    }

    @Override
    public int getItemCount() {
        return profileInfoResp.getData().getAchievement().size();
    }

    @Override
    public void onUpdatePassData(String awardsid, String titletxt, String occupationtxt, String descriptiontxt, String dateSpinnertxt, String issuedBytxt, int position, boolean b) {
        mawardsid = awardsid;
        mtitletxt = titletxt;
        moccupationtxt = occupationtxt;
        madescriptiontxt = descriptiontxt;
        mdateSpinnertxt = dateSpinnertxt;
        missuedBytxt = issuedBytxt;
        updateposition = position;
        mb = b;
        call_update_awards_api(true,updateposition);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.awards_title)
        TextView awardsTitle;
        @BindView(R.id.awards_date)
        TextView awardsDate;
        @BindView(R.id.awards_place)
        TextView awardsPlace;
        @BindView(R.id.awards_recieved)
        TextView awardsRecieved;
        @BindView(R.id.awards_desc)
        TextView awardsDesc;
        @BindView(R.id.awards_delete)
        ImageView awardsDelete;
        @BindView(R.id.awards_card)
        ConstraintLayout awardsCard;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }


    }


    private void call_update_awards_master_api(String qualification_id, AwardsAdapter awardsAdapter, int position) {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            Call<ProfileAwardsAddResponse> call = ApiClient.getApiInterface().updateMasterAwards(Constants.getApiKey(activity), Constants.getAccessKey(activity),
                    Constants.getToken(activity),
                    qualification_id);

            call.enqueue(new Callback<ProfileAwardsAddResponse>() {
                @Override
                public void onResponse(@NonNull Call<ProfileAwardsAddResponse> call, @NonNull Response<ProfileAwardsAddResponse> response) {
                    if (response.isSuccessful()) {
                        //   Log.d(TAG, "onResponse:ProfileYouthInfoResponse 1 ");
                        if (response.body() != null) {
                            if (response.body().getStatus() == 1) {
                                profileAwardsAddResponse = response.body();
                                Log.d(TAG, "onResponse:educationUpdateMaster " + new Gson().toJson(profileAwardsAddResponse));
                                //       update_ui(profileInfoMaster);
                                AwardsDialog awardsDialog = new AwardsDialog(activity, profileAwardsAddResponse.getData().getAchievement().get(0), true, position);
                                awardsDialog.setOnUpdatePassDataListener(awardsAdapter);
                                awardsDialog.show();

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
                public void onFailure(@NonNull Call<ProfileAwardsAddResponse> call, @NonNull Throwable t) {
                    call_update_awards_master_api(qualification_id, awardsAdapter, position);
                    Log.d(Constants.failureResponse + " ProfileInfo", t.toString());
                    Loader.showLoad(activity, false);
                }
            });

        }
    }


    private void call_update_awards_api(boolean mfilter, int updateposition) {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            Call<ProfileAwardsAddResponse> call = ApiClient.getApiInterface().updateAwards(Constants.getApiKey(activity), Constants.getAccessKey(activity),
                    Constants.getToken(activity), mawardsid,
                    mtitletxt, moccupationtxt, missuedBytxt, madescriptiontxt, mdateSpinnertxt);
            Log.d(TAG, "upddateAwards: " + mdateSpinnertxt);
            call.enqueue(new Callback<ProfileAwardsAddResponse>() {
                @Override
                public void onResponse(@NonNull Call<ProfileAwardsAddResponse> call, @NonNull Response<ProfileAwardsAddResponse> response) {
                    if (response.isSuccessful()) {
                        //   Log.d(TAG, "onResponse:ProfileYouthInfoResponse 1 ");
                        if (response.body() != null) {
                            if (response.body().getStatus() == 1) {
                                profileAwardsAddResponse = response.body();
                                profileInfoResp.getData().getAchievement().set(updateposition,profileAwardsAddResponse.getData().getAchievement().get(updateposition));
                                AwardsAdapter.this.notifyDataSetChanged();
                                MyToast.normalMessage("Awards update successfully", activity);
                            } else {
                                //     Log.d(TAG, "onResponse:ProfileYouthInfoResponse else "+new Gson().toJson(profileInfoResp));
                                Log.d(TAG, "onResponse:failure " + new Gson().toJson(response.body()));
                                MyToast.errorMessage(response.body().getMessage(), activity);
                            }

                        }
                    } else {
                        Log.d(Constants.failureResponse, " call_create_awards_api" + response.toString());
                    }
                    Loader.showLoad(activity, false);
                }

                @Override
                public void onFailure(@NonNull Call<ProfileAwardsAddResponse> call, @NonNull Throwable t) {
                    call_update_awards_api(mfilter, updateposition);
                    Log.d(Constants.failureResponse, " call_create_awards_api" + t.toString());
                    Loader.showLoad(activity, false);
                }
            });

        }
    }


    private void call_delete_achievement_api(String achievement_id) {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            Call<BasicResponse> call = ApiClient.getApiInterface().deleteAchievement(Constants.getApiKey(activity), Constants.getAccessKey(activity),
                    Constants.getToken(activity), achievement_id
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
                    call_delete_achievement_api(achievement_id);
                    Log.d(Constants.failureResponse, " profile_info_update" + t.toString());
                    Loader.showLoad(activity, false);
                }
            });

        }
    }

    public void removeAt(int position) {
        profileInfoResp.getData().getAchievement().remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, profileInfoResp.getData().getAchievement().size());
    }
}
