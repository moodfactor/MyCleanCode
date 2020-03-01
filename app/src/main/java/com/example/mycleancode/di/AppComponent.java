package com.example.mycleancode.di;

import com.example.mycleancode.ui.login.LoginActivity;
import com.example.mycleancode.ui.login.LoginModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, LoginModule.class}) //mendefinisikan sebuah jembatan penghubung antara module dan injection.
public interface AppComponent {
    void inject(LoginActivity target);
}
