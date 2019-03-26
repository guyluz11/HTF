package com.htf.ui.home;

import android.os.Bundle;

import com.htf.lib.v7.fragment.HostActivity;
import com.htf.ui.example.DaggerExampleActivityComponent;
import com.htf.ui.example.fr.example.ExampleFragment;

import javax.inject.Inject;

import androidx.fragment.app.Fragment;

public class HomeActivity extends HostActivity<HomeContract.IPresenter> implements HomeContract.IView {

    @Inject
    public HomeContract.IPresenter presenter;

    @Override
    protected Fragment getFirstFragment() {
        return ExampleFragment.newInstance();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerHomeActivityComponent.builder().homeActivityModule(new HomeActivityModule(this))
                .build().injectPresenter(this);
    }
}
