package com.htf.ui.main.fr.create_new_account;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.htf.R;

import androidx.fragment.app.Fragment;


public class CreateNewAccount extends Fragment {
    private View myView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        myView = inflater.inflate(R.layout.fragment_create_new_account, container, false);   // get the view of the fragment (do not delete or move)
        constructViews();

        return myView;
    }


    private void constructViews() {        // initialize all the variables in an organized way
    }
}
