package com.htf.ui.main.ac.logged_in__activity;

import com.htf.components.network.INetwork;
import com.htf.components.prefs.IPrefs;
import com.htf.lib.v7.mvp.Presenter;

public class LoggedInActivityPresenter extends Presenter<LoggedInActivityContract.IView> implements LoggedInActivityContract.IPresenter {
    private IPrefs mPrefs;
    public LoggedInActivityPresenter(LoggedInActivityContract.IView view, IPrefs prefs) {
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
