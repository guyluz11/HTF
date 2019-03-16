package com.htf.lib.v7.fragment;

import com.htf.lib.contract.fragment.FragmentContract;

/**
 * Created by Max
 * on 08/10/2017.
 */

public abstract class FragmentPresenter<VIEW extends FragmentContract.IView> {
    public VIEW view;

    public FragmentPresenter(VIEW view){
        this.view = view;
    }
}
