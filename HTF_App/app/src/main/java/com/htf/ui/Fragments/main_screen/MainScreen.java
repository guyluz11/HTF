package com.htf.ui.Fragments.main_screen;


import android.os.Bundle;

import androidx.annotation.NonNull;
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


public class MainScreen extends Fragment {

    private View myView;
    private BottomNavigationView bottomNavView;
    private View fragment;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        myView = inflater.inflate(R.layout.fragment_main_screen, container, false);
        constructViews();

        //TODO: Change this to work correctly and not with title names Add link of example (In kotlin)
        // https://codelabs.developers.google.com/codelabs/android-navigation/#1
        //
        // lines in kotlin
        // val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_nav_view)
        // bottomNav?.setupWithNavController(navController)

        bottomNavView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getTitle().toString()){
                    case "Home Screen":
//                        NavigationUI.setupActionBarWithNavController(bottomNavView);
                        Navigation.findNavController(fragment).navigate(R.id.action_chat_to_hackathonGroups);       // Change to Customer menu Screen b
                        break;
                    case "Chat is here":
                        Navigation.findNavController(fragment).navigate(R.id.action_hackathonGroups_to_chat);       // Change to Customer menu Screen
                        break;
                    case "":
                        break;
                }
                return true;
            }
        });
        return myView;
    }

    private void constructViews() {        // initialize all the variables in an organized way
        bottomNavView = myView.findViewById(R.id.bottomNavView);
        fragment = myView.findViewById(R.id.fragmenttt2);
    }

}
