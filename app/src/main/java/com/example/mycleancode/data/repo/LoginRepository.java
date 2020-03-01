package com.example.mycleancode.data.repo;

import com.example.mycleancode.data.model.User;

public interface LoginRepository {
    User getUser(); //inisialisasi proses

    void saveUser(User user); //inisialisasi proses
}
