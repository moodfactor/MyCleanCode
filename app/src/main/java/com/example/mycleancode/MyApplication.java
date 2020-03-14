package com.example.mycleancode;

import android.app.Activity;
import android.app.Application;

import com.example.mycleancode.di.component.ApplicationComponent;
import com.example.mycleancode.di.component.DaggerApplicationComponent;
import com.example.mycleancode.di.module.ContextModule;

public class MyApplication extends Application {
    ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent
                .builder()
                .contextModule(new ContextModule(this))
                .build();
        applicationComponent.inject(this);

    }

    public static MyApplication get(Activity activity){
        return (MyApplication) activity.getApplication();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
