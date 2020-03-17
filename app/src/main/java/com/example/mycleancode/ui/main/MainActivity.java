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

public class MainActivity extends BaseActivity implements MainView {

    @BindView(R.id.lst_repo)
    RecyclerView lstRepo;

    MainAdapter adapter;
    private List<Repo> repos = new ArrayList<>();

    @Override
    public int contentView() {
        return R.layout.activity_main;
    }

    @Override
    public void onCreated() {
        ((MyApplication) getApplication()).getAppComponent().inject(this); //mendefinisikan sebuah request dependency, bisa berupa konstruktor, method, maupun field

        new MainPresenter(this).getRepos();
        lstRepo.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MainAdapter(repos, this);
        lstRepo.setAdapter(adapter);
    }

    @Override
    public void onSuccess(List<Repo> result) {
        if (result != null) {
//            adapter = new MainAdapter(repos, this);
//            adapter.notifyDataSetChanged();
//            lstRepo.setAdapter(adapter);
            for (int i = 0; i < result.size(); i++) {
                String name = result.get(i).getName();
                String desc = result.get(i).getDescription();
                String lang = result.get(i).getLanguage();
                repos.add(new Repo(name, desc, lang));
                adapter.notifyDataSetChanged();
            }
        } else {
            super.onInfo("Repository Not Found");
        }
    }

    @Override
    public void onError(String message) {
        super.onError(message);
    }

}