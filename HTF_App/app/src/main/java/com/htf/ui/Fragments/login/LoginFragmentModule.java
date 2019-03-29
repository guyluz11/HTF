package com.htf.ui.Fragments.login;

import com.htf.components.Injection;

import dagger.Module;
import dagger.Provides;

@Module
public class LoginFragmentModule {

    private final LoginFragmentContract.IView view;

    public LoginFragmentModule(LoginFragmentContract.IView view) {
        this.view = view;
    }

    @Provides
    public LoginFragmentContract.IPresenter providePresenter() {
        return new LoginFragmentPresenter(view, Injection.getProvider().getNetwork());
    }
}
