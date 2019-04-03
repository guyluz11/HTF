package com.htf.ui.main.ac.logged_in__activity;

import com.htf.components.Injection;

import dagger.Module;
import dagger.Provides;

@Module
public class LoggedInActivityModule {

    private final LoggedInActivityContract.IView view;

    public LoggedInActivityModule(LoggedInActivityContract.IView view) {
        this.view = view;
    }

    @Provides
    public LoggedInActivityContract.IPresenter providePresenter() {
        return new LoggedInActivityPresenter(view, Injection.getProvider().getPrefs());
    }
}
