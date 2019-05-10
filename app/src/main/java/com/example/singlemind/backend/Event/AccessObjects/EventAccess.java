package com.example.singlemind.backend.Event.AccessObjects;

import com.example.singlemind.backend.Event.TransferObjects.Event;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EventAccess {
    //private static final String URL = Resources.getSystem().getString(R.string.event_http);
    private static final String URL = "http://35.211.60.25/singlemind";
    private EventAccessService service;

    public EventAccess(){

        service = new Retrofit.Builder()
                .baseUrl(URL)
                .client(getOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(EventAccessService.class);

    }

    public Call<Void> addEvent(Event event){
        return service.addEvent(event);
    }

    public Call<Void> deleteEvent(int event_id){
        return service.deleteEvent(event_id);
    }

    public Call<Void> updateEvent(Event event){ return service.updateEvent(event, event.getEventID());}

    public Call<List<Event>> getEventByEventID(int event_id){ return service.getEventByEventID(event_id);}
    public Call<List<Event>> getEventsByUserID(int user_id){return service.getEventByUserID(user_id);}


    private OkHttpClient getOkHttpClient(){
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okClient = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();
        return okClient;
    }
}
