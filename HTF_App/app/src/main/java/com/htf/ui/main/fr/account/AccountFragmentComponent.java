package com.htf.ui.main.fr.account;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AccountFragmentModule.class})
public interface AccountFragmentComponent {

    void injectPresenter(AccountFragment view);
}
