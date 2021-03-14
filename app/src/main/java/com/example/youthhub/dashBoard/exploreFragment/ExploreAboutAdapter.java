package com.example.youthhub.dashBoard.exploreFragment;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.youthhub.R;
import com.example.youthhub.resModel.explore.Relatedexplore;
import com.example.youthhub.utils.AppUtils;
import com.example.youthhub.utils.Constants;
import com.example.youthhub.utils.FontTypeFace;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ExploreAboutAdapter extends RecyclerView.Adapter<ExploreAboutAdapter.MyViewHolder> implements View.OnClickListener {

    private Activity activity;
    private List<Relatedexplore> list = new ArrayList<>();
    private OnPassDataListener onPassDataListener;

    void setPassDataListener(OnPassDataListener onPassDataListener){
        this.onPassDataListener = onPassDataListener;
    }

    ExploreAboutAdapter(Activity activity) {
        this.activity = activity;
    }

    void addAll(List<Relatedexplore> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.explore_about_adapter, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        callTypeFace(holder);
        if (position == (list.size() - 1)) {
            holder.view.setVisibility(View.VISIBLE);
        } else {
            holder.view.setVisibility(View.GONE);
        }

        Relatedexplore relatedexplore = list.get(position);

        holder.layout.setOnClickListener(this);
        holder.layout.setTag(relatedexplore);

        holder.title.setText(relatedexplore.getXmTitle());
        holder.subTitle.setText(relatedexplore.getUmName());
        holder.date.setText(relatedexplore.getXmPostDate());

        switch (relatedexplore.getXcType()) {
            case "4":
                Glide.with(activity)
                        .load(relatedexplore.getCoverfile())
                        .apply(AppUtils.getRequestOptionWithoutOverride())
                        .into(holder.image);
                break;
            default:
                Glide.with(activity)
                        .load(Constants.getLoadGlide(activity,relatedexplore.getCoverpath() + relatedexplore.getCoverfile()))
                        .apply(AppUtils.getRequestOptionWithoutOverride())
                        .into(holder.image);
                break;
        }

    }

    private void callTypeFace(MyViewHolder holder) {
        holder.title.setTypeface(FontTypeFace.fontBold(activity));
        holder.subTitle.setTypeface(FontTypeFace.fontSemiBold(activity));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.layout) {
            Relatedexplore relatedexplore = (Relatedexplore) v.getTag();
            onPassDataListener.onPassData(relatedexplore);
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.image)
        ImageView image;
        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.sub_title)
        TextView subTitle;
        @BindView(R.id.date)
        TextView date;
        @BindView(R.id.card_view)
        CardView cardView;
        @BindView(R.id.view)
        View view;
        @BindView(R.id.layout)
        LinearLayout layout;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface OnPassDataListener{
        void onPassData(Relatedexplore exploreViewRes);
    }

}
