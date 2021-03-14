package com.example.youthhub.support;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.youthhub.R;
import com.example.youthhub.resModel.supportRes.view.HelpdeskDetail;
import com.example.youthhub.utils.AppUtils;
import com.example.youthhub.utils.Constants;
import com.example.youthhub.utils.FontTypeFace;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

import static com.example.youthhub.dashBoard.dashboard.DashBoardPostListAdapter.TAG;

public class SupportViewAdapter extends RecyclerView.Adapter<SupportViewAdapter.MyViewHolder> {

    private Activity activity;
    private List<HelpdeskDetail> helpdeskDetails = new ArrayList<>();
    private String userThumbnailPath;

    SupportViewAdapter(Activity activity) {
        this.activity = activity;
    }

    void addAll(List<HelpdeskDetail> helpdeskDetails, String userThumbnailPath) {
        this.helpdeskDetails = helpdeskDetails;
        this.userThumbnailPath = userThumbnailPath;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.open_adapter, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int i) {

        callTypeFace(holder);

        HelpdeskDetail helpdeskDetail = helpdeskDetails.get(i);

        holder.name.setText(helpdeskDetail.getUmName());
        holder.message.setText(helpdeskDetail.getHdMessage());

        switch (helpdeskDetail.getIsFileExist()) {
            case 1:
                holder.download.setVisibility(View.VISIBLE);
                break;
            case 0:
                holder.download.setVisibility(View.GONE);
                break;
        }

        switch (helpdeskDetail.getIsPicExist()) {
            case 0:
                holder.nameCode.setVisibility(View.VISIBLE);
                holder.image.setVisibility(View.GONE);
                holder.nameCode.setText(helpdeskDetail.getUmNameCode());
                break;
            case 1:
                Log.d(TAG, "onBindViewHolder: userThumbnailPath"+userThumbnailPath + helpdeskDetail.getUmProfilePicture());
                holder.nameCode.setVisibility(View.GONE);
                holder.image.setVisibility(View.VISIBLE);
                Glide.with(activity)
                        .load(Constants.getLoadGlide(activity,userThumbnailPath + helpdeskDetail.getUmProfilePicture()))
                        .apply(AppUtils.getRequestOptionWithoutOverride())
                        .into(holder.image);
                break;
            default:
                holder.nameCode.setVisibility(View.VISIBLE);
                holder.image.setVisibility(View.GONE);
                holder.nameCode.setText(helpdeskDetail.getUmNameCode());
                break;
        }
    }

    private void callTypeFace(MyViewHolder holder) {
        holder.nameCode.setTypeface(FontTypeFace.fontBold(activity));
        holder.name.setTypeface(FontTypeFace.fontMedium(activity));
        holder.download.setTypeface(FontTypeFace.fontBold(activity));
    }

    @Override
    public int getItemCount() {
        return helpdeskDetails.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.name_code)
        TextView nameCode;
        @BindView(R.id.image)
        CircleImageView image;
        @BindView(R.id.profiler_constrain)
        ConstraintLayout profilerConstrain;
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.download)
        TextView download;
        @BindView(R.id.message)
        TextView message;

        public MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
