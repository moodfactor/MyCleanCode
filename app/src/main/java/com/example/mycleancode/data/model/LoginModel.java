package com.example.mycleancode.data.model;

import com.example.mycleancode.data.repo.LoginRepository;
import com.example.mycleancode.ui.login.LoginView;

public class LoginModel implements LoginView.Model {

    private LoginRepository repository; //sebagai media data statis

    public LoginModel(LoginRepository repository) { //sebagai constructor / penghubung antara loginmodel dengan loginrepository
        this.repository = repository;
    }

    @Override
    public void createUser(String name, String lastName) { //function didapatkan dari pemanggilan loginview.model
        repository.saveUser(new User(name, lastName)); //mengambil data statis dari loginrepository
    }

    @Override
    public User getUser() { //function didapatkan dari pemanggilan loginview.model
        return repository.getUser(); //mengambil data statis dari loginrepository
    }
}
