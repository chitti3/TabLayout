package com.example.youthhub.profile.profileTabSubViews;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.youthhub.R;
import com.example.youthhub.dashBoard.DeleteMessageDialog;
import com.example.youthhub.dashBoard.dashboard.CommentAdapter;
import com.example.youthhub.resModel.profile.BasicResponse;
import com.example.youthhub.resModel.profile.ProfileYouthInfoResponse;
import com.example.youthhub.resModel.profile.profileinfo.ProfileInfoResp;
import com.example.youthhub.retrofit.ApiClient;
import com.example.youthhub.utils.Constants;
import com.example.youthhub.utils.Loader;
import com.example.youthhub.utils.MyToast;
import com.example.youthhub.utils.NetWorkUtil;
import com.google.gson.Gson;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WishListAdapter extends RecyclerView.Adapter<WishListAdapter.MyViewHolder> implements DeleteMessageDialog.OnDeleteListener {

    Activity activity;
    Context context;
    ProfileInfoResp profileInfoResp;
    BasicResponse basicResponse;
    public static final String TAG = WishListAdapter.class.getSimpleName();
    String userType = "";
    private OnPassDataListener onPassDataListener;

    private int deletePosition;

    void setOnPassDataListener(OnPassDataListener onPassDataListener) {
        this.onPassDataListener = onPassDataListener;
    }
    public WishListAdapter(Activity activity, ProfileInfoResp profileInfoResp, String userType) {
        this.activity = activity;
        this.profileInfoResp = profileInfoResp;
        this.userType = userType;
        context = activity;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.wish_list_adapter, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.wishlistAdapterTitle.setText(profileInfoResp.getData().getJobWishlist().get(i).getWitName());

        myViewHolder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // call_delete_wishlist_api(profileInfoResp.getData().getJobWishlist().get(i).getWiuWishlistId());
                DeleteMessageDialog deleteMessageDialog = new DeleteMessageDialog(activity,"wishlist" ,profileInfoResp.getData().getJobWishlist().get(i).getWiuWishlistId(), null,null);
                deleteMessageDialog.setOnDeleteListener(WishListAdapter.this);
                deleteMessageDialog.show();
               // removeAt(i);
            }
        });

        if (userType.equalsIgnoreCase("1")){
            myViewHolder.delete.setVisibility(View.VISIBLE);
        }else{
            myViewHolder.delete.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return profileInfoResp.getData().getJobWishlist().size();
    }

    @Override
    public void OnDelete(boolean deleted) {
        onPassDataListener.passData(deleted, deletePosition,"wishlist");
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.wishlist_adapter_title)
        TextView wishlistAdapterTitle;
        @BindView(R.id.delete)
        ImageView delete;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    private void call_delete_wishlist_api(String wishlish_id) {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            Call<BasicResponse> call = ApiClient.getApiInterface().deleteWishlist(Constants.getApiKey(activity), Constants.getAccessKey(activity),
                    Constants.getToken(activity),wishlish_id
            );

            call.enqueue(new Callback<BasicResponse>() {
                @Override
                public void onResponse(@NonNull Call<BasicResponse> call, @NonNull Response<BasicResponse> response) {
                    if (response.isSuccessful()) {
                        //   Log.d(TAG, "onResponse:ProfileYouthInfoResponse 1 ");
                        if (response.body() != null) {
                            if (response.body().getStatus() == 1) {
                                basicResponse = response.body();

                                MyToast.normalMessage(response.body().getMessage(), activity);
                            } else {
                                //     Log.d(TAG, "onResponse:ProfileYouthInfoResponse else "+new Gson().toJson(profileInfoResp));
                                MyToast.errorMessage(response.body().getMessage(), activity);
                            }

                        }
                    } else {
                        Log.d(Constants.failureResponse, " profile_info_update" + response.toString());
                    }
                    Loader.showLoad(activity, false);
                }

                @Override
                public void onFailure(@NonNull Call<BasicResponse> call, @NonNull Throwable t) {
                    call_delete_wishlist_api(wishlish_id);
                    Log.d(Constants.failureResponse, " profile_info_update" + t.toString());
                    Loader.showLoad(activity, false);
                }
            });

        }
    }
    public void removeAt(int position) {
        profileInfoResp.getData().getJobWishlist().remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, profileInfoResp.getData().getJobWishlist().size());
    }
    public interface OnPassDataListener {
        void passData(boolean deleted, int deletePosition,String which);
    }
}
