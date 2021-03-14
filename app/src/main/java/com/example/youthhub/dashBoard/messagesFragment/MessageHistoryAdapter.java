package com.example.youthhub.dashBoard.messagesFragment;

import android.app.Activity;
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
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.youthhub.R;
import com.example.youthhub.utils.AppUtils;
import com.example.youthhub.utils.Constants;
import com.example.youthhub.utils.FontTypeFace;
import com.google.gson.Gson;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

import static com.example.youthhub.utils.Constants.App_CHAT_USER_ONLINE;

public class MessageHistoryAdapter extends RecyclerView.Adapter<MessageHistoryAdapter.MyViewHolder> implements View.OnClickListener {

    public static final String TAG = MessageHistoryAdapter.class.getSimpleName();
    private List<MessageChatHistoryResponse.Data.ChatList> chatLists;
    Activity activity;
    private String imgUrl;
    private String user_thumbnail_path;
    private String thumbnail_path;

    private MessageHistoryAdapter.OnLoadMoreListener onLoadMoreListener;
    private MessageHistoryAdapter.PassDataListener passDataListener;
    private boolean isLoading;
    private int visibleThreshold = 5;
    private int lastVisibleItem, totalItemCount;


    MessageHistoryAdapter(final RecyclerView messageRecycler, final List<MessageChatHistoryResponse.Data.ChatList> chatLists,
                          Activity activity, String imgUrl, String user_thumbnail_path, String thumbnail_path) {
        this.chatLists = chatLists;
        this.activity = activity;
        this.imgUrl = imgUrl;
        this.user_thumbnail_path = user_thumbnail_path;
        this.thumbnail_path = thumbnail_path;

        final LinearLayoutManager linearLayoutManager = (LinearLayoutManager) messageRecycler.getLayoutManager();
        messageRecycler.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                boolean scrolled = AppUtils.isLastItemDisplaying(messageRecycler);
                if (scrolled) {
                    if (linearLayoutManager != null) {
                        totalItemCount = linearLayoutManager.getItemCount();
                       // totalItemCount = 0;
                    }
                    if (linearLayoutManager != null) {
                       lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();
                    //    lastVisibleItem = linearLayoutManager.findFirstVisibleItemPosition();
                    }
                    Log.d(TAG, "onScrolled: totalItemCount"+totalItemCount);
                    Log.d(TAG, "onScrolled: lastVisibleItem"+lastVisibleItem);
                   if (!isLoading && totalItemCount <= (lastVisibleItem + visibleThreshold)) {
// (!isLoading && totalItemCount >= ( lastVisibleItem)) {
                   // if (!isLoading && totalItemCount == (0)) {
                       Log.d(TAG, "onScrolled: lastVisibleItem came");
                        if (onLoadMoreListener != null) {
                            Log.d(TAG, "onScrolled: lastVisibleItem came not null");
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


    void setOnLoadMoreListener(MessageHistoryAdapter.OnLoadMoreListener mOnLoadMoreListener) {
        this.onLoadMoreListener = mOnLoadMoreListener;
    }

    void setPassDataListener(MessageHistoryAdapter.PassDataListener passDataListener) {
        this.passDataListener = passDataListener;
    }

    public void addAll(List<MessageChatHistoryResponse.Data.ChatList> chatLists) {

        this.chatLists = chatLists;
        notifyDataSetChanged();
    }

    @Override
    public MessageHistoryAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.message_activity_include, parent, false);
        itemView.setOnClickListener(this);
        return new MessageHistoryAdapter.MyViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(MessageHistoryAdapter.MyViewHolder holder, final int position) {

        callTypeFace(holder);
        MessageChatHistoryResponse.Data.ChatList dataModel = chatLists.get(position);
        Log.d(TAG, "onBindViewHolder: " + new Gson().toJson(dataModel));

        if (dataModel.getCmes_type().equals("0")) {
            holder.circleImageViewleft.setVisibility(View.GONE);
            holder.chat_timeleft.setVisibility(View.GONE);
            holder.textViewleft.setVisibility(View.GONE);
            holder.projects_image_left.setVisibility(View.GONE);
            holder.receive_msg_name_left.setVisibility(View.GONE);
            holder.circleImageViewright.setVisibility(View.VISIBLE);
            holder.receive_msg_name_right.setVisibility(View.VISIBLE);
            holder.chat_timeright.setVisibility(View.VISIBLE);
            holder.textViewright.setVisibility(View.VISIBLE);
            holder.projects_image_right.setVisibility(View.VISIBLE);
            holder.textViewdate.setVisibility(View.GONE);

            holder.circleImageViewright.setBackground(activity.getResources().getDrawable(R.drawable.textview_circle2));
            if (dataModel.getUm_profile_picture() != null && !dataModel.getUm_profile_picture().isEmpty()) {

                holder.circleImageViewright.setVisibility(View.VISIBLE);
                //invisible because text constrained to msg text
                holder.receive_msg_name_right.setVisibility(View.INVISIBLE);

                Glide.with(activity)
                        .load(Constants.getLoadGlide(activity, user_thumbnail_path + dataModel.getUm_profile_picture()))
                        .apply(AppUtils.getRequestOption())
                        .into(holder.circleImageViewright);

            } else {
                holder.circleImageViewright.setVisibility(View.GONE);
                holder.receive_msg_name_right.setVisibility(View.VISIBLE);
                holder.receive_msg_name_right.setText(dataModel.getUsername_code());
            }
            holder.chat_timeright.setText(dataModel.getChat_time());
            if (!dataModel.getCmes_message().isEmpty() && dataModel.getCmes_message() != null) {
                holder.textViewright.setText(dataModel.getCmes_message());
            } else {
                holder.textViewright.setVisibility(View.GONE);
            }
            if (!dataModel.getCmes_file_name().isEmpty() && dataModel.getCmes_file_name() != null) {
                Glide.with(activity)
                        .load(Constants.getLoadGlide(activity, thumbnail_path + dataModel.getCmes_file_name()))
                        .apply(AppUtils.getRequestOptionWithoutOverride())
                        .into(holder.projects_image_right);
            } else {
                holder.projects_image_right.setVisibility(View.GONE);
            }

        } else /*if (dataModel.getCmes_type().equals("1"))*/ {
            holder.circleImageViewleft.setVisibility(View.VISIBLE);
            holder.chat_timeleft.setVisibility(View.VISIBLE);
            holder.textViewleft.setVisibility(View.VISIBLE);
            holder.projects_image_left.setVisibility(View.VISIBLE);
            holder.receive_msg_name_left.setVisibility(View.VISIBLE);
            holder.circleImageViewright.setVisibility(View.GONE);
            holder.receive_msg_name_right.setVisibility(View.GONE);
            holder.chat_timeright.setVisibility(View.GONE);
            holder.textViewright.setVisibility(View.GONE);
            holder.projects_image_right.setVisibility(View.GONE);
            holder.textViewdate.setVisibility(View.GONE);

            holder.circleImageViewleft.setBackground(activity.getResources().getDrawable(R.drawable.textview_circle2));
            if (dataModel.getUm_profile_picture() != null && !dataModel.getUm_profile_picture().isEmpty()) {

                holder.circleImageViewleft.setVisibility(View.VISIBLE);
                //invisible because text constrained to msg text
                holder.receive_msg_name_left.setVisibility(View.INVISIBLE);

                Glide.with(activity)
                        .load(Constants.getLoadGlide(activity, user_thumbnail_path + dataModel.getUm_profile_picture()))
                        .apply(AppUtils.getRequestOption())
                        .into(holder.circleImageViewleft);

            } else {
                holder.circleImageViewleft.setVisibility(View.GONE);
                holder.receive_msg_name_left.setVisibility(View.VISIBLE);
                holder.receive_msg_name_left.setText(dataModel.getUsername_code());
            }
            holder.chat_timeleft.setText(dataModel.getChat_time());
            if (!dataModel.getCmes_message().isEmpty() && dataModel.getCmes_message() != null) {
                holder.textViewleft.setText(dataModel.getCmes_message());
            } else {
                holder.textViewleft.setVisibility(View.GONE);
            }
            if (!dataModel.getCmes_file_name().isEmpty() && dataModel.getCmes_file_name() != null) {
                Glide.with(activity)
                        .load(Constants.getLoadGlide(activity, thumbnail_path + dataModel.getCmes_file_name()))
                        .apply(AppUtils.getRequestOptionWithoutOverride())
                        .into(holder.projects_image_left);
            } else {
                holder.projects_image_left.setVisibility(View.GONE);
            }
        } /*else {
            holder.circleImageViewleft.setVisibility(View.GONE);
            holder.chat_timeleft.setVisibility(View.GONE);
            holder.textViewleft.setVisibility(View.GONE);
            holder.projects_image_left.setVisibility(View.GONE);
            holder.receive_msg_name_left.setVisibility(View.GONE);
            holder.circleImageViewright.setVisibility(View.GONE);
            holder.receive_msg_name_right.setVisibility(View.GONE);
            holder.chat_timeright.setVisibility(View.GONE);
            holder.textViewright.setVisibility(View.GONE);
            holder.projects_image_right.setVisibility(View.GONE);
            holder.textViewdate.setVisibility(View.VISIBLE);

            holder.textViewdate.setText(dataModel.getCmes_message());
        }*/
           /* holder.messageName.setText(dataModel.getUm_name());
            holder.messageText.setText(dataModel.getLatest_message());
            holder.messageTime.setText(dataModel.getLast_chat_on());

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

            holder.messageImg.setBackground(activity.getResources().getDrawable(R.drawable.textview_circle2));
            if (dataModel.getUm_profile_picture() != null && !dataModel.getUm_profile_picture().isEmpty()) {

                holder.messageImg.setVisibility(View.VISIBLE);
                //invisible because text constrained to msg text
                holder.receive_msg_name.setVisibility(View.INVISIBLE);

                Glide.with(activity)
                        .load(Constants.getLoadGlide(activity,imgUrl + dataModel.getUm_profile_picture()))
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
            });*/
 /*       Glide.with(activity)
                .load(Constants.getLoadGlide(activity, imgUrl + dataModel.getUm_profile_picture()))
                .apply(AppUtils.getRequestOptionWithoutOverride())
                .into(holder.messageImg);*/
     /*   if (position == 2) {
            holder.onlineShow.setVisibility(View.VISIBLE);
            holder.messageCount.setVisibility(View.VISIBLE);
        }*/

    }

    private void callTypeFace(MessageHistoryAdapter.MyViewHolder holder) {
        holder.textViewleft.setTypeface(FontTypeFace.fontBold(activity));
        holder.chat_timeleft.setTypeface(FontTypeFace.fontMedium(activity));
        holder.chat_timeright.setTypeface(FontTypeFace.fontMedium(activity));
        holder.textViewright.setTypeface(FontTypeFace.fontBold(activity));
    }

    @Override
    public void onClick(View v) {

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.circleImageViewleft)
        CircleImageView circleImageViewleft;
        @BindView(R.id.circleImageViewright)
        CircleImageView circleImageViewright;
        @BindView(R.id.projects_image_left)
        ImageView projects_image_left;
        @BindView(R.id.projects_image_right)
        ImageView projects_image_right;
        @BindView(R.id.textViewleft)
        TextView textViewleft;
        @BindView(R.id.chat_timeleft)
        TextView chat_timeleft;
        @BindView(R.id.chat_timeright)
        TextView chat_timeright;
        @BindView(R.id.textViewright)
        TextView textViewright;
        @BindView(R.id.textViewdate)
        TextView textViewdate;
        @BindView(R.id.receive_msg_name_right)
        TextView receive_msg_name_right;
        @BindView(R.id.receive_msg_name_left)
        TextView receive_msg_name_left;


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
        return chatLists == null ? 0 : chatLists.size();
    }


    public interface OnLoadMoreListener {
        void onLoadMore();
    }

    public interface PassDataListener {
        void passData(MessageListResponse.UserList userList, boolean viewPage, int position);
    }
}
