package com.examen.mvpsample.base;

import android.app.Application;

import com.examen.mvpsample.data.prefs.DataManager;
import com.examen.mvpsample.data.prefs.SharedPrefsHelper;

public class MyApp extends Application {
    private DataManager dataManager;
    @Override
    public void onCreate() {
        super.onCreate();
        SharedPrefsHelper sharedPrefsHelper = new SharedPrefsHelper(getApplicationContext());
        dataManager = new DataManager(sharedPrefsHelper);
    }

    public DataManager getDataManager() {
        return dataManager;
    }
}
