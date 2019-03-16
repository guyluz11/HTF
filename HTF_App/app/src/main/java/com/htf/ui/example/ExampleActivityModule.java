package com.htf.ui.example;

import dagger.Module;
import dagger.Provides;

@Module
public class ExampleActivityModule {

    private final ExampleContract.IView view;

    public ExampleActivityModule(ExampleContract.IView view) {
        this.view = view;
    }

    @Provides
    public ExampleContract.IPresenter providePresenter() {
        return new ExampleActivityPresenter(view);
    }
}
