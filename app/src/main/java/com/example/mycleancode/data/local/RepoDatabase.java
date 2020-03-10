package com.example.mycleancode.data.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {RepoItem.class}, version = RepoDatabase.VERSION)
public abstract class RepoDatabase extends RoomDatabase {
    static final int VERSION = 1;
    public abstract RepoDao getRepoDao();
}
