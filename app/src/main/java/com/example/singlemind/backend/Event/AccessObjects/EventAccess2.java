package com.example.singlemind.backend.Event.AccessObjects;

import android.util.Log;

import com.example.singlemind.backend.Event.TransferObjects.Event;
import com.example.singlemind.backend.Event.TransferObjects.Events;
import com.example.singlemind.backend.Http.HttpLogger;
import com.example.singlemind.backend.Http.HttpRequester;
import com.google.gson.Gson;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

public final class EventAccess2 {
    //public static final String URL = Resources.getSystem().getString(R.string.user_http);
    public static final String URL = "http://35.211.60.25/singlemind/events";
    //public static final String URL = "https://0a0ddb84-9589-4a60-9d92-ec8f46b570b7.mock.pstmn.io/users";
    public static final MediaType JSON
            = MediaType.get("application/json; charset=utf-8");
    //= MediaType.get("application/x-www-form-urlencoded; charset=utf-8");

    OkHttpClient client;
    HttpRequester httpRequester;
    HttpLogger logger;


    public EventAccess2(){
        client = getOkHttpClient();
        httpRequester = new HttpRequester(client);
        logger = new HttpLogger();
    }


    public Boolean addEvent(Event event){
        // The new user must be formatted to json before attaching it to the http post request.
        String data = new Gson().toJson(event);
        Log.d("http_outgoing_json", data);


        // Add the header and the body, like how it is shown in Alex's api.

        RequestBody body = RequestBody.create(JSON, data);
        Request request = new Request.Builder()
                .url(URL)
                .addHeader("Content-Type", "application/json")
                .post(body)
                .build();

        //logger.logRequest(request);


        try(Response response = httpRequester.makeRequest(request).get()){

            //logger.logResponse(response);
            Log.d("success", "successfully added user");

            return response.isSuccessful();

        } catch (Exception e){

            Log.d("http_outgoing_error", e.getMessage()+e.toString()+e.getCause()+e.getStackTrace());

            return false;

        }
    }

    public Boolean deleteEventByEventId(int event_id){
        //RequestBody body = RequestBody.create(JSON, "");
        Request request = new Request.Builder()
                .url(URL + "/" + event_id)
                .delete()
                .build();

        //logger.logRequest(request);

        try(Response response = httpRequester.makeRequest(request).get()){

            //logger.logResponse(response);

            return response.isSuccessful();

        } catch (Exception e){

            Log.d("http_outgoing_error", e.getMessage());

            return false;

        }

    }
/*
    public Optional<Events> getEvent(int event_id){
        return this.getUserField("/" + event_id);
    }

    public Optional<Events> getEventsByUserId(int user_id){
        return this.getUserField("/user/" + user_id);
    }
*/
    public Events getEvent(int event_id){
        return this.getUserField("/" + event_id);
    }

    public Events getEventsByUserId(int user_id){
        return this.getUserField("/user/" + user_id);
    }


    public Boolean updateEvent(Event event){
// The new user must be formatted to json before attaching it to the http post request.
        String data = new Gson().toJson(event);
        Log.d("http_outgoing_json", data);

        // Add the header and the body, like how it is shown in Alex's api.

        RequestBody body = RequestBody.create(JSON, data);
        Request request = new Request.Builder()
                .url(URL + "/" + event.getEventID())
                .addHeader("Content-Type", "application/json")
                .put(body)
                .build();

        //logger.logRequest(request);


        try(Response response = httpRequester.makeRequest(request).get()){

            //logger.logResponse(response);
            Log.d("success", "successfully added user");

            return response.isSuccessful();

        } catch (Exception e){

            Log.d("http_outgoing_error", e.getMessage()+e.toString()+e.getCause()+e.getStackTrace());

            return false;

        }    }
/*
    private Optional<Events> getUserField(String url_suffix){
        Request request = new Request.Builder()
                .url(URL + url_suffix)
                .get()
                .build();

        //logger.logRequest(request);

        try(Response response = httpRequester.makeRequest(request).get()){

            String json = response.body().string();

            //logger.logResponse(response);

            if(!response.isSuccessful()) throw new Exception("Failed to get a user via their id or username.");

            Events events = new Gson()
                    .fromJson(json, Events.class);
            //Log.d("http_user",users.users.get(0));

            return Optional.of(events);
            //return Optional.of(events.events.get(0));

        } catch (Exception e){

            Log.d("http_outgoing_error", e.getMessage()+ ": " + e.getCause());

            return Optional.empty();
        }
    }
*/
    private Events getUserField(String url_suffix){
        Request request = new Request.Builder()
                .url(URL + url_suffix)
                .get()
                .build();

        //logger.logRequest(request);

        try(Response response = httpRequester.makeRequest(request).get()){

            String json = response.body().string();

            //logger.logResponse(response);

            if(!response.isSuccessful()) throw new Exception("Failed to get a user via their id or username.");

            Events events = new Gson().fromJson(json, Events.class);
            //Log.d("http_user",users.users.get(0));
            if(events.events.isEmpty()) {

            }
            return events;
            //return Optional.of(events.events.get(0));

        } catch (Exception e){

            Log.d("http_outgoing_error", e.getMessage()+ ": " + e.getCause());

            return null;
        }
    }

    private OkHttpClient getOkHttpClient(){
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okClient = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();
        return okClient;
    }
}
