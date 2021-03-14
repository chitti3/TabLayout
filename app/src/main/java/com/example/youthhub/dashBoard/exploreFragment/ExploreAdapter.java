package com.example.youthhub.dashBoard.exploreFragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.youthhub.R;
import com.example.youthhub.resModel.explore.ExploreViewRes;
import com.example.youthhub.resModel.explore.Explorelist;
import com.example.youthhub.retrofit.ApiClient;
import com.example.youthhub.utils.AppUtils;
import com.example.youthhub.utils.Constants;
import com.example.youthhub.utils.FontTypeFace;
import com.example.youthhub.utils.Loader;
import com.example.youthhub.utils.MyToast;
import com.example.youthhub.utils.NetWorkUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ExploreAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {

    private Activity activity;
    private List<Explorelist> explorelists;
    private String imgUrl;

    private OnLoadMoreListener onLoadMoreListener;
    private final int VIEW_TYPE_ITEM = 0;
    private final int VIEW_TYPE_LOADING = 1;
    private boolean isLoading;
    private int visibleThreshold = 2;
    private int lastVisibleItem, totalItemCount;

    void setOnLoadMoreListener(OnLoadMoreListener mOnLoadMoreListener) {
        this.onLoadMoreListener = mOnLoadMoreListener;
    }

    ExploreAdapter(Activity activity, final RecyclerView exploreRecycler, List<Explorelist> explorelists, String imgUrl) {
        this.activity = activity;
        this.explorelists = explorelists;
        this.imgUrl = imgUrl;

        if (exploreRecycler.getLayoutManager() instanceof LinearLayoutManager) {
            final LinearLayoutManager linearLayoutManager = (LinearLayoutManager) exploreRecycler.getLayoutManager();
            exploreRecycler.addOnScrollListener(new RecyclerView.OnScrollListener() {
                @Override
                public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                    super.onScrolled(recyclerView, dx, dy);
                    boolean scrolled = AppUtils.isLastItemDisplaying(exploreRecycler);
                    if (scrolled) {
                        if (linearLayoutManager != null) {
                            totalItemCount = linearLayoutManager.getItemCount();
                            lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();
                        }
                        if (!isLoading && totalItemCount <= (totalItemCount + visibleThreshold)) {
                            Log.e("totalItemCount" + totalItemCount, "lastVisibleItem" + lastVisibleItem);
                            if (onLoadMoreListener != null) {
                                onLoadMoreListener.onLoadMore();
                            }
                            isLoading = true;
                        }
                    }
                }
            });
        }
    }

    public void addAll(List<Explorelist> explorelists) {
        this.explorelists = explorelists;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        if (viewType == VIEW_TYPE_ITEM) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.explore_adapter, viewGroup, false);
            view.setOnClickListener(this);
            return new MyViewHolder(view);
        } else if (viewType == VIEW_TYPE_LOADING) {
            View view = LayoutInflater.from(activity).inflate(R.layout.item_loading, viewGroup, false);
            return new LoadingViewHolder(view);
        } else {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.explore_adapter, viewGroup, false);
            view.setOnClickListener(this);
            return new MyViewHolder(view);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyViewHolder) {
            populateItemRows((MyViewHolder) holder, position);
        } else if (holder instanceof LoadingViewHolder) {
            showLoadingView((LoadingViewHolder)holder,position);
        }
    }

    private void showLoadingView(LoadingViewHolder holder, int position) {
      holder.progressBar.setIndeterminate(true);


    }

    private void populateItemRows(MyViewHolder holder, int position) {

        callTypeFace(holder);
        holder.exploreMoreBtn.setOnClickListener(this);

        Explorelist explorelist = explorelists.get(position);

        holder.exploreMoreBtn.setTag(explorelist);

        holder.exploreTitle.setText(explorelist.getXmTitle());
        holder.exploreName.setText(explorelist.getUmName());
        String views = explorelist.getXmTotalView() + " Views";
        holder.exploreViews.setText(views);

        holder.exploreDate.setText(explorelist.getXmPostDate());
        holder.exploreSubject.setText(explorelist.getXmSubject());
        holder.exploreDesc.setText(Html.fromHtml(explorelist.getXmDescription()));

        /*ByteArrayOutputStream bytes = new ByteArrayOutputStream();

        //save scaled down image to cache dir

        newBitmap.compress(Bitmap.CompressFormat.JPEG, 100, bytes);

        File imageFile = new File(imgUrl+explorelist.getLogo());

        // write the bytes in file
        FileOutputStream fo = new FileOutputStream(imageFile);
        fo.write(bytes.toByteArray());*/

        RequestOptions options = new RequestOptions()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .priority(Priority.HIGH);

        switch (explorelist.getXcType()) {
            case "4":
                Glide.with(activity)
                        .load(explorelist.getCoverfile())
                        .apply(options)
                        .into(holder.exploreImg);
                break;
            default:
                Glide.with(activity)
                        .load(Constants.getLoadGlide(activity,explorelist.getCoverpath() + explorelist.getCoverfile()))
                        .apply(options)
                        .into(holder.exploreImg);
                break;
        }

    }

    private void callTypeFace(MyViewHolder holder) {
        holder.exploreTitle.setTypeface(FontTypeFace.fontBold(activity));
        holder.exploreName.setTypeface(FontTypeFace.fontSemiBold(activity));
        holder.exploreViews.setTypeface(FontTypeFace.fontSemiBold(activity));
        holder.exploreMoreBtn.setTypeface(FontTypeFace.fontBold(activity));
    }

    @Override
    public int getItemCount() {
        return explorelists == null ? 0 : explorelists.size();
    }

    @Override
    public int getItemViewType(int position) {
        return explorelists.get(position) == null ? VIEW_TYPE_LOADING : VIEW_TYPE_ITEM;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.explore_more_btn:
                Explorelist explorelist = (Explorelist) v.getTag();
                call_explore_view_api(explorelist);
                break;
        }
    }

    private void call_explore_view_api(Explorelist explorelist) {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            String explore_code = explorelist.getXmCode();
            Call<ExploreViewRes> call = ApiClient.getApiInterface().getExploreView(Constants.getApiKey(activity),Constants.getAccessKey(activity), Constants.getToken(activity), explore_code, "");
            call.enqueue(new Callback<ExploreViewRes>() {
                @Override
                public void onResponse(@NonNull Call<ExploreViewRes> call, @NonNull Response<ExploreViewRes> response) {
                    Loader.showLoad(activity, false);
                    if (response.isSuccessful()) {
                        if (response.body() != null) {
                            if(response.body().getStatus()==1){
                                Bundle bundle = new Bundle();
                                bundle.putParcelable(Constants.ExploreView,response.body());
                                Intent intent = new Intent(activity, ExploreViewActivity.class);
                                intent.putExtras(bundle);
                                activity.startActivity(intent);
                                activity.overridePendingTransition(R.anim.activity_slide_up, R.anim.stay);
                            }else {
                                MyToast.errorMessage(response.body().getMessage(),activity);
                            }
                        }
                    } else {
                        Log.d(Constants.failureResponse + " ExploreView", response.toString());
                    }
                }

                @Override
                public void onFailure(@NonNull Call<ExploreViewRes> call, @NonNull Throwable t) {
                    Loader.showLoad(activity, false);
                    Log.d(Constants.failureResponse + " ExploreView", t.toString());
                }
            });
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.explore_img)
        ImageView exploreImg;
        @BindView(R.id.explore_title)
        TextView exploreTitle;
        @BindView(R.id.three_dots)
        ImageView threeDots;
        @BindView(R.id.explore_name)
        TextView exploreName;
        @BindView(R.id.explore_views)
        TextView exploreViews;
        @BindView(R.id.explore_date)
        TextView exploreDate;
        @BindView(R.id.explore_subject)
        TextView exploreSubject;
        @BindView(R.id.explore_desc)
        TextView exploreDesc;
        @BindView(R.id.view)
        View view;
        @BindView(R.id.explore_more_btn)
        Button exploreMoreBtn;
        @BindView(R.id.explore_share)
        ImageView exploreShare;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
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

    public void setLoaded() {
        isLoading = false;
    }

    public interface OnLoadMoreListener {
        void onLoadMore();
    }

}
