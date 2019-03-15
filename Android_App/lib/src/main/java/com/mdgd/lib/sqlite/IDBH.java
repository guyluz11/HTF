package com.mdgd.lib.sqlite;

import android.database.sqlite.SQLiteDatabase;

public interface IDBH {
    String getTableName();

    void close();

    SQLiteDatabase getWritableDatabase();

    SQLiteDatabase getReadableDatabase();
}
