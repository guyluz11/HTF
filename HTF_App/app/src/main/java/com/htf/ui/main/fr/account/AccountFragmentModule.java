package com.htf.ui.main.fr.account;

import com.htf.components.Injection;

import dagger.Module;
import dagger.Provides;

@Module
public class AccountFragmentModule {

    private final AccountFragmentContract.IView view;

    public AccountFragmentModule(AccountFragmentContract.IView view) {
        this.view = view;
    }

    @Provides
    public AccountFragmentContract.IPresenter providePresenter() {
        return new AccountFragmentPresenter(view, Injection.getProvider().getNetwork());
    }
}
