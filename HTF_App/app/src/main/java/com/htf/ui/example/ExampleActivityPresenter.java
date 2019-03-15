package com.htf.ui.example;

import com.htf.lib.v7.mvp.Presenter;

public class ExampleActivityPresenter extends Presenter<ExampleContract.IView> implements ExampleContract.IPresenter {

    public ExampleActivityPresenter(ExampleContract.IView view) {
        super(view);
    }
}
