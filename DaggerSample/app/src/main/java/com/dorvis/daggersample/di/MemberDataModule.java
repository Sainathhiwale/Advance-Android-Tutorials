package com.dorvis.daggersample.di;

import com.dorvis.daggersample.MemberDataManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MemberDataModule {

    @Singleton
    @Provides
    MemberDataManager provideMemberDataManager(){
        return new MemberDataManager();
    }
}
