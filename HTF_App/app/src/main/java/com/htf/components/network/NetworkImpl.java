package com.htf.components.network;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.htf.lib.result.ICallback;
import com.htf.lib.result.Result;
import com.htf.lib.retrofit_support.BasicNetwork;

import java.util.HashMap;
import java.util.Map;

import androidx.annotation.NonNull;

public class NetworkImpl extends BasicNetwork implements INetwork {

    @Override
    public void addUser(String name, String secondName, int year, ICallback<String> callback) {

    }

    public boolean isSignedIn(){
        return FirebaseAuth.getInstance().getCurrentUser() != null;
    }

    public void register(String userName, String password, String fullName, ICallback<String> callback){
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(userName, password)
                .addOnCompleteListener((@NonNull Task<AuthResult> task) -> {
                    if(task.isSuccessful()) {
                        addInitialUserDocument(userName, fullName, callback);
                    } else {
                        // exec callback
                        //todo check how to pass false calback if i must evter string (even if empty)
                          callback.onResult(new Result<>(task.getException()));
                    }
                });
    }

    @Override
    public void loginUser(String userName, String password, ICallback<String> callback) {
        FirebaseAuth.getInstance().signInWithEmailAndPassword(userName, password)
                .addOnCompleteListener((@NonNull Task<AuthResult> task) -> {
                    if(task.isSuccessful()) {
                        callback.onResult(new Result<>("user logged in"));
                    } else {
                        callback.onResult(new Result<>(task.getException()));
                    }
                });
    }

    private void addInitialUserDocument(String userName, String fullName, ICallback<String> callback){ // adds document for the first time if the user was registered
        Map<String, Object> userObject = new HashMap<>();
        userObject.put("name", fullName);
        FirebaseFirestore.getInstance().collection("users")
                .document(userName).set(userObject).addOnCompleteListener((@NonNull Task<Void> task) -> {
                if(task.isSuccessful()){
                    //when i pass ANY String the result.isSuccess()) will be true
                    callback.onResult(new Result<>("user added correctly"));
                }else {
                    callback.onResult(new Result<>(task.getException()));
                }
        });

    }


}
