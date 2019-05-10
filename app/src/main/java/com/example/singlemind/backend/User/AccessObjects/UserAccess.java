package com.example.singlemind.backend.User.AccessObjects;


import com.example.singlemind.backend.User.TransferObjects.User;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Optional;

public final class UserAccess {
    public UserAccess(FirebaseAuth mAuth){
        database = new UserAccessDatabase();
        firebase = new UserAccessFirebase(mAuth);
    }

    public Boolean addUser(User user, String password) {
        Boolean database_created_user = database.addUser(user);

        if(database_created_user) {
            Boolean firebase_created_user = firebase.addUser(user.getEmail(), password);

            if(firebase_created_user){
                return true;
            }
            else{
                Optional<User> bad_user = database.getUser(user.getUsername());
                if(bad_user.isPresent())
                    database.deleteUser(bad_user.get().getUserID());
                return false;
            }
        }
        else{
            return false;
        }
    }

    public Boolean deleteUser(int user_id) {
        return (firebase.deleteUser() && database.deleteUser(user_id));
    }

    public Optional<User> getUser(int user_id){
        return database.getUser(user_id);
    }
    public Optional<User> getUser(String username){
        return database.getUser(username);
    }

    public Boolean updateUserUsername(int user_id, String username){
        return database.updateUserUsername(user_id, username);
    }
    public Boolean updateUserPassword(String password){
        return firebase.updateUserPassword(password);
    }
    public Boolean updateUserEmail(User user, String new_email){
        String old_email = user.getEmail();
        int user_id = user.getUserID();
        Boolean database_email_updated = database.updateUserEmail(user_id, new_email);

        if(database_email_updated){
            Boolean firebase_email_updated = firebase.updateUserEmail(new_email);
            if(firebase_email_updated){
                return true;
            } else{
                database.updateUserEmail(user_id, old_email);
                return false;
            }
        } else{
            return false;
        }
    }
    public Boolean updateUserFirstName(int user_id, String first_name){
        return database.updateUserFirstName(user_id, first_name);
    }
    public Boolean updateUserLastName(int user_id, String last_name){
        return database.updateUserLastName(user_id, last_name);
    }
    public Boolean updateUserPhone(int user_id, String phone){
        return database.updateUserPhone(user_id, phone);
    }

    private final UserAccessDatabase database;
    private final UserAccessFirebase firebase;
}
