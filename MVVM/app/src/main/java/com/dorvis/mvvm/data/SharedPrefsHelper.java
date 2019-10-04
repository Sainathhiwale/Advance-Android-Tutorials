package com.dorvis.mvvm.data;

import android.content.Context;
import android.content.SharedPreferences;

import com.dorvis.mvvm.utils.AppConstants;

import static android.content.Context.MODE_PRIVATE;

public class SharedPrefsHelper {
    private static final String MY_PREFS = "MVVM_PREFS";
    private static final String USEREMAIL = "USEREMAIL";
    private static final String USERPHONE = "USERPHONE";
    private static final String USERNAME = "USERNAME";
    private static final String USERID = "ID";
    private static final String MSG = "error_msg";
    private static final String IS_LOG_IN = "IS_LOGGED_IN";

    private SharedPreferences mSharedPreferences;

    public SharedPrefsHelper(Context context) {
        mSharedPreferences = context.getSharedPreferences(MY_PREFS, MODE_PRIVATE);
    }
    public void clear(){
        mSharedPreferences.edit().clear().apply();
    }

    public boolean getLoggedInMode(){
        return mSharedPreferences.getBoolean(IS_LOG_IN,false);
    }

    public void setLoggedInMode(boolean loggedIn){
        mSharedPreferences.edit().putBoolean(IS_LOG_IN,loggedIn).apply();
    }
    public void putUserEmail(String userEmail){
        mSharedPreferences.edit().putString(USEREMAIL,userEmail).apply();
    }
    public String getUseremail(){
        return mSharedPreferences.getString(USEREMAIL, AppConstants.EMPTY);
    }
    public void putUserPhone(String userPhone){
        mSharedPreferences.edit().putString(USERPHONE,userPhone).apply();
    }
    public String getUserphone(){
        return mSharedPreferences.getString(USERPHONE, AppConstants.EMPTY);
    }
    public void putUserName(String userName){
        mSharedPreferences.edit().putString(USERNAME,userName).apply();
    }
    public String getUsername(){
        return mSharedPreferences.getString(USERNAME,AppConstants.EMPTY);
    }

    public void putUserID(String userID){
        mSharedPreferences.edit().putString(USERID,userID).apply();
    }
    public String getUserId(){
        return mSharedPreferences.getString(USERID,AppConstants.EMPTY);
    }

    public void putMsg(String msg) {
        mSharedPreferences.edit().putString(MSG,msg).apply();
    }

    public String getMsg() {
        return mSharedPreferences.getString(MSG,AppConstants.EMPTY);
    }
}

