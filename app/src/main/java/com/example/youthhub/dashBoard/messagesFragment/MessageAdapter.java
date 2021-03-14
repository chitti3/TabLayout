package com.example.youthhub.dashBoard.messagesFragment;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.youthhub.DataModel;
import com.example.youthhub.R;
import com.example.youthhub.dashBoard.dashboard.LikeActivity;
import com.example.youthhub.dashBoard.eventFragment.EventAdapter;
import com.example.youthhub.resModel.event.EventList;
import com.example.youthhub.utils.AppUtils;
import com.example.youthhub.utils.Constants;
import com.example.youthhub.utils.FontTypeFace;
import com.example.youthhub.utils.Preference;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

import static com.example.youthhub.utils.Constants.App_CHAT_USER_ONLINE;
import static com.makeramen.roundedimageview.RoundedImageView.TAG;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MyViewHolder> implements View.OnClickListener {

    public static final String TAG = MessageAdapter.class.getSimpleName();
    private List<MessageListResponse.UserList> userLists;
    private List<MessageListResponse.UserList> exampleListFull;
    Activity activity;
    private String imgUrl;

    private OnLoadMoreListener onLoadMoreListener;
    private PassDataListener passDataListener;
    private boolean isLoading;
    private int visibleThreshold = 5;
    private int lastVisibleItem, totalItemCount;


    MessageAdapter(final RecyclerView messageRecycler, final List<MessageListResponse.UserList> userLists, Activity activity, String imgUrl) {
        this.userLists = userLists;
        this.activity = activity;
        this.imgUrl = imgUrl;
        exampleListFull = new ArrayList<>(userLists);

        final LinearLayoutManager linearLayoutManager = (LinearLayoutManager) messageRecycler.getLayoutManager();
        messageRecycler.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                boolean scrolled = AppUtils.isLastItemDisplaying(messageRecycler);
                if (scrolled) {
                    if (linearLayoutManager != null) {
                        totalItemCount = linearLayoutManager.getItemCount();
                    }
                    if (linearLayoutManager != null) {
                        lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();
                    }
                    if (!isLoading && totalItemCount <= (lastVisibleItem + visibleThreshold)) {
                        if (onLoadMoreListener != null) {
                            onLoadMoreListener.onLoadMore();
                        }
                        isLoading = true;
                    }
                }
            }
        });
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }


    void setOnLoadMoreListener(OnLoadMoreListener mOnLoadMoreListener) {
        this.onLoadMoreListener = mOnLoadMoreListener;
    }

    void setPassDataListener(PassDataListener passDataListener) {
        this.passDataListener = passDataListener;
    }

    public void addAll(List<MessageListResponse.UserList> userLists) {
        this.userLists = userLists;
        notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.messages_layout, parent, false);
        itemView.setOnClickListener(this);
        return new MyViewHolder(itemView);
    }



    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        callTypeFace(holder);
        holder.constrain.setOnClickListener(this);
        MessageListResponse.UserList dataModel = userLists.get(position);
     //   Log.d(TAG, "onBindViewHolder: "+new Gson().toJson(dataModel));
        holder.messageName.setText(dataModel.getUm_name());
        holder.messageText.setText(dataModel.getLatest_message());
        holder.messageTime.setText(dataModel.getLast_chat_on());
        Log.d(TAG, "onBindViewHolder:getUser_online_status "+dataModel.getUser_online_status());
     if (dataModel.getUser_online_status().equals(App_CHAT_USER_ONLINE)){
         holder.onlineShow.setVisibility(View.VISIBLE);
     }else{
         holder.onlineShow.setVisibility(View.GONE);
        }
        if (dataModel.getUnread_count().equals("0")){
            holder.messageCount.setVisibility(View.GONE);
        }else{
            holder.messageCount.setVisibility(View.VISIBLE);
            holder.messageCount.setText(dataModel.getUnread_count());
        }
       // holder.messageImg.setBackground(activity.getResources().getDrawable(R.drawable.textview_circle2));
        if (dataModel.getUm_profile_picture() != null && !dataModel.getUm_profile_picture().isEmpty()) {

            holder.messageImg.setVisibility(View.VISIBLE);
            //invisible because text constrained to msg text
            holder.receive_msg_name.setVisibility(View.INVISIBLE);

            Glide.with(activity)
                    .load(Constants.getLoadGlide(activity,dataModel.getUm_profile_picture()))
                    .apply(AppUtils.getRequestOption())
                    .into(holder.messageImg);
        } else {
            holder.messageImg.setVisibility(View.GONE);
            holder.receive_msg_name.setVisibility(View.VISIBLE);
            holder.receive_msg_name.setText(dataModel.getUsername_code());
        }

        holder.constrain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString(Constants.App_CHAT_ID, String.valueOf(userLists.get(position).getChat_id()));
                bundle.putString(Constants.App_CHAT_USERCODE, String.valueOf(userLists.get(position).getUm_code()));
                Intent intent = new Intent(activity,MessageActivity.class);
                intent.putExtras(bundle);
                activity.startActivity(intent);
                activity.overridePendingTransition(R.anim.activity_slide_up,R.anim.stay);
            }
        });
 /*       Glide.with(activity)
                .load(Constants.getLoadGlide(activity, imgUrl + dataModel.getUm_profile_picture()))
                .apply(AppUtils.getRequestOptionWithoutOverride())
                .into(holder.messageImg);*/
     /*   if (position == 2) {
            holder.onlineShow.setVisibility(View.VISIBLE);
            holder.messageCount.setVisibility(View.VISIBLE);
        }*/

    }

    private void callTypeFace(MyViewHolder holder) {
        holder.messageName.setTypeface(FontTypeFace.fontBold(activity));
        holder.messageText.setTypeface(FontTypeFace.fontMedium(activity));
        holder.messageTime.setTypeface(FontTypeFace.fontMedium(activity));
        holder.messageCount.setTypeface(FontTypeFace.fontBold(activity));
    }

    @Override
    public void onClick(View v) {

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.message_img)
        CircleImageView messageImg;
        @BindView(R.id.online_show)
        ImageView onlineShow;
        @BindView(R.id.message_name)
        TextView messageName;
        @BindView(R.id.message_time)
        TextView messageTime;
        @BindView(R.id.message_text)
        TextView messageText;
        @BindView(R.id.message_count)
        TextView messageCount;
        @BindView(R.id.receive_msg_name)
        TextView receive_msg_name;
        @BindView(R.id.constrain)
        ConstraintLayout constrain;

        public MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, itemView);
        }
    }

    public void setLoaded() {
        isLoading = false;
    }

    @Override
    public int getItemCount() {
        return userLists == null ? 0 : userLists.size();
    }


    public interface OnLoadMoreListener {
        void onLoadMore();
    }

    public interface PassDataListener {
        void passData(MessageListResponse.UserList userList, boolean viewPage, int position);
    }

    public Filter getFilter() {

        return filter;

    }


    Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {

            List<MessageListResponse.UserList> filteredList = new ArrayList<>();


            if(charSequence == null | charSequence.length() == 0){
                filteredList.addAll(exampleListFull);

            }else{
                String searchChr = charSequence.toString().toLowerCase().trim();

                for(MessageListResponse.UserList userModel: exampleListFull){
                    if(userModel.getUm_name().toLowerCase().contains(searchChr)){
                        filteredList.add(userModel);
                    }
                }

            }
            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }


        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {

            userLists.clear();
            userLists.addAll((List) filterResults.values);
            notifyDataSetChanged();


        }
    };


}