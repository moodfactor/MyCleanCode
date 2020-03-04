package com.example.mycleancode.ui.main;

import com.example.mycleancode.data.repo.GitRepository;
import com.example.mycleancode.ui.base.BaseView;

interface MainView extends BaseView {

    void onSuccess(GitRepository result);

    void onError(String message);
}
