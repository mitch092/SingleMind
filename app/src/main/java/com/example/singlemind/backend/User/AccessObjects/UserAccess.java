package com.example.singlemind.backend.User.AccessObjects;


import com.example.singlemind.backend.User.TransferObjects.User;
import com.google.firebase.auth.FirebaseAuth;

import java.time.LocalDateTime;
import java.util.Optional;

public final class UserAccess {
    public UserAccess(){
        database = new UserAccessDatabase();
        firebase = new UserAccessFirebase();
    }
/*
    public Boolean addUser(FirebaseAuth mAuth, NewUser user, String password, String password_validate) {
        Boolean firebase_created_user = firebase.addUserFirebase(user.getEmail(),user.getPassword(), mAuth);

        if(firebase_created_user) {
            Boolean database_created_user = database.addUserDatabase(user, mAuth);

            if(database_created_user){
                return true;
            }
            else{

                return false;
            }
        }
        else{
            return false;
        }

    }

    public Boolean deleteUser(FirebaseAuth mAuth, User user) {

    }

    public Optional<User> getUserId(int user_id){}
    public Optional<User> getUserUsername(String username){}
    public Optional<User> getUserEmail(String email){}

    public Boolean updateUserUsername(User user, String username){

    }
    public Boolean updateUserPassword(FirebaseAuth mAuth, User user, String password, String validate_password){

    }
    public Boolean updateUserEmail(FirebaseAuth mAuth, User user, String email){}
    public Boolean updateUserFirstName(User user, String first_name){}
    public Boolean updateUserLastName(User user, String last_name){}
    public Boolean updateUserPhone(User user, int phone){}
    public Boolean updateUserBirthdate(User user, Optional<LocalDateTime> birthdate){}
*/



    private final UserAccessDatabase database;
    private final UserAccessFirebase firebase;
}
