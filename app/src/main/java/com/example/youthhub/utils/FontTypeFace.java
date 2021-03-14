package com.example.youthhub.utils;

import android.app.Activity;
import android.graphics.Typeface;

public class FontTypeFace {
    public static Typeface fontRegular(Activity activity){
        Typeface typeface=Typeface.createFromAsset(activity.getAssets(),"fonts/Poppins-Regular.ttf");
        return typeface;
    }
    public static Typeface fontBold(Activity activity){
        Typeface typeface=Typeface.createFromAsset(activity.getAssets(),"fonts/Poppins-Bold.ttf");
        return typeface;
    }
    public static Typeface fontSemiBold(Activity activity){
        Typeface typeface=Typeface.createFromAsset(activity.getAssets(),"fonts/Poppins-SemiBold.ttf");
        return typeface;
    }
    public static Typeface fontMedium(Activity activity){
        Typeface typeface=Typeface.createFromAsset(activity.getAssets(),"fonts/Poppins-Medium.ttf");
        return typeface;
    }
    public static Typeface fontLight(Activity activity){
        Typeface typeface=Typeface.createFromAsset(activity.getAssets(),"fonts/Poppins-Light.ttf");
        return typeface;
    }
}
