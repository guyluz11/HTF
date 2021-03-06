package com.htf.ui.main.fr.main_screen;

import com.htf.components.prefs.IPrefs;
import com.htf.lib.v7.fragment.FragmentPresenter;

public class HomeFragmentPresenter extends FragmentPresenter<HomeFragmentContract.IView>
        implements HomeFragmentContract.IPresenter {


    private IPrefs mPrefs;


    public HomeFragmentPresenter(HomeFragmentContract.IView view, IPrefs prefs) {
        super(view);
        this.mPrefs = prefs;
    }

    @Override
    public boolean goToUserSkills() {
        if ("interests".equals(mPrefs.getInterest("interests"))) {
            mPrefs.putInterest(null);
            return true;
        } else {
            return false;
        }
    }
}
