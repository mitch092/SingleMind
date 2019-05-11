package com.example.singlemind.backend.User.AccessObjects;


import com.example.singlemind.backend.User.TransferObjects.User;

import java.util.Optional;

public final class UserAccess {
    public UserAccess(){
        database = new UserAccessDatabase();

    }

    public Boolean addUser(User user, String password) {

        return (database.addUser(user));
        //Boolean database_created_user = database.addUser(user);
/*
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
        */
    }

    public Boolean deleteUser(int user_id) {
        return (database.deleteUser(user_id));
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
        return database.updateUserPassword(password);
    }

    public Boolean updateUserEmail(User user, String new_email){
        String old_email = user.getEmail();
        int user_id = user.getUserID();
        Boolean database_email_updated = database.updateUserEmail(user_id, new_email);
        return true;
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
}
