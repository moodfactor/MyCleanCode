package com.example.mycleancode.ui.login;

import com.example.mycleancode.data.model.User;

public interface LoginView {

    //Component untuk inisialisasi process (tampilan)
    interface View {
        String getFirstName();

        void setFirstName(String firstName);

        String getLastName();

        void setLastName(String lastName);

        void showInputError();

        void showUserSavedMessage();
    }

    //Component untuk inisialisasi process (service)
    interface Presenter {
        void setView(View view);

        void loginButtonClicked();

        void getCurrentUser();
    }

    //Component untuk inisialisasi process (data variabel)
    interface Model {
        void createUser(String name, String lastName);

        User getUser();
    }


}
