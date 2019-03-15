package worshifter.com.hgf.components.db.income;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.mdgd.lib.sqlite.IDBH;

/**
 * Created by Owner
 * on 26/08/2018.
 */
public class IncomeDBH extends SQLiteOpenHelper implements IDBH {
    private static final String DATABASE_NAME = "kids_locations.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "kid_locations";
    static final String COLUMN_TIME = "time";
    static final String COLUMN_ID = "_id";
    static final String COLUMN_LAT = "lat";
    static final String COLUMN_LON = "lon";
    static final String COLUMN_SENT = "sent";

    IncomeDBH(final Context ctx) {
        super(ctx, DATABASE_NAME, null, DATABASE_VERSION);
    }

    void createIndex(SQLiteDatabase database, String idxName, String tableName, String columnName) {
        database.execSQL("CREATE INDEX idx_" + idxName + " ON " + tableName + "(" + columnName + ")");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " +
                TABLE_NAME + "( " +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_SENT + " integer, " +
                COLUMN_TIME + " integer, " +
                COLUMN_LAT + " double(4,8), " +
                COLUMN_LON + " double(4,8) " +
                ");");
        createIndex(db, "idx_time", TABLE_NAME, COLUMN_TIME);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    @Override
    public String getTableName() {
        return TABLE_NAME;
    }
}
