package com.example.mycleancode.di.module;

import android.content.Context;

import com.example.mycleancode.di.qualifier.ActivityContext;
import com.example.mycleancode.di.scopes.ActivityScope;
import com.example.mycleancode.ui.main.MainActivity;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityContextModule {
    private MainActivity mainActivity;
    public Context context;

    public MainActivityContextModule(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        context = mainActivity;
    }

    @Provides
    @ActivityContext
    public MainActivity providesMainActivity() {
        return mainActivity;
    }

    @Provides
    @ActivityScope
    @ActivityContext
    public Context provideContext() {
        return context;
    }
}
