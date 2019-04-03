package com.htf.ui.main.fr.forgot_password;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.htf.R;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;


public class ForgotPassword extends Fragment {
    private View myView;
    Button textButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        myView = inflater.inflate(R.layout.fragment_forgot_password, container, false);   // get the view of the fragment (do not delete or move)
        constructViews();


        return myView;
    }


    private void constructViews() {        // initialize all the variables in an organized way
        textButton = myView.findViewById(R.id.button2);

        textButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

    }

}
