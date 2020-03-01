package com.example.mycleancode;

import android.app.Application;

import com.example.mycleancode.di.AppComponent;
import com.example.mycleancode.di.AppModule;
import com.example.mycleancode.di.DaggerAppComponent;
import com.example.mycleancode.ui.login.LoginModule;

public class App extends Application {
    private AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .loginModule(new LoginModule())
                .build();
    }

    public AppComponent getComponent() {
        return component;
    }
}
