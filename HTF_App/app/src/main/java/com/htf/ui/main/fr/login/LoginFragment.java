package com.htf.ui.main.fr.login;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.htf.R;
import com.htf.lib.v7.fragment.HostedFragment;

import javax.inject.Inject;

import androidx.annotation.Nullable;
import androidx.navigation.fragment.NavHostFragment;


public class LoginFragment extends HostedFragment<LoginFragmentContract.IPresenter,
        LoginFragmentContract.IHost> implements LoginFragmentContract.IView, View.OnClickListener {

    private Button loginButton;
    private TextView gotAccount, email, name, password;


    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Inject
    protected LoginFragmentContract.IPresenter presenter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerLoginFragmentComponent.builder()
                .loginFragmentModule(new LoginFragmentModule(this))
                .build().injectPresenter(this);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_login;
    }

    @Override
    protected void initViews(View v) {
        loginButton = v.findViewById(R.id.loginButton_login);
        gotAccount = v.findViewById(R.id.already_have_account_textView);
        email = v.findViewById(R.id.email_textView);
        name = v.findViewById(R.id.name_textView);
        password = v.findViewById(R.id.password_textView);

        loginButton.setOnClickListener(this);//Navigation.createNavigateOnClickListener(R.id.action_login_to_mainScreen, null));  // only to change page
        gotAccount.setOnClickListener(this);//Navigation.createNavigateOnClickListener(R.id.action_login_to_mainScreen, null));  // only to change page

        // email.setOnClickListener(this);//Navigation.createNavigateOnClickListener(R.id.action_login_to_mainScreen, null));  // only to change page
        // name.setOnClickListener(this);//Navigation.createNavigateOnClickListener(R.id.action_login_to_mainScreen, null));  // only to change page
        // password.setOnClickListener(this);//Navigation.createNavigateOnClickListener(R.id.action_login_to_mainScreen, null));  // only to change page
        // forgotPassword.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_login_to_forgotPassword, null));  // only to change page
        // newAccount.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_login_to_createNewAccount, null));  // only to change page
    }

    @Override
    public void onClick(View v) {
        if (v == loginButton) {
            //login the user
            presenter.registerUser(getText(email), getText(password), getText(name));
        } else if (v == gotAccount) {
            presenter.login(getText(email), getText(password));
        }
    }

    private String getText(TextView textView) {
        return textView.getText().toString();
    }

    @Override
    public void setValidationResult(ValidationResult validation) {
        email.setError(validation.getEmailMsg());
        password.setError(validation.getPasswordMsg());
        name.setError(validation.getNameMsg());
    }

    @Override
    public void goToHomeScreen() {
        NavHostFragment.findNavController(this).navigate(R.id.action_login_to_mainScreen);
    }

    @Override
    public void goToUserDataScreen() {
        // todo proceed to fill user's interests screen
    }
}