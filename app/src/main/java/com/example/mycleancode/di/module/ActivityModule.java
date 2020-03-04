package com.example.mycleancode.di.module;

import com.example.mycleancode.data.model.Repo;
import com.example.mycleancode.data.repo.GitServices;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module //mendefinisikan kelas yang menyediakan dependencies
public class ActivityModule {
    @Provides //mendefinisikan method-method yang ada di kelas @Module
    @Singleton
    public GitServices provideGitRepository() {
        return new GitServices(new Repo());
    }
}
