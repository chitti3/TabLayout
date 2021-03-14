package com.example.youthhub.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.content.ContextCompat;

import com.example.youthhub.R;

import java.util.Objects;

public class NetWorkUtil {

    static boolean isConnectingToInternet(Activity activity) {

        ConnectivityManager cm = (ConnectivityManager) activity.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();

        return activeNetwork != null && activeNetwork.isConnectedOrConnecting();

    }

    public static boolean isNetworkConnected(Activity activity){
        if(!isConnectingToInternet(activity)){
            NetworkCheckDialog networkCheckDialog = new NetworkCheckDialog(activity);
            Objects.requireNonNull(networkCheckDialog.getWindow()).setBackgroundDrawable(new ColorDrawable(ContextCompat.getColor(activity, R.color.transparent)));
            networkCheckDialog.show();
            return false;
        }else {
            return true;
        }
    }

}