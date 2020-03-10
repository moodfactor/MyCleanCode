package com.example.mycleancode.data.local;

import java.util.List;

import androidx.lifecycle.LiveData;

public interface RepoRepository {
    LiveData<RepoItem> findById(int id);

    LiveData<List<RepoItem>> findAll();

    long insert(RepoItem repoItem);

    int delete(RepoItem repoItem);
}
