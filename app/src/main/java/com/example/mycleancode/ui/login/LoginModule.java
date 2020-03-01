package com.example.mycleancode.ui.login;

import com.example.mycleancode.data.model.LoginModel;
import com.example.mycleancode.data.repo.LoginRepository;
import com.example.mycleancode.data.repo.UserRepository;

import dagger.Module;
import dagger.Provides;

@Module //mendefinisikan kelas yang menyediakan dependencies
public class LoginModule {
    @Provides //mendefinisikan method-method yang ada di kelas @Module
    public LoginView.Presenter provideLoginPresenter(LoginView.Model model) {
        return new LoginPresenter(model);
    }

    @Provides //mendefinisikan method-method yang ada di kelas @Module
    public LoginView.Model provideLoginActivityModel(LoginRepository repository) {
        return new LoginModel(repository);
    }

    @Provides //mendefinisikan method-method yang ada di kelas @Module
    public LoginRepository provideLoginRepository() {
        return new UserRepository();
    }
}
