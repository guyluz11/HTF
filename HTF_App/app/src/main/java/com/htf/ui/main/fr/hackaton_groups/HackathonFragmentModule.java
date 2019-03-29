package com.htf.ui.main.fr.hackaton_groups;

import com.htf.components.Injection;

import dagger.Module;
import dagger.Provides;

@Module
public class HackathonFragmentModule {

    private final HackathonFragmentContract.IView view;

    public HackathonFragmentModule(HackathonFragmentContract.IView view) {
        this.view = view;
    }

    @Provides
    public HackathonFragmentContract.IPresenter providePresenter() {
        return new AccountFragmentPresenter(view, Injection.getProvider().getNetwork());
    }
}
