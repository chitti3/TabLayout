package com.example.youthhub.dashBoard.eventFragment;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.youthhub.R;
import com.example.youthhub.resModel.event.eventView.Datum;
import com.example.youthhub.utils.AppUtils;
import com.example.youthhub.utils.Constants;
import com.example.youthhub.utils.FontTypeFace;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

import static com.example.youthhub.profile.ProfileFragment.TAG;

public class ParticipantListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {


    private Activity activity;
    private List<Datum> datums;

    private OnLoadMoreListener onLoadMoreListener;
    private PassDataListener passDataListener;
    private final int VIEW_TYPE_ITEM = 0;
    private final int VIEW_TYPE_LOADING = 1;
    private boolean isLoading;
    private int visibleThreshold = 5;
    private int lastVisibleItem, totalItemCount;
    private  String userMediumPath;

    void setOnLoadMoreListener(OnLoadMoreListener mOnLoadMoreListener) {
        this.onLoadMoreListener = mOnLoadMoreListener;
    }

    void setPassDataListener(PassDataListener passDataListener) {
        this.passDataListener = passDataListener;
    }

    public void addAll(List<Datum> datums) {
        this.datums = datums;
        notifyDataSetChanged();
    }

    ParticipantListAdapter(final RecyclerView recyclerView1, final List<Datum> datums, Activity activity, String userMediumPath) {
        this.datums = datums;
        this.activity = activity;
        this.userMediumPath = userMediumPath;

        final LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView1.getLayoutManager();
        recyclerView1.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                boolean scrolled = AppUtils.isLastItemDisplaying(recyclerView1);
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

    @Override
    public int getItemViewType(int position) {
        return datums.get(position) == null ? VIEW_TYPE_LOADING : VIEW_TYPE_ITEM;
    }

    @Override
    public int getItemCount() {
        return datums == null ? 0 : datums.size();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_ITEM) {
            View view = LayoutInflater.from(activity).inflate(R.layout.participant_list_adapter, parent, false);
            view.setOnClickListener(this);
            return new MyViewHolder(view);
        } else if (viewType == VIEW_TYPE_LOADING) {
            View view = LayoutInflater.from(activity).inflate(R.layout.item_loading, parent, false);
            return new LoadingViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyViewHolder) {
            populateItemRows((MyViewHolder) holder, position);
        } else if (holder instanceof LoadingViewHolder) {
            showLoadingView();
        }
    }

    private void callTypeFace(MyViewHolder holder) {
        holder.userName.setTypeface(FontTypeFace.fontBold(activity));
        holder.userCode.setTypeface(FontTypeFace.fontBold(activity));
    }

    private void showLoadingView() {
        //ProgressBar would be displayed

    }

    private void populateItemRows(MyViewHolder holder, int position) {

        callTypeFace(holder);
        Datum datum = datums.get(position);
    //    holder.userCode.setText(datum.getUsernameCode());
        Log.d(TAG, "populateItemRows: "+datum.getUmProfilePicture());
        holder.userName.setText(datum.getUmName());
        holder.userAbout.setText(datum.getUtDescription());

        if (datum.getUmProfilePicture() != null && !datum.getUmProfilePicture().isEmpty()) {

            holder.messageImg.setVisibility(View.VISIBLE);
            //invisible because text constrained to msg text
            holder.userCode.setVisibility(View.INVISIBLE);

            Glide.with(activity)
                    .load(Constants.getLoadGlide(activity,userMediumPath+ datum.getUmProfilePicture()))
                    .apply(AppUtils.getRequestOption())
                    .into(holder.messageImg);





        } else {
            holder.messageImg.setVisibility(View.GONE);
            holder.userCode.setVisibility(View.VISIBLE);
            holder.userCode.setText(datum.getUsernameCode());
        }
    }

    public void setLoaded() {
        isLoading = false;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

        }
    }

    // "Loading item" ViewHolder
    public class LoadingViewHolder extends RecyclerView.ViewHolder {
        ProgressBar progressBar;

        LoadingViewHolder(View view) {
            super(view);
            progressBar = view.findViewById(R.id.progressBar);
        }
    }

    // "Normal item" ViewHolder
    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.user_code)
        TextView userCode;
        @BindView(R.id.user_name)
        TextView userName;
        @BindView(R.id.user_about)
        TextView userAbout;
        @BindView(R.id.message_img)
        CircleImageView messageImg;

        @BindView(R.id.comment_image_code_constrain)
        ConstraintLayout commentImageCodeConstrain;

        public MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface OnLoadMoreListener {
        void onLoadMore();
    }

    public interface PassDataListener {
        void passData();
    }

}