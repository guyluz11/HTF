package com.htf.ui.main.fr.splash;

import com.htf.components.network.INetwork;
import com.htf.lib.v7.fragment.FragmentPresenter;

public class SplashFragmentPresenter extends FragmentPresenter<SplashFragmentContract.IView>
        implements SplashFragmentContract.IPresenter {

    private final INetwork network;

    public SplashFragmentPresenter(SplashFragmentContract.IView view, INetwork network) {
        super(view);
        this.network = network;
    }

    @Override
    public void checkSignIn() {
        if (network.isSignedIn()) view.proceedToMain();
        else view.proceedToSignIn();

    }
}
