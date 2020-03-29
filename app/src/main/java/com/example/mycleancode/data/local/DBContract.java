package com.example.mycleancode.data.local;

import android.provider.BaseColumns;

public class DBContract {
    static String TABLE_NAME = "github";

    static final class GithubColumns implements BaseColumns {
        static String ID = "id";
        static String NAME = "name";
        static String DESC = "desc";
        static String LANG = "lang";
    }
}
