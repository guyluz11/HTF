package com.htf.ui.main.fr.book_mark;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {BookMarkFragmentModule.class})
public interface BookMarkFragmentComponent {

    void injectPresenter(BookMarkFragment view);
}
