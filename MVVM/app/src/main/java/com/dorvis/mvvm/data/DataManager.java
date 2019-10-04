package com.dorvis.mvvm.data;

public class DataManager {
    private SharedPrefsHelper mSharedPrefsHelper;


    public DataManager(SharedPrefsHelper sharedPrefsHelper) {
        this.mSharedPrefsHelper = sharedPrefsHelper;
    }


    public void clear() {
        mSharedPrefsHelper.clear();
    }

    public void setLoggedIn() {
        mSharedPrefsHelper.setLoggedInMode(true);
    }

    public Boolean getLoggedInMode() {
        return mSharedPrefsHelper.getLoggedInMode();
    }

    public void setUserEmail(String userEmail) {
        mSharedPrefsHelper.putUserEmail(userEmail);
    }

    public String getUserEmail() {
        return mSharedPrefsHelper.getUseremail();
    }

    public void setUserName(String userName) {
        mSharedPrefsHelper.putUserName(userName);
    }

    public String getUserName() {
        return mSharedPrefsHelper.getUsername();
    }

    public void setUserPhone(String userPhone) {
        mSharedPrefsHelper.putUserPhone(userPhone);
    }

    public String getUserPhone() {
        return mSharedPrefsHelper.getUserphone();
    }

    public void setUserID(String userID){
        mSharedPrefsHelper.putUserID(userID);
    }
    public String getUserID(){
        return mSharedPrefsHelper.getUserId();
    }

    public void setMsg(String msg){
        mSharedPrefsHelper.putMsg(msg);
    }
    public String getMsg(){
        return mSharedPrefsHelper.getMsg();
    }

}
