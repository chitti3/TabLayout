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

import static com.example.youthhub.profile.ProfileFragment.TAG;

public class TestimonialAdapter extends RecyclerView.Adapter<TestimonialAdapter.MyViewHolder> {

    Activity activity;
    ProfileInfoResp profileInfoResp;
    private BasicResponse basicResponse;
    String userType = "";

    public TestimonialAdapter(Activity activity, ProfileInfoResp profileInfoResp, String userType) {
        this.activity = activity;
        this.profileInfoResp = profileInfoResp;
        this.userType = userType;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.testimonials_adapter, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        callTypeFace(myViewHolder);
        myViewHolder.title.setText(profileInfoResp.getData().getTestimonials().get(i).getSkmName());
        myViewHolder.date.setText(profileInfoResp.getData().getTestimonials().get(i).getTeuCreatedOn());
        myViewHolder.subTitle.setText(profileInfoResp.getData().getTestimonials().get(i).getTeuProviderCompany());
        myViewHolder.mail.setText(profileInfoResp.getData().getTestimonials().get(i).getTeuProviderEmail());
        myViewHolder.desc.setText(profileInfoResp.getData().getTestimonials().get(i).getTeuProviderMessage());
        myViewHolder.endorsedName.setText(profileInfoResp.getData().getTestimonials().get(0).getTeuProviderName() + " - " + profileInfoResp.getData().getTestimonials().get(0).getTeuProviderTitle());

    myViewHolder.delete.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            call_delete_testmonial_api(profileInfoResp.getData().getTestimonials().get(i).getTeuTestimonialId());
            removeAt(i);
        }
    });

        if (userType.equalsIgnoreCase("1")){
            myViewHolder.delete.setVisibility(View.VISIBLE);
        }else{
            myViewHolder.delete.setVisibility(View.INVISIBLE);
        }
    }

    private void callTypeFace(MyViewHolder myViewHolder) {
        myViewHolder.title.setTypeface(FontTypeFace.fontBold(activity));
        myViewHolder.date.setTypeface(FontTypeFace.fontMedium(activity));
        myViewHolder.endorsedTxt.setTypeface(FontTypeFace.fontBold(activity));
    }

    @Override
    public int getItemCount() {
        return profileInfoResp.getData().getTestimonials().size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.date)
        TextView date;
        @BindView(R.id.sub_title)
        TextView subTitle;
        @BindView(R.id.mail)
        TextView mail;
        @BindView(R.id.desc)
        TextView desc;
        @BindView(R.id.endorsed_txt)
        TextView endorsedTxt;
        @BindView(R.id.endorsed_name)
        TextView endorsedName;
        @BindView(R.id.delete)
        ImageView delete;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
    private void call_delete_testmonial_api(String testmonial_id) {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            Call<BasicResponse> call = ApiClient.getApiInterface().deleteTestimonial(Constants.getApiKey(activity), Constants.getAccessKey(activity),
                    Constants.getToken(activity),testmonial_id
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
                    call_delete_testmonial_api(testmonial_id);
                    Log.d(Constants.failureResponse, " profile_info_update" + t.toString());
                    Loader.showLoad(activity, false);
                }
            });

        }
    }
    public void removeAt(int position) {
        profileInfoResp.getData().getTestimonials().remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, profileInfoResp.getData().getTestimonials().size());
    }

}
