package com.htf.lib.services;

import android.app.IntentService;

import com.htf.lib.contract.services.ServiceContract;

/**
 * Created by Max
 * on 13/06/2018.
 */
public abstract class CommonIntentService<T extends ServiceContract.IPresenter> extends IntentService
        implements ServiceContract.IService {
    protected final T presenter;

    public CommonIntentService(String name) {
        super(name);
        this.presenter = getPresenter();
    }

    protected abstract T getPresenter();
}
