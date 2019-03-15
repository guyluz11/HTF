package com.mdgd.lib.v7.mvp;

import com.mdgd.lib.contract.mvp.ActivityContract;

/**
 * Created by Max
 * on 08/10/2017.
 */

public abstract class Presenter<VIEW extends ActivityContract.IView> {
    public VIEW view;

    public Presenter(VIEW view){
        this.view = view;
    }
}
