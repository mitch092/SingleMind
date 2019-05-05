package com.example.singlemind.backend.User.AccessObjects;

import com.example.singlemind.backend.User.TransferObjects.NewUser;
import com.example.singlemind.backend.User.TransferObjects.User;
import com.google.gson.Gson;

import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Optional;

public final class UserAccessDatabase {
    public UserAccessDatabase(){}


    public Boolean addUser(String URL, NewUser user){
        try {
            int response = Request.Post(URL).addHeader("Content-Type", "application/json")
                    .bodyForm(Form.form()
                            .add("Username", user.getUsername())
                            .add("LastName", user.getLastName())
                            .add("FirstName", user.getFirstName())
                            .add("Email", user.getEmail())
                            .add("PhoneNumber", Integer.toString(user.getPhone())).build())
                    .execute().returnResponse().getStatusLine().getStatusCode();

            if(response != 201)
                throw new IOException("Failed to create user. Returned code" + response);

            return true;

        } catch (Exception e){
            return false;
        }
    }

    public Boolean deleteUser(User user){

    }

    public Optional<User> getUserId(int user_id){}
    public Optional<User> getUserUsername(String username){}
    public Optional<User> getUserEmail(String email){}

    public Boolean updateUserUsername(User user, String username){

    }
    public Boolean updateUserEmail(User user, String email){}
    public Boolean updateUserFirstName(User user, String first_name){}
    public Boolean updateUserLastName(User user, String last_name){}
    public Boolean updateUserPhone(User user, int phone){}
    public Boolean updateUserBirthdate(User user, Optional<LocalDateTime> birthdate){}

}
