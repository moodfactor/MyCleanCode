package com.example.mycleancode.di.component;

import android.app.Application;

import com.example.mycleancode.data.local.RepoDao;
import com.example.mycleancode.data.local.RepoDatabase;
import com.example.mycleancode.data.local.RepoRepository;
import com.example.mycleancode.di.module.ActivityModule;
import com.example.mycleancode.di.module.AppModule;
import com.example.mycleancode.di.module.RoomModule;
import com.example.mycleancode.ui.main.MainActivity;

import dagger.Component;

@Component(modules = {AppModule.class, ActivityModule.class, RoomModule.class})
public interface AppComponent {
    void inject(MainActivity activity);

    RepoDao repoDao();
    RepoDatabase repoDatabase();
    RepoRepository repoRepository();
    Application application();
}
