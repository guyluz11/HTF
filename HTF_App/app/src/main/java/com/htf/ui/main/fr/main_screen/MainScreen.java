package com.htf.ui.main.fr.main_screen;


import android.os.Bundle;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.htf.R;
import com.htf.lib.v7.fragment.HostedFragment;

import javax.inject.Inject;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;


public class MainScreen extends HostedFragment<HomeFragmentContract.IPresenter, HomeFragmentContract.IHost>
        implements HomeFragmentContract.IView {

    @Inject
    protected HomeFragmentContract.IPresenter presenter;
    private BottomNavigationView bottomNavView;
    private Fragment fragment;

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_main_screen;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerHomeFragmentComponent.builder()
                .homeFragmentModule(new HomeFragmentModule(this))
                .build().injectPresenter(this);
    }

    @Override
    protected void initViews(View v) {
        bottomNavView = v.findViewById(R.id.bottomNavView);
        fragment = getChildFragmentManager().findFragmentById(R.id.fragmenttt2);

        NavigationUI.setupWithNavController(bottomNavView, NavHostFragment.findNavController(fragment));
    }
}
