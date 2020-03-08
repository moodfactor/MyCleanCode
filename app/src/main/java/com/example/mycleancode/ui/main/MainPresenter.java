package com.example.mycleancode.ui.main;

import com.example.mycleancode.data.model.Repo;
import com.example.mycleancode.ui.base.BaseRequest;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

class MainPresenter extends BaseRequest {
    private MainView view;

    MainPresenter(MainView view) {
        this.view = view;
        initialize();
    }

    void getRepos() {
        view.onShowLoading();
        getRoutes().getRepos().enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                view.onHideLoading();
                if (response.isSuccessful()) {
                    view.onSuccess(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {
                view.onHideLoading();
                view.onError(t.getMessage());
            }
        });
    }
}
