package com.example.singlemind.backend.User;


import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class UserAccess {



    public static Boolean addUser(User user, FirebaseAuth mAuth) {
        Boolean firebase_created_user = addUserFirebase(user.getEmail(),user.getPassword(), mAuth);
        Boolean database_created_user = addUserDatabase(user, mAuth);

        if(firebase_created_user && !database_created_user){
            // Delete the firebase created  user here, because firebase worked but the database did not.
        }
        else if(!firebase_created_user && database_created_user){
            // Delete the database created user here, because the database worked but firebase did not.
        }


        return (firebase_created_user && database_created_user);
    }




    private static Boolean addUserFirebase(String email, String password, FirebaseAuth mAuth){

        class UserResult implements OnCompleteListener<AuthResult>{
            public Boolean result = false;
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                result = task.isSuccessful();
            }
        }

        UserResult Result = new UserResult();

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(Result);

        if(Result.result){
            mAuth.signOut();
        }

        return Result.result;

    }

    private static Boolean addUserDatabase(User user, FirebaseAuth mAuth){
        
    }
}
