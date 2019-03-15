package com.htf.lib.contract.fragment;

import com.htf.lib.contract.IToast;
import com.htf.lib.contract.progress.IProgressContainer;

/**
 * Created by Max
 * on 05/09/2018.
 */
public class FragmentContract {

    public interface IHost extends IProgressContainer, IToast {

        void finish();

        void onBackPressed();

        boolean isFinishing();
    }

    public interface IPresenter {}

    public interface IView extends IProgressContainer, IToast {}
}
