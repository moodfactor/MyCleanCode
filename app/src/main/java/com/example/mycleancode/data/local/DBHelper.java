package com.example.mycleancode.data.local;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.mycleancode.data.model.Repo;

import java.util.ArrayList;
import java.util.List;

import static android.provider.BaseColumns._ID;
import static com.example.mycleancode.data.local.DBContract.GithubColumns.ID;
import static com.example.mycleancode.data.local.DBContract.TABLE_NAME;

public class DBHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String SQL_CREATE_TABLE_GITHUB = String.format(
            "CREATE TABLE %s" + " (%s INTEGER PRIMARY KEY AUTOINCREMENT," +
                    " %s TEXT NOT NULL)",
            TABLE_NAME,
            _ID,
            ID
    );
    public static String DATABASE_NAME = "dbgithub.db";
    SQLiteOpenHelper dbhandler;
    SQLiteDatabase db;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void open() {
        Log.i("FAVORITES", "Database Opened");
        db = dbhandler.getWritableDatabase();
    }

    public void close() {
        Log.i("FAVORITES", "Database Close");
        dbhandler.close();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_TABLE_GITHUB);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public void addFavorite(Repo repo) {
        db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(ID, repo.getId());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public void deleteFavorite(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, ID + " = " + id, null);
    }

    public List<Repo> getAllFavorite() {
        String[] columns = {
                _ID, ID
        };
        String sort = _ID + " ASC";
        List<Repo> repoList = new ArrayList<>();

        db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME,
                columns,
                null,
                null,
                null,
                null,
                sort);

        if (cursor.moveToFirst()) {
            do {
                Repo repo = new Repo();
                repo.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(ID))));

                repoList.add(repo);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return repoList;
    }
}
