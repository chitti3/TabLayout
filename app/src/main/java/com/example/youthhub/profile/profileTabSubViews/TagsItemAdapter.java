package com.example.youthhub.profile.profileTabSubViews;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.youthhub.R;

import com.example.youthhub.resModel.profile.visualjourney.TagsItem;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.youthhub.profile.ProfileInfoDialog.TAG;

public class TagsItemAdapter extends RecyclerView.Adapter<TagsItemAdapter.MyViewHolder> implements View.OnClickListener {

    private Activity activity;
    private OnViewTagClickListener onViewClickListener;

    private List<TagsItem> lists = new ArrayList<>();
    private List<TagsItem> selectedLists = new ArrayList<>();

    public void addAll(List<TagsItem> lists, List<TagsItem> selectedLists) {
        this.lists = lists;
        this.selectedLists = selectedLists;
        notifyDataSetChanged();

    }


    public TagsItemAdapter(Activity activity) {
        this.activity = activity;
    }

    @NonNull
    @Override
    public TagsItemAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(activity).inflate(R.layout.multi_select_adapter, viewGroup, false);
        view.setOnClickListener(this);
        return new TagsItemAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TagsItemAdapter.MyViewHolder holder, int position) {
        TagsItem list = lists.get(position);
        holder.tagsName.setText(list.getTgName());

        holder.checkView.setOnClickListener(this);
        holder.checkView.setTag(R.id.holder_tag, holder);
        holder.checkView.setTag(R.id.data_tag, list);
        holder.checkView.setTag(R.id.position, position);
        for (int i=0;i<selectedLists.size();i++){
            if(list.getTgTagId().equals(selectedLists.get(i).getTgTagId())){
                //holder.checkImg.setVisibility(View.VISIBLE);
                holder.checkView.performClick();
            }
        }
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.check_view) {
            MyViewHolder holder = (MyViewHolder) v.getTag(R.id.holder_tag);
            TagsItem singleList = (TagsItem) v.getTag(R.id.data_tag);
            if(holder.checkImg.getVisibility()!=View.VISIBLE){
                holder.checkImg.setVisibility(View.VISIBLE);
            }else {
                holder.checkImg.setVisibility(View.INVISIBLE);
            }
            onViewClickListener.OnViewTagItemClick(singleList);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public void setOnViewClickListener(OnViewTagClickListener onViewClickListener) {
        this.onViewClickListener = onViewClickListener;
    }

    public interface OnViewTagClickListener {
        void OnViewTagItemClick(TagsItem singleList);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tags_name)
        TextView tagsName;
        @BindView(R.id.check_img)
        ImageView checkImg;
        @BindView(R.id.check_view)
        View checkView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}