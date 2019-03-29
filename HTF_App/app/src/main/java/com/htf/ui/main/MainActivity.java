package com.htf.ui.main;

import android.os.Bundle;

import com.htf.R;
import com.htf.components.Injection;
import com.htf.dto.Group;
import com.htf.dto.Hackathon;
import com.htf.dto.User;
import com.htf.lib.v7.fragment.HostActivity;
import com.htf.ui.main.fr.account.AccountFragmentContract;
import com.htf.ui.main.fr.login.LoginFragmentContract;

import java.util.ArrayList;

import javax.inject.Inject;

public class MainActivity extends HostActivity<MainContract.IPresenter> implements MainContract.IView,
        LoginFragmentContract.IHost, AccountFragmentContract.IHost {

    @Inject
    public MainContract.IPresenter presenter;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerMainActivityComponent.builder().mainActivityModule(new MainActivityModule(this))
                .build().injectPresenter(this);

        mockData();
    }

    private void mockData() {
        // create 4 users and push db
        /*
        createNewUserPushToDB("APX7EK5JzLZspyvMnXMZgB0lTav1");
        createNewUserPushToDB("oLzvRH5f12YdYGMzLTjtaYmTFuk1");
        createNewUserPushToDB("dPqGbA0UsbePWTnJ6DNecN2UFE22");
        createNewUserPushToDB("DXbUGvJx3vhfEo8Bkt9RNU0WHdg2");
        */

        // create 4 hackathon and push db
        //createNewHackathonsPushToDB();

        // create 4 groups with 1,2,3,4
        createNewGroupPushToDB("xa");


    }


    @Override
    public void showHackatonDetails(Hackathon item) {
        // TODO SHOW HACKATON DETAILS
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

    private void createNewGroupPushToDB(String uid) {
        ArrayList<String> participants = new ArrayList<>();
        participants.add("APX7EK5JzLZspyvMnXMZgB0lTav1");
        participants.add("oLzvRH5f12YdYGMzLTjtaYmTFuk1");
        participants.add("dPqGbA0UsbePWTnJ6DNecN2UFE22");


        ArrayList<String> waitlist = new ArrayList<>();
        waitlist.add("DXbUGvJx3vhfEo8Bkt9RNU0WHdg2");
        Group group1 = new Group("FlappyBird", "Nice game to play", 10);
        group1.setId(1);
        group1.setmParticipates(participants);
        group1.setmWaitingList(waitlist);

        Injection.getProvider().getNetwork().createGroup(group1, result -> {
            System.out.println();
        });

        Group group2 = new Group("PC VS Wings", "Get all the wings", 10);
        group2.setId(2);
        group2.setmParticipates(participants);
        group2.setmWaitingList(waitlist);

        Injection.getProvider().getNetwork().createGroup(group2, result -> {
            System.out.println();
        });

        Group group3 = new Group("MyRemote", "Long distance remote controller", 10);
        group3.setId(3);
        group3.setmParticipates(participants);
        group3.setmWaitingList(waitlist);

        Injection.getProvider().getNetwork().createGroup(group3, result -> {
            System.out.println();
        });

        Group group4 = new Group("FlappyBird", "Nice game to play", 10);
        group4.setId(4);
        group4.setmParticipates(participants);
        group4.setmWaitingList(waitlist);

        Injection.getProvider().getNetwork().createGroup(group4, result -> {
            System.out.println();
        });

    }

    private void createNewHackathonsPushToDB() {
        Hackathon hackathon;
        hackathon = new Hackathon("Android Academy",
                "This is the best ever!", 13, 4);
        // adding 4 groups with id
        ArrayList<String> groups = new ArrayList<>();
        groups.add("1");
        groups.add("2");
        groups.add("3");
        groups.add("4");
        hackathon.setmGroupListId(groups);
        Injection.getProvider().getNetwork().createHackathons(hackathon, result -> {
            System.out.println();
        });
        hackathon = new Hackathon("IPHONE Minus Academy", "okay ...", 13, 4);
        hackathon.setmGroupListId(groups);

        Injection.getProvider().getNetwork().createHackathons(hackathon, result -> {
            System.out.println();
        });


        hackathon = new Hackathon("Cyber Academy",
                "prefix used to describe a person, thing, or idea as part of the computer and information age. Taken from kybernetes, Greek for \"steersman\" or", 13, 4);
        hackathon.setmGroupListId(groups);
        Injection.getProvider().getNetwork().createHackathons(hackathon, result -> {
            System.out.println();
        });

        hackathon = new Hackathon("Google Academy",
                "This is the best ever!", 13, 4);
        hackathon.setmGroupListId(groups);
        Injection.getProvider().getNetwork().createHackathons(hackathon, result -> {
            System.out.println();
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }
}
