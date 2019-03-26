package com.htf.ui.home;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {HomeActivityModule.class})
public interface HomeActivityComponent {

    void injectPresenter(HomeActivity view);
}
