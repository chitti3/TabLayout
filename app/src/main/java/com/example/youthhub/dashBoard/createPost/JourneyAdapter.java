package com.example.youthhub.dashBoard.createPost;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.youthhub.R;
import com.example.youthhub.resModel.post.createPost.PrimeTag;
import com.example.youthhub.resModel.profile.visualjourney.PrimeTagsItem;
import com.example.youthhub.utils.Constants;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class JourneyAdapter extends RecyclerView.Adapter<JourneyAdapter.MyViewHolder> {

    private Activity activity;
    private int num = 2;

    private List<PrimeTag> primeTags = new ArrayList<>();
    private List<PrimeTag> selectedTags;
    private String primeTagsPath;
    private OnPassDataListener onPassDataListener;

    public void setOnPassDataListener(OnPassDataListener onPassDataListener) {
        this.onPassDataListener = onPassDataListener;
    }

    JourneyAdapter(Activity activity) {
        this.activity = activity;
    }

    public void addAll(List<PrimeTag> primeTags, String primeTagsPath, List<PrimeTag> selectedTags) {
        this.primeTags = primeTags;
        this.primeTagsPath = primeTagsPath;
        this.selectedTags = selectedTags;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.journey_adapter, viewGroup, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        if (position == num) {
            holder.journeyView1.setVisibility(View.GONE);
            num = num + 3;
        } else {
            holder.journeyView1.setVisibility(View.VISIBLE);
        }

        PrimeTag primeTag = primeTags.get(position);

        holder.journeyConstrain.setTag(R.id.holder_tag, holder);
        holder.journeyConstrain.setTag(R.id.data_tag, primeTag);
        holder.journeyConstrain.setTag(R.id.position, position);

        holder.journeyTxt.setText(primeTag.getTgName());

        RequestOptions options = new RequestOptions()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .priority(Priority.HIGH);

        Glide.with(activity)
                .load(Constants.getLoadGlide(activity,primeTagsPath + primeTag.getTgIcon()))
                .apply(options)
                .into(holder.journeyImg);
        for (int i = 0; i < selectedTags.size(); i++) {
            if (primeTag.getTgTagId().equals(selectedTags.get(i).getTgTagId())) {
                holder.journeyConstrain.performClick();
            }
        }

    }

    @Override
    public int getItemCount() {
        return primeTags.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.select)
        ImageView select;
        @BindView(R.id.journey_img)
        ImageView journeyImg;
        @BindView(R.id.journey_txt)
        TextView journeyTxt;
        @BindView(R.id.journey_constrain)
        ConstraintLayout journeyConstrain;
        @BindView(R.id.journey_view1)
        View journeyView1;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.journey_constrain)
        public void onViewClicked(View view) {
            if (view.getId() == R.id.journey_constrain) {
                MyViewHolder holder = (MyViewHolder) view.getTag(R.id.holder_tag);
                PrimeTag primeTag = (PrimeTag) view.getTag(R.id.data_tag);

                if (holder.select.getVisibility() != View.VISIBLE) {
                    holder.select.setVisibility(View.VISIBLE);
                } else {
                    holder.select.setVisibility(View.INVISIBLE);
                }
                onPassDataListener.onPassData(primeTag);
            }

        }

    }

    public interface OnPassDataListener {
        void onPassData(PrimeTag primeTag);
    }

}

