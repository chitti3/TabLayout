package com.example.youthhub.dashBoard.findConnectionFragment;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.youthhub.R;
import com.example.youthhub.dashBoard.findConnectionFragment.multiSelectFilter.FindSharedDialog;
import com.example.youthhub.profile.ProfileActivity;
import com.example.youthhub.resModel.connection.ConnectionList;
import com.example.youthhub.resModel.connection.contactMessage.ContactMessageResponse;
import com.example.youthhub.resModel.connection.shared.SharedProfileResponse;
import com.example.youthhub.retrofit.ApiClient;
import com.example.youthhub.utils.AppUtils;
import com.example.youthhub.utils.Constants;
import com.example.youthhub.utils.FontTypeFace;
import com.example.youthhub.utils.Loader;
import com.example.youthhub.utils.MyToast;
import com.example.youthhub.utils.NetWorkUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.youthhub.profile.ProfileFragment.TAG;

public class FindConnectionAdapter extends RecyclerView.Adapter<FindConnectionAdapter.MyViewHolder> implements
        View.OnClickListener, ContactDialog.OnPassDataListener, FindSharedDialog.OnPassDataListener {


    private Activity activity;

    private boolean isLoading;
    private int visibleThreshold = 5;
    private int lastVisibleItem, totalItemCount;
    private OnLoadMoreListener onLoadMoreListener;
    private OnPassDataListener onPassDataListener;
    private List<ConnectionList> connectionLists = new ArrayList<>();
    private Map<String, String> imagePath = new HashMap<>();
    private int current_position = 0;
    ContactDialog contactDialog;
    FindSharedDialog findSharedDialog;
    String usertype = "";


    String usercode = "";
    int chat_id = 0;

    public int getCurrent_position() {
        return current_position;
    }

    public void setCurrent_position(int current_position) {
        this.current_position = current_position;
    }

    void setOnLoadMoreListener(OnLoadMoreListener mOnLoadMoreListener) {
        this.onLoadMoreListener = mOnLoadMoreListener;
    }

    void setOnPassDataListener(OnPassDataListener onPassDataListener) {
        this.onPassDataListener = onPassDataListener;
    }

    FindConnectionAdapter(Activity activity, final RecyclerView findConnectionRecycler) {
        this.activity = activity;

        contactDialog = new ContactDialog(activity);
        findSharedDialog = new FindSharedDialog(activity);
        Log.d(TAG, "FindConnectionAdapter: "+usertype);
        final LinearLayoutManager linearLayoutManager = (LinearLayoutManager) findConnectionRecycler.getLayoutManager();
        findConnectionRecycler.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                boolean scrolled = AppUtils.isLastItemDisplaying(findConnectionRecycler);
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

    void addAll(List<ConnectionList> connectionLists, Map<String, String> imagePath) {
        this.connectionLists = connectionLists;
        this.imagePath = imagePath;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(activity).inflate(R.layout.adapter_find_connection, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        callTypeFace(holder);
        if ((position % 2) != 0) {
            holder.view3.setVisibility(View.VISIBLE);
            holder.view1.setVisibility(View.GONE);
        } else {
            holder.view3.setVisibility(View.GONE);
            holder.view1.setVisibility(View.VISIBLE);
        }
        ConnectionList connectionList = connectionLists.get(position);

        //img and code both click listener same to go profile
        holder.connectorImg.setOnClickListener(this);
        holder.connectorImg.setTag(R.id.connection_object, connectionList);
        holder.connectorNameCode.setOnClickListener(this);
        holder.connectorNameCode.setTag(connectionList);

        holder.follow.setOnClickListener(this);
        holder.follow.setTag(R.id.follow__tag_object, connectionList);
        holder.follow.setTag(R.id.follow__tag_position, position);

        holder.connectorName.setText(connectionList.getUsername());
        holder.connectorPlace.setText(connectionList.getSubtitle1());


        switch (connectionList.getIsFollow()) {
            case 0:
                holder.follow.setText("Follow");
                break;
            case 1:
                holder.follow.setText("UnFollow");
                break;
        }

//        if (connectionList.getIsPicExist() == 1) {
//            holder.connectorImg.setVisibility(View.VISIBLE);
//            //invisible because text constrained to msg text
//            holder.connectorNameCode.setVisibility(View.INVISIBLE);
//
//            Glide.with(activity)
//                    .load(Constants.getLoadGlide(activity, imagePath.get("user_thumbnail_path") + connectionList.getProfile()))
//                    .apply(AppUtils.getRequestOptionWithoutOverride())
//                    .into(holder.connectorImg);
//        } else {
//            holder.connectorImg.setVisibility(View.GONE);
//            holder.connectorNameCode.setVisibility(View.VISIBLE);
//            holder.connectorNameCode.setText(connectionList.getUsernameCode());
//        }


        if (connectionList.getIsPicExist() == 1) {
            holder.connectorImg.setVisibility(View.VISIBLE);

            Glide.with(activity)
                    .load(Constants.getLoadGlide(activity, imagePath.get("user_thumbnail_path") + connectionList.getProfile()))
                    .apply(AppUtils.getRequestOptionWithoutOverride())
                    .into(holder.connectorImg);
            if (connectionList.getUsertype().equals("6")){
                if (connectionList.getUmlevel().equals("4"))
                {
                    holder.connectorImg.setVisibility(View.VISIBLE);
                    holder.connectorImg.setBorderColor(Color.parseColor("#212529"));


                }else if (connectionList.getUmlevel().equals("3"))
                {
                    holder.connectorImg.setVisibility(View.VISIBLE);
                    holder.connectorImg.setBorderColor(Color.parseColor("#cb8d37"));
                }else if (connectionList.getUmlevel().equals("2"))
                {
                    holder.connectorImg.setVisibility(View.VISIBLE);
                    holder.connectorImg.setBorderColor(Color.parseColor("#7b7b7b"));
                }}else
            {
                holder.connectorImg.setBorderColor(Color.parseColor("#FFFFFF"));
            }


            //invisible because text constrained to msg text
            holder.connectorNameCode.setVisibility(View.INVISIBLE);

        } else {
            holder.connectorImg.setVisibility(View.GONE);
            holder.connectorNameCode.setVisibility(View.VISIBLE);
            holder.connectorNameCode.setText(connectionList.getUsernameCode());
            if (connectionList.getUsertype().equals("6"))
            {
                if (connectionList.getUmlevel().equals("4")) {
                    holder.connectorNameCode.setVisibility(View.VISIBLE);
                    holder.connectorNameCode.setBackgroundResource(R.drawable.text_circle_platinum);
                } else if (connectionList.getUmlevel().equals("3")) {
                    holder.connectorNameCode.setBackgroundResource(R.drawable.text_circle_gold);
                } else if (connectionList.getUmlevel().equals("2")) {
                    holder.connectorNameCode.setBackgroundResource(R.drawable.text_circle_silve);
                }

            }else
            {
                holder.connectorNameCode.setBackgroundResource(R.drawable.textview_circle2);
            }
        }















        holder.connectorImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConnectionList imgConnectionList = (ConnectionList) v.getTag(R.id.connection_object);
                Intent intent = new Intent(activity, ProfileActivity.class);
                intent.putExtra(Constants.UserCode, connectionLists.get(position).getUsercode());
                intent.putExtra(Constants.UserType, connectionLists.get(position).getUsertype());
                intent.putExtra(Constants.UserChat, String.valueOf(connectionLists.get(position).getChatId()));
                intent.putExtra(Constants.UserFollow, String.valueOf(connectionLists.get(position).getIsFollow()));
                activity.startActivity(intent);

                activity.overridePendingTransition(R.anim.activity_slide_up, R.anim.stay);
            }
        });
        holder.connectorNameCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConnectionList imgConnectionList = (ConnectionList) v.getTag(R.id.connection_object);
                Intent intent = new Intent(activity, ProfileActivity.class);
                intent.putExtra(Constants.UserCode, connectionLists.get(position).getUsercode());
                intent.putExtra(Constants.UserType, connectionLists.get(position).getUsertype());
                intent.putExtra(Constants.UserChat, connectionLists.get(position).getChatId());
                intent.putExtra(Constants.UserFollow, String.valueOf(connectionLists.get(position).getIsFollow()));

                activity.startActivity(intent);

                activity.overridePendingTransition(R.anim.activity_slide_up, R.anim.stay);
            }
        });

        if (connectionList.getUsertype().equalsIgnoreCase("5")){
            holder.shared.setVisibility(View.VISIBLE);
        }else {
            holder.shared.setVisibility(View.GONE);
        }
        holder.contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usercode = connectionList.getUsercode();
                chat_id = connectionList.getChatId();
                contactDialog.setOnPassDataListener(FindConnectionAdapter.this);
                contactDialog.show();
            }
        });
        if(connectionList.getIsShare().equals("1")){
            holder.shared.setText("Shared");
        }
        holder.shared.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(connectionList.getIsShare().equals("1")){
                  //  holder.shared.setText("Shared");
                }else {
                    usercode = connectionList.getUsercode();
                    chat_id = connectionList.getChatId();
                    findSharedDialog = new FindSharedDialog(activity,usercode,holder.shared);
                    findSharedDialog.setOnPassDataListener(FindConnectionAdapter.this);
                    findSharedDialog.show();

                }
            }
        });

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


    private void callTypeFace(MyViewHolder holder) {
        holder.connectorName.setTypeface(FontTypeFace.fontBold(activity));
        holder.follow.setTypeface(FontTypeFace.fontBold(activity));
        holder.contact.setTypeface(FontTypeFace.fontBold(activity));
        holder.shared.setTypeface(FontTypeFace.fontBold(activity));
        holder.connectorNameCode.setTypeface(FontTypeFace.fontBold(activity));
    }

    @Override
    public int getItemCount() {
        return connectionLists.size();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
          /*  case R.id.connector_img:


                break;*/
            case R.id.connector_name_code:
                ConnectionList codeConnectionList = (ConnectionList) v.getTag();
                break;
            case R.id.follow:
                ConnectionList followConnectionList = (ConnectionList) v.getTag(R.id.follow__tag_object);
                int position = (int) v.getTag(R.id.follow__tag_position);
                onPassDataListener.onPassData(followConnectionList, position);
                break;
        }
    }

    @Override
    public void passData(String message, boolean clear) {
        if (message.trim().isEmpty()){
            MyToast.errorMessage("Please Enter message",activity);
        }else {
            call_connect_api(message);
        }
    }

    @Override
    public void passData(boolean clear) {
        if (clear){
          // shared.setText("Shared");
        }

        //call_shared_profile(clear);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.view1)
        View view1;
        @BindView(R.id.view2)
        View view2;
        @BindView(R.id.connector_name_code)
        TextView connectorNameCode;
        @BindView(R.id.connector_img)
        CircleImageView connectorImg;
        @BindView(R.id.connector_name)
        TextView connectorName;
        @BindView(R.id.connector_place)
        TextView connectorPlace;
        @BindView(R.id.follow)
        Button follow;
        @BindView(R.id.contact)
        Button contact;
        @BindView(R.id.card_view)
        CardView cardView;
        @BindView(R.id.view3)
        View view3;
        @BindView(R.id.shared)
        public  Button shared;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface OnLoadMoreListener {
        void onLoadMore();
    }

    public interface OnPassDataListener {
        void onPassData(ConnectionList connectionList, int position);
    }

    public void setLoaded() {
        isLoading = false;
    }

}