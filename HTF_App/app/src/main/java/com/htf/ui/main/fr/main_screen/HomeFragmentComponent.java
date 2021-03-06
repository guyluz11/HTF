package com.htf.ui.main.fr.main_screen;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {HomeFragmentModule.class})
public interface HomeFragmentComponent {

    void injectPresenter(MainScreen view);
}
