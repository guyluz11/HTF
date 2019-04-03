package com.htf.ui.main.ac.logged_in__activity;


import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {LoggedInActivityModule.class})
public interface LoggedInActivityComponent {

    void injectPresenter(LoggedInActivity view);
}
