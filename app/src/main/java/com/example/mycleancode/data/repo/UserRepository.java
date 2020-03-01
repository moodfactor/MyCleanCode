package com.example.mycleancode.data.repo;

import com.example.mycleancode.data.model.User;

public class UserRepository implements LoginRepository {
    private User user; //memanggil data varibale

    @Override
    public User getUser() { //pemanggilan dari inisialisasi loginrepository
        if (user == null) { //flow setting value statis untuk login
            User user = new User("Dinesh", "Kumar");
            user.setId(0);
            return user;
        } else {
            return user;
        }
    }

    @Override
    public void saveUser(User user) { //pemanggilan dari inisialisasi loginrepository
        if (user == null) { //flow untuk save value dari hasil getuser
            user = getUser();
        }
        this.user = user;
    }
}

