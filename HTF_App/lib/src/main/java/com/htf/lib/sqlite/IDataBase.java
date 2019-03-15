package com.htf.lib.sqlite;

import java.util.List;

public interface IDataBase<T> {

    List<T> getAll();

    void insert(T item);

    void insert(List<T> entities);

    void delete(T item);

    void delete(List<T> entities);

    void update(T item);

    void update(List<T> entities);
}
