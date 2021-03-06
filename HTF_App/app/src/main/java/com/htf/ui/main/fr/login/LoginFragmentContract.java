package com.htf.ui.main.fr.login;

import com.htf.lib.contract.fragment.FragmentContract;

public class LoginFragmentContract {

    public interface IPresenter extends FragmentContract.IPresenter {
        void login(String username, String password);

        void registerUser(String Email, String password);

    }

    public interface IHost extends FragmentContract.IHost {
    }

    public interface IView extends FragmentContract.IView {
        void setValidationResult(ValidationResult validation);

        void goToHomeScreen();

        void goToUserDataScreen();
    }
}
