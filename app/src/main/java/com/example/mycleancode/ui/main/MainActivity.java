package com.example.mycleancode.ui.main;

import com.example.mycleancode.App;
import com.example.mycleancode.R;
import com.example.mycleancode.data.model.Repo;
import com.example.mycleancode.data.repo.GitRepository;
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

    private MainAdapter adapter;
    private List<Repo> repos = new ArrayList<>();

    @Override
    public int contentView() {
        return R.layout.activity_main;
    }

    @Override
    public void onCreated() {
        ((App) getApplication()).getComponent().inject(this); //mendefinisikan sebuah request dependency, bisa berupa konstruktor, method, maupun field

        new MainPresenter(this).getRepos();
        lstRepo.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MainAdapter(repos, this);
        lstRepo.setAdapter(adapter);
    }

    @Override
    public void onSuccess(GitRepository result) {
        if (result != null) {
            if (result.getRepoList().size() > 0) {
                repos.clear();
                repos.addAll(result.getRepoList());
                adapter.notifyDataSetChanged();
            } else {
                super.onInfo("Repository Not Found");
            }
        }
    }

    @Override
    public void onError(String message) {
        super.onError(message);
    }
}
