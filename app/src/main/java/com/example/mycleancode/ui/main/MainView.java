package com.example.mycleancode.ui.main;

import com.example.mycleancode.data.model.Repo;
import com.example.mycleancode.ui.base.BaseView;

import java.util.List;

interface MainView extends BaseView {

    void onSuccessView(List<Repo> repos);

    void onError(String message);

    void onErrorLoading();

    void onHideError();
}
