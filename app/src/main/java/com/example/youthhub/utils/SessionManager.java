package com.example.youthhub.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import com.example.youthhub.FirstOpenPage.ActivityOpenAppScreen;
import com.example.youthhub.R;
import com.example.youthhub.dashBoard.DashBoardActivity;
import com.example.youthhub.loginPage.ActivityLogin;
import com.example.youthhub.resModel.login.LoginResponse;
import com.example.youthhub.retrofit.ApiClient;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.youthhub.utils.Constants.App_TYPE;
import static com.example.youthhub.utils.Constants.DEVICE_KEY;
import static com.example.youthhub.utils.Constants.DEVICE_TYPE;

public class SessionManager {

    // Shared Preferences
    SharedPreferences pref;

    // Editor for Shared preferences
    SharedPreferences.Editor editor;

    // Context
    Activity _context;

    // Shared pref mode
    int PRIVATE_MODE = 0;

    // Sharedpref file name
    private static final String PREF_NAME = "YouthHubPref";

    // All Shared Preferences Keys
    private static final String IS_LOGIN = "IsLoggedIn";

    // User name (make variable public to access from outside)
    public static final String KEY_USER_NAME = "username";

    // Email address (make variable public to access from outside)
    public static final String KEY_PWD = "pwd";

    // Constructor
    public SessionManager(Activity activity){
        this._context = activity;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    /**
     * Create login session
     * */
    public void createLoginSession(String username, String pwd){
        // Storing login value as TRUE
        editor.putBoolean(IS_LOGIN, true);

        // Storing name in pref
        editor.putString(KEY_USER_NAME, username);

        // Storing email in pref
        editor.putString(KEY_PWD, pwd);

        // commit changes
        editor.commit();
    }

    /**
     * Check login method wil check user login status
     * If false it will redirect user to login page
     * Else won't do anything
     * */
    public boolean checkLogin(){
        // Check login status
        if(this.isLoggedIn()){

            callApi();
            /*// user is not logged in redirect him to Login Activity
            Intent i = new Intent(_context, ActivityOpenAppScreen.class);
            // Closing all the Activities
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            // Add new Flag to start new Activity
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            // Staring Login Activity
            _context.startActivity(i);*/
            return this.isLoggedIn();
        }else {
            return this.isLoggedIn();
        }

    }

    private void callApi() {
        if (NetWorkUtil.isNetworkConnected(_context)) {
            Loader.showLoad(_context,true);
            HashMap<String, String> user = this.getUserDetails();

            final String userName = user.get(KEY_USER_NAME);
            final String passWord = user.get(KEY_PWD);
            Call<LoginResponse> loginResponseCall = ApiClient.getApiInterface().getLogin(Constants.getApiKey(_context),DEVICE_KEY,DEVICE_TYPE,userName, passWord,App_TYPE);
            loginResponseCall.enqueue(new Callback<LoginResponse>() {
                @Override
                public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                    //Loader.showLoad(activity,false);
                    if (response.isSuccessful()) {
                        if (response.body().getStatus() == 1) {
                            createLoginSession(userName, passWord);
                            Bundle bundle = new Bundle();
                            bundle.putParcelable(Constants.LoginData, response.body());
                            Intent intent = new Intent(_context, DashBoardActivity.class);
                            intent.putExtras(bundle);
                            _context.startActivity(intent);
                            _context.overridePendingTransition(R.anim.activity_slide_up, R.anim.stay);
                        } else {
                            MyToast.normalMessage(response.body().getMessage(), _context);
                        }
                    } else {
                        Log.d(Constants.failureResponse + " Login", response.toString());
                    }
                    Loader.showLoad(_context,true);
                }

                @Override
                public void onFailure(Call<LoginResponse> call, Throwable t) {
                    //ProgressLoad.show(activity,false);
                    //Loader.showLoad(activity,false);
                    Log.d(Constants.failureResponse + " Login", t.toString());
                    Loader.showLoad(_context,true);
                }
            });
        }

    }



    /**
     * Get stored session data
     * */
    public HashMap<String, String> getUserDetails(){
        HashMap<String, String> user = new HashMap<String, String>();
        // user name
        user.put(KEY_USER_NAME, pref.getString(KEY_USER_NAME, null));

        // user email id
        user.put(KEY_PWD, pref.getString(KEY_PWD, null));

        // return user
        return user;
    }

    /**
     * Clear session details
     * */
    public void logoutUser(){
        // Clearing all data from Shared Preferences
        editor.clear();
        editor.commit();

        // After logout redirect user to Loing Activity
        Intent i = new Intent(_context, ActivityOpenAppScreen.class);
        // Closing all the Activities
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        // Add new Flag to start new Activity
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        // Staring Login Activity
        _context.startActivity(i);
    }

    /**
     * Quick check for login
     * **/
    // Get Login State
    public boolean isLoggedIn(){
        return pref.getBoolean(IS_LOGIN, false);
    }

}
