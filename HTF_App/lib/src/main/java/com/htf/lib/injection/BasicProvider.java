package com.htf.lib.injection;

import java.lang.ref.WeakReference;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * Created by Max
 * on 15/07/2018.
 */
public abstract class BasicProvider {

    protected <T> WeakReference<T> checkIfExists(@Nullable WeakReference<T> ref, @NonNull IInitAction<T> action) {
        if(ref == null || ref.get() == null) ref = new WeakReference<>(action.init());
        return ref;
    }
}
