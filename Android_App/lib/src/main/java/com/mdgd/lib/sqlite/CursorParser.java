package com.mdgd.lib.sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.support.annotation.NonNull;

/**
 * Created by Max
 * on 05/09/2018.
 */
public abstract class CursorParser<T> implements ICursorParser<T> {

    protected String get(@NonNull Cursor c, @NonNull String columnName, @NonNull String defValue) {
        final int columnIndex = c.getColumnIndex(columnName);
        return columnIndex == -1 ? defValue : c.getString(columnIndex);
    }

    protected int get(@NonNull Cursor c, @NonNull String columnName, int defValue) {
        final int columnIndex = c.getColumnIndex(columnName);
        return columnIndex == -1 ? defValue : c.getInt(columnIndex);
    }

    protected float get(@NonNull Cursor c, @NonNull String columnName, float defValue) {
        final int columnIndex = c.getColumnIndex(columnName);
        return columnIndex == -1 ? defValue : c.getFloat(columnIndex);
    }

    protected double get(@NonNull Cursor c, @NonNull String columnName, double defValue) {
        final int columnIndex = c.getColumnIndex(columnName);
        return columnIndex == -1 ? defValue : c.getDouble(columnIndex);
    }

    protected long get(@NonNull Cursor c, @NonNull String columnName, long defValue) {
        final int columnIndex = c.getColumnIndex(columnName);
        return columnIndex == -1 ? defValue : c.getLong(columnIndex);
    }

    protected short get(@NonNull Cursor c, @NonNull String columnName, short defValue) {
        final int columnIndex = c.getColumnIndex(columnName);
        return columnIndex == -1 ? defValue : c.getShort(columnIndex);
    }

    protected byte[] get(@NonNull Cursor c, @NonNull String columnName, @NonNull byte[] defValue) {
        final int columnIndex = c.getColumnIndex(columnName);
        return columnIndex == -1 ? defValue : c.getBlob(columnIndex);
    }

    @Override
    public ContentValues toContentValues(@NonNull T item) {
        return toContentValues(item, new ContentValues());
    }
}
