package com.htf.components.network;

import com.htf.dto.Group;
import com.htf.dto.Hackathon;
import com.htf.dto.User;
import com.htf.lib.result.ICallback;
import com.htf.lib.result.Result;

import java.util.ArrayList;
import java.util.List;

public interface INetwork {

    void loginUser(String username, String password, ICallback<Boolean> callback);

    void addUser(User user, ICallback<Boolean> callback);

    void getUser(String uid, ICallback<List<User>> callback);


    //register the user
    void register(String userName, String password, ICallback<String> callback);

    //check if the user already signed in
    boolean isSignedIn();

    void loadHackathons(String userId, ICallback<List<Hackathon>> callback);

    void createHackathons(String title, String description, int maxNumberOfGroups, int maxNumberOfPeopleInGroup, ICallback<Boolean> callback);

    void createHackathons(Hackathon hackathon, ICallback<Boolean> callback);


    void createGroup(Group group, ICallback<Boolean> callback);

    void updateUser(User user, ICallback<Boolean> callback);

    void updateUsersSkills(List<String> skills, ICallback<Boolean> callback);
}
