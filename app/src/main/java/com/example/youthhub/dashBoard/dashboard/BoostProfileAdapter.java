package com.example.youthhub.dashBoard.dashboard;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.youthhub.R;
import com.example.youthhub.utils.FontTypeFace;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BoostProfileAdapter extends RecyclerView.Adapter<BoostProfileAdapter.MyViewHolder> {

    Activity activity;

    public BoostProfileAdapter(Activity activity) {
        this.activity = activity;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_boost_profile, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        callTypeFace(holder);

        if (position == 0) {
            holder.beginBtn.setVisibility(View.GONE);
            holder.titleTxt.setText("154pts");
            holder.titleTxt.setTextSize(26);
            holder.titleTxt.setTypeface(FontTypeFace.fontBold(activity));
            holder.pointsTxt.setText("to level up");
            holder.pointsTxt.setTextSize(14);
            holder.pointsTxt.setTypeface(FontTypeFace.fontMedium(activity));
        } else {
            holder.beginBtn.setVisibility(View.VISIBLE);
        }
        if (position == 3) {
            holder.view2.setVisibility(View.VISIBLE);
        } else {
            holder.view2.setVisibility(View.GONE);
        }
        if (position == 0) {
            holder.view3.setVisibility(View.VISIBLE);
        } else {
            holder.view3.setVisibility(View.GONE);
        }
    }

    private void callTypeFace(MyViewHolder holder) {
        holder.titleTxt.setTypeface(FontTypeFace.fontSemiBold(activity));
        holder.beginBtn.setTypeface(FontTypeFace.fontBold(activity));
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.view3)
        View view3;
        @BindView(R.id.view1)
        View view1;
        @BindView(R.id.title_txt)
        TextView titleTxt;
        @BindView(R.id.points_txt)
        TextView pointsTxt;
        @BindView(R.id.begin_btn)
        Button beginBtn;
        @BindView(R.id.card_view)
        CardView cardView;
        @BindView(R.id.view2)
        View view2;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
