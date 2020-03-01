package com.example.mycleancode.di;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module //mendefinisikan kelas yang menyediakan dependencies
public class AppModule {
    private Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Provides //mendefinisikan method-method yang ada di kelas @Module
    @Singleton
    public Context provideContext() {
        return application;
    }
}
