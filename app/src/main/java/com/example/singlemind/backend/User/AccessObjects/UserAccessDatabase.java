package com.example.singlemind.backend.User.AccessObjects;

import android.content.res.Resources;
import android.util.Log;

import com.example.singlemind.R;
import com.example.singlemind.backend.GsonDeserializers.LocalDateTimeDeserializer;
import com.example.singlemind.backend.Http.HttpLogger;
import com.example.singlemind.backend.Http.HttpRequester;
import com.example.singlemind.backend.User.TransferObjects.NewUser;
import com.example.singlemind.backend.User.TransferObjects.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.concurrent.Future;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public final class UserAccessDatabase {
    public static final String URL = Resources.getSystem().getString(R.string.user_http);
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


    public Boolean addUser(NewUser user){
        // The new user must be formatted to json before attaching it to the http post request.
        String data = new Gson().toJson(user);


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

    public Boolean deleteUser(int user_id){
        //RequestBody body = RequestBody.create(JSON, "");
        Request request = new Request.Builder()
                .url(URL + "/" + user_id)
                .delete()
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

    public Optional<User> getUser(int user_id){
        return this.getUserField("/" + user_id);
    }

    public Optional<User> getUser(String username){
        return this.getUserField("?username=" + username);
    }

    public Boolean updateUserUsername(int user_id, String username){

        return this.updateUserField(user_id, "Username", username);
    }

    public Boolean updateUserEmail(int user_id, String email){
        return this.updateUserField(user_id, "Email", email);
    }

    public Boolean updateUserFirstName(int user_id, String first_name){
        return this.updateUserField(user_id, "FirstName", first_name);
    }

    public Boolean updateUserLastName(int user_id, String last_name){
        return this.updateUserField(user_id, "LastName", last_name);
    }

    public Boolean updateUserPhone(int user_id, String phone){
        return this.updateUserField(user_id, "PhoneNumber", phone);
    }

    private Optional<User> getUserField(String url_suffix){
        Request request = new Request.Builder()
                .url(URL + url_suffix)
                .get()
                .build();

        logger.logRequest(request);

        try(Response response = httpRequester.makeRequest(request).get()){

            logger.logResponse(response);

            if(!response.isSuccessful()) throw new Exception("Failed to get a user via their id or username.");

            User user = new GsonBuilder()
                    .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeDeserializer())
                    .create()
                    .fromJson(response.body().string(), User.class);


            return Optional.of(user);

        } catch (Exception e){

            Log.d("http_outgoing_error", e.getMessage());

            return Optional.empty();

        }
    }

    private Boolean updateUserField(int user_id, String field, String new_value){
        RequestBody form = new FormBody.Builder()
                .add(field, new_value)
                .build();


        Request request = new Request.Builder()
                .url(URL + "/" + user_id)
                .post(form)
                .build();

        logger.logRequest(request);

        try(Response response = httpRequester.makeRequest(request).get()){

            logger.logResponse(response);

            if(!response.isSuccessful()) throw new Exception("Failed to get a user via their username.");

            return true;

        } catch (Exception e){

            Log.d("http_outgoing_error", e.getMessage());

            return false;

        }
    }
}
