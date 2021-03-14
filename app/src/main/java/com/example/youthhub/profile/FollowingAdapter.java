package com.example.youthhub.profile;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.youthhub.R;
import com.example.youthhub.resModel.connection.ConnectionList;
import com.example.youthhub.resModel.profile.follower.ProfileFollowerResponse;
import com.example.youthhub.utils.AppUtils;
import com.example.youthhub.utils.Constants;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class FollowingAdapter extends RecyclerView.Adapter<FollowingAdapter.MyViewHolder> {

    Context context;
    ProfileFollowerResponse followingModelList;
    Activity activity;



    public FollowingAdapter(Activity activity, ProfileFollowerResponse followingModelList) {
        this.followingModelList = followingModelList;
        this.activity = activity;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.following_layout, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.messageImg.setBackground(activity.getResources().getDrawable(R.drawable.textview_circle2));
        if (followingModelList.getData().getResult().get(position).getUserProfile() != null && !followingModelList.getData().getResult().get(position).getUserProfile().isEmpty()) {

            holder.messageImg.setVisibility(View.VISIBLE);
            //invisible because text constrained to msg text
            holder.receiveMsgName.setVisibility(View.INVISIBLE);

            Glide.with(activity)
                    .load(Constants.getLoadGlide(activity, followingModelList.getData().getUserThumbnailPath() + followingModelList.getData().getResult().get(position).getUserProfile()))
                    .apply(AppUtils.getRequestOption())
                    .into(holder.messageImg);





        } else {
            holder.messageImg.setVisibility(View.GONE);
            holder.receiveMsgName.setVisibility(View.VISIBLE);
            holder.receiveMsgName.setText(followingModelList.getData().getResult().get(position).getUsernameCode());
        }



        holder.messageImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConnectionList imgConnectionList = (ConnectionList) v.getTag(R.id.connection_object);
                Intent intent = new Intent(activity, ProfileActivity.class);
                intent.putExtra(Constants.UserCode,followingModelList.getData().getResult().get(position).getUserCode());
                intent.putExtra(Constants.UserType,followingModelList.getData().getResult().get(position).getUsertype());
                activity.startActivity(intent);

                activity.overridePendingTransition(R.anim.activity_slide_up, R.anim.stay);
            }
        });
        holder.receiveMsgName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConnectionList imgConnectionList = (ConnectionList) v.getTag(R.id.connection_object);
                Intent intent = new Intent(activity, ProfileActivity.class);
                intent.putExtra(Constants.UserCode,followingModelList.getData().getResult().get(position).getUserCode());
                intent.putExtra(Constants.UserType,followingModelList.getData().getResult().get(position).getUsertype());
                activity.startActivity(intent);

                activity.overridePendingTransition(R.anim.activity_slide_up, R.anim.stay);
            }
        });
        holder.name.setText(followingModelList.getData().getResult().get(position).getUsername());

    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.message_img)
        CircleImageView messageImg;
        @BindView(R.id.receive_msg_name)
        TextView receiveMsgName;
        @BindView(R.id.comment_image_code_constrain)
        ConstraintLayout commentImageCodeConstrain;
        @BindView(R.id.following_name)
        TextView name;


        public MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, itemView);
        }
    }

    @Override
    public int getItemCount() {
        return followingModelList.getData().getResult().size();
    }
}
