package com.example.youthhub.support;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.youthhub.R;
import com.example.youthhub.resModel.supportRes.SupportList;
import com.example.youthhub.utils.AppUtils;
import com.example.youthhub.utils.FontTypeFace;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SupportListAdapter extends RecyclerView.Adapter<SupportListAdapter.MyViewHolder> implements View.OnClickListener {

    private Activity activity;
    private List<SupportList> supportLists = new ArrayList<>();

    private boolean isLoading;
    private int visibleThreshold = 5;
    private int lastVisibleItem, totalItemCount;
    private OnLoadMoreListener onLoadMoreListener;

    public void setOnLoadMoreListener(OnLoadMoreListener mOnLoadMoreListener) {
        this.onLoadMoreListener = mOnLoadMoreListener;
    }

    void addAll(List<SupportList> supportLists) {
        this.supportLists = supportLists;
        notifyDataSetChanged();
    }

    SupportListAdapter(Activity activity, final RecyclerView supportRecycler) {
        this.activity = activity;

        final LinearLayoutManager linearLayoutManager = (LinearLayoutManager) supportRecycler.getLayoutManager();
        supportRecycler.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                boolean scrolled = AppUtils.isLastItemDisplaying(supportRecycler);
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

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.support_adapter, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        callTypeFace(holder);

        SupportList supportlist = supportLists.get(position);

        holder.openBtn.setOnClickListener(this);
        holder.openBtn.setTag(supportlist);

        holder.ticketId.setText(supportlist.getHmCode());
        holder.subject.setText(supportlist.getHmSubject());
        holder.date.setText(supportlist.getHmDate());
        holder.repliesView.setText(supportlist.getHmUserReplies());
        holder.openBtn.setText(supportlist.getHmSmStatusName());
    }

    private void callTypeFace(MyViewHolder holder) {
        holder.ticketId.setTypeface(FontTypeFace.fontBold(activity));
        holder.subject.setTypeface(FontTypeFace.fontMedium(activity));
        holder.repliesView.setTypeface(FontTypeFace.fontMedium(activity));
        holder.date.setTypeface(FontTypeFace.fontMedium(activity));
        holder.openBtn.setTypeface(FontTypeFace.fontBold(activity));
    }

    @Override
    public int getItemCount() {

        return supportLists.size();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.open_btn:
                SupportList supportList = (SupportList) v.getTag();
                Intent intent = new Intent(activity, SupportViewActivity.class);
                intent.putExtra("TicketCode",supportList.getHmCode());
                activity.startActivity(intent);
                activity.overridePendingTransition(R.anim.activity_slide_up, R.anim.stay);
                }
        }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.ticket_id_txt)
        TextView ticketIdTxt;
        @BindView(R.id.ticket_id)
        TextView ticketId;
        @BindView(R.id.date_txt)
        TextView dateTxt;
        @BindView(R.id.date)
        TextView date;
        @BindView(R.id.subject_txt)
        TextView subjectTxt;
        @BindView(R.id.subject)
        TextView subject;
        @BindView(R.id.replies_view_txt)
        TextView repliesViewTxt;
        @BindView(R.id.replies_view)
        TextView repliesView;
        @BindView(R.id.open_btn)
        Button openBtn;
        @BindView(R.id.card_view)
        CardView cardView;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
    public interface OnLoadMoreListener {
        void onLoadMore();
    }

    public void setLoaded() {
        isLoading = false;
    }
}
