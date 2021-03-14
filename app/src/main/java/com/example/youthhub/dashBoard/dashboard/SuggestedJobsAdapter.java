package com.example.youthhub.dashBoard.dashboard;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.youthhub.R;
import com.example.youthhub.dashBoard.jobsFragment.JobActivity;
import com.example.youthhub.resModel.post.postList.JobsList;
import com.example.youthhub.resModel.profilepostlist.JobsListItem;
import com.example.youthhub.utils.FontTypeFace;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SuggestedJobsAdapter extends RecyclerView.Adapter<SuggestedJobsAdapter.MyViewHolder> {

    Activity activity;
    @BindView(R.id.suggest_view1)
    View suggestView1;
    @BindView(R.id.suggest_view2)
    View suggestView2;
    @BindView(R.id.suggest_job_title)
    TextView suggestJobTitle;
    @BindView(R.id.suggest_job_post_by)
    TextView suggestJobPostBy;
    @BindView(R.id.job_type)
    TextView jobType;
    @BindView(R.id.view)
    View view;
    @BindView(R.id.view_more_btn)
    Button viewMoreBtn;
    @BindView(R.id.suggest_card_view)
    CardView suggestCardView;
    @BindView(R.id.suggest_view3)
    View suggestView3;
    private List<JobsListItem> jobsLists;

    SuggestedJobsAdapter(Activity activity, List<JobsListItem> jobsLists) {
        this.activity = activity;
        this.jobsLists = jobsLists;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.suggested_jobs_adapter, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        callTypeFace(holder);

        if (position == 2) {
            holder.suggestView3.setVisibility(View.VISIBLE);
        }

        if (position == 0) {
            holder.suggestView1.setVisibility(View.VISIBLE);
        } else {
            holder.suggestView1.setVisibility(View.GONE);
        }

        JobsListItem jobsList = jobsLists.get(position);

        holder.viewMoreBtn.setTag(jobsList);

        holder.suggestJobTitle.setText(jobsList.getJmTitle());
        holder.suggestJobPostBy.setText(jobsList.getPostBy());
        holder.jobType.setText(jobsList.getJmTypeName());

    }

    private void callTypeFace(MyViewHolder holder) {
        holder.suggestJobTitle.setTypeface(FontTypeFace.fontBold(activity));
        holder.suggestJobPostBy.setTypeface(FontTypeFace.fontSemiBold(activity));
        holder.viewMoreBtn.setTypeface(FontTypeFace.fontBold(activity));
    }

    @Override
    public int getItemCount() {
        return jobsLists.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.suggest_view1)
        View suggestView1;
        @BindView(R.id.suggest_view2)
        View suggestView2;
        @BindView(R.id.suggest_job_title)
        TextView suggestJobTitle;
        @BindView(R.id.suggest_job_post_by)
        TextView suggestJobPostBy;
        @BindView(R.id.job_type)
        TextView jobType;
        @BindView(R.id.view)
        View view;
        @BindView(R.id.view_more_btn)
        Button viewMoreBtn;
        @BindView(R.id.suggest_card_view)
        CardView suggestCardView;
        @BindView(R.id.suggest_view3)
        View suggestView3;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.view_more_btn)
        public void onViewClicked(View view) {
            JobsList jobsList = (JobsList) view.getTag();
            Intent intent = new Intent(activity, JobActivity.class);
            intent.putExtra("JobCode",jobsList.getJmCode());
            activity.startActivity(intent);
            activity.overridePendingTransition(R.anim.activity_slide_up, R.anim.stay);
        }

    }

}
