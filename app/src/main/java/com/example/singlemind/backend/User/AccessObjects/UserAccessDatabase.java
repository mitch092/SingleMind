package com.example.singlemind.backend.User.AccessObjects;

import android.util.Log;

import com.example.singlemind.backend.User.TransferObjects.NewUser;
import com.example.singlemind.backend.User.TransferObjects.User;
import com.google.gson.Gson;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Optional;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public final class UserAccessDatabase {
    public static final MediaType JSON
            = MediaType.get("application/json; charset=utf-8");
    OkHttpClient client;

    public UserAccessDatabase(){
        client = new OkHttpClient();
    }


    public Boolean addUser(String URL, NewUser user){
        // The new user must be formatted to json before attaching it to the http post (I think)
        Gson gson = new Gson();
        String data = gson.toJson(user);

        Log.d("newuser_json", data);

        // Add the header and the body, like how it is shown in Alex's api.
        RequestBody body = RequestBody.create(JSON, data);
        Request request = new Request.Builder()
                .url(URL)
                .addHeader("Content-Type", "application/json")
                .post(body)
                .build();

        String outgoing = request.toString();
        String header_str = request.headers().toString();
        String body_str = request.body().toString();
        Log.d("http_request", outgoing);
        Log.d("http_header", header_str);
        Log.d("http_body", body_str);



        try (Response response = client.newCall(request).execute()){
            int code = response.code();

            Log.d("addUser_response_http", Integer.toString(code));

            if(code != 201)
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
