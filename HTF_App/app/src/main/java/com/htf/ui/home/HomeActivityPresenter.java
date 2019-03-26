package com.htf.ui.home;

import com.htf.components.network.INetwork;
import com.htf.lib.v7.mvp.Presenter;

public class HomeActivityPresenter extends Presenter<HomeContract.IView> implements HomeContract.IPresenter {

    public HomeActivityPresenter(HomeContract.IView view, INetwork network) {
        super(view);
    }
}
