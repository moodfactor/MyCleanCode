package com.example.mycleancode.ui.main;

import com.example.mycleancode.data.model.Repo;
import com.example.mycleancode.data.network.Routes;
import com.example.mycleancode.ui.base.BaseRequest;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

class MainPresenter extends BaseRequest {
    MainView view;
    List<Repo> repos = new ArrayList<>();

    @Inject
    MainPresenter(MainView view) {
        this.view = view;
        initialize();
    }

    void getRepos() {
        view.onShowLoading();
        getRoutes().getRepos()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Repo>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<Repo> repoList) {
                        repos.addAll(repoList);
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.onError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        view.onHideLoading();
                        view.onSuccess(repos);
                    }
                });

    }
}
