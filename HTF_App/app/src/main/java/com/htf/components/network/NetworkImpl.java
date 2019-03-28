package com.htf.components.network;

import android.content.Context;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.htf.R;
import com.htf.dto.User;
import com.htf.lib.result.ICallback;
import com.htf.lib.result.Result;
import com.htf.lib.retrofit_support.BasicNetwork;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;

public class NetworkImpl extends BasicNetwork implements INetwork {

    private final Context appCtx;

    public NetworkImpl(Context appCtx) {
        this.appCtx = appCtx;
    }

    /**
     * login user with email and password
     *
     * @param email
     * @param password
     * @param callback
     */
    public void loginUser(String email, String password, ICallback<Boolean> callback) {
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                .addOnCompleteListener((@NonNull Task<AuthResult> task) -> {
                    if (task.isSuccessful()) {
                        callback.onResult(new Result<>(true));
                    } else {
                        callback.onResult(new Result<>(false));
                    }
                });
    }


    /**
     * Create new / override current user
     */
    @Override
    public void updateUser(String firstname, String lastname, ArrayList<String> skills, ICallback<Boolean> callback) {
        FirebaseFirestore.getInstance().collection("users").add(new User(firstname, lastname, skills))
                .addOnCompleteListener((@NonNull Task<DocumentReference> task1) -> {
                    if (task1.isSuccessful()) {
                        callback.onResult(new Result<>(true));
                    } else {
                        callback.onResult(new Result<>(false));
                    }
                });
    }

    /**
     * Create new user / override current one
     */
    @Override
    public void updateUser(User user, ICallback<Boolean> callback) {
        FirebaseFirestore.getInstance().collection("users").add(user)
                .addOnCompleteListener((@NonNull Task<DocumentReference> task1) -> {
                    if (task1.isSuccessful()) {
                        callback.onResult(new Result<>(true));
                    } else {
                        callback.onResult(new Result<>(false));
                    }
                });
    }

    public void getUsers(ICallback<List<User>> callback) {
        // create users collection first
        FirebaseFirestore.getInstance().collection(appCtx.getString(R.string.users_db)).get()
                .addOnCompleteListener((@NonNull Task<QuerySnapshot> task) -> {
                    if (task.isSuccessful()) {
                        callback.onResult(new Result<>(task.getResult().toObjects(User.class)));
                    } else {
                        callback.onResult(new Result<>(task.getException()));
                    }
                });
    }

    @Override
    public void getUser(String uId, ICallback<List<User>> callback) {
        // talk with Niv before implement
        FirebaseFirestore.getInstance().collection(appCtx.getString(R.string.users_db)).whereEqualTo("mId", uId).get()
                .addOnCompleteListener((@NonNull Task<QuerySnapshot> task) -> {
                    if (task.isSuccessful()) {
                        callback.onResult(new Result<>(task.getResult().toObjects(User.class)));
                    } else {
                        callback.onResult(new Result<>(task.getException()));
                    }
                });
    }

    /**
     * Init User database
     */
    @Override
    public void initUserDB() {
        FirebaseFirestore.getInstance().collection(appCtx.getString(R.string.users_db)).add(new User("123456"))
                .addOnCompleteListener((@NonNull Task<DocumentReference> task1) -> {
                    System.out.println();
                });
    }
}
