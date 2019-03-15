package com.mdgd.lib.retrofit_support;

import com.mdgd.lib.result.ICallback;
import com.mdgd.lib.result.Result;

import androidx.annotation.NonNull;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Owner
 * on 05/02/2019.
 */
public class RetroCallbackImpl<T, X> implements Callback<T> {

    private final ITransformer<T, X> transform;
    private final ICallback<X> callback;

    public RetroCallbackImpl(ICallback<X> callback, ITransformer<T, X> transform) {
        this.transform = transform;
        this.callback = callback;
    }

    @Override
    public void onResponse(@NonNull Call<T> call, @NonNull Response<T> response) {
        if (response.isSuccessful()) callback.onResult(new Result<>(transform(response.body())));
        else callback.onResult(new Result<X>(new Exception("" + response.code() + " " + response.message())));
    }

    private X transform(T body) {
        return transform == null ? (X)body : transform.transform(body);
    }

    @Override
    public void onFailure(@NonNull Call<T> call, @NonNull Throwable t) {
        callback.onResult(new Result<X>(t));
    }
}
