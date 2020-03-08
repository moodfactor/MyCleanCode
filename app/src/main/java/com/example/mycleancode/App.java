package com.example.mycleancode;

import android.app.Application;

import com.example.mycleancode.di.component.AppComponent;
import com.example.mycleancode.di.component.DaggerAppComponent;
import com.example.mycleancode.di.module.AppModule;

public class App extends Application {
    private AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getComponent() {
        return component;
    }
}
