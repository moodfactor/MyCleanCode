package com.example.mycleancode.ui.main;

import com.example.mycleancode.MyApplication;
import com.example.mycleancode.R;
import com.example.mycleancode.data.model.Repo;
import com.example.mycleancode.ui.adapter.MainAdapter;
import com.example.mycleancode.ui.base.BaseActivity;

import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

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
        ((MyApplication) getApplication()).getAppComponent().inject(this); //mendefinisikan sebuah request dependency, bisa berupa konstruktor, method, maupun field

        new MainPresenter(this).getRepos();
    }

    @Override
    public void onSuccess(List<Repo> result) {
        if (result != null) {
            lstRepo.setLayoutManager(new LinearLayoutManager(this));
            adapter = new MainAdapter(result, this);
            adapter.notifyDataSetChanged();
            lstRepo.setAdapter(adapter);
        } else {
            super.onInfo("Repository Not Found");
        }
    }

    @Override
    public void onError(String message) {
        super.onError(message);
    }

}