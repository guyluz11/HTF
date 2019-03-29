package com.htf.components.network;

import com.htf.lib.result.ICallback;

public interface INetwork {

    // adds new user if it not yet created
    void addUser(String name, String secondName, int year, ICallback<String> callback);
    //login the user and save logged state
    void loginUser(String Email, String password, ICallback<String> callback);
    //register the user
    void register(String userName, String password, String fullName, ICallback<String> callback);
    //check if the user already signed in
    boolean isSignedIn();


}
