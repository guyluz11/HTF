package com.htf.ui.main.fr.hackaton_groups;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {HackathonFragmentModule.class})
public interface HackathonFragmentComponent {

    void injectPresenter(HackathonFragment view);
}
