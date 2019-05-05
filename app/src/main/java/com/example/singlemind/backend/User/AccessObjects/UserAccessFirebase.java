package com.example.singlemind.backend.User.AccessObjects;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.concurrent.ExecutionException;

public final class UserAccessFirebase {
    public UserAccessFirebase(){}

    public Boolean addUser(FirebaseAuth mAuth, String email, String password){
        Task<AuthResult> task = mAuth.signInWithEmailAndPassword(email, password);

        try {
            AuthResult result = Tasks.await(task);
        } catch (ExecutionException e) {
            return false;
        } catch (InterruptedException e){
            return false;
        }

        return true;
    }

    public Boolean deleteUser(FirebaseAuth mAuth){
        try {
            Task<Void> task = mAuth.getCurrentUser().delete();
            Tasks.await(task);
        } catch (ExecutionException e) {
            return false;
        } catch (InterruptedException e){
            return false;
        } catch (NullPointerException e){
            return false;
        }

        return true;

    }

    public Boolean updateUserEmail(FirebaseAuth mAuth, String new_email){
        try {
            Task<Void> task = mAuth.getCurrentUser().updateEmail(new_email);
            Tasks.await(task);
        } catch (ExecutionException e) {
            return false;
        } catch (InterruptedException e){
            return false;
        } catch (NullPointerException e){
            return false;
        }

        return true;
    }
    public Boolean updateUserPassword(FirebaseAuth mAuth, String new_password, String validate_password){
        if(new_password == validate_password)
            return false;

        try {
            Task<Void> task = mAuth.getCurrentUser().updatePassword(new_password);
            Tasks.await(task);
        } catch (ExecutionException e) {
            return false;
        } catch (InterruptedException e){
            return false;
        } catch (NullPointerException e){
            return false;
        }

        return true;
    }

}
