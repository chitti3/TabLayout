package com.example.youthhub.dashBoard.exploreFragment;


import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.youthhub.R;
import com.example.youthhub.resModel.explore.masterApi.ExploreTag;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ExploreTagsAdapter extends RecyclerView.Adapter<ExploreTagsAdapter.MyViewHolder> implements View.OnClickListener {

    private Activity activity;
    private List<ExploreTag> lists;
    private OnViewClickListener onViewClickListener;
    private List<ExploreTag> selectedTags;

    ExploreTagsAdapter(Activity activity, List<ExploreTag> lists, List<ExploreTag> selectedTags) {
        this.activity = activity;
        this.lists = lists;
        this.selectedTags = selectedTags;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.explore_multi_select_adapter, viewGroup, false);
        view.setOnClickListener(this);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ExploreTag list = lists.get(position);
        holder.tagsName.setText(list.getTgName());
        holder.checkbox.setTag(list);
        holder.checkbox.setOnClickListener(this);
        for (int i=0;i<selectedTags.size();i++){
            if(list.getTgTagId().equals(selectedTags.get(i).getTgTagId())){
                holder.checkbox.performClick();
            }
        }
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.checkbox) {
            ExploreTag exploreTag = (ExploreTag) v.getTag();
            onViewClickListener.OnViewItemClick(exploreTag);
        }
    }

    void setOnViewClickListener(OnViewClickListener onViewClickListener) {
        this.onViewClickListener = onViewClickListener;
    }

    public interface OnViewClickListener {
        void OnViewItemClick(ExploreTag exploreTag);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tags_name)
        TextView tagsName;
        @BindView(R.id.checkbox)
        CheckBox checkbox;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}