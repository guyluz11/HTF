package com.htf.ui.main.fr.login;

import com.htf.R;
import com.htf.components.network.INetwork;
import com.htf.lib.result.Result;
import com.htf.lib.v7.fragment.FragmentPresenter;
import com.htf.util.TextUtils;

import java.util.regex.Pattern;

public class LoginFragmentPresenter extends FragmentPresenter<LoginFragmentContract.IView>
        implements LoginFragmentContract.IPresenter {

    private final String regex = "^([_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*(\\.[a-zA-Z]{1,6}))?$";
    private final Pattern pattern = Pattern.compile(regex);
    private final INetwork network;

    public LoginFragmentPresenter(LoginFragmentContract.IView view, INetwork network) {
        super(view);
        this.network = network;
    }

    @Override
    public void login(String username, String password) {
        final ValidationResult validation = validate(username, password, false, "");
        view.setValidationResult(validation);
        if (validation.isInvalid()) return;

        view.showProgress();
        network.loginUser(username, password, (Result<String> result) -> {
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

    private ValidationResult validate(String username, String password, boolean checkFullName, String fullName) {
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
        if(checkFullName && TextUtils.isEmpty(fullName)) {
            result.setFullNameValidation(view.getString(R.string.name_is_empty));
        }
        return result;
    }

    @Override
    public void registerUser(String username, String password, String fullName) {
        //register the user for the first time if he don`t have account
        final ValidationResult validation = validate(username, password, true, fullName);
        view.setValidationResult(validation);
        if (validation.isInvalid()) return;
        //register the user for the first time
        view.showProgress(R.string.empty, R.string.wait_please);
        network.register(username, password, fullName, (Result<String> result) -> {
            view.hideProgress();
            if (result.isSuccess()) {
                view.showToast(R.string.registered);
                view.goToUserDataScreen();
            } else {
                view.showToast(result.error.getMessage());
            }
        });
    }
}


