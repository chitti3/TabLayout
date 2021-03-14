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
import com.example.youthhub.resModel.profile.profileeducation.update.ProfileUpdateEducationResponse;
import com.example.youthhub.resModel.profile.profileinfo.ProfileInfoResp;
import com.example.youthhub.resModel.profile.profilemaster.ProfileAddMasterResponse;
import com.example.youthhub.resModel.profile.volunteer.add.create.ProfileAddVolunteerResponse;
import com.example.youthhub.resModel.profile.volunteer.add.create.update.ProfileUpdateVolunteerResponse;
import com.example.youthhub.resModel.profile.volunteer.add.create.updatemaster.ProfileVolunteerUpdateMasterResponse;
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

public class VolunteerAdapter extends RecyclerView.Adapter<VolunteerAdapter.MyViewHolder> implements VolunteerDialog.OnUpdatePassDataListener {

    Activity activity;
    ProfileInfoResp profileInfoResp;

    private BasicResponse basicResponse;
    ProfileAddMasterResponse profileAddMasterResponse;
    private ProfileVolunteerUpdateMasterResponse profileVolunteerUpdateMasterResponse;
    private String mvolunteerId = null;
    private String misinprocess = "0";
    private String mvolcatId = null;
    private String mrolettxt = null;
    private String mstartDatetxt = null;
    private String mendDatetxt = null;
    private String morganisationtxt = null;
    private String mdescriptiontxt = null;
    private boolean mb = false;
    private ProfileUpdateVolunteerResponse profileUpdateVolunteerResponse;
    String userType = "";

