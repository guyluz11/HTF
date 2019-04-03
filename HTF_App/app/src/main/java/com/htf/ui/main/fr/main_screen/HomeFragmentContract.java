package com.htf.ui.main.fr.main_screen;

import com.htf.lib.contract.fragment.FragmentContract;

public class HomeFragmentContract {
    public interface IPresenter extends FragmentContract.IPresenter {
        boolean goToUserSkills();
    }

    public interface IHost extends FragmentContract.IHost {
    }

    public interface IView extends FragmentContract.IView {
    }
}
