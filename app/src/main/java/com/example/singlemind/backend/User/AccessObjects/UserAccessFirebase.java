package com.example.singlemind.backend.User.AccessObjects;

import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.singlemind.Globals;
import com.example.singlemind.MainActivity;
import com.example.singlemind.SignupActivity;
import com.example.singlemind.backend.User.TransferObjects.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.concurrent.ExecutionException;

public final class UserAccessFirebase {
    FirebaseAuth mAuth;

    public UserAccessFirebase(FirebaseAuth mAuth){
        this.mAuth = mAuth;
    }

    public boolean addUser(String email, String password){

        Task<AuthResult> task = mAuth.createUserWithEmailAndPassword(email, password);

        try {
            AuthResult result = Tasks.await(task);
        } catch (Exception e) {
            Log.d("http_firebase", "Firebase is not working.");
        }

        return true;/*
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    // Sign in success, update UI with the signed-in user's information

                }

                } else {
                    // If sign in fails, display a message to the user.

                }

            }
        });*/
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
