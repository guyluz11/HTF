package com.mdgd.lib.retrofit_support;

import com.mdgd.lib.result.ICallback;

import retrofit2.Call;

/**
 * Created by Owner
 * on 05/02/2019.
 */
public class BasicNetwork {
    protected <T, X> void execAsync(Call<T> call, ICallback<X> callback, ITransformer<T, X> transform) {
        call.enqueue(new RetroCallbackImpl<>(callback, transform));
    }

    protected <T, X> void execSync(Call<T> call, ICallback<X> callback, ITransformer<T, X> transform) {
        final RetroCallbackImpl<T, X> callbackImpl = new RetroCallbackImpl<>(callback, transform);
        try {
            callbackImpl.onResponse(call, call.execute());
        } catch (Throwable e){
            callbackImpl.onFailure(call, e);
        }
    }
}
