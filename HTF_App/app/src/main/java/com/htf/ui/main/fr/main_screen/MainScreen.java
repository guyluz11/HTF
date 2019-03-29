package com.htf.ui.main.fr.main_screen;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.htf.R;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;


public class MainScreen extends Fragment {

    private View myView;
    private BottomNavigationView bottomNavView;
    private Fragment fragment;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        myView = inflater.inflate(R.layout.fragment_main_screen, container, false);
        constructViews();

        bottomNavView = myView.findViewById(R.id.bottomNavView);
        NavigationUI.setupWithNavController(bottomNavView, NavHostFragment.findNavController(fragment));
//        bottomNavView.setOnNavigationItemSelectedListener((@NonNull MenuItem menuItem) -> {
//
//                switch (menuItem.getItemId()){
//                    case R.id.action_to_home_m:
//                        Navigation.findNavController(fragment).navigate(R.id.action_to_home);       // Change to Customer menu Screen b
//                        break;
//                    case R.id.action_to_chat_m:
//                        Navigation.findNavController(fragment).navigate(R.id.action_to_chat);       // Change to Customer menu Screen
//                        break;
//                     case R.id.action_to_account_m:
//                            Navigation.findNavController(fragment).navigate(R.id.action_to_account);       // Change to Customer menu Screen
//                            break;
//                     case R.id.action_to_bookMark_m:
//                            Navigation.findNavController(fragment).navigate(R.id.action_to_bookMark);       // Change to Customer menu Screen
//                            break;
//                }
//                return true;
//        });
        return myView;
    }

    private void constructViews() {        // initialize all the variables in an organized way
        bottomNavView = myView.findViewById(R.id.bottomNavView);
        fragment = getChildFragmentManager().findFragmentById(R.id.fragmenttt2);
    }

}
