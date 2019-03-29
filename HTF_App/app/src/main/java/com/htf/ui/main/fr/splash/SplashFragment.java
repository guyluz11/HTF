package com.htf.ui.main.fr.splash;

import android.os.Bundle;

import com.htf.R;
import com.htf.lib.v7.fragment.HostedFragment;

import javax.inject.Inject;

import androidx.annotation.Nullable;
import androidx.navigation.fragment.NavHostFragment;


public class SplashFragment extends HostedFragment<SplashFragmentContract.IPresenter,
        SplashFragmentContract.IHost> implements SplashFragmentContract.IView {

    @Inject
    protected SplashFragmentContract.IPresenter presenter;

    public static SplashFragment newInstance() {
        return new SplashFragment();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_splash;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerSplashFragmentComponent.builder()
                .splashFragmentModule(new SplashFragmentModule(this))
                .build().injectPresenter(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        presenter.checkSignIn();
    }

    @Override
    public void proceedToMain() {
        NavHostFragment.findNavController(this).navigate(R.id.mainScreen);
    }

    @Override
    public void proceedToSignIn() {
        NavHostFragment.findNavController(this).navigate(R.id.login);
    }
}
