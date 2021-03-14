package com.example.youthhub.dashBoard.eventFragment;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.Guideline;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.youthhub.R;
import com.example.youthhub.dashBoard.DeleteMessageDialog;
import com.example.youthhub.resModel.event.discussion.Discussion;
import com.example.youthhub.utils.AppUtils;
import com.example.youthhub.utils.Constants;
import com.example.youthhub.utils.FontTypeFace;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class DiscussionAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnLongClickListener, DeleteMessageDialog.OnDeleteListener {

    Activity activity;
    private List<Discussion> discussions = new ArrayList<>();
    private Map<String, String> imagePath;

    private OnLoadMoreListener onLoadMoreListener;
    private boolean isLoading;
    private int firstVisibleItem;

    private String user_code;
    private String eventCode;
    private OnPassDataListener onPassDataListener;
    private int deletePosition;

    void setOnPassDataListener(OnPassDataListener onPassDataListener) {
        this.onPassDataListener = onPassDataListener;
    }

    void setOnLoadMoreListener(OnLoadMoreListener mOnLoadMoreListener) {
        this.onLoadMoreListener = mOnLoadMoreListener;
    }

    public void addAll(List<Discussion> discussions, Map<String, String> imagePath, String eventCode) {
        this.discussions = discussions;
        this.imagePath = imagePath;
        this.eventCode = eventCode;
        notifyDataSetChanged();
    }

    DiscussionAdapter(Activity activity, RecyclerView recyclerView) {
        this.activity = activity;

        user_code = Constants.getUserCode(activity);

        final LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                boolean scrolled = AppUtils.isLastItemDisplaying(recyclerView);
                if (scrolled) {
                    if (linearLayoutManager != null) {
                        firstVisibleItem = linearLayoutManager.findFirstCompletelyVisibleItemPosition();
                    }
                    if (!isLoading && firstVisibleItem >= 0) {
                        if (onLoadMoreListener != null) {
                            onLoadMoreListener.onLoadMore();
                        }
                        isLoading = true;
                    }
                }
            }
        });
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.discussion_adapter, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        populateItemRows((MyViewHolder) holder, position);
    }

    private void populateItemRows(MyViewHolder holder, int position) {

        callTypeFace(holder);
        Discussion discussion = discussions.get(position);
        String userCode = discussion.getUmCode();

        holder.sendMsg.setOnLongClickListener(this);

        //RightMsgView
        if (userCode.equals(user_code)) {

            holder.sendMsg.setTag(R.id.delete_msg__tag, discussion);
            holder.sendMsg.setTag(R.id.delete_msg__position, position);

            holder.msgLeftConstrain.setVisibility(View.GONE);
            holder.msgRightConstrain.setVisibility(View.VISIBLE);

            holder.sendMsg.setText(discussion.getEfbMessage());
            if (discussion.getUmProfilePicture() != null && !discussion.getUmProfilePicture().isEmpty()) {

                holder.sendMsgImg.setVisibility(View.VISIBLE);
                //invisible because text constrained to msg text
                holder.sendMsgName.setVisibility(View.INVISIBLE);

                Glide.with(activity)
                        .load(Constants.getLoadGlide(activity,imagePath.get("user_thumbnail_path") + discussion.getUmProfilePicture()))
                        .apply(AppUtils.getRequestOption())
                        .into(holder.sendMsgImg);

            } else {
                holder.sendMsgImg.setVisibility(View.GONE);
                holder.sendMsgName.setVisibility(View.VISIBLE);
                holder.sendMsgName.setText(discussion.getUsernameCode());
            }
        } else {
            //leftMsgView
            holder.msgRightConstrain.setVisibility(View.GONE);
            holder.msgLeftConstrain.setVisibility(View.VISIBLE);

            holder.receiveMsg.setText(discussion.getEfbMessage());
            if (discussion.getUmProfilePicture() != null && !discussion.getUmProfilePicture().isEmpty()) {

                holder.receiveMsgImg.setVisibility(View.VISIBLE);
                //invisible because text constrained to msg text
                holder.receiveMsgName.setVisibility(View.INVISIBLE);

                Glide.with(activity)
                        .load(Constants.getLoadGlide(activity,imagePath.get("user_thumbnail_path") + discussion.getUmProfilePicture()))
                        .apply(AppUtils.getRequestOption())
                        .into(holder.receiveMsgImg);

            } else {
                holder.receiveMsgImg.setVisibility(View.GONE);
                holder.receiveMsgName.setVisibility(View.VISIBLE);
                holder.receiveMsgName.setText(discussion.getUsernameCode());
            }

        }
    }

    private void callTypeFace(MyViewHolder holder) {
        holder.sendMsgName.setTypeface(FontTypeFace.fontBold(activity));
        holder.receiveMsgName.setTypeface(FontTypeFace.fontBold(activity));
    }

    @Override
    public int getItemCount() {
        return discussions.size();
    }

    public void setLoaded() {
        isLoading = false;
    }

    @Override
    public boolean onLongClick(View v) {
        switch (v.getId()) {
            case R.id.send_msg:
                Discussion discussion = (Discussion) v.getTag(R.id.delete_msg__tag);
                deletePosition = (int) v.getTag(R.id.delete_msg__position);
                DeleteMessageDialog deleteMessageDialog = new DeleteMessageDialog(activity,"Event" ,eventCode, discussion.getEfbFeedId(),null);
                deleteMessageDialog.setOnDeleteListener(this);
                deleteMessageDialog.show();
                break;
        }
        return false;
    }

    @Override
    public void OnDelete(boolean deleted) {
        onPassDataListener.passData(deleted, deletePosition);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.receive_msg_img)
        CircleImageView receiveMsgImg;
        @BindView(R.id.receive_msg_name)
        TextView receiveMsgName;
        @BindView(R.id.receive_msg)
        TextView receiveMsg;
        @BindView(R.id.msg_left_constrain)
        ConstraintLayout msgLeftConstrain;
        @BindView(R.id.send_msg_img)
        CircleImageView sendMsgImg;
        @BindView(R.id.send_msg_name)
        TextView sendMsgName;
        @BindView(R.id.send_msg)
        TextView sendMsg;
        @BindView(R.id.msg_right_constrain)
        ConstraintLayout msgRightConstrain;
        @BindView(R.id.guideline3)
        Guideline guideline3;
        @BindView(R.id.guideline4)
        Guideline guideline4;
        @BindView(R.id.topView)
        View topView;
        @BindView(R.id.bottomView)
        View bottomView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface OnLoadMoreListener {
        void onLoadMore();
    }

    public interface OnPassDataListener {
        void passData(boolean deleted, int deletePosition);
    }

}