    public VolunteerAdapter(Activity activity, ProfileInfoResp profileInfoResp, ProfileAddMasterResponse profileAddMasterResponse, String userType) {
        this.activity = activity;
        this.profileInfoResp = profileInfoResp;
        this.profileAddMasterResponse = profileAddMasterResponse;
        this.userType = userType;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.volunteer_adapter, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int i) {
        callTypeFace(holder);
        String year = "";
        holder.volunteerDelete.setVisibility(View.VISIBLE);
        if (!profileInfoResp.getData().getVolunteering().get(i).getDiffYear().equals("0")) {
            year = year + profileInfoResp.getData().getVolunteering().get(i).getDiffYear() + " yrs ";
        }
        if (!profileInfoResp.getData().getVolunteering().get(i).getDiffMonth().equals("0")) {
            year = year + profileInfoResp.getData().getVolunteering().get(i).getDiffMonth() + " mon ";
        }
        holder.volunteerTitle.setText(profileInfoResp.getData().getVolunteering().get(i).getVouTitle());
        holder.volunteerDate.setText(profileInfoResp.getData().getVolunteering().get(i).getVouStartDate() + " - " + profileInfoResp.getData().getVolunteering().get(i).getVouEndDate());
        holder.volunteerPosition.setText(profileInfoResp.getData().getVolunteering().get(i).getVouProviderName());
        holder.volunteerYears.setText(year);
        holder.volunteerDesc.setText(profileInfoResp.getData().getVolunteering().get(i).getVouDescription());
        holder.volunteerDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call_delete_volunteer_api(profileInfoResp.getData().getVolunteering().get(i).getVouQualificationId());
                removeAt(i);
            }
        }); holder.volunteerCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call_update_volunteer_master_api(profileInfoResp.getData().getVolunteering().get(i).getVouQualificationId(),VolunteerAdapter.this,i);
               // removeAt(i);
            }
        });

        if (userType.equalsIgnoreCase("1")){
            holder.volunteerDelete.setVisibility(View.VISIBLE);
        }else{
            holder.volunteerDelete.setVisibility(View.INVISIBLE);
        }
    }

    private void callTypeFace(MyViewHolder holder) {
        holder.volunteerTitle.setTypeface(FontTypeFace.fontBold(activity));
        holder.volunteerDate.setTypeface(FontTypeFace.fontMedium(activity));
    }

    @Override
    public int getItemCount() {
        return profileInfoResp.getData().getVolunteering().size();
    }

    @Override
    public void onUpdatePassData(String volunteerId, String volcatId, String rolettxt, String startDatetxt, String endDatetxt, String organisationtxt, String descriptiontxt, String isinprocess, boolean b) {
        mvolunteerId = volunteerId;
        mvolcatId = volcatId;
        mrolettxt = rolettxt;
        mstartDatetxt = startDatetxt;
        mendDatetxt = endDatetxt;
        morganisationtxt = organisationtxt;
        mdescriptiontxt = descriptiontxt;
        misinprocess = isinprocess;
        mb = b;
        call_update_volunteer_api(true);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.volunteer_title)
        TextView volunteerTitle;
        @BindView(R.id.volunteer_date)
        TextView volunteerDate;
        @BindView(R.id.volunteer_position)
        TextView volunteerPosition;
        @BindView(R.id.volunteer_years)
        TextView volunteerYears;
        @BindView(R.id.volunteer_desc)
        TextView volunteerDesc;
        @BindView(R.id.volunteer_delete)
        ImageView volunteerDelete;
        @BindView(R.id.volunteer_card)
        ConstraintLayout volunteerCard;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }



    private void call_update_volunteer_api(boolean mfilter) {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            Call<ProfileUpdateVolunteerResponse> call = ApiClient.getApiInterface().updateVolunteer(Constants.getApiKey(activity), Constants.getAccessKey(activity),
                    Constants.getToken(activity),mvolunteerId,
                    mrolettxt, morganisationtxt, mdescriptiontxt, mvolcatId, mstartDatetxt, mendDatetxt
                    , misinprocess);

            call.enqueue(new Callback<ProfileUpdateVolunteerResponse>() {
                @Override
                public void onResponse(@NonNull Call<ProfileUpdateVolunteerResponse> call, @NonNull Response<ProfileUpdateVolunteerResponse> response) {
                    if (response.isSuccessful()) {
                        //   Log.d(TAG, "onResponse:ProfileYouthInfoResponse 1 ");
                        if (response.body() != null) {
                            if (response.body().getStatus() == 1) {
                                profileUpdateVolunteerResponse = response.body();
                                profileInfoResp.getData().getVolunteering().add(profileUpdateVolunteerResponse.getData().getVolunteering().get(0));
                                VolunteerAdapter.this.notifyDataSetChanged();
                                MyToast.normalMessage("Volunteer update successfully", activity);
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
                public void onFailure(@NonNull Call<ProfileUpdateVolunteerResponse> call, @NonNull Throwable t) {
                    call_update_volunteer_api(mfilter);
                    Log.d(Constants.failureResponse, " profile_info_update" + t.toString());
                    Loader.showLoad(activity, false);
                }
            });

        }
    }


    private void call_update_volunteer_master_api(String qualification_id, VolunteerAdapter volunteerAdapter, int position) {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            Call<ProfileVolunteerUpdateMasterResponse> call = ApiClient.getApiInterface().updateMasterVolunteer(Constants.getApiKey(activity), Constants.getAccessKey(activity),
                    Constants.getToken(activity),
                    qualification_id);

            call.enqueue(new Callback<ProfileVolunteerUpdateMasterResponse>() {
                @Override
                public void onResponse(@NonNull Call<ProfileVolunteerUpdateMasterResponse> call, @NonNull Response<ProfileVolunteerUpdateMasterResponse> response) {
                    if (response.isSuccessful()) {
                        //   Log.d(TAG, "onResponse:ProfileYouthInfoResponse 1 ");
                        if (response.body() != null) {
                            if (response.body().getStatus() == 1) {
                                profileVolunteerUpdateMasterResponse = response.body();
                                Log.d(TAG, "onResponse:educationUpdateMaster " + new Gson().toJson(profileVolunteerUpdateMasterResponse));
                                //       update_ui(profileInfoMaster);
                                VolunteerDialog volunteerDialog = new VolunteerDialog(activity,profileVolunteerUpdateMasterResponse.getData().getVolunteering().get(0),profileAddMasterResponse,true,position);
                                volunteerDialog.setOnUpdatePassDataListener(volunteerAdapter);
                                volunteerDialog.show();

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
                public void onFailure(@NonNull Call<ProfileVolunteerUpdateMasterResponse> call, @NonNull Throwable t) {
                    call_update_volunteer_master_api(qualification_id,volunteerAdapter, position);
                    Log.d(Constants.failureResponse + " ProfileInfo", t.toString());
                    Loader.showLoad(activity, false);
                }
            });

        }
    }




    private void call_delete_volunteer_api(String volunteer_id) {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            Call<BasicResponse> call = ApiClient.getApiInterface().deleteVolunteering(Constants.getApiKey(activity), Constants.getAccessKey(activity),
                    Constants.getToken(activity), volunteer_id
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
                    call_delete_volunteer_api(volunteer_id);
                    Log.d(Constants.failureResponse, " profile_info_update" + t.toString());
                    Loader.showLoad(activity, false);
                }
            });

        }
    }

    public void removeAt(int position) {
        profileInfoResp.getData().getVolunteering().remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, profileInfoResp.getData().getVolunteering().size());
    }

}
