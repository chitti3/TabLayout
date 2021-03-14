package com.example.youthhub.signUpPage;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.youthhub.R;
import com.example.youthhub.resModel.register.JobWishlist;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class JobWishListAdapter extends RecyclerView.Adapter<JobWishListAdapter.MyViewHolder> implements View.OnClickListener{

    Activity activity;
    List<JobWishlist> lists;
    private OnViewClickListener onViewClickListener;

    JobWishListAdapter(Activity activity, List<JobWishlist> lists) {
        this.activity = activity;
        this.lists = lists;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.job_wish_list_adapter, viewGroup, false);
        view.setOnClickListener(this);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        JobWishlist jobWishlist = lists.get(position);
        holder.wishListName.setText(jobWishlist.getWitName());
        holder.checkBox.setTag(jobWishlist);
        holder.checkBox.setOnClickListener(this);

    }

    @Override
    public int getItemCount() {
        return lists.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.checkbox){
            JobWishlist jobWishlist = (JobWishlist) v.getTag();
            onViewClickListener.OnViewItemClick(jobWishlist);
        }
    }

    void setOnViewClickListener(OnViewClickListener onViewClickListener){
        this.onViewClickListener = onViewClickListener;
    }

    public interface OnViewClickListener{
        void OnViewItemClick(JobWishlist jobWishlist);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.wish_list_name)
        TextView wishListName;
        @BindView(R.id.checkbox)
        CheckBox checkBox;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}