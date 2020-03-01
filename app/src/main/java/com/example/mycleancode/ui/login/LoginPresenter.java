package com.example.mycleancode.ui.login;

import com.example.mycleancode.data.model.User;

import androidx.annotation.Nullable;

public class LoginPresenter implements LoginView.Presenter { // ini class core processnya
    @Nullable
    private LoginView.View view;
    private LoginView.Model model;

    public LoginPresenter(LoginView.Model model) {
        this.model = model;
    }

    @Override
    public void setView(LoginView.View view) {
        this.view = view;
    }

    @Override
    public void loginButtonClicked() {
        if (view != null) {
            if (view.getFirstName().trim().equals("") || view.getLastName().trim().equals("")) {
                view.showInputError();
            } else {
                model.createUser(view.getFirstName(), view.getLastName());
                view.showUserSavedMessage();
            }
        }
    }

    @Override
    public void getCurrentUser() {
        User user = model.getUser();
        if (user != null) {
            if (view != null) {
                view.setFirstName(user.getFirstName());
                view.setLastName(user.getLastName());
            }
        }
    }
}
