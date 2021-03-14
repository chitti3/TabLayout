package com.example.youthhub.profile;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.youthhub.R;
import com.example.youthhub.resModel.profile.visualjourney.PrimeTagsItem;
import com.example.youthhub.utils.AppUtils;
import com.example.youthhub.utils.Constants;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.youthhub.profile.ProfileFragment.TAG;

public class AddStepCategoryAdapter extends RecyclerView.Adapter<AddStepCategoryAdapter.MyViewHolder> {

    Activity activity;
    /*    String[] titles;
        String[] titles_icons;
        String[] titles_id;*/
    String primeTagsPath;

    private int num = 2;
    private List<PrimeTagsItem> primeTags = new ArrayList<>();
    private List<PrimeTagsItem> selectedTags;

    private OnPassDataListener onPassDataListener;

    public AddStepCategoryAdapter(Activity activity, String primeTagsPath) {
        this.activity = activity;
        this.primeTagsPath = primeTagsPath;
    }

    public void setOnPassDataListener(OnPassDataListener onPassDataListener) {
        this.onPassDataListener = onPassDataListener;
    }

    /*   AddStepCategoryAdapter(Activity activity) {
           this.activity = activity;
       }
   */
    public void addAll(List<PrimeTagsItem> primeTags, String primeTagsPath, List<PrimeTagsItem> selectedTags) {
        this.primeTags = primeTags;
        this.primeTagsPath = primeTagsPath;
        this.selectedTags = selectedTags;
        notifyDataSetChanged();
    }
 /*   public void addAll(String[] titles, int[] titles_icons) {
        this.titles = titles;
        this.titles_icons = titles_icons;
        notifyDataSetChanged();
    }*/

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.add_step_category_adapter, viewGroup, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Log.d(TAG, "onBindViewHolder: " + primeTagsPath + primeTags.get(position));
        Log.d(TAG, "onBindViewHolder: " + primeTagsPath + primeTags.get(position));

        Glide.with(activity)
                .load(Constants.getLoadGlide(activity, primeTagsPath + primeTags.get(position).getTgIcon()))
                .apply(AppUtils.getRequestOptionWithoutOverride())
                .into(holder.stepsImg);
        //   holder.stepsImg.setBackgroundResource(titles_icons[position]);
        holder.stepsTxt.setText(primeTagsPath + primeTags.get(position));
        if (position == (primeTags.size() - 1)) {
            holder.addStepAdapterView1.setVisibility(View.GONE);
        } else {
            holder.addStepAdapterView1.setVisibility(View.VISIBLE);
        }


      /*  if (position == num) {
            holder.addStepAdapterView1.setVisibility(View.GONE);
            num = num + 3;
        } else {
            holder.addStepAdapterView1.setVisibility(View.VISIBLE);
        }*/

        PrimeTagsItem primeTag = primeTags.get(position);

        holder.addStepAdapterConstrain.setTag(R.id.holder_tag, holder);
        holder.addStepAdapterConstrain.setTag(R.id.data_tag, primeTag);
        holder.addStepAdapterConstrain.setTag(R.id.position, position);

        holder.stepsTxt.setText(primeTag.getTgName());

        for (int i = 0; i < selectedTags.size(); i++) {
            if (primeTag.getTgTagId().equals(selectedTags.get(i).getTgTagId())) {
                holder.addStepAdapterConstrain.performClick();
            }
        }

        holder.addStepAdapterConstrain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyViewHolder holder = (MyViewHolder) v.getTag(R.id.holder_tag);
                PrimeTagsItem primeTag = (PrimeTagsItem) v.getTag(R.id.data_tag);

                if (holder.select.getVisibility() != View.VISIBLE) {
                    holder.select.setVisibility(View.VISIBLE);
                } else {
                    holder.select.setVisibility(View.INVISIBLE);
                }
                onPassDataListener.onPassData(primeTag);
            }
        });
    }

    @Override
    public int getItemCount() {
        return primeTags.size();
    }
/*
    public void addAll(String[] titles, String[] titles_icons, String[] titles_id) {
        this.titles = titles;
        this.titles_icons = titles_icons;
        this.titles_id = titles_id;
        notifyDataSetChanged();
    }*/

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.steps_img)
        ImageView stepsImg;
        @BindView(R.id.steps_txt)
        TextView stepsTxt;
        @BindView(R.id.add_step_adapter_constrain)
        ConstraintLayout addStepAdapterConstrain;
        @BindView(R.id.add_step_adapter_view1)
        View addStepAdapterView1;
        @BindView(R.id.select)
        ImageView select;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }

    public interface OnPassDataListener {
        void onPassData(PrimeTagsItem primeTag);
    }
}
