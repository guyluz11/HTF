package com.htf.ui.main.fr.splash;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {SplashFragmentModule.class})
public interface SplashFragmentComponent {

    void injectPresenter(SplashFragment view);
}
