package com.example.youthhub.dashBoard.notificationFragment;

import android.app.Activity;
import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.youthhub.DataModel1;
import com.example.youthhub.R;
import com.example.youthhub.utils.FontTypeFace;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.MyViewHolder> {

    Context context;

    private List<DataModel1> dataModel1s;
    Activity activity;


    public NotificationAdapter(Activity activity,List<DataModel1> dataModel1List) {
        this.dataModel1s = dataModel1List;
        this.activity = activity;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.notifications_layout, parent, false);

        return new MyViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        callTypeFace(holder);

        DataModel1 dataModel1 = dataModel1s.get(position);
        String message = dataModel1.getMessage().toString();
        if (message.contains("following")) {
            holder.notifyImgCardView.setVisibility(View.GONE);
            holder.notifyAcceptBtn.setVisibility(View.GONE);
        } else if (message.contains("liked")) {
            holder.notifyImgCardView.setVisibility(View.VISIBLE);
            holder.notifyAcceptBtn.setVisibility(View.GONE);
        } else if (message.contains("invite") || message.contains("request")) {
            holder.notifyImgCardView.setVisibility(View.GONE);
            holder.notifyAcceptBtn.setVisibility(View.VISIBLE);
        }

        if (message.contains("others")) {
            holder.notifyProfileImg.setVisibility(View.GONE);
            holder.notifyProfileImages.setVisibility(View.VISIBLE);
        }else {
            holder.notifyProfileImg.setVisibility(View.VISIBLE);
            holder.notifyProfileImages.setVisibility(View.GONE);
            holder.notifyProfileImg.setImageResource(dataModel1.getImage());
        }
        if(position==(dataModel1s.size()-1)) {
            holder.notifyView.setVisibility(View.INVISIBLE);
        }else {
            holder.notifyView.setVisibility(View.VISIBLE);
        }
        holder.notifyTxt.setText(Html.fromHtml(message));
        holder.notifyTime.setText(dataModel1.getTime());
    }

    private void callTypeFace(MyViewHolder holder) {
        holder.notifyAcceptBtn.setTypeface(FontTypeFace.fontBold(activity));
    }

    @Override
    public int getItemCount() {
        return dataModel1s.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.notify_profile_img)
        ImageView notifyProfileImg;
        @BindView(R.id.notify_profile_img1)
        CircleImageView notifyProfileImg1;
        @BindView(R.id.notify_profile_img2)
        CircleImageView notifyProfileImg2;
        @BindView(R.id.notify_profile_view1)
        View notifyProfileView1;
        @BindView(R.id.notify_profile_view2)
        View notifyProfileView2;
        @BindView(R.id.notify_profile_images)
        ConstraintLayout notifyProfileImages;
        @BindView(R.id.notify_profiler_constrain)
        ConstraintLayout notifyProfilerConstrain;
        @BindView(R.id.notify_txt)
        TextView notifyTxt;
        @BindView(R.id.notify_time)
        TextView notifyTime;
        @BindView(R.id.notify_accept_btn)
        Button notifyAcceptBtn;
        @BindView(R.id.notify_img)
        RoundedImageView notifyImg;
        @BindView(R.id.notify_img_cardView)
        CardView notifyImgCardView;
        @BindView(R.id.notify_constrain)
        ConstraintLayout notifyConstrain;
        @BindView(R.id.notify_view)
        View notifyView;

        public MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, itemView);
        }
    }

}