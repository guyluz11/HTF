package com.htf.ui.Activities;

import android.os.Bundle;

import com.htf.R;
import com.htf.lib.v7.fragment.HostActivity;
import com.htf.ui.Fragments.login.LoginFragmentContract;

public class MainActivity extends HostActivity implements LoginFragmentContract.IHost {

    private String TAG = "GO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

}
