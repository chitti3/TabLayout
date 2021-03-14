package com.example.youthhub.dashBoard.dashboard;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.youthhub.R;
import com.example.youthhub.dashBoard.eventFragment.EventActivity;
import com.example.youthhub.resModel.event.eventView.EventViewResponse;
import com.example.youthhub.resModel.post.postList.EventList;
import com.example.youthhub.resModel.profilepostlist.EventListItem;
import com.example.youthhub.retrofit.ApiClient;
import com.example.youthhub.utils.Constants;
import com.example.youthhub.utils.FontTypeFace;
import com.example.youthhub.utils.Loader;
import com.example.youthhub.utils.MyToast;
import com.example.youthhub.utils.NetWorkUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SuggestedEventsAdapter extends RecyclerView.Adapter<SuggestedEventsAdapter.MyViewHolder> {

    Activity activity;
    private List<EventListItem> eventLists;
    private String eventLogoPath;
    private EventViewResponse eventViewResponse;

    SuggestedEventsAdapter(Activity activity, List<EventListItem> eventLists, String eventLogoPath) {
        this.activity = activity;
        this.eventLists = eventLists;
        this.eventLogoPath = eventLogoPath;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.suggested_event_adapter, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        callTypeFace(holder);

        EventListItem eventList = eventLists.get(position);

        if ((eventLists.size() - 1) == position) {
            holder.suggestedEventImg.setImageDrawable(ContextCompat.getDrawable(activity, R.drawable.suggest_img2));
            holder.suggestView3.setVisibility(View.VISIBLE);
        }

        if (position == 0) {
            holder.suggestView1.setVisibility(View.VISIBLE);
        }

        holder.suggestedEventTitle.setText(eventList.getTitle());
        holder.suggestedDate.setText(eventList.getStartDate());

        String time = eventList.getStartTime()+" - "+eventList.getEndTime();

        holder.suggestedTime.setText(time);

        RequestOptions options = new RequestOptions()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .priority(Priority.HIGH);


        Glide.with(activity)
                .load(Constants.getLoadGlide(activity, eventLogoPath + eventList.getLogo()))
                .apply(options)
                .into(holder.suggestedEventImg);

        holder.suggestedEventImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callEvents(eventList.getCode());
              
            }
        });

    }

    public void callEvents(String code){
      


        System.out.println("===============getcoded" +code);

        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);

            Call<EventViewResponse> responseCall = ApiClient.getApiInterface().getEventView(Constants.getApiKey(activity), Constants.getAccessKey(activity), Constants.getToken(activity), code);
            responseCall.enqueue(new Callback<EventViewResponse>() {
                @Override
                public void onResponse(@NonNull Call<EventViewResponse> call, @NonNull Response<EventViewResponse> response) {
                    if (response.isSuccessful()) {
                        eventViewResponse = response.body();
                        if (response.body() != null) {
                            if (response.body().getStatus() == 1) {
                                if (eventViewResponse.getStatus() == 1) {
                                    Bundle bundle = new Bundle();
                                    bundle.putParcelable(Constants.EventViewRes, eventViewResponse);
                                    Intent eventIntent = new Intent(activity, EventActivity.class);
                                    eventIntent.putExtras(bundle);
                                    activity.startActivity(eventIntent);
                                    activity.overridePendingTransition(R.anim.activity_slide_up, R.anim.stay);
                                }
                            } else {
                                MyToast.errorMessage(response.body().getMessage(), activity);
                            }
                        }
                    } else {
                        Log.d(Constants.failureResponse + " EventView", response.toString());
                    }
                    Loader.showLoad(activity, false);
                }

                @Override
                public void onFailure(@NonNull Call<EventViewResponse> call, @NonNull Throwable t) {
                    Log.d(Constants.failureResponse + " EventView", t.toString());
                    MyToast.errorMessage("Please Try Again Later..", activity);
                    Loader.showLoad(activity, false);
                }
            });
        }


    }


    private void callTypeFace(MyViewHolder holder) {
        holder.suggestedEventTitle.setTypeface(FontTypeFace.fontBold(activity));
        holder.suggestedDate.setTypeface(FontTypeFace.fontSemiBold(activity));
    }

    @Override
    public int getItemCount() {
        return eventLists.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.suggest_view1)
        View suggestView1;
        @BindView(R.id.suggest_view2)
        View suggestView2;
        @BindView(R.id.suggested_event_img)
        ImageView suggestedEventImg;
        @BindView(R.id.suggested_event_title)
        TextView suggestedEventTitle;
        @BindView(R.id.suggested_date)
        TextView suggestedDate;
        @BindView(R.id.suggested_time)
        TextView suggestedTime;
        @BindView(R.id.suggest_card_view)
        CardView suggestCardView;
        @BindView(R.id.suggest_view3)
        View suggestView3;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
