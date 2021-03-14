package com.example.youthhub.profile;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.youthhub.R;
import com.example.youthhub.utils.FontTypeFace;
import com.example.youthhub.utils.SquareImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProjectsAdapter extends RecyclerView.Adapter<ProjectsAdapter.MyViewHolder> implements View.OnClickListener {

    Activity activity;
    String whichFragment;

    public ProjectsAdapter(Activity activity, String whichFragment) {
        this.activity = activity;
        this.whichFragment = whichFragment;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.projects_adapter, viewGroup, false);
        view.setOnClickListener(this);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        callTypeFace(holder);
        switch (whichFragment) {
            case "ProjectsFragment":
                doProjectAdapter(holder, position);
                break;
            case "EventPhotosFragment":
                doEventPhotosAdapter(holder, position);
                break;
            case "EventVideosFragment":
                doEventVideosAdapter(holder, position);
                break;
        }

        switch (position) {
            case 0:
            case 4:
                holder.projectsImage.setBackground(ContextCompat.getDrawable(activity, R.drawable.dashboard_img));
                break;
            case 1:
            case 5:
                holder.projectsImage.setBackground(ContextCompat.getDrawable(activity, R.drawable.dashboard_img1));
                break;
            case 2:
            case 6:
                holder.projectsImage.setBackground(ContextCompat.getDrawable(activity, R.drawable.dashboard_img2));
                break;
            case 3:
            case 7:
                holder.projectsImage.setBackground(ContextCompat.getDrawable(activity, R.drawable.ocean));
                break;
        }

    }

    private void doEventVideosAdapter(MyViewHolder holder, int position) {
        holder.title.setVisibility(View.GONE);
        holder.playBtn.setVisibility(View.VISIBLE);
    }

    private void doEventPhotosAdapter(MyViewHolder holder, int position) {
        holder.title.setVisibility(View.GONE);
        holder.playBtn.setVisibility(View.GONE);
    }

    private void doProjectAdapter(MyViewHolder holder, int position) {
        holder.title.setVisibility(View.VISIBLE);
        holder.playBtn.setVisibility(View.GONE);
    }

    private void callTypeFace(MyViewHolder holder) {
        holder.title.setTypeface(FontTypeFace.fontBold(activity));
    }

    @Override
    public int getItemCount() {
        return 8;
    }

    @Override
    public void onClick(View v) {

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {


        @BindView(R.id.projects_image)
        SquareImageView projectsImage;
        @BindView(R.id.play_btn)
        ImageView playBtn;
        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.projects_card)
        CardView projectsCard;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
