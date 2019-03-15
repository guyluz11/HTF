package com.mdgd.lib.injection;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.lang.ref.WeakReference;

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
