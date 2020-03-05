package com.example.mycleancode;

import android.app.Application;

import com.example.mycleancode.di.component.AppComponent;
import com.example.mycleancode.di.component.DaggerAppComponent;
import com.example.mycleancode.di.module.ActivityModule;
import com.example.mycleancode.di.module.ApplicationModule;

public class App extends Application {
    private AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerAppComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public AppComponent getComponent() {
        return component;
    }
}
