package com.example.youthhub.dashBoard.dashboard;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.youthhub.R;
import com.example.youthhub.dashBoard.findConnectionFragment.ContactDialog;
import com.example.youthhub.profile.ProfileActivity;
import com.example.youthhub.resModel.connection.contactMessage.ContactMessageResponse;
import com.example.youthhub.resModel.connection.followunfollow.FollowUnfollowResponse;
import com.example.youthhub.resModel.post.postList.ConnectionList;
import com.example.youthhub.resModel.profilepostlist.ConnectionListItem;
import com.example.youthhub.retrofit.ApiClient;
import com.example.youthhub.utils.Constants;
import com.example.youthhub.utils.FontTypeFace;
import com.example.youthhub.utils.Loader;
import com.example.youthhub.utils.MyToast;
import com.example.youthhub.utils.NetWorkUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SuggestConnectAdapter extends RecyclerView.Adapter<SuggestConnectAdapter.MyViewHolder> implements ContactDialog.OnPassDataListener {

    public static final String TAG = "SuggestConnectAdapter";
    Activity activity;
    @BindView(R.id.suggest_con_view1)
    View suggestConView1;
    @BindView(R.id.suggest_con_view2)
    View suggestConView2;
    @BindView(R.id.connection_img)
    CircleImageView connectionImg;
    @BindView(R.id.connection_user_code)
    TextView connectionUserCode;
    @BindView(R.id.connection_constrain)
    ConstraintLayout connectionConstrain;
    @BindView(R.id.connection_name)
    TextView connectionName;
    @BindView(R.id.connection_region)
    TextView connectionRegion;
    @BindView(R.id.follow)
    Button follow;
    @BindView(R.id.contact)
    Button contact;
    @BindView(R.id.suggest_con_cardview)
    CardView suggestConCardview;
    @BindView(R.id.suggest_con_view3)
    View suggestConView3;

    private List<ConnectionListItem> connectionLists;

    private String profileMediumPath;
    private String profileThumbnailPath;
    private ContactDialog contactDialog;
    private String usercode = "";
    private Integer chat_id = 0;

    SuggestConnectAdapter(Activity activity, List<ConnectionListItem> connectionLists, String profileMediumPath, String profileThumbnailPath) {
        this.activity = activity;

        this.connectionLists = connectionLists;
        this.profileMediumPath = profileMediumPath;
        this.profileThumbnailPath = profileThumbnailPath;

        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_suggested_connections, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {
        contactDialog = new ContactDialog(activity);
        CallTypeFace(myViewHolder);

        ConnectionListItem connectionList = connectionLists.get(position);

        myViewHolder.follow.setTag(R.id.follow__tag_object, connectionList);
        myViewHolder.follow.setTag(R.id.follow__tag_position, position);

        if (position == 2) {
            myViewHolder.suggestConView3.setVisibility(View.VISIBLE);
        }
        if (position == 0) {
            myViewHolder.suggestConView1.setVisibility(View.VISIBLE);
        } else {
            myViewHolder.suggestConView1.setVisibility(View.GONE);
        }

        myViewHolder.connectionName.setText(connectionList.getUsername());
        myViewHolder.connectionRegion.setText(connectionList.getRegionName());

        myViewHolder.contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usercode = connectionList.getUsercode();
                chat_id = connectionList.getChatId();
                contactDialog.setOnPassDataListener(SuggestConnectAdapter.this);
                contactDialog.show();
            }
        });
        switch (connectionList.getIsFollow()) {
            case 0:
                myViewHolder.follow.setText(activity.getString(R.string.follow));
                break;
            case 1:
                myViewHolder.follow.setText(activity.getString(R.string.un_follow));
                break;
        }


        switch (connectionList.getIsPicExist()) {
            case 1:
                myViewHolder.connectionUserCode.setVisibility(View.GONE);
                RequestOptions options = new RequestOptions()
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .priority(Priority.HIGH);
                Glide.with(activity)
                        .load(Constants.getLoadGlide(activity, profileThumbnailPath + connectionList.getProfile()))
                        .apply(options)
                        .into(myViewHolder.connectionImg);
                break;
            case 0:
                myViewHolder.connectionUserCode.setVisibility(View.VISIBLE);
                myViewHolder.connectionUserCode.setText(connectionList.getUsernameCode());
                break;
        }

        myViewHolder.connectionConstrain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, ProfileActivity.class);
                intent.putExtra(Constants.UserCode, connectionLists.get(position).getUsercode());
                intent.putExtra(Constants.UserType, connectionLists.get(position).getUsertype());
                activity.startActivity(intent);

                activity.overridePendingTransition(R.anim.activity_slide_up, R.anim.stay);
            }
        });

    }

    private void CallTypeFace(MyViewHolder myViewHolder) {
        myViewHolder.connectionName.setTypeface(FontTypeFace.fontBold(activity));
        myViewHolder.connectionUserCode.setTypeface(FontTypeFace.fontBold(activity));
    }

    @Override
    public int getItemCount() {
        return connectionLists.size();
    }

    @Override
    public void passData(String title, boolean clear) {
        call_connect_api(title);
    }


    private void call_connect_api(String message) {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            Call<ContactMessageResponse> call = ApiClient.getApiInterface().createContactMessage(Constants.getApiKey(activity), Constants.getAccessKey(activity), Constants.getToken(activity),
                    usercode, String.valueOf(chat_id), message);
            call.enqueue(new Callback<ContactMessageResponse>() {


                @Override
                public void onResponse(Call<ContactMessageResponse> call, Response<ContactMessageResponse> response) {
                    if (response.isSuccessful()) {
                        if (response.body() != null) {
                            if (response.body().getStatus() == 1) {
                                // connectionListMaster = response.body();

                            } else {
                                MyToast.errorMessage(response.body().getMessage(), activity);
                            }
                        }
                    } else {
                        Log.d(Constants.failureResponse + " ConListMaster", response.toString());
                    }
                    Loader.showLoad(activity, false);
                }

                @Override
                public void onFailure(@NonNull Call<ContactMessageResponse> call, @NonNull Throwable t) {
                    call_connect_api(message);
                    Log.d(Constants.failureResponse + " ConListMaster", t.toString());
                    Loader.showLoad(activity, false);
                }
            });
        }
    }




    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.suggest_con_view1)
        View suggestConView1;
        @BindView(R.id.suggest_con_view2)
        View suggestConView2;
        @BindView(R.id.connection_img)
        CircleImageView connectionImg;
        @BindView(R.id.connection_user_code)
        TextView connectionUserCode;
        @BindView(R.id.connection_name)
        TextView connectionName;
        @BindView(R.id.connection_region)
        TextView connectionRegion;
        @BindView(R.id.follow)
        Button follow;
        @BindView(R.id.contact)
        Button contact;
        @BindView(R.id.suggest_con_cardview)
        CardView suggestConCardview;
        @BindView(R.id.suggest_con_view3)
        View suggestConView3;
        @BindView(R.id.connection_constrain)
        ConstraintLayout connectionConstrain;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }


        @OnClick({R.id.follow, R.id.contact})
        public void onViewClicked(View view) {
            switch (view.getId()) {
                case R.id.follow:
                    ConnectionList connectionList = (ConnectionList) view.getTag(R.id.follow__tag_object);
                    int position = (int) view.getTag(R.id.follow__tag_position);
                    call_connection_follow_api(connectionList, position);
                    break;
                case R.id.contact:
                    break;

            }
        }

    }

    private void call_connection_follow_api(ConnectionList connectionList, int position) {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            String isfollow;
            if (connectionList.getIsFollow() == 0) {
                isfollow = "1";
            } else {
                isfollow = "0";
            }
            Call<FollowUnfollowResponse> call = ApiClient.getApiInterface().getFollowUnFollow(Constants.getApiKey(activity), Constants.getAccessKey(activity), Constants.getToken(activity), connectionList.getUsercode(), isfollow);
            call.enqueue(new Callback<FollowUnfollowResponse>() {
                @Override
                public void onResponse(@NonNull Call<FollowUnfollowResponse> call, @NonNull Response<FollowUnfollowResponse> response) {
                    if (response.isSuccessful()) {
                        if (response.body() != null) {
                            if (response.body().getStatus() == 1) {
                                change_ui(response.body(), position);
                            } else {
                                MyToast.errorMessage(response.body().getMessage(), activity);
                            }
                        }
                    } else {
                        Log.d(Constants.failureResponse + " FollowUnFollow", response.toString());
                    }
                    Loader.showLoad(activity, false);
                }

                @Override
                public void onFailure(@NonNull Call<FollowUnfollowResponse> call, @NonNull Throwable t) {
                    Log.d(Constants.failureResponse + " FollowUnFollow", t.toString());
                    Loader.showLoad(activity, false);
                }
            });
        }
    }

    private void change_ui(FollowUnfollowResponse connection, int position) {
        if (connection.getMessage().contains("Follow") || connection.getMessage().contains("Unfollow")) {
            ConnectionListItem connectionList = connectionLists.get(position);
            if (connection.getMessage().contains("Follow")) {
                connectionList.setIsFollow(1);
            } else if (connection.getMessage().contains("Unfollow")) {
                connectionList.setIsFollow(0);
            }
            connectionLists.set(position, connectionList);
            notifyDataSetChanged();
        }
    }

}
