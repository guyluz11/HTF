package com.htf.ui.main.fr.skills;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {SkillsFragmentModule.class})
public interface SkillsFragmentComponent {

    void injectPresenter(SkillsFragment view);
}
