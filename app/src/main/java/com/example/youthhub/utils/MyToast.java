package com.example.youthhub.utils;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;

import com.example.youthhub.R;
import com.marcoscg.materialtoast.MaterialToast;

public class MyToast {

    public static void normalMessage(String message,Activity activity){
        new MaterialToast(activity)
                .setMessage(message)
                .setDuration(Toast.LENGTH_SHORT)
                .setBackgroundColor(ContextCompat.getColor(activity, R.color.colorPrimary))
                .show();
    }

    public static void errorMessage(String message,Activity activity){
        new MaterialToast(activity)
                .setMessage(message)
                .setDuration(Toast.LENGTH_SHORT)
                .setBackgroundColor(ContextCompat.getColor(activity, R.color.red))
                .show();
    }

}
