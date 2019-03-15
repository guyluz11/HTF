package com.mdgd.lib.services;

import android.app.Service;

import com.mdgd.lib.contract.services.ServiceContract;

/**
 * Created by Max
 * on 13/06/2018.
 */
public abstract class CommonService<PRESENTER extends ServiceContract.IPresenter> extends Service {
    public PRESENTER presenter;

    public CommonService() {
        this.presenter = getPresenter();
    }

    protected abstract PRESENTER getPresenter();
}
