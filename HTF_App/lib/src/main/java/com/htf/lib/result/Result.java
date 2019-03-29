package com.htf.lib.result;

/**
 * Created by Owner
 * on 05/02/2019.
 */
public class Result<T> {
    public final T data;
    public final Throwable error;
    private final boolean isSuccess;

    public Result(T data) {
        this.data = data;
        error = null;
        isSuccess = true;
    }

    public Result(Throwable error) {
        this.error = error;
        data = null;
        isSuccess = false;
    }

    public boolean isFail() {
        return !isSuccess;
    }

    public boolean isSuccess() {
        return isSuccess;
    }
}
