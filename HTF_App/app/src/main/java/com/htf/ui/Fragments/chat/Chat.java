package com.htf.ui.Fragments.chat;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.htf.R;


public class Chat extends Fragment {
    private View myView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        myView = inflater.inflate(R.layout.fragment_chat, container, false);
        constructViews();

        return myView;
    }

    private void constructViews() {        // initialize all the variables in an organized way
    }


}
