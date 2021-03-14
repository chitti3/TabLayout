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
import com.example.youthhub.resModel.profile.interest.ProfileInterestAddResponse;
import com.example.youthhub.resModel.profile.profileinfo.ProfileInfoResp;
import com.example.youthhub.resModel.profile.technicalskill.ProfileTechnicalSkillAddResponse;
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

public class TechSkillsAdapter extends RecyclerView.Adapter<TechSkillsAdapter.MyViewHolder> implements TechnicalSkillsDialog.OnUpdatePassDataListener,
        InterestDialog.OnUpdatePassDataListener {

    Activity activity;
    ProfileInfoResp profileInfoResp;

    private BasicResponse basicResponse;
    String type_adapter;

    //Technical Skill
    private String mskilltxt = null;
    private String mleveltxt = null;
    private String mtechnicalId = null;
    private String userType = "";
    private ProfileTechnicalSkillAddResponse profileTechnicalSkillAddResponse;
    private ProfileInterestAddResponse profileInterestAddResponse;
    //Interest
    private String minterestId = null;
    private String minteresttxt = null;
    private boolean mb = false;
    private int techskillposition = 0;

    public TechSkillsAdapter(Activity activity, ProfileInfoResp profileInfoResp, String type_adapter, String userType) {
        this.activity = activity;
        this.profileInfoResp = profileInfoResp;
        this.type_adapter = type_adapter;
        this.userType = userType;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tech_skills_adapter, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int i) {
        callTypeFace(holder);
        //holder.skillsDelete.setVisibility(View.VISIBLE);
        holder.skillsDelete.setVisibility(View.GONE);


        if (type_adapter.equals("Technical Skills")) {
            holder.skills_delete2.setVisibility(View.VISIBLE);
            holder.skillsTitle.setText(profileInfoResp.getData().getTechnicalSkills().get(i).getSkuName());
            holder.skillsRating.setText(profileInfoResp.getData().getTechnicalSkills().get(i).getSkuLevel());

            holder.skills_delete2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    call_delete_technical_skills_api(profileInfoResp.getData().getTechnicalSkills().get(i).getSkuSequenceId());
                    removeAt(i);
                }
            });
            holder.cardTechnicalskil.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    call_update_technicalskill_master_api(profileInfoResp.getData().getTechnicalSkills().get(i).getSkuSequenceId(), TechSkillsAdapter.this, i);
                }
            });


        } else if (type_adapter.equals("Interests")) {
            holder.skillsTitle.setText(profileInfoResp.getData().getInterests().get(i).getInuName());
            holder.skillsRating.setVisibility(View.GONE);
            holder.skillsDelete.setVisibility(View.VISIBLE);
            holder.skills_delete2.setVisibility(View.GONE);

            holder.skillsDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    call_delete_interests_api(profileInfoResp.getData().getInterests().get(i).getInuInterestId());
                    removeAt(i);
                }
            });
            holder.cardTechnicalskil.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    call_update_interest_master_api(profileInfoResp.getData().getInterests().get(i).getInuInterestId(), TechSkillsAdapter.this, i);
                }
            });
        } else if (type_adapter.equals("Languages")) {
            holder.skillsTitle.setText(profileInfoResp.getData().getLanguage().get(i).getLamName());
            holder.skillsRating.setVisibility(View.GONE);
            holder.skillsDelete.setVisibility(View.VISIBLE);
            holder.skills_delete2.setVisibility(View.GONE);

            holder.skillsDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    call_delete_languages_api(profileInfoResp.getData().getLanguage().get(i).getLauSequenceId());
                    removeAt(i);
                }
            });
            holder.cardTechnicalskil.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //   call_update_interest_master_api(profileInfoResp.getData().getInterests().get(i).getInuInterestId(), TechSkillsAdapter.this, i);
                }
            });
        } else {
            holder.skillsTitle.setText(profileInfoResp.getData().getTechnicalSkills().get(i).getSkuName());
            holder.skillsRating.setText(profileInfoResp.getData().getTechnicalSkills().get(i).getSkuLevel());
            holder.skillsDelete.setVisibility(View.VISIBLE);
            holder.skills_delete2.setVisibility(View.GONE);

            holder.skillsDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    call_delete_technical_skills_api(profileInfoResp.getData().getTechnicalSkills().get(i).getSkuSequenceId());
                    removeAt(i);
                }
            });
        }

