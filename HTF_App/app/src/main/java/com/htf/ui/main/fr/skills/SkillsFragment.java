package com.htf.ui.main.fr.skills;

import android.os.Bundle;

import com.htf.lib.v7.fragment.HostedFragment;

import javax.inject.Inject;

import androidx.annotation.Nullable;


public class SkillsFragment extends HostedFragment<SkillsFragmentContract.IPresenter,
        SkillsFragmentContract.IHost> implements SkillsFragmentContract.IView {

    @Inject
    protected SkillsFragmentContract.IPresenter presenter;

    public static SkillsFragment newInstance() {
        return new SkillsFragment();
    }

    @Override
    protected int getLayoutResId() {
        return 0;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        DaggerExampleFragmentComponent.builder()
//                .exampleFragmentModule(new SkillsFragmentModule(this))
//                .build().injectPresenter(this);
    }
}
