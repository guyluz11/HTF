package com.htf.ui.main.fr.login;

import com.htf.R;
import com.htf.components.network.INetwork;
import com.htf.components.prefs.IPrefs;
import com.htf.lib.result.Result;
import com.htf.lib.v7.fragment.FragmentPresenter;
import com.htf.util.TextUtils;

import java.util.regex.Pattern;

public class LoginFragmentPresenter extends FragmentPresenter<LoginFragmentContract.IView>
        implements LoginFragmentContract.IPresenter {

    private final String regex = "^([_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*(\\.[a-zA-Z]{1,6}))?$";
    private final Pattern pattern = Pattern.compile(regex);
    private final INetwork network;
    private final IPrefs prefs;

    public LoginFragmentPresenter(LoginFragmentContract.IView view, INetwork network, IPrefs prefs) {
        super(view);
        this.network = network;
        this.prefs = prefs;
    }

    @Override
    public void login(String username, String password) {
        final ValidationResult validation = validate(username, password);
        view.setValidationResult(validation);
        if (validation.isInvalid()) return;

        view.showProgress(R.string.empty, R.string.wait_please);
        network.loginUser(username, password, (Result<Boolean> result) -> {
            view.hideProgress();
            if (result.isSuccess()) {
                //if the string that got passed from the 'NetworkImpl'
                // inside 'addInitialUserDocument' method exists
                view.showToast(R.string.logged_in);
                view.goToHomeScreen();
            } else {
                view.showToast(R.string.error);
            }
        });
    }

    private ValidationResult validate(String username, String password) {
        final ValidationResult result = new ValidationResult();
        if (TextUtils.isEmpty(password)) {
            result.setPasswordValidation(view.getString(R.string.password_is_empty));
        } else if (password.length() < 6) {
            result.setPasswordValidation(view.getString(R.string.password_is_short));
        }

        if (TextUtils.isEmpty(username)) {
            result.setEmailValidation(view.getString(R.string.email_is_empty));
        } else if (!pattern.matcher(username).matches()) {
            result.setEmailValidation(view.getString(R.string.email_not_valid));
        }
        return result;
    }

    @Override
    public void registerUser(String username, String password) {
        //register the user for the first time if he don`t have account
        final ValidationResult validation = validate(username, password);
        view.setValidationResult(validation);
        if (validation.isInvalid()) return;
        //register the user for the first time
        view.showProgress(R.string.empty, R.string.wait_please);
        network.register(username, password, (Result<String> result) -> {
            view.hideProgress();
            if (result.isSuccess()) {

                view.showToast(R.string.registered);
                prefs.putInterest("interests");
                view.goToUserDataScreen();
            } else {
                view.showToast(result.error.getMessage());
            }
        });
    }



}


