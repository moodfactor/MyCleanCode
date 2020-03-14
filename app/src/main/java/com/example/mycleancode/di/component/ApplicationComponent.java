package com.example.mycleancode.di.component;

import android.content.Context;

import com.example.mycleancode.MyApplication;
import com.example.mycleancode.data.network.Routes;
import com.example.mycleancode.di.module.ContextModule;
import com.example.mycleancode.di.module.NetworkModule;
import com.example.mycleancode.di.qualifier.ApplicationContext;
import com.example.mycleancode.di.scopes.ApplicationScope;

import dagger.Component;

@ApplicationScope
@Component(modules = {ContextModule.class, NetworkModule.class})
public interface ApplicationComponent {
    void inject(MyApplication myApplication);

    Routes getRoutes();

    @ApplicationContext
    Context getContext();
}
