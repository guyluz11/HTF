package com.htf.ui.main.fr.login;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {LoginFragmentModule.class})
public interface LoginFragmentComponent {

    void injectPresenter(LoginFragment view);
}
