package com.htf.ui.example.fr.example;

import com.htf.lib.v7.fragment.FragmentPresenter;

public class ExampleFragmentPresenter extends FragmentPresenter<ExampleFragmentContract.IView>
        implements ExampleFragmentContract.IPresenter {

    public ExampleFragmentPresenter(ExampleFragmentContract.IView view) {
        super(view);
    }
}