/*
        if (userType.equalsIgnoreCase("1")){
            holder.skillsDelete.setVisibility(View.INVISIBLE);
        }else{
            holder.skillsDelete.setVisibility(View.INVISIBLE);
        }

 */


    }

    private void callTypeFace(MyViewHolder holder) {
        holder.skillsTitle.setTypeface(FontTypeFace.fontBold(activity));
        holder.skillsRating.setTypeface(FontTypeFace.fontMedium(activity));
    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: "+type_adapter);
        Log.d(TAG, "getItemCount: "+profileInfoResp.getData().getInterests().size());
        if (type_adapter.equals("Technical Skills")) {
            return profileInfoResp.getData().getTechnicalSkills().size();
        } else if (type_adapter.equals("Interests")) {
            return profileInfoResp.getData().getInterests().size();
        } else if (type_adapter.equals("Languages")) {
            return profileInfoResp.getData().getLanguage().size();
        }
        return 0;
    }

    @Override
    public void onUpdatePassData(String technicalId, String skilltxt, String leveltxt, int position, boolean b) {
        mtechnicalId = technicalId;
        mskilltxt = skilltxt;
        mleveltxt = leveltxt;
        techskillposition = position;
        call_update_technicalSkill_api(true,techskillposition);
    }

    @Override
    public void onUpdatePassData(String interestId, String interesttxt, boolean b) {
        minterestId = interestId;
        minteresttxt = interesttxt;
        mb = b;
        call_update_interest_api(true);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.skills_title)
        TextView skillsTitle;
        @BindView(R.id.skills_rating)
        TextView skillsRating;
        @BindView(R.id.skills_delete)
        ImageView skillsDelete;
        @BindView(R.id.skills_delete2)
        ImageView skills_delete2;
        @BindView(R.id.card_technicalskil)
        ConstraintLayout cardTechnicalskil;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


    private void call_delete_technical_skills_api(String technical_skills_id) {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            Call<BasicResponse> call = ApiClient.getApiInterface().deleteTechnicalSkills(Constants.getApiKey(activity), Constants.getAccessKey(activity),
                    Constants.getToken(activity), technical_skills_id
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
                    call_delete_technical_skills_api(technical_skills_id);
                    Log.d(Constants.failureResponse, " profile_info_update" + t.toString());
                    Loader.showLoad(activity, false);
                }
            });

        }
    }

    private void call_delete_interests_api(String interest_id) {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            Call<BasicResponse> call = ApiClient.getApiInterface().deleteInterests(Constants.getApiKey(activity), Constants.getAccessKey(activity),
                    Constants.getToken(activity), interest_id
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
                    call_delete_interests_api(interest_id);
                    Log.d(Constants.failureResponse, " profile_info_update" + t.toString());
                    Loader.showLoad(activity, false);
                }
            });

        }
    }

    private void call_delete_languages_api(String language_id) {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            Call<BasicResponse> call = ApiClient.getApiInterface().deleteLanguages(Constants.getApiKey(activity), Constants.getAccessKey(activity),
                    Constants.getToken(activity), language_id
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
                    call_delete_languages_api(language_id);
                    Log.d(Constants.failureResponse, " profile_info_update" + t.toString());
                    Loader.showLoad(activity, false);
                }
            });

        }
    }


    private void call_update_technicalSkill_api(boolean mfilter, int techskillposition) {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            Call<ProfileTechnicalSkillAddResponse> call = ApiClient.getApiInterface().updateTechnicalSkill(Constants.getApiKey(activity), Constants.getAccessKey(activity),
                    Constants.getToken(activity), mtechnicalId,
                    mskilltxt, mleveltxt);

            call.enqueue(new Callback<ProfileTechnicalSkillAddResponse>() {
                @Override
                public void onResponse(@NonNull Call<ProfileTechnicalSkillAddResponse> call, @NonNull Response<ProfileTechnicalSkillAddResponse> response) {
                    if (response.isSuccessful()) {
                        //   Log.d(TAG, "onResponse:ProfileYouthInfoResponse 1 ");
                        if (response.body() != null) {
                            if (response.body().getStatus() == 1) {
                                profileTechnicalSkillAddResponse = response.body();
                                profileInfoResp.getData().getTechnicalSkills().set(techskillposition,profileTechnicalSkillAddResponse.getData().getTechnicalSkills().get(techskillposition));
                                TechSkillsAdapter.this.notifyDataSetChanged();
                                MyToast.normalMessage("Technical Skill update successfully", activity);
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
                public void onFailure(@NonNull Call<ProfileTechnicalSkillAddResponse> call, @NonNull Throwable t) {
                    call_update_technicalSkill_api(mfilter, techskillposition);
                    Log.d(Constants.failureResponse, " call_create_awards_api" + t.toString());
                    Loader.showLoad(activity, false);
                }
            });

        }
    }


    private void call_update_interest_api(boolean mfilter) {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            Call<ProfileInterestAddResponse> call = ApiClient.getApiInterface().updateInterest(Constants.getApiKey(activity), Constants.getAccessKey(activity),
                    Constants.getToken(activity), minterestId,
                    minteresttxt);

            call.enqueue(new Callback<ProfileInterestAddResponse>() {
                @Override
                public void onResponse(@NonNull Call<ProfileInterestAddResponse> call, @NonNull Response<ProfileInterestAddResponse> response) {
                    if (response.isSuccessful()) {
                        //   Log.d(TAG, "onResponse:ProfileYouthInfoResponse 1 ");
                        if (response.body() != null) {
                            if (response.body().getStatus() == 1) {
                                profileInterestAddResponse = response.body();
                                profileInfoResp.getData().getInterests().add(profileInterestAddResponse.getData().getInterests().get(0));
                                TechSkillsAdapter.this.notifyDataSetChanged();
                                MyToast.normalMessage("Interest update successfully", activity);
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
                public void onFailure(@NonNull Call<ProfileInterestAddResponse> call, @NonNull Throwable t) {
                    call_update_technicalSkill_api(mfilter, techskillposition);
                    Log.d(Constants.failureResponse, " call_create_awards_api" + t.toString());
                    Loader.showLoad(activity, false);
                }
            });

        }
    }

    private void call_update_technicalskill_master_api(String qualification_id, TechSkillsAdapter techSkillsAdapter, int position) {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            Call<ProfileTechnicalSkillAddResponse> call = ApiClient.getApiInterface().updateMasterTechnicalSkill(Constants.getApiKey(activity), Constants.getAccessKey(activity),
                    Constants.getToken(activity),
                    qualification_id);

            call.enqueue(new Callback<ProfileTechnicalSkillAddResponse>() {
                @Override
                public void onResponse(@NonNull Call<ProfileTechnicalSkillAddResponse> call, @NonNull Response<ProfileTechnicalSkillAddResponse> response) {
                    if (response.isSuccessful()) {
                        //   Log.d(TAG, "onResponse:ProfileYouthInfoResponse 1 ");
                        if (response.body() != null) {
                            if (response.body().getStatus() == 1) {
                                profileTechnicalSkillAddResponse = response.body();
                                Log.d(TAG, "onResponse:educationUpdateMaster " + new Gson().toJson(profileTechnicalSkillAddResponse));
                                //       update_ui(profileInfoMaster);
                                TechnicalSkillsDialog technicalSkillsDialog = new TechnicalSkillsDialog(activity, profileTechnicalSkillAddResponse.getData().getTechnicalSkills().get(0), true, position);
                                technicalSkillsDialog.setOnUpdatePassDataListener(TechSkillsAdapter.this);
                                technicalSkillsDialog.show();

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
                public void onFailure(@NonNull Call<ProfileTechnicalSkillAddResponse> call, @NonNull Throwable t) {
                    call_update_technicalskill_master_api(qualification_id, techSkillsAdapter, position);
                    Log.d(Constants.failureResponse + " ProfileInfo", t.toString());
                    Loader.showLoad(activity, false);
                }
            });

        }
    }


    private void call_update_interest_master_api(String qualification_id, TechSkillsAdapter techSkillsAdapter, int position) {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            Call<ProfileInterestAddResponse> call = ApiClient.getApiInterface().updateMasterInterest(Constants.getApiKey(activity), Constants.getAccessKey(activity),
                    Constants.getToken(activity),
                    qualification_id);

            call.enqueue(new Callback<ProfileInterestAddResponse>() {
                @Override
                public void onResponse(@NonNull Call<ProfileInterestAddResponse> call, @NonNull Response<ProfileInterestAddResponse> response) {
                    if (response.isSuccessful()) {
                        //   Log.d(TAG, "onResponse:ProfileYouthInfoResponse 1 ");
                        if (response.body() != null) {
                            if (response.body().getStatus() == 1) {
                                profileInterestAddResponse = response.body();
                                Log.d(TAG, "onResponse:educationUpdateMaster " + new Gson().toJson(profileInterestAddResponse));
                                //       update_ui(profileInfoMaster);
                                InterestDialog interestDialog = new InterestDialog(activity, profileInterestAddResponse.getData().getInterests().get(0), true, position);
                                interestDialog.setOnUpdatePassDataListener(TechSkillsAdapter.this);
                                interestDialog.show();

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
                public void onFailure(@NonNull Call<ProfileInterestAddResponse> call, @NonNull Throwable t) {
                    call_update_interest_master_api(qualification_id, techSkillsAdapter, position);
                    Log.d(Constants.failureResponse + " ProfileInfo", t.toString());
                    Loader.showLoad(activity, false);
                }
            });

        }
    }



    public void removeAt(int position) {

        if (type_adapter.equals("Technical Skills")) {
            profileInfoResp.getData().getTechnicalSkills().remove(position);
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, profileInfoResp.getData().getTechnicalSkills().size());
        } else if (type_adapter.equals("Interests")) {
            profileInfoResp.getData().getInterests().remove(position);
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, profileInfoResp.getData().getInterests().size());
        } else if (type_adapter.equals("Languages")) {
            profileInfoResp.getData().getLanguage().remove(position);
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, profileInfoResp.getData().getLanguage().size());
        } else {
            profileInfoResp.getData().getTechnicalSkills().remove(position);
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, profileInfoResp.getData().getTechnicalSkills().size());
        }

    }

}
