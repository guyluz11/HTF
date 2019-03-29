package com.htf.ui.Fragments.main_screen;

import com.htf.components.Injection;
import com.htf.components.prefs.IPrefs;
import com.htf.components.prefs.Prefs;

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
        return new HomeFragmentPresenter(view, Injection.getProvider().getPrefs());
    }
  }
