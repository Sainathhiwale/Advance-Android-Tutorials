package com.dorvis.daggersample.di;

import com.dorvis.daggersample.MainActivity;
import com.dorvis.daggersample.MemberDataManager;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = MemberDataModule.class)
public interface MemberAppComponent {
    void inject(MainActivity mainActivity);

}
