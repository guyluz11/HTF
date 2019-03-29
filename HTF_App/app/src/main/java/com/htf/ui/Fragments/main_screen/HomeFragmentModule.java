package com.htf.ui.Fragments.main_screen;

import dagger.Module;
import dagger.Provides;

@Module
public class HomeFragmentModule {

    private final HomeFragmentContract.IView view;

    public HomeFragmentModule(HomeFragmentContract.IView view) {
        this.view = view;
    }

    @Provides
    public HomeFragmentContract.IPresenter providePresenter() {
        return new HomeFragmentPresenter(view);
    }
}
