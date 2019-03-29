package com.htf.ui.Fragments.main_screen;

import com.htf.lib.v7.fragment.FragmentPresenter;

public class HomeFragmentPresenter extends FragmentPresenter<HomeFragmentContract.IView>
        implements HomeFragmentContract.IPresenter {

    public HomeFragmentPresenter(HomeFragmentContract.IView view) {
        super(view);
    }
}
