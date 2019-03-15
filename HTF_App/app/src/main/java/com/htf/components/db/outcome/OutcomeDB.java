package com.htf.components.db.outcome;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.htf.dto.Outcome;
import com.htf.lib.sqlite.BasicDataBase;

import androidx.annotation.NonNull;

public class OutcomeDB extends BasicDataBase<OutcomeDBH, Outcome> {

    public OutcomeDB(Context appCtx) {
        super(new OutcomeDBH(appCtx));
    }

    @Override
    public Outcome fromCursor(@NonNull Cursor c) {
        return null;
    }

    @Override
    public ContentValues toContentValues(@NonNull Outcome item, @NonNull ContentValues cv) {
        return null;
    }
}
