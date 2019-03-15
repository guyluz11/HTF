package com.htf.ui.example;

import android.os.Bundle;

import com.htf.lib.v7.fragment.HostActivity;
import com.htf.ui.example.fr.example.ExampleFragment;

import javax.inject.Inject;

import androidx.fragment.app.Fragment;

public class ExampleActivity extends HostActivity<ExampleContract.IPresenter> implements ExampleContract.IView {

    @Inject
    public ExampleContract.IPresenter presenter;

    @Override
    protected Fragment getFirstFragment() {
        return ExampleFragment.newInstance();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerExampleActivityComponent.builder()
                .exampleActivityModule(new ExampleActivityModule(this))
                .build().injectPresenter(this);
    }
}
