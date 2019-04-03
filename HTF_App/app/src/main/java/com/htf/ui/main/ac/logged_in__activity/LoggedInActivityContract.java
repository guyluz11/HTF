package com.htf.ui.main.ac.logged_in__activity;

import com.htf.lib.contract.mvp.ActivityContract;

public class LoggedInActivityContract {
    public interface IPresenter extends ActivityContract.IPresenter {
        boolean goToUserSkills();
    }

    public interface IView extends ActivityContract.IView {
    }
}
