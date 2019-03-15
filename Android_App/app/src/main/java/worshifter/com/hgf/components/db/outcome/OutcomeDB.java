package worshifter.com.hgf.components.db.outcome;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.mdgd.lib.sqlite.BasicDataBase;

import androidx.annotation.NonNull;
import worshifter.com.hgf.dto.Outcome;

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
