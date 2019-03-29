package com.htf.ui.Fragments.login;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {LoginFragmentModule.class})
public interface LoginFragmentComponent {

    void injectPresenter(LoginFragment view);
}
