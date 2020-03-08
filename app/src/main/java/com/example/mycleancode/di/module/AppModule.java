package com.example.mycleancode.di.module;

import android.app.Application;
import android.content.Context;

import com.example.mycleancode.di.qualifier.ApplicationContext;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module //mendefinisikan kelas yang menyediakan dependencies
public class AppModule {
    private Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return application;
    }

    @Provides //mendefinisikan method-method yang ada di kelas @Module
    @Singleton
    public Application provideApplication() {
        return application;
    }
}
