package com.htf.ui.Fragments.main_screen;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.htf.R;
import com.htf.lib.v7.fragment.HostedFragment;
import com.htf.ui.example.fr.example.DaggerExampleFragmentComponent;
import com.htf.ui.example.fr.example.ExampleFragmentContract;
import com.htf.ui.example.fr.example.ExampleFragmentModule;

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
        navigateToInterestsScreen();
    }

    private void navigateToInterestsScreen(){
        //todo go to interests screen if this is the first time
        //if(myView.get)  Navigation.findNavController(fragment).navigate(R.id.action_to_home);
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
