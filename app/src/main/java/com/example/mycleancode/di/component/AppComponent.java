package com.example.mycleancode.di.component;

import com.example.mycleancode.di.module.ActivityModule;
import com.example.mycleancode.di.module.AppModule;
import com.example.mycleancode.ui.main.MainActivity;

import dagger.Component;

@Component(modules = {AppModule.class, ActivityModule.class})
public interface AppComponent {
    void inject(MainActivity activity);
}
