package com.htf.ui.main.fr.blank_fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.htf.R;

import androidx.fragment.app.Fragment;


public class BlankFragment extends Fragment {
    private View myView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        myView = inflater.inflate(R.layout.fragment_blank, container, false);
        constructViews();

        return myView;
    }

    private void constructViews() {        // initialize all the variables in an organized way
    }


}
