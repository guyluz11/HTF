package com.htf.ui.main.fr.splash;

import com.htf.components.Injection;

import dagger.Module;
import dagger.Provides;

@Module
public class SplashFragmentModule {

    private final SplashFragmentContract.IView view;

    public SplashFragmentModule(SplashFragmentContract.IView view) {
        this.view = view;
    }

    @Provides
    public SplashFragmentContract.IPresenter providePresenter() {
        return new SplashFragmentPresenter(view, Injection.getProvider().getNetwork());
    }
}
