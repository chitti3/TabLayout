package com.example.youthhub;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.StrictMode;
import android.support.multidex.MultiDex;

import com.example.youthhub.utils.Prefs;
import com.example.youthhub.utils.TypefaceUtil;

public class MyApp extends Application {
    private Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
        // Initialize the Shared Preferences class
        new Prefs.Builder().setContext(this)
                .setMode(ContextWrapper.MODE_PRIVATE)
                .setPrefsName(getPackageName())
                .setUseDefaultSharedPreference(true).build();
        TypefaceUtil.overrideFont(getApplicationContext(), "SERIF", "fonts/Poppins-Regular.ttf");
    }
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(base);
    }
    public MyApp instance() {
        return (MyApp) mContext.getApplicationContext();
    }
}
