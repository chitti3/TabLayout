package com.example.youthhub.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Parcelable;
import android.util.Log;

import com.example.youthhub.resModel.login.LoginResponse;
import com.google.gson.Gson;

public class Preference {

    private Context context;

    private final static String PREFS_NAME = "YouthHub";

    private Preference(Context context){
        this.context = context;
    }

    private static Preference yourPreference;

    private SharedPreferences sharedPreferences;

    public static Preference getInstance(Context context) {
        if (yourPreference == null) {
            yourPreference = new Preference(context);
        }
        return yourPreference;
    }

    public void setInt( String key, int value) {
        sharedPreferences = context.getSharedPreferences(PREFS_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    public int getInt(String key) {
        sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getInt(key, 0);
    }

    public void setStr(String key, String value) {
        sharedPreferences = context.getSharedPreferences(PREFS_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public String getStr(String key) {
        sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(key,"");
    }

    public void setBool(String key, boolean value) {
        sharedPreferences = context.getSharedPreferences(PREFS_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    public boolean getBool(String key) {
        sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(key,false);
    }

    /*public void loginDetails(LoginResponse loginResponse) {
        sharedPreferences = context.getSharedPreferences(PREFS_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(_CUS_ID,loginResponse.getId());
        editor.putString(_FIRST_NAME, loginResponse.getFirstname());
        editor.putString(_LAST_NAME, loginResponse.getLastname());
        editor.putString(_EMAIL, loginResponse.getEmailaddress());
        editor.putString(_MOBILE, loginResponse.getMobileno());
        editor.putString(_HOUSENO, loginResponse.getFlatvillahouseno());
        editor.putString(_APARTMENT_NAME, loginResponse.getAppartmentname());
        editor.putString(_STREET_NAME, loginResponse.getStreetname());
        editor.putString(_AREA, loginResponse.getArea() + "");
        editor.putString(_PIN_CODE, loginResponse.getPincode());
        editor.commit();
    }

    public LoginResponse getLoginDetails() {
        LoginResponse userInfo = new LoginResponse();
        userInfo.setId(pref.getInt(_CUS_ID,0));
        userInfo.setFirstname(pref.getString(_FIRST_NAME, ""));
        userInfo.setLastname(pref.getString(_LAST_NAME, ""));
        userInfo.setEmailaddress(pref.getString(_EMAIL, ""));
        userInfo.setMobileno(pref.getString(_MOBILE, ""));
        userInfo.setFlatvillahouseno(pref.getString(_HOUSENO, ""));
        userInfo.setAppartmentname(pref.getString(_APARTMENT_NAME, ""));
        userInfo.setArea(pref.getString(_AREA, ""));
        userInfo.setStreetname(pref.getString(_STREET_NAME, ""));
        userInfo.setPincode(pref.getString(_PIN_CODE, ""));
        return userInfo;
    }*/

}