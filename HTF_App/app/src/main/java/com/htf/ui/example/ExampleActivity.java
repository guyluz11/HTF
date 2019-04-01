package com.htf.ui.example;

import android.os.Bundle;

import com.htf.components.Injection;
import com.htf.dto.User;
import com.htf.lib.v7.fragment.HostActivity;
import com.htf.ui.example.fr.example.ExampleFragment;

import java.util.ArrayList;

import javax.inject.Inject;

import androidx.fragment.app.Fragment;

public class ExampleActivity extends HostActivity<ExampleContract.IPresenter> implements ExampleContract.IView {

    @Inject
    public ExampleContract.IPresenter presenter;

    @Override
    protected Fragment getFirstFragment() {
        return ExampleFragment.newInstance();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerExampleActivityComponent.builder()
                .exampleActivityModule(new ExampleActivityModule(this))
                .build().injectPresenter(this);
        mockUsers();
    }

    /**
     * this func used when new user register, its update Auth DB, User DB MOCK
     */
    private void createNewUserPushToDB(String uid) {
        User user;
        ArrayList<String> skills = new ArrayList<>();
        skills.add("Developer");
        skills.add("UX");
        skills.add("Android");

        // the uid key i put is just some key of a user i took from the firebase
        user = new User(uid);
        Injection.getProvider().getNetwork().addUser(user, result -> {
            System.out.println();
        });
    }


    public void mockUsers() {
        createNewUserPushToDB("853OejCcg7aUkGKXsefkAOsnSx72");
        createNewUserPushToDB("853OejCcg7aUkGKXsefkAOsnSx72");
        createNewUserPushToDB("A1bHZFAaEaOQfnQcBSTYkDkDgzf2");
        createNewUserPushToDB("C25OKgkxQaUZlAiU5To2GeJ7qB03");
    }

}
