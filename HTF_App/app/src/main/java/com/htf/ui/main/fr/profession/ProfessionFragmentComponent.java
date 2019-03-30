package com.htf.ui.main.fr.profession;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ProfessionFragmentModule.class})
public interface ProfessionFragmentComponent {

    void injectPresenter(ProfessionFragment view);
}
