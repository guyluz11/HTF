package com.htf.ui.main.fr.book_mark;

import com.htf.components.Injection;

import dagger.Module;
import dagger.Provides;

@Module
public class BookMarkFragmentModule {

    private final BookMarkFragmentContract.IView view;

    public BookMarkFragmentModule(BookMarkFragmentContract.IView view) {
        this.view = view;
    }

    @Provides
    public BookMarkFragmentContract.IPresenter providePresenter() {
        return new BookMarkFragmentPresenter(view, Injection.getProvider().getNetwork());
    }
}
