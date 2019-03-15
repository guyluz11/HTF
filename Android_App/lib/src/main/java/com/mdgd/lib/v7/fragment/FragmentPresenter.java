package com.mdgd.lib.v7.fragment;

import com.mdgd.lib.contract.fragment.FragmentContract;

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
