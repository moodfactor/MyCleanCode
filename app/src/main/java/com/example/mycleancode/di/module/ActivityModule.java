package com.example.mycleancode.di.module;

import android.app.Activity;
import android.content.Context;

import com.example.mycleancode.di.qualifier.ApplicationContext;
import com.example.mycleancode.di.scopes.ActivityScope;
import com.example.mycleancode.di.scopes.ApplicationScope;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {
    private Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @ApplicationScope
    @ApplicationContext
    Context provideContext() {
        return activity;
    }

    @Provides
    @ActivityScope
    Activity provideActivity() {
        return activity;
    }
}
