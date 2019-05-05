package com.example.singlemind.backend.User.AccessObjects;

import com.example.singlemind.backend.User.TransferObjects.User;
import com.example.singlemind.backend.User.TransferObjects.UserDatabase;

import java.time.LocalDateTime;
import java.util.Optional;

public final class UserAccessDatabase {
    public UserAccessDatabase(){}


    public Boolean addUser(String username, String email,
                            String first_name, String last_name,
                            int phone, Optional<LocalDateTime> birthdate){

    }

    public Boolean deleteUser(UserDatabase user){

    }

    public Optional<UserDatabase> getUserId(int user_id){}
    public Optional<UserDatabase> getUserUsername(String username){}

    public Boolean updateUserUsername(UserDatabase user, String username){

    }
    public Boolean updateUserEmail(UserDatabase user, String email){}
    public Boolean updateUserFirstName(UserDatabase user, String first_name){}
    public Boolean updateUserLastName(UserDatabase user, String last_name){}
    public Boolean updateUserPhone(UserDatabase user, int phone){}
    public Boolean updateUserBirthdate(UserDatabase user, Optional<LocalDateTime> birthdate){}

}
