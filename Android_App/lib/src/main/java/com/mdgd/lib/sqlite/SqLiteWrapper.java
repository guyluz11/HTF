package com.mdgd.lib.sqlite;

import android.content.ContentValues;
import android.support.annotation.NonNull;

/**
 * Created by Max
 * on 05/09/2018.
 */
public abstract class SqLiteWrapper<T> extends CursorParser<T> {

    @Override
    public ContentValues toContentValues(@NonNull T item) {
        return toContentValues(item, new ContentValues());
    }
}
