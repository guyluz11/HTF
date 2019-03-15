package com.mdgd.lib.sqlite;

import android.content.ContentValues;
import android.database.Cursor;

import androidx.annotation.NonNull;

/**
 * Created by Max
 * on 05/09/2018.
 */
public interface ICursorParser<T> {

    T fromCursor(@NonNull Cursor c);

    ContentValues toContentValues(@NonNull T item);

    ContentValues toContentValues(@NonNull T item, @NonNull ContentValues cv);
}
