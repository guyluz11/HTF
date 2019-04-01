package com.htf.ui.main.fr.profession;

import com.htf.components.Injection;

import dagger.Module;
import dagger.Provides;

@Module
public class ProfessionFragmentModule {

    private final ProfessionFragmentContract.IView view;

    public ProfessionFragmentModule(ProfessionFragmentContract.IView view) {
        this.view = view;
    }

    @Provides
    public ProfessionFragmentContract.IPresenter providePresenter() {
        return new ProfessionFragmentPresenter(view, Injection.getProvider().getNetwork());
    }
}
