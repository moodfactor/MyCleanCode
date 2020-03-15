package com.example.mycleancode.ui.main;

import com.example.mycleancode.MyApplication;
import com.example.mycleancode.R;
import com.example.mycleancode.data.model.Repo;
import com.example.mycleancode.ui.adapter.MainAdapter;
import com.example.mycleancode.ui.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements MainView {

    @BindView(R.id.lst_repo)
    RecyclerView lstRepo;

    MainAdapter adapter;

    @Override
    public int contentView() {
        return R.layout.activity_main;
    }

    @Override
    public void onCreated() {
        ((MyApplication) getApplication()).getAppComponent().inject(this);

        ButterKnife.bind(this);
        new MainPresenter(this).getRepos();
    }


    @Override
    public void onSuccess(List<Repo> repos) {
        lstRepo.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MainAdapter(repos, this);
        adapter.notifyDataSetChanged();
        lstRepo.setAdapter(adapter);
    }

    @Override
    public void onError(String message) {
        super.onError(message);
    }
}
