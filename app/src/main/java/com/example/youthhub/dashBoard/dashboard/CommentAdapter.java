package com.example.youthhub.dashBoard.dashboard;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.youthhub.R;
import com.example.youthhub.dashBoard.DeleteMessageDialog;
import com.example.youthhub.resModel.post.CommentList;
import com.example.youthhub.utils.Constants;
import com.example.youthhub.utils.FontTypeFace;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.MyViewHolder> implements View.OnLongClickListener,DeleteMessageDialog.OnDeleteListener {

    Activity activity;

    private List<CommentList> lists = new ArrayList<>();

    private String userMediumPath;
    private String userThumbnailPath;

    private OnPassDataListener onPassDataListener;

    private int deletePosition;

    void setOnPassDataListener(OnPassDataListener onPassDataListener) {
        this.onPassDataListener = onPassDataListener;
    }

    CommentAdapter(Activity activity) {
        this.activity = activity;
    }

    void addAll(List<CommentList> lists, String userMediumPath, String userThumbnailPath) {
        this.lists = lists;
        this.userMediumPath = userMediumPath;
        this.userThumbnailPath = userThumbnailPath;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.comment_adapter, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        callTypeFace(holder);

        CommentList list = lists.get(position);

        holder.commenterName.setText(list.getUserName());
        holder.commentTime.setText(list.getPfeCreatedOn());
        holder.comment.setText(list.getPfeMessage());

        if(list.getUserCode().equals(Constants.getUserCode(activity))) {
            holder.deleteClick.setOnLongClickListener(this);
            holder.deleteClick.setTag(R.id.data_tag, list);
            holder.deleteClick.setTag(R.id.position, position);
        }

        switch (list.getIsPicExist()) {
            case 0:
                holder.commenterImg.setVisibility(View.GONE);
                holder.commentUserCode.setVisibility(View.VISIBLE);
                holder.commentUserCode.setText(list.getUsernameCode());
                break;
            case 1:
                holder.commenterImg.setVisibility(View.VISIBLE);
                holder.commentUserCode.setVisibility(View.GONE);

                RequestOptions options = new RequestOptions()
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .priority(Priority.HIGH);

                Glide.with(activity)
                        .load(Constants.getLoadGlide(activity, userThumbnailPath + list.getUmProfilePicture()))
                        .apply(options)
                        .into(holder.commenterImg);
                break;
        }


    }

    private void callTypeFace(MyViewHolder holder) {
        holder.commenterName.setTypeface(FontTypeFace.fontBold(activity));
        holder.commentUserCode.setTypeface(FontTypeFace.fontBold(activity));
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public boolean onLongClick(View v) {
        switch (v.getId()) {
            case R.id.delete_click:
                CommentList list = (CommentList) v.getTag(R.id.data_tag);
                deletePosition = (int) v.getTag(R.id.position);
                DeleteMessageDialog deleteMessageDialog = new DeleteMessageDialog(activity,"Comment" ,list.getPostCode(), list.getPfeFeedId(),null);
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

        @BindView(R.id.commenter_img)
        CircleImageView commenterImg;
        @BindView(R.id.comment_user_code)
        TextView commentUserCode;
        @BindView(R.id.comment_image_code_constrain)
        ConstraintLayout commentImageCodeConstrain;
        @BindView(R.id.commenter_name)
        TextView commenterName;
        @BindView(R.id.comment_time)
        TextView commentTime;
        @BindView(R.id.constrain1)
        ConstraintLayout constrain1;
        @BindView(R.id.comment)
        TextView comment;
        @BindView(R.id.view1)
        View view1;
        @BindView(R.id.delete_click)
        View deleteClick;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }

    public interface OnPassDataListener {
        void passData(boolean deleted, int deletePosition);
    }

}
