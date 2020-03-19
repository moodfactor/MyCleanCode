package com.example.mycleancode;

import android.app.Application;

import com.example.mycleancode.di.component.AppComponent;
import com.example.mycleancode.di.component.DaggerAppComponent;
import com.example.mycleancode.di.module.AppModule;
import com.example.mycleancode.di.module.NetworkModule;

public class MyApplication extends Application {
    AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .networkModule(new NetworkModule())
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
