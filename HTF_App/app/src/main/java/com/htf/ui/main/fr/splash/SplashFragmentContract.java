package com.htf.ui.main.fr.splash;

import com.htf.lib.contract.fragment.FragmentContract;

public class SplashFragmentContract {
    public interface IPresenter extends FragmentContract.IPresenter {
        void checkSignIn();
    }

    public interface IHost extends FragmentContract.IHost {
    }

    public interface IView extends FragmentContract.IView {
        void proceedToMain();

        void proceedToSignIn();
    }
}
