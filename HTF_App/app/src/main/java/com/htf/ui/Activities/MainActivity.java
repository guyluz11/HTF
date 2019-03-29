package com.htf.ui.Activities;

import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.htf.R;
import com.htf.components.Injection;
import com.htf.dto.User;
import com.htf.lib.result.Result;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private String TAG = "GO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //createNewUserPushToDB();
        loginUserAndGetUserObject();
    }

    private void loginUserAndGetUserObject() {
        User user;
        // login user that already exist and ger User Object from database
        Injection.getProvider().getNetwork().loginUser("nivsaparov@gmail.com", "123456789", result -> {
            // get user object
            String id = FirebaseAuth.getInstance().getCurrentUser().getUid();
            Injection.getProvider().getNetwork().getUser(id, (Result<List<User>> result1) -> {
                populateUser(result1.data);
            });
        });
    }

    private User populateUser(List<User> data) {
        return data.isEmpty() ? null : data.get(0);
    }

    /**
     * this func used when new user register, its update Auth DB, User DB
     */
    private void createNewUserPushToDB() {
        // inject user auth for sign in with email and password push for db
        /*


            registerAuthUser();


         */

        // after user logged in we need to push the User object to DB

        User user;
        ArrayList<String> skills = new ArrayList<>();
        skills.add("cdasca");
        skills.add("cdasca");
        skills.add("cdasca");

        // the uid key i put is just some key of a user i took from the firebase
        user = new User("oIxDNGoE9FgtxBGpFDpo2lnM9gK2");

        Injection.getProvider().getNetwork().updateUser(user, result -> {
            System.out.println();
        });
    }
}
