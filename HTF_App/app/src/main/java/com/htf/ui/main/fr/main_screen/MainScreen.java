package com.htf.ui.Fragments.main_screen;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.Navigation;

import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.htf.R;
import com.htf.lib.v7.fragment.HostedFragment;

import javax.inject.Inject;


public class MainScreen extends HostedFragment<HomeFragmentContract.IPresenter, HomeFragmentContract.IHost>
implements HomeFragmentContract.IView {

    @Inject
    protected HomeFragmentContract.IPresenter presenter;
    private BottomNavigationView bottomNavView;
    private View fragment;


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
    public void onStart() {
        super.onStart();
        navigateToInterestsScreen();
    }

    private void navigateToInterestsScreen(){
        //todo go to interests screen if this is the first time

        if(presenter.goToUserSkills()) {
            System.out.println("there is value to the prefs");
            // TODO: 29/03/2019 check is this will get fixed after guy push 
            Navigation.findNavController(fragment).navigate(R.id.action_to_chat);

        }

    }

    @Override
    protected void initViews(View v) {
        bottomNavView = v.findViewById(R.id.bottomNavView);
        fragment = v.findViewById(R.id.fragmenttt2);
        bottomNavView = v.findViewById(R.id.bottomNavView);
        bottomNavView.setOnNavigationItemSelectedListener((@NonNull MenuItem menuItem) -> {

            switch (menuItem.getItemId()){
                case R.id.action_to_home_m:
                    Navigation.findNavController(fragment).navigate(R.id.action_to_home);       // Change to Customer menu Screen b
                    break;
                case R.id.action_to_chat_m:
                    Navigation.findNavController(fragment).navigate(R.id.action_to_chat);       // Change to Customer menu Screen
                    break;
                case R.id.action_to_account_m:
                    Navigation.findNavController(fragment).navigate(R.id.action_to_account);       // Change to Customer menu Screen
                    break;
                case R.id.action_to_bookMark_m:
                    Navigation.findNavController(fragment).navigate(R.id.action_to_bookMark);       // Change to Customer menu Screen
                    break;
            }
            return true;
        });
    }



}
