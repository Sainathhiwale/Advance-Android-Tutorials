package com.dorvis.mvvm.di.module;

import com.dorvis.mvvm.ui.login.LoginActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {

    @ContributesAndroidInjector()
    abstract LoginActivity bindLoginActivity();
}
