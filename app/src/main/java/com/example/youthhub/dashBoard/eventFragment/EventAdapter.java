package com.example.youthhub.dashBoard.eventFragment;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import com.example.youthhub.resModel.event.EventList;
import com.example.youthhub.utils.AppUtils;
import com.example.youthhub.utils.Constants;
import com.example.youthhub.utils.FontTypeFace;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EventAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {

    private static final int VIEW_ITEM =0;
    private Activity activity;
    private List<EventList> eventLists;
    private String imgUrl;

    private OnLoadMoreListener onLoadMoreListener;
    private PassDataListener passDataListener;
    private boolean isLoading;
    private int visibleThreshold = 5;
    private int lastVisibleItem, totalItemCount;

    void setOnLoadMoreListener(OnLoadMoreListener mOnLoadMoreListener) {
        this.onLoadMoreListener = mOnLoadMoreListener;
    }

    void setPassDataListener(PassDataListener passDataListener) {
        this.passDataListener = passDataListener;
    }

    public void addAll(List<EventList> eventLists) {
        this.eventLists = eventLists;
        notifyDataSetChanged();
    }

    EventAdapter(final RecyclerView eventRecycler, final List<EventList> eventLists, Activity activity, String imgUrl) {
        this.eventLists = eventLists;
        this.activity = activity;
        this.imgUrl = imgUrl;

        final LinearLayoutManager linearLayoutManager = (LinearLayoutManager) eventRecycler.getLayoutManager();
        eventRecycler.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                boolean scrolled = AppUtils.isLastItemDisplaying(eventRecycler);
                if (scrolled) {
                    if (linearLayoutManager != null) {
                        totalItemCount = linearLayoutManager.getItemCount();
                        Log.e("fffhw", String.valueOf(linearLayoutManager.getItemCount()));
                    }
                    if (linearLayoutManager != null) {
                        lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();
                        Log.e("fffhw", String.valueOf( lastVisibleItem));
                    }
                    if (!isLoading && totalItemCount <= (lastVisibleItem + visibleThreshold)) {
                        if (onLoadMoreListener != null) {
                            onLoadMoreListener.onLoadMore();
                        }
                        isLoading = true;
                        Log.e("fffhw", String.valueOf(isLoading));
                    }
                }
            }
        });
        notifyDataSetChanged();

    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return eventLists == null ? 0 : eventLists.size();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder ViewHolder;
        Log.e("grgrfe", String.valueOf(viewType));
        if (viewType == VIEW_ITEM){
        View view = LayoutInflater.from(activity).inflate(R.layout.event_adapter, parent, false);
        view.setOnClickListener(this);
        ViewHolder= new UserViewHolder(view);}
        else {
            View view =LayoutInflater.from(activity).inflate(R.layout.item_loading,parent,false);
            ViewHolder= new ProgrsssViewHolder(view);
        }
        return ViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof  UserViewHolder ) {
            populateItemRows((UserViewHolder) holder, position);
        }else {
            ((ProgrsssViewHolder) holder).progressBar.setIndeterminate(true);
        }
    }

    private void callTypeFace(UserViewHolder holder) {
        holder.eventTitle.setTypeface(FontTypeFace.fontBold(activity));
        holder.eventDate.setTypeface(FontTypeFace.fontSemiBold(activity));
        holder.eventRegion.setTypeface(FontTypeFace.fontSemiBold(activity));
        holder.eventTime.setTypeface(FontTypeFace.fontMedium(activity));
        holder.eventCity.setTypeface(FontTypeFace.fontMedium(activity));
        holder.countMeBtn.setTypeface(FontTypeFace.fontBold(activity));
        holder.eventMoreDetailsBtn.setTypeface(FontTypeFace.fontBold(activity));


    }

    private void populateItemRows(UserViewHolder holder, int position) {

        callTypeFace(holder);

        EventList eventList = eventLists.get(position);

        holder.eventMoreDetailsBtn.setOnClickListener(this);
        holder.eventMoreDetailsBtn.setTag(eventList);

/*        holder.countMeBtn.setOnClickListener(this);
        holder.countMeBtn.setTag(R.id.object, eventList);
        holder.countMeBtn.setTag(R.id.integer, position);*/

        holder.eventTitle.setText(eventList.getTitle());
        holder.eventDate.setText(eventList.getStartDate());
        holder.eventRegion.setText(eventList.getRegionName());

        if (eventList.getStatusName().equals("Expired"))
        {
            holder.countMeBtn.setVisibility(View.INVISIBLE);
        }else
        {
            holder.countMeBtn.setVisibility(View.VISIBLE);
            holder.countMeBtn.setOnClickListener(this);
            holder.countMeBtn.setTag(R.id.object, eventList);
            holder.countMeBtn.setTag(R.id.integer, position);
        }

        String time = eventList.getStarttime() + " - " + eventList.getEndtime();
        holder.eventTime.setText(time);

        holder.eventCity.setText(eventList.getCityName());

        String hosted = "Hosted by " + eventList.getPostbyUserName();
        holder.eventHosted.setText(hosted);

        holder.countMeBtn.setText(eventList.getParticipantCurrentStatusName());

        Glide.with(activity)
                .load(Constants.getLoadGlide(activity, imgUrl + eventList.getLogo()))
                .apply(AppUtils.getRequestOptionWithoutOverride())
                .into(holder.eventImg);


    }

    public void setLoaded() {
        isLoading = false;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.event_more_details_btn:
                EventList eventList = (EventList) v.getTag();
                passDataListener.passData(eventList, true, -1);
                //call_event_api(eventList.getCode());
                break;
            case R.id.count_me_btn:
                EventList eventList1 = (EventList) v.getTag(R.id.object);
                int position = (int) v.getTag(R.id.integer);
                passDataListener.passData(eventList1, false, position);
                //call_count_status_api(eventList1.getCode(),eventList1.getParticipantCurrentStatus());
                break;
        }
    }

    // "Normal item" ViewHolder
    class UserViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.event_img)
        ImageView eventImg;
        @BindView(R.id.event_title)
        TextView eventTitle;
        @BindView(R.id.three_dots)
        ImageView threeDots;
        @BindView(R.id.event_date)
        TextView eventDate;
        @BindView(R.id.event_region)
        TextView eventRegion;
        @BindView(R.id.event_time)
        TextView eventTime;
        @BindView(R.id.event_city)
        TextView eventCity;
        @BindView(R.id.event_hosted)
        TextView eventHosted;
        @BindView(R.id.event_view)
        View eventView;
        @BindView(R.id.event_more_details_btn)
        Button eventMoreDetailsBtn;
        @BindView(R.id.count_me_btn)
        Button countMeBtn;
        @BindView(R.id.event_share)
        ImageView eventShare;

        UserViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, itemView);
        }
    }



    public interface OnLoadMoreListener {
        void onLoadMore();
    }

    public interface PassDataListener {
        void passData(EventList eventList, boolean viewPage, int position);
    }

     class ProgrsssViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.progressBar)
        ProgressBar progressBar;
        public ProgrsssViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, itemView);
        }
    }
}
