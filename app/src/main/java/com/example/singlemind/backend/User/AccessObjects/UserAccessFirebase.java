package com.example.singlemind.backend.User.AccessObjects;

import com.example.singlemind.backend.User.TransferObjects.User;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.concurrent.ExecutionException;

public final class UserAccessFirebase {
    FirebaseAuth mAuth;

    public UserAccessFirebase(FirebaseAuth mAuth){
        this.mAuth = mAuth;
    }

    public Boolean addUser(String email, String password){
        Task<AuthResult> task = mAuth.createUserWithEmailAndPassword(email, password);

        try {
            AuthResult result = Tasks.await(task);
            mAuth.signOut();
        } catch (ExecutionException e) {
            return false;
        } catch (InterruptedException e){
            return false;
        }

        return true;
    }

    public Boolean deleteUser(){
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

    public Boolean updateUserEmail(String new_email){
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
    public Boolean updateUserPassword(String new_password){
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
