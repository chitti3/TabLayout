package com.example.youthhub.utils;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.Gravity;
import android.view.WindowManager;

import com.example.youthhub.R;

import java.util.Objects;

public class Loader {

    private static CustomProgress customProgress;

    public static void showLoad(Activity activity,boolean load){
        try {
            if(customProgress == null) {
                customProgress = new CustomProgress(activity);
                customProgress.setCanceledOnTouchOutside(false);
                customProgress.setCancelable(false);
                Objects.requireNonNull(customProgress.getWindow()).clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
                customProgress.getWindow().setGravity(Gravity.BOTTOM);

                Objects.requireNonNull(customProgress.getWindow()).setBackgroundDrawable(new ColorDrawable(ContextCompat.getColor(activity, R.color.transparent)));
            }
            if(load){
                customProgress.show();
            }else {
                customProgress.dismiss();
                customProgress = null;
            }
        }catch (Exception e){
            Log.d("LoaderError",e.toString());
        }
    }

}