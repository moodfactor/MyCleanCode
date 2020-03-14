package com.example.mycleancode.di.module;

import android.content.Context;

import com.example.mycleancode.di.qualifier.ApplicationContext;
import com.example.mycleancode.di.scopes.ApplicationScope;

import dagger.Module;
import dagger.Provides;

@Module //mendefinisikan kelas yang menyediakan dependencies
public class ContextModule {
    private Context context;

    public ContextModule(Context context) {
        this.context = context;
    }

    @Provides
    @ApplicationScope
    @ApplicationContext
    public Context provideContext() {
        return context;
    }
}
