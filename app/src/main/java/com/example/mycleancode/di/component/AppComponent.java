package com.example.mycleancode.di.component;

import com.example.mycleancode.di.module.ActivityModule;
import com.example.mycleancode.di.module.ApplicationModule;
import com.example.mycleancode.ui.main.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, ActivityModule.class})
//mendefinisikan sebuah jembatan penghubung antara module dan injection.
public interface AppComponent {
    void inject(MainActivity activity);
}
