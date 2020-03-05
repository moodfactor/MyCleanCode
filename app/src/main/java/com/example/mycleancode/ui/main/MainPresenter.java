package com.example.mycleancode.ui.main;

import com.example.mycleancode.data.repo.GitRepository;
import com.example.mycleancode.ui.base.BaseRequest;

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
        getRoutes().getRepos().enqueue(new Callback<GitRepository>() {
            @Override
            public void onResponse(Call<GitRepository> call, Response<GitRepository> response) {
                view.onHideLoading();
                if (response.isSuccessful()) {
                    view.onSuccess(response.body());
                }
            }

            @Override
            public void onFailure(Call<GitRepository> call, Throwable t) {
                view.onHideLoading();
                view.onError(t.getMessage());
            }
        });
    }
}
