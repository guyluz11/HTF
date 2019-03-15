package com.htf.lib.sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by Owner
 * on 12/07/2018.
 */
public abstract class BasicDataBase<T extends IDBH, X extends IDbBean> extends SqLiteWrapper<X> implements IDataBase<X> {
    final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    final T mDbHelper;
    protected SQLiteDatabase db;

    protected BasicDataBase(T mDbHelper) {
        this.mDbHelper = mDbHelper;
    }

    private void close() {
        mDbHelper.close();
    }

    private void openWritable() {
        checkIsOpen();
        checkIsWritable();
        if (db == null) db = mDbHelper.getWritableDatabase();
    }

    private void checkIsOpen() {
        if (db != null && !db.isOpen()) closeDB();
    }

    private void checkIsWritable() {
        if (db != null && db.isReadOnly()) closeDB();
    }

    private void closeDB() {
        db.close();
        db = null;
    }

    void openReadable() {
        checkIsOpen();
        if (db == null) db = mDbHelper.getReadableDatabase();
    }

    @Override
    protected void finalize() throws Throwable {
        close();
        super.finalize();
    }

    ContentValues createIfNull(final ContentValues cv) {
        return cv == null ? new ContentValues() : cv;
    }

    @Override
    public List<X> getAll() {
        lock.readLock().lock();
        final List<X> result = new ArrayList<>();
        try {
            openReadable();
            final Cursor c = db.query(mDbHelper.getTableName(), null, null/*selection*/, null/*selection args*/, null, null, null);
            if (c != null) {
                while (c.moveToNext()) {
                    final X parse = fromCursor(c);
                    if (parse != null) result.add(parse);
                }
                c.close();
            }
        } finally {
            lock.readLock().unlock();
        }
        return result;
    }

    @Override
    public void insert(X item) {
        lock.writeLock().lock();
        try {
            openWritable();
            db.beginTransactionNonExclusive();
            try {
                insert(item, new ContentValues());
                db.setTransactionSuccessful();
            } finally {
                db.endTransaction();
            }
        } finally {
            lock.writeLock().unlock();
        }
    }

    @Override
    public void insert(List<X> entities) {
        lock.writeLock().lock();
        try {
            openWritable();
            db.beginTransactionNonExclusive();
            try {
                final ContentValues cv = new ContentValues();
                for (X entity : entities) {
                    insert(entity, cv);
                }
                db.setTransactionSuccessful();
            } finally {
                db.endTransaction();
            }
        } finally {
            lock.writeLock().unlock();
        }
    }

    private void insert(X item, ContentValues cv) {
        toContentValues(item, cv);
        db.insert(mDbHelper.getTableName(), null, cv);
    }

    @Override
    public void update(X item) {
        lock.writeLock().lock();
        try {
            openWritable();
            db.beginTransactionNonExclusive();
            try {
                update(item, new ContentValues());
                db.setTransactionSuccessful();
            } finally {
                db.endTransaction();
            }
        } finally {
            lock.writeLock().unlock();
        }
    }

    @Override
    public void update(List<X> entities) {
        lock.writeLock().lock();
        try {
            openWritable();
            db.beginTransactionNonExclusive();
            try {
                final ContentValues cv = new ContentValues();
                for (X entity : entities) {
                    update(entity, cv);
                }
                db.setTransactionSuccessful();
            } finally {
                db.endTransaction();
            }
        } finally {
            lock.writeLock().unlock();
        }
    }

    private void update(X item, ContentValues cv) {
        toContentValues(item, cv);
        db.update(mDbHelper.getTableName(), cv, "_id=?" /*selection*/, new String[]{String.valueOf(item.getId())});
    }

    @Override
    public void delete(List<X> entities) {
        lock.writeLock().lock();
        try {
            openWritable();
            db.beginTransactionNonExclusive();
            try {
                for (X entity : entities) {
                    delete(entity.getId());
                }
                db.setTransactionSuccessful();
            } finally {
                db.endTransaction();
            }
        } finally {
            lock.writeLock().unlock();
        }
    }

    @Override
    public void delete(X item) {
        lock.writeLock().lock();
        try {
            openWritable();
            db.beginTransactionNonExclusive();
            try {
                delete(item.getId());
                db.setTransactionSuccessful();
            } finally {
                db.endTransaction();
            }
        } finally {
            lock.writeLock().unlock();
        }
    }

    private void delete(long id) {
        db.delete(mDbHelper.getTableName(), "_id=?" /*selection*/, new String[]{String.valueOf(id)}/*selection args*/);
    }
}
