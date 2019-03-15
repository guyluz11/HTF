package com.htf;

import android.app.Application;

import com.htf.components.ComponentProvider;
import com.htf.components.Injection;

public class OurApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Injection.setProvider(new ComponentProvider(this));
    }
}
