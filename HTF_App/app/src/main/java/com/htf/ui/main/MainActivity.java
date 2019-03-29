package com.htf.ui.main;

import android.os.Bundle;

import com.htf.R;
import com.htf.lib.v7.fragment.HostActivity;
import com.htf.ui.main.fr.login.LoginFragmentContract;

import javax.inject.Inject;

public class MainActivity extends HostActivity<MainContract.IPresenter> implements MainContract.IView,
        LoginFragmentContract.IHost {

    @Inject
    public MainContract.IPresenter presenter;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerMainActivityComponent.builder().mainActivityModule(new MainActivityModule(this))
                .build().injectPresenter(this);
    }
}