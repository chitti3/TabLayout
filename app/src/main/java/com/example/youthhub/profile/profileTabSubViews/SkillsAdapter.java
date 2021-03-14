package com.example.youthhub.profile.profileTabSubViews;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.youthhub.R;
import com.example.youthhub.resModel.profile.profileinfo.ProfileInfoResp;
import com.example.youthhub.utils.FontTypeFace;
import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SkillsAdapter extends RecyclerView.Adapter<SkillsAdapter.MyViewHolder> {

    private static final String TAG = "SkillsAdapter";
    Activity activity;
    ProfileInfoResp profileInfoResp;

    public SkillsAdapter(Activity activity, ProfileInfoResp profileInfoResp) {
        this.activity = activity;
        this.profileInfoResp = profileInfoResp;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.skills_adapter, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int i) {
        callTypeFace(holder);
        holder.skillsTitle.setText(profileInfoResp.getData().getSkills().get(i).getSkmName());
     //   Log.d(TAG, "onBindViewHolder:i "+" "+i+new Gson().toJson(profileInfoResp.getData().getSkills().get(i)));
        if (profileInfoResp.getData().getSkills().get(i).getEndorsedBy().size()>=1){
            holder.skillsText2.setVisibility(View.VISIBLE);
            holder.skillsText2.setText(profileInfoResp.getData().getSkills().get(i).getEndorsedBy().get(0).getCode());

        }else {
            holder.skillsText2.setVisibility(View.INVISIBLE);
        }
        if (profileInfoResp.getData().getSkills().get(i).getEndorsedBy().size()>=2){
            holder.skillsText1.setVisibility(View.VISIBLE);
            holder.skillsText1.setText(profileInfoResp.getData().getSkills().get(i).getEndorsedBy().get(1).getCode());

        }else {
            holder.skillsText1.setVisibility(View.INVISIBLE);
        }
    }

    private void callTypeFace(MyViewHolder holder) {
        holder.skillsTitle.setTypeface(FontTypeFace.fontBold(activity));
    }

    @Override
    public int getItemCount() {
        return profileInfoResp.getData().getSkills().size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.skills_title)
        TextView skillsTitle;
        @BindView(R.id.skills_text1)
        TextView skillsText1;
        @BindView(R.id.skills_text2)
        TextView skillsText2;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
