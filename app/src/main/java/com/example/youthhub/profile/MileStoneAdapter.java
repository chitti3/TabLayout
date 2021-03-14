package com.example.youthhub.profile;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.youthhub.R;
import com.example.youthhub.resModel.profile.journey.ProfileJourneyListResponse;

import com.example.youthhub.resModel.profile.milestone.ProfileMilestoneListResponse;
import com.example.youthhub.resModel.profile.visualjourney.add.MilestoneUpdateMaster;
import com.example.youthhub.retrofit.ApiClient;
import com.example.youthhub.utils.AppUtils;
import com.example.youthhub.utils.Constants;
import com.example.youthhub.utils.FontTypeFace;
import com.example.youthhub.utils.Loader;
import com.example.youthhub.utils.NetWorkUtil;
import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MileStoneAdapter extends RecyclerView.Adapter<MileStoneAdapter.MyViewHolder> implements View.OnClickListener {
    Activity activity;
    ProfileMilestoneListResponse profileMilestoneListResponse;
    ProfileJourneyListResponse profileJourneyListResponse;
    MilestoneDelete milestoneDelete;
    String id,vjcode;
    String milestoneid;

    public MileStoneAdapter(Activity activity, ProfileMilestoneListResponse profileMilestoneListResponse,String id,String vjcode) {
        this.activity = activity;
        this.profileMilestoneListResponse = profileMilestoneListResponse;
        this.id=id;
        this.vjcode=vjcode;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mile_stone_adapter, viewGroup, false);
        view.setOnClickListener(this);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        callTypeFace(holder);
       /* if(position==0){
            holder.topViewOffCard.setVisibility(View.VISIBLE);
        }

        if(position==2){
            holder.milestoneImg.setVisibility(View.VISIBLE);
        }else {
            holder.milestoneImg.setVisibility(View.GONE);
        }
        if(position==3){
            holder.bottomOffBottomView.setVisibility(View.GONE);
        }*/

        if (id.equals("1"))
        {
            holder.mileDelete.setVisibility(View.VISIBLE);
            holder.milestoneCard.setEnabled(true);
        }else
        {
            holder.mileDelete.setVisibility(View.GONE);
            holder.milestoneCard.setEnabled(false);

        }
        if (profileMilestoneListResponse.getData().getMilestoneList().get(position).getJucImage().length() != 0) {
            holder.milestoneImg.setVisibility(View.VISIBLE);
            Glide.with(activity)
                    .load(Constants.getLoadGlide(activity, profileMilestoneListResponse.getData().getImagePathMedium() + profileMilestoneListResponse.getData().getMilestoneList().get(position).getJucImage()))
                    .apply(AppUtils.getRequestOption())
                    .listener(AppUtils.requestListener)
                    .into(holder.milestoneImg);
        }else {
            holder.milestoneImg.setVisibility(View.GONE);
        }
        holder.title.setText(profileMilestoneListResponse.getData().getMilestoneList().get(position).getJusTitle());
        holder.date.setText(profileMilestoneListResponse.getData().getMilestoneList().get(position).getJusDate());
        holder.desc.setText(profileMilestoneListResponse.getData().getMilestoneList().get(position).getJusDetail());
        holder.mileDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                milestoneid =profileMilestoneListResponse.getData().getMilestoneList().get(position).getJusMilestoneId();
                call_delete_api(vjcode, milestoneid);
                removeAt(position);



            }
        });
        holder.milestoneCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id=profileMilestoneListResponse.getData().getMilestoneList().get(position).getJusMilestoneId();
                call_update_milestone(id,vjcode,position);
            }
        });


        if (position==profileMilestoneListResponse.getData().getMilestoneList().size()){
            holder.bottomOffBottomView.setVisibility(View.GONE);
        }
    }

    private void call_update_milestone(String milestoneid, String vjcode,int position)
    {

        if (NetWorkUtil.isNetworkConnected(activity));
        {
            Loader.showLoad(activity, true);
            Call<MilestoneUpdateMaster> call =ApiClient.getApiInterface().getmilestoneupdatemaster(Constants.getApiKey(activity), Constants.getAccessKey(activity),
                    Constants.getToken(activity),milestoneid,vjcode);
            call.enqueue(new Callback<MilestoneUpdateMaster>() {
                @Override
                public void onResponse(Call<MilestoneUpdateMaster> call, Response<MilestoneUpdateMaster> response) {
                    Log.e("Response",response.message());
                    MilestoneUpdateMaster milestoneUpdateMaster=response.body();
                    Log.e("Response", new Gson().toJson(milestoneUpdateMaster.getData().getMilestoneview()));
                    //   AddMilestoneActivity addMilestoneActivity =new AddMilestoneActivity(activity,milestoneUpdateMaster,true,position);
                    Intent intent = new Intent(activity,AddMilestoneActivity.class);
                    intent.putExtra("mileid",milestoneid);
                    intent.putExtra("vjid",vjcode);
                    intent.putExtra("boolean",true);
                    activity.startActivity(intent);

                    Loader.showLoad(activity,false);
                }

                @Override
                public void onFailure(Call<MilestoneUpdateMaster> call, Throwable t) {
                    Log.e("Response",t.getMessage());
                    Loader.showLoad(activity,false);
                }
            });

        }
    }

    private void call_delete_api(String code, String jumCode) {
        if (NetWorkUtil.isNetworkConnected(activity))
        {
            Loader.showLoad(activity, true);
            Call<MilestoneDelete> call = ApiClient.getApiInterface().getmilestonedelete(Constants.getApiKey(activity), Constants.getAccessKey(activity),
                    Constants.getToken(activity),jumCode,code);
            call.enqueue(new Callback<MilestoneDelete>() {
                @Override
                public void onResponse(Call<MilestoneDelete> call, Response<MilestoneDelete> response) {
                    if (response.isSuccessful())
                    {
                        milestoneDelete=response.body();
                        Toast.makeText(activity, milestoneDelete.getMessage(), Toast.LENGTH_SHORT).show();
                        Loader.showLoad(activity,false);
                    }
                }

                @Override
                public void onFailure(Call<MilestoneDelete> call, Throwable t) {
                    Toast.makeText(activity, t.getMessage(), Toast.LENGTH_SHORT).show();
                    Log.e("failureresponse",t.toString());
                    Loader.showLoad(activity,false);

                }
            });
        }
    }


    private void callTypeFace(MyViewHolder holder) {
        holder.title.setTypeface(FontTypeFace.fontBold(activity));
    }

    @Override
    public int getItemCount() {
        return profileMilestoneListResponse.getData().getMilestoneList().size();
    }

    @Override
    public void onClick(View v) {

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {


        @BindView(R.id.top_view_off_card)
        View topViewOffCard;
        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.date)
        TextView date;
        @BindView(R.id.milestone_img)
        ImageView milestoneImg;
        @BindView(R.id.mile_delete)
        ImageView mileDelete;
        @BindView(R.id.desc)
        TextView desc;
        @BindView(R.id.milestone_card)
        CardView milestoneCard;
        @BindView(R.id.round_view)
        View roundView;
        @BindView(R.id.right_off_roundView)
        View rightOffRoundView;
        @BindView(R.id.top_off_roundView)
        View topOffRoundView;
        @BindView(R.id.top_off_topView)
        View topOffTopView;
        @BindView(R.id.bottom_off_roundView)
        View bottomOffRoundView;
        @BindView(R.id.bottom_off_bottomView)
        View bottomOffBottomView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
    public void removeAt(int position) {
        profileMilestoneListResponse.getData().getMilestoneList().remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, profileMilestoneListResponse.getData().getMilestoneList().size());
    }
}
