package com.example.singlemind.backend.User.AccessObjects;

import android.util.Log;

import com.example.singlemind.backend.User.TransferObjects.NewUser;
import com.example.singlemind.backend.User.TransferObjects.User;
import com.google.gson.Gson;

import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Optional;

public final class UserAccessDatabase {
    public UserAccessDatabase(){}


    public Boolean addUser(String URL, NewUser user){
        // The new user must be formatted to json before attaching it to the http post (I think)
        Gson gson = new Gson();
        String data = gson.toJson(user);

        // Add the header and the body, like how it is shown in Alex's api.
        Request request = Request.Post(URL)
                .addHeader("Content-Type", "application/json")
                .bodyString(data, ContentType.APPLICATION_JSON);

        String outgoing = request.toString();
        Log.d("addUser_outgoing_http", outgoing);

        try {
            int response = request.execute().returnResponse().getStatusLine().getStatusCode();

            Log.d("addUser_response_http", Integer.toString(response));

            if(response != 201)
                throw new IOException("Failed to create user. Returned code" + response);

            return true;

        } catch (Exception e){
            return false;
        }
    }
/*
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
*/
}
