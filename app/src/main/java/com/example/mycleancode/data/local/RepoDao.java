package com.example.mycleancode.data.local;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface RepoDao {
    @Query("SELECT * FROM RepoItem WHERE id=:id")
    LiveData<RepoItem> findById(int id);

    @Query("SELECT * FROM RepoItem")
    LiveData<List<RepoItem>> findAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insert(RepoItem repoItem);

    @Delete
    int delete(RepoItem repoItem);
}
