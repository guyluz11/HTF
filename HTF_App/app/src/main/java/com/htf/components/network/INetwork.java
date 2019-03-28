package com.htf.components.network;

import com.htf.dto.User;
import com.htf.lib.result.ICallback;

import java.util.ArrayList;
import java.util.List;

public interface INetwork {
    void getUsers(ICallback<List<User>> callback);
    void loginUser(String username, String password, ICallback<Boolean> callback);

    void updateUser(String firstname, String lastname, ArrayList<String> skills, ICallback<Boolean> callback);
    void updateUser(User user, ICallback<Boolean> callback);



    void initUserDB();
    void getUser(String uid, ICallback<List<User>> callback);
}
