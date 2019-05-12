package com.example.singlemind.backend.Event.AccessObjects;

import android.util.Log;

import com.example.singlemind.backend.Event.TransferObjects.Event;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EventAccess {
    //private static final String URL = Resources.getSystem().getString(R.string.event_http);
    private static final String URL = "http://35.211.60.25/";
    private EventAccessService service;

    public EventAccess(){

        service = new Retrofit.Builder()
                .baseUrl(URL)
                .client(getOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(EventAccessService.class);

    }

    public Boolean addEvent(Event event){
        try {
            return service.addEvent(event).execute().isSuccessful();
        } catch(IOException e){
            Log.d("http_IOException", "error adding events");
            return false;
        }
    }

    public Boolean deleteEvent(int event_id){
        try {
            return service.deleteEvent(event_id).execute().isSuccessful();
        } catch(IOException e){
            Log.d("http_IOException", "error deleting events");
            return false;
        }
    }

    public Boolean updateEvent(Event event){
        try {
            return service.updateEvent(event, event.getEventID()).execute().isSuccessful();
        } catch(IOException e){
            Log.d("http_IOException", "error updating events");
            return false;
        }
    }

    public Optional<Event> getEventByEventID(int event_id){
        try {
            return Optional.of(service.getEventByEventID(event_id)
                    .execute().body().getEventByEventID(event_id));
        } catch(IOException e){
            Log.d("http_IOException", "error getting events by event id");
            return Optional.empty();
        } catch(NullPointerException e){
            Log.d("http_nullptr_exception", "error getting events by event id");
            return Optional.empty();
        }
    }
    public ArrayList<Event> getEventsByUserID(int user_id){
        ArrayList<Event> evnt = new ArrayList<>();
        evnt.clear();
        try {
            for(int i = 0; i < service.getEventByUserID(user_id).execute().body().size(); i++)
                evnt.add(service.getEventByUserID(user_id).execute().body().get(i));
            return evnt;
        } catch(IOException e){
            Log.d("http_IOException", "error getting events by user id");
            return evnt;
        } catch(NullPointerException e){
            Log.d("http_nullptr_exception", "error getting events by event id");
            return evnt;
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
