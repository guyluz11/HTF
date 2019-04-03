package com.htf.ui.main.ac.main_activity;

import com.htf.components.network.INetwork;
import com.htf.lib.v7.mvp.Presenter;

public class MainActivityPresenter extends Presenter<MainContract.IView> implements MainContract.IPresenter {

    public MainActivityPresenter(MainContract.IView view, INetwork network) {
        super(view);
    }


}
