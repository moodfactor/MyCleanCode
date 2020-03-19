package com.example.mycleancode.di.component;

import com.example.mycleancode.di.module.ActivityModule;
import com.example.mycleancode.di.module.AppModule;
import com.example.mycleancode.di.module.NetworkModule;
import com.example.mycleancode.di.scopes.ApplicationScope;
import com.example.mycleancode.ui.main.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@ApplicationScope
@Component(modules = {AppModule.class, ActivityModule.class, NetworkModule.class})
public interface AppComponent {
    void inject(MainActivity activity);
}
