package com.example.youthhub.signUpPage;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Window;
import android.widget.Button;

import com.example.youthhub.R;
import com.example.youthhub.resModel.register.JobWishlist;
import com.example.youthhub.utils.MyToast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class JobwishlistDialog extends Dialog implements JobWishListAdapter.OnViewClickListener {

    Activity activity;

    List<JobWishlist> lists;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.pass_btn)
    Button passBtn;
    private List<JobWishlist> jobWishlists = new ArrayList<>();

    private PassJobWishListItems passJobWishListItems;

    JobwishlistDialog(Activity activity) {
        super(activity);
        this.activity = activity;
    }

    void newInstance(List<JobWishlist> lists){
        this.lists = lists;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.jobwishlist_dialog);
        ButterKnife.bind(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(activity));
        JobWishListAdapter jobWishListAdapter = new JobWishListAdapter(activity, lists);
        jobWishListAdapter.setOnViewClickListener(this);
        recyclerView.setAdapter(jobWishListAdapter);

    }

    @Override
    public void OnViewItemClick(JobWishlist jobWishlist) {
        int num;
        boolean itemTheir = false;
        if (jobWishlists.size() == 0) {
            jobWishlists.add(jobWishlist);
        } else {
            num = jobWishlists.size();
            for (int i = 0; i < num; i++) {
                if (jobWishlists.get(i).getWitTagId().equals(jobWishlist.getWitTagId())) {
                    jobWishlists.remove(i);
                    itemTheir = false;
                    break;
                } else {
                    itemTheir = true;
                }
            }
            if (itemTheir) {
                jobWishlists.add(jobWishlist);
            }
        }

        //Toast.makeText(activity,String.valueOf(jobWishlists.size()),Toast.LENGTH_LONG).show();
    }

    @OnClick(R.id.pass_btn)
    public void onViewClicked() {
        if(jobWishlists.size()!=0){
            passJobWishListItems.PassDatas(jobWishlists);
            dismiss();
        }else {
            MyToast.errorMessage("Please Select Your MyJobs WishList",activity);
        }
    }

    public void setPassJobWishListItems(PassJobWishListItems passJobWishListItems){
        this.passJobWishListItems = passJobWishListItems;
    }

    public interface PassJobWishListItems{
        void PassDatas(List<JobWishlist> jobWishlists);
    }
}
