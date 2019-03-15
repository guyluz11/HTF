package com.mdgd.lib.v7.fragment;

import android.os.Bundle;
import android.view.View;

import com.mdgd.lib.R;
import com.mdgd.lib.contract.mvp.ActivityContract;
import com.mdgd.lib.v7.mvp.CommonActivity;

import java.util.List;

import androidx.fragment.app.Fragment;

/**
 * Created by Max
 * on 25/07/2017.
 */

public abstract class HostActivity<PRESENTER extends ActivityContract.IPresenter>
        extends CommonActivity<PRESENTER> {

    protected View container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        container = findViewById(getFragmentContainerId());
        if(savedInstanceState == null) addFirstFragment();
        else {
            final List<Fragment> fragments = getSupportFragmentManager().getFragments();
            if(fragments.isEmpty()) addFirstFragment();
            else restoreFragments(fragments);
        }
    }

    protected void addFirstFragment() {
        final Fragment f = getFirstFragment();
        if(f == null) return;
        addFragment(f, false, "firstFragment");
    }

    protected void restoreFragments(List<Fragment> fragments){}

    @Override
    protected int getLayoutResId(){
        return R.layout.activity_fragment;
    }

    protected abstract Fragment getFirstFragment();
}
