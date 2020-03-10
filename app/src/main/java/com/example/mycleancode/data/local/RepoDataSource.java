package com.example.mycleancode.data.local;

import java.util.List;

import javax.inject.Inject;

import androidx.lifecycle.LiveData;

public class RepoDataSource implements RepoRepository {
    private RepoDao repoDao;

    @Inject
    public RepoDataSource(RepoDao repoDao) {
        this.repoDao = repoDao;
    }

    @Override
    public LiveData<RepoItem> findById(int id) {
        return repoDao.findById(id);
    }

    @Override
    public LiveData<List<RepoItem>> findAll() {
        return repoDao.findAll();
    }

    @Override
    public long insert(RepoItem repoItem) {
        return repoDao.insert(repoItem);
    }

    @Override
    public int delete(RepoItem repoItem) {
        return repoDao.delete(repoItem);
    }
}
