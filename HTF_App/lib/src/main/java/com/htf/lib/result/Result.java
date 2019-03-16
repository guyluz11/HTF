package com.htf.lib.result;

/**
 * Created by Owner
 * on 05/02/2019.
 */
public class Result<T> {
    public final T data;
    public final Throwable error;

    public Result(T data) {
        this.data = data;
        error = null;
    }

    public Result(Throwable error) {
        this.error = error;
        data = null;
    }

    public boolean isFail() {
        return error != null;
    }

    public boolean isSuccess() {
        return error == null;
    }
}
