package com.htf.ui.main.ac.main_activity;

import com.htf.components.Injection;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityModule {

    private final MainContract.IView view;

    public MainActivityModule(MainContract.IView view) {
        this.view = view;
    }

    @Provides
    public MainContract.IPresenter providePresenter() {
        return new MainActivityPresenter(view, Injection.getProvider().getNetwork());
    }
}
