package com.htf.components.network;

import android.content.Context;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.htf.R;
import com.htf.dto.Hackathon;
import com.htf.dto.User;
import com.htf.lib.result.ICallback;
import com.htf.lib.result.Result;
import com.htf.lib.retrofit_support.BasicNetwork;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.annotation.NonNull;

public class NetworkImpl extends BasicNetwork implements INetwork {

    private final Context appCtx;

    public NetworkImpl(Context appCtx) {
        this.appCtx = appCtx;
    }

    @Override
    public void addUser(String name, String secondName, int year, ICallback<String> callback) {

    }

    public boolean isSignedIn() {
        return FirebaseAuth.getInstance().getCurrentUser() != null;
    }

    public void register(String userName, String password, String fullName, ICallback<String> callback) {
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(userName, password)
                .addOnCompleteListener((@NonNull Task<AuthResult> task) -> {
                    if (task.isSuccessful()) {
                        addInitialUserDocument(userName, fullName, callback);
                    } else {
                        // exec callback
                        //todo check how to pass false calback if i must evter string (even if empty)
                        callback.onResult(new Result<>(task.getException()));
                    }
                });
    }

    private void addInitialUserDocument(String userName, String fullName, ICallback<String> callback) { // adds document for the first time if the user was registered
        Map<String, Object> userObject = new HashMap<>();
        userObject.put("name", fullName);
        FirebaseFirestore.getInstance().collection("users")
                .document(userName).set(userObject).addOnCompleteListener((@NonNull Task<Void> task) -> {
            if (task.isSuccessful()) {
                //when i pass ANY String the result.isSuccess()) will be true
                callback.onResult(new Result<>("user added correctly"));
            } else {
                callback.onResult(new Result<>(task.getException()));
            }
        });

    }

    @Override
    public void loginUser(String userName, String password, ICallback<Boolean> callback) {
        FirebaseAuth.getInstance().signInWithEmailAndPassword(userName, password)
                .addOnCompleteListener((@NonNull Task<AuthResult> task) -> {
                    if (task.isSuccessful()) {
                        callback.onResult(new Result<>(true));
                    } else {
                        callback.onResult(new Result<>(task.getException()));
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

    @Override
    public void loadHackathons(String userId, ICallback<List<Hackathon>> callback) {
        FirebaseFirestore.getInstance().collection("hackathons").get()
                .addOnCompleteListener((@NonNull Task<QuerySnapshot> task) -> {
                    if (task.isSuccessful()) {
                        callback.onResult(new Result<>(task.getResult().toObjects(Hackathon.class)));
                    } else {
                        callback.onResult(new Result<>(task.getException()));
                    }
                });
    }

}
