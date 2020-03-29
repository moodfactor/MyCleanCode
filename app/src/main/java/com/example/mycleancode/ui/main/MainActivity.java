package com.example.mycleancode.ui.main;

import android.os.Handler;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.mycleancode.MyApplication;
import com.example.mycleancode.R;
import com.example.mycleancode.data.model.Repo;
import com.example.mycleancode.ui.adapter.ListAdapter;
import com.example.mycleancode.ui.base.BaseActivity;

import java.util.List;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.BindView;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class MainActivity extends BaseActivity implements MainView {

    MainPresenter mainPresenter;
    ListAdapter listAdapter;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.lst_repo)
    RecyclerView lstRepo;
    @BindView(R.id.swRepo)
    SwipeRefreshLayout swRepo;
    @BindView(R.id.img_error)
    ImageView imgError;
    @BindView(R.id.llError)
    LinearLayout llError;

    @Override
    public int contentView() {
        return R.layout.activity_main;
    }

    @Override
    public void onCreated() {
        ((MyApplication) getApplication()).getAppComponent().inject(this); //mendefinisikan sebuah request dependency, bisa berupa konstruktor, method, maupun field
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("");
        }
        mainPresenter = new MainPresenter(this);
        mainPresenter.getRepos();

        swRepo.setColorSchemeResources(R.color.colorAccent);
        swRepo.setOnRefreshListener(() -> {
            refreshContent();
        });
    }

    private void refreshContent() {
        new Handler().postDelayed(() -> {
            listAdapter.clear();
            mainPresenter.getRepos();
            swRepo.setRefreshing(false);
        }, 3000);
    }

    @Override
    public void onSuccessView(List<Repo> result) {
        if (result != null) {
            lstRepo.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
            listAdapter = new ListAdapter(result, this);
            listAdapter.notifyDataSetChanged();
            lstRepo.setAdapter(listAdapter);
        } else {
            llError.setVisibility(VISIBLE);
            super.onInfo(String.valueOf(R.string.message_no_data));
        }
    }

    @Override
    public void onError(String message) {
        super.onError(message);
    }

    @Override
    public void onErrorLoading() {
        lstRepo.setVisibility(GONE);
        llError.setVisibility(VISIBLE);
    }

    @Override
    public void onHideError() {
        lstRepo.setVisibility(VISIBLE);
        llError.setVisibility(GONE);
    }

}