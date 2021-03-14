package com.example.youthhub.dashBoard.jobsFragment;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.youthhub.R;
import com.example.youthhub.resModel.jobs.JobsList;
import com.example.youthhub.utils.AppUtils;
import com.example.youthhub.utils.FontTypeFace;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class JobsAdapter extends RecyclerView.Adapter<JobsAdapter.MyViewHolder> implements View.OnClickListener {


    private Activity activity;
    private List<JobsList> jobsLists = new ArrayList<>();

    private boolean isLoading;
    private int visibleThreshold = 5;
    private int lastVisibleItem, totalItemCount;
    private OnLoadMoreListener onLoadMoreListener;
    private OnPassDataListener onPassDataListener;

    void setOnLoadMoreListener(OnLoadMoreListener mOnLoadMoreListener) {
        this.onLoadMoreListener = mOnLoadMoreListener;
    }

    void setOnPassDataListener(OnPassDataListener onPassDataListener) {
        this.onPassDataListener = onPassDataListener;
    }

    void addAll(List<JobsList> jobsLists) {
        this.jobsLists = jobsLists;
        notifyDataSetChanged();
    }

    JobsAdapter(Activity activity, final RecyclerView jobsRecycler) {
        this.activity = activity;

        final LinearLayoutManager linearLayoutManager = (LinearLayoutManager) jobsRecycler.getLayoutManager();
        jobsRecycler.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                boolean scrolled = AppUtils.isLastItemDisplaying(jobsRecycler);
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

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.job_search_adapter, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        callTypeFace(holder);
        /*if (i == 0) {
            holder.pinUnpinImg.setImageDrawable(ContextCompat.getDrawable(activity, R.drawable.ic_pin_bookmark));
        }*/
        JobsList jobsList = jobsLists.get(position);


        holder.jobsViewMoreBtn.setOnClickListener(this);
        holder.jobsViewMoreBtn.setTag(jobsList);

        holder.pinUnpinImg.setOnClickListener(this);
        holder.pinUnpinImg.setTag(R.id.is_save_tag_object, jobsList);
        holder.pinUnpinImg.setTag(R.id.is_save_tag_position, position);

        holder.jobsTitle.setText(jobsList.getJmTitle());
        holder.postBy.setText(jobsList.getPostBy());
        holder.jobsRegion.setText(jobsList.getJloReRegionName());
        holder.jobsType.setText(jobsList.getJmTypeName());
        holder.jobsDate.setText(jobsList.getJmEndDate());
        holder.jobsDesc.setText(jobsList.getJmFullDescription());
        if (jobsList.getIsApplied()==1){
            holder.txtIsApplied.setText("Applied");
        }else if (jobsList.getIsView()==1){
            holder.txtIsApplied.setText("Viewed");
        }else {
            holder.txtIsApplied.setText("");
        }
        switch (jobsList.getIsSave()) {
            case 0:
                holder.pinUnpinImg.setImageDrawable(ContextCompat.getDrawable(activity, R.drawable.ic_unpin_bookmark));
                break;
            case 1:
                holder.pinUnpinImg.setImageDrawable(ContextCompat.getDrawable(activity, R.drawable.ic_pin_bookmark));
                break;
        }
    }

    private void callTypeFace(MyViewHolder holder) {
        holder.jobsTitle.setTypeface(FontTypeFace.fontBold(activity));
        holder.postBy.setTypeface(FontTypeFace.fontSemiBold(activity));
        holder.jobsRegion.setTypeface(FontTypeFace.fontSemiBold(activity));
        holder.jobsViewMoreBtn.setTypeface(FontTypeFace.fontBold(activity));
    }

    @Override
    public int getItemCount() {
        return jobsLists.size();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.jobs_view_more_btn:
                JobsList jobsList = (JobsList) v.getTag();
                Intent intent = new Intent(activity, JobActivity.class);
                intent.putExtra("JobCode", jobsList.getJmCode());
                activity.startActivity(intent);
                activity.overridePendingTransition(R.anim.activity_slide_up, R.anim.stay);
                break;
            case R.id.pin_unpin_img:
                JobsList isSaveJobsList = (JobsList) v.getTag(R.id.is_save_tag_object);
                int position = (int) v.getTag(R.id.is_save_tag_position);
                onPassDataListener.onPassData(isSaveJobsList, position);
                break;
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.jobs_title)
        TextView jobsTitle;
        @BindView(R.id.pin_unpin_img)
        ImageView pinUnpinImg;
        @BindView(R.id.post_by)
        TextView postBy;
        @BindView(R.id.jobs_region)
        TextView jobsRegion;
        @BindView(R.id.jobs_type)
        TextView jobsType;
        @BindView(R.id.jobs_date)
        TextView jobsDate;
        @BindView(R.id.jobs_desc)
        TextView jobsDesc;
        @BindView(R.id.jobs_view)
        View jobsView;
        @BindView(R.id.jobs_view_more_btn)
        Button jobsViewMoreBtn;
        @BindView(R.id.txt_is_applied)
        TextView txtIsApplied;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface OnLoadMoreListener {
        void onLoadMore();
    }

    public interface OnPassDataListener {
        void onPassData(JobsList jobsList, int position);
    }

    public void setLoaded() {
        isLoading = false;
    }
}
