package com.htf.ui.home;

import com.htf.components.Injection;

import dagger.Module;
import dagger.Provides;

@Module
public class HomeActivityModule {

    private final HomeContract.IView view;

    public HomeActivityModule(HomeContract.IView view) {
        this.view = view;
    }

    @Provides
    public HomeContract.IPresenter providePresenter() {
        return new HomeActivityPresenter(view, Injection.getProvider().getNetwork());
    }
}
