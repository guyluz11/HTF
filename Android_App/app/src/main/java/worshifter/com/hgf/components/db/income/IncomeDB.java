package worshifter.com.hgf.components.db.income;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.mdgd.lib.sqlite.BasicDataBase;

import androidx.annotation.NonNull;
import worshifter.com.hgf.dto.Income;

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
