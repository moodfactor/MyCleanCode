package com.example.mycleancode.ui.main;

import com.example.mycleancode.data.model.Repo;
import com.example.mycleancode.ui.base.BaseRequest;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

class MainPresenter extends BaseRequest {
    MainView view;
    List<Repo> repoList = new ArrayList<>();

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
                    for (int i = 0; i < repoList.size(); i++) {
                        String name = repoList.get(i).getFullName();
                        String description = repoList.get(i).getDescription();
                        String language = repoList.get(i).getLanguage();

                        repoList.add(new Repo(name, description, language));
                        view.onSuccess(repoList);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {
                view.onHideLoading();
                view.onError(t.getMessage());
            }
        });

//        getRoutes().getRepos()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<List<Repo>>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(List<Repo> repos) {
//                        for (int i = 0; i < repos.size(); i++) {
//                            String name = repos.get(i).getFullName();
//                            String description = repos.get(i).getDescription();
//                            String language = repos.get(i).getLanguage();
//
//                            repos.add(new Repo(name, description, language));
//                        }
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        view.onError(e.getMessage());
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        view.onHideLoading();
//                        view.onSuccess();
//                    }
//                });

    }
}
