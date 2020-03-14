package com.example.mycleancode.di.component;

import android.content.Context;

import com.example.mycleancode.di.module.AdapterModule;
import com.example.mycleancode.di.qualifier.ActivityContext;
import com.example.mycleancode.di.scopes.ActivityScope;
import com.example.mycleancode.ui.main.MainActivity;

import dagger.Component;

@ActivityScope
@Component(modules = AdapterModule.class, dependencies = ApplicationComponent.class)
public interface MainActivityComponent {

    @ActivityContext
    Context getContext();


    void injectMainActivity(MainActivity mainActivity);
}
