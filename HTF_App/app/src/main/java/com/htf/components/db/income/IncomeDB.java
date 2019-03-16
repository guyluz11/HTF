package com.htf.components.db.income;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.htf.dto.Income;
import com.htf.lib.sqlite.BasicDataBase;

import androidx.annotation.NonNull;

public class IncomeDB extends BasicDataBase<IncomeDBH, Income> {

    public IncomeDB(Context appCtx) {
        super(new IncomeDBH(appCtx));
    }

    @Override
    public Income fromCursor(@NonNull Cursor c) {
        return null;
    }

    @Override
    public ContentValues toContentValues(@NonNull Income item, @NonNull ContentValues cv) {
        return null;
    }
}
