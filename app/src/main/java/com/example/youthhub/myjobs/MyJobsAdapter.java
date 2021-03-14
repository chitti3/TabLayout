package com.example.youthhub.myjobs;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.youthhub.R;
import com.example.youthhub.resModel.myjobs.MyJobs;
import com.example.youthhub.utils.FontTypeFace;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyJobsAdapter extends RecyclerView.Adapter<MyJobsAdapter.MyViewHolder> {

    private Activity activity;
    List<MyJobs> myJobs = new ArrayList<>();

    MyJobsAdapter(Activity activity) {
        this.activity = activity;
    }

    void addAll(List<MyJobs> myJobs) {
        this.myJobs = myJobs;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.my_jobs_adapter, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        callTypeFace(holder);
        MyJobs myJob = myJobs.get(position);
        holder.jobTitle.setText(myJob.getJmTitle());
        holder.jobCompany.setText(myJob.getUmName());
        holder.jobPlace.setText(myJob.getReName());
        holder.jobDate.setText(myJob.getJapDate());
    }

    private void callTypeFace(MyViewHolder holder) {
        holder.jobTitle.setTypeface(FontTypeFace.fontBold(activity));
        holder.jobDate.setTypeface(FontTypeFace.fontSemiBold(activity));
        holder.jobCompany.setTypeface(FontTypeFace.fontSemiBold(activity));
    }

    @Override
    public int getItemCount() {
        return myJobs.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.job_title)
        TextView jobTitle;
        @BindView(R.id.job_company)
        TextView jobCompany;
        @BindView(R.id.location_img)
        ImageView locationImg;
        @BindView(R.id.job_place)
        TextView jobPlace;
        @BindView(R.id.job_date)
        TextView jobDate;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
