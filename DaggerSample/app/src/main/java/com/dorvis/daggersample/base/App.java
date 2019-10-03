package com.dorvis.daggersample.base;

import android.app.Application;

import com.dorvis.daggersample.di.DaggerMemberAppComponent;
import com.dorvis.daggersample.di.MemberAppComponent;
import com.dorvis.daggersample.di.MemberDataModule;

public class App extends Application {

    private static App app;
    private MemberAppComponent memberAppComponent;

    public static App getApp(){
        return app;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        memberAppComponent = DaggerMemberAppComponent.builder()
                .memberDataModule(new MemberDataModule())
                .build();
    }

    public MemberAppComponent getMemberAppComponent() {
        return memberAppComponent;
    }
}
