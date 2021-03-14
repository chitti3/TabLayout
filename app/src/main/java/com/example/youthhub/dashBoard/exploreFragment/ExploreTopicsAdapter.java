package com.example.youthhub.dashBoard.exploreFragment;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
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
import com.example.youthhub.resModel.explore.Topic;
import com.example.youthhub.utils.AppUtils;
import com.example.youthhub.utils.Constants;
import com.example.youthhub.utils.FontTypeFace;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ExploreTopicsAdapter extends RecyclerView.Adapter<ExploreTopicsAdapter.MyViewHolder> {

    @BindView(R.id.image)
    ImageView image;
    @BindView(R.id.play_btn)
    ImageView playBtn;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.date)
    TextView date;
    @BindView(R.id.double_tick)
    ImageView doubleTick;
    @BindView(R.id.card_view)
    CardView cardView;
    @BindView(R.id.view)
    View view;
    @BindView(R.id.layout)
    LinearLayout layout;
    private Activity activity;
    private List<Topic> list = new ArrayList<>();

    private boolean isLoading;
    private int visibleThreshold = 5;
    private int lastVisibleItem, totalItemCount;
    private OnLoadMoreListener onLoadMoreListener;
    private OnPassDataListener onPassDataListener;

    void setOnPassDataListener(OnPassDataListener onPassDataListener){
        this.onPassDataListener = onPassDataListener;
    }

    void setOnLoadMoreListener(OnLoadMoreListener onLoadMoreListener) {
        this.onLoadMoreListener = onLoadMoreListener;
    }

    ExploreTopicsAdapter(Activity activity, final RecyclerView topicRecycler) {
        this.activity = activity;

        final LinearLayoutManager linearLayoutManager = (LinearLayoutManager) topicRecycler.getLayoutManager();
        topicRecycler.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                boolean scrolled = AppUtils.isLastItemDisplaying(topicRecycler);
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

    void addAll(List<Topic> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.explore_topics_adapter, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        callTypeFace(holder);
        if (position % 2 == 0) {
            holder.view.setVisibility(View.GONE);
        } else {
            holder.view.setVisibility(View.VISIBLE);
        }
        Topic topic = list.get(position);

        holder.layout.setTag(topic);

        holder.title.setText(topic.getXtTitle());
        holder.date.setText(topic.getXtCreatedOn());

        switch (topic.getIsRead()) {
            case 0:
                holder.doubleTick.setVisibility(View.GONE);
                break;
            case 1:
                holder.doubleTick.setVisibility(View.VISIBLE);
                break;
        }

        switch (topic.getXcType()) {
            case "4":
                Glide.with(activity)
                        .load(topic.getCoverfile())
                        .apply(AppUtils.getRequestOptionWithoutOverride())
                        .into(holder.image);
                holder.playBtn.setVisibility(View.VISIBLE);
                break;
            default:
                Glide.with(activity)
                        .load(Constants.getLoadGlide(activity,topic.getCoverpath() + topic.getCoverfile()))
                        .apply(AppUtils.getRequestOptionWithoutOverride())
                        .into(holder.image);
                holder.playBtn.setVisibility(View.GONE);
                break;
        }

    }

    private void callTypeFace(MyViewHolder holder) {
        holder.title.setTypeface(FontTypeFace.fontBold(activity));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.image)
        ImageView image;
        @BindView(R.id.play_btn)
        ImageView playBtn;
        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.date)
        TextView date;
        @BindView(R.id.double_tick)
        ImageView doubleTick;
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

        @OnClick(R.id.layout)
        public void onViewClicked(View view) {
            Topic topic = (Topic) view.getTag();
            onPassDataListener.onPassData(topic);
        }

    }

    public interface OnLoadMoreListener {
        void onLoadMore();
    }

    public void setLoaded() {
        isLoading = false;
    }

    public interface OnPassDataListener{
        void onPassData(Topic topic);
    }

}
