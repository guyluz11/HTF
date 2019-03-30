package com.htf.ui.main.fr.skills;

import dagger.Module;
import dagger.Provides;

@Module
public class SkillsFragmentModule {

    private final SkillsFragmentContract.IView view;

    public SkillsFragmentModule(SkillsFragmentContract.IView view) {
        this.view = view;
    }

    @Provides
    public SkillsFragmentContract.IPresenter providePresenter() {
        return new SkillsFragmentPresenter(view);
    }
}
