package com.example.mycleancode.di.module;

import com.example.mycleancode.di.scopes.ActivityScope;
import com.example.mycleancode.ui.adapter.MainAdapter;
import com.example.mycleancode.ui.main.MainActivity;

import dagger.Module;
import dagger.Provides;

@Module(includes = {MainActivityContextModule.class})
public class AdapterModule {
    @Provides
    @ActivityScope
    public MainAdapter getRepoListAdapter(MainAdapter.ClickListener clickListener) {
        return new MainAdapter(clickListener);
    }

    @Provides
    @ActivityScope
    public MainAdapter.ClickListener getClickListener(MainActivity mainActivity) {
        return mainActivity;
    }
}
