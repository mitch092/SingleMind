package com.example.singlemind.backend.User.AccessObjects;

import android.content.res.Resources;
import android.util.Log;

import com.example.singlemind.R;
import com.example.singlemind.backend.Http.HttpLogger;
import com.example.singlemind.backend.Http.HttpRequester;
import com.example.singlemind.backend.User.TransferObjects.NewUser;
import com.example.singlemind.backend.User.TransferObjects.User;
import com.google.gson.Gson;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.concurrent.Future;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public final class UserAccessDatabase {
    public static final MediaType JSON
            = MediaType.get("application/json; charset=utf-8");
    OkHttpClient client;
    HttpRequester httpRequester;
    HttpLogger logger;


    public UserAccessDatabase(){
        client = new OkHttpClient();
        httpRequester = new HttpRequester(client);
        logger = new HttpLogger();
    }


    public Boolean addUser(String URL, NewUser user){
        // The new user must be formatted to json before attaching it to the http post (I think)
        Gson gson = new Gson();
        String data = gson.toJson(user);

        Log.d("http_json_user", data);

        // Add the header and the body, like how it is shown in Alex's api.
        RequestBody body = RequestBody.create(JSON, data);
        Request request = new Request.Builder()
                .url(URL)
                .addHeader("Content-Type", "application/json")
                .post(body)
                .build();

        logger.logRequest(request);


        try(Response response = httpRequester.makeRequest(request).get()){

            logger.logResponse(response);

            return response.isSuccessful();
        } catch (Exception e){
            
            Log.d("http_outgoing_error", e.getMessage());

            return false;
        }
    }
/*
    public Boolean deleteUser(User user){

    }

    public Optional<User> getUserId(int user_id){}
    public Optional<User> getUserUsername(String username){}

    public Boolean updateUserUsername(User user, String username){

    }
    public Boolean updateUserEmail(User user, String email){}
    public Boolean updateUserFirstName(User user, String first_name){}
    public Boolean updateUserLastName(User user, String last_name){}
    public Boolean updateUserPhone(User user, int phone){}
*/
}
