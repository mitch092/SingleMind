package com.example.singlemind.backend.User.AccessObjects;

import com.example.singlemind.backend.User.TransferObjects.UserFirebase;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Optional;
import java.util.concurrent.ExecutionException;

public final class UserAccessFirebase {
    public UserAccessFirebase(FirebaseAuth auth){
        mAuth = auth;
    }

    public Boolean addUser(UserFirebase user){
        Task<AuthResult> task = mAuth.signInWithEmailAndPassword(email, password);

        try {
            AuthResult result = Tasks.await(task);
        } catch (ExecutionException e) {
            return false;
        } catch (InterruptedException e){
            return false;
        }

        mAuth.signOut();

        return true;
    }

    public Boolean deleteUser(UserFirebase user){

    }

    public Optional<String> getUserPassword(String email){}

    public Boolean updateUserEmail(UserFirebase user, String new_email){

    }
    public Boolean updateUserPassword(UserFirebase user, String new_password,
                                      String validate_password){

    }




    private final FirebaseAuth mAuth;
}
