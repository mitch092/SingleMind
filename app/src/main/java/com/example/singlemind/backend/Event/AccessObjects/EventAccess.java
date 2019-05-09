package com.example.singlemind.backend.Event.AccessObjects;

import android.content.res.Resources;

import com.example.singlemind.R;
import com.example.singlemind.backend.Event.TransferObjects.Event;
import com.example.singlemind.backend.Event.TransferObjects.NewEvent;
import com.example.singlemind.backend.Http.HttpLogger;
import com.example.singlemind.backend.Http.HttpRequester;

import java.util.List;
import java.util.Optional;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EventAccess {
    private static final String URL = Resources.getSystem().getString(R.string.event_http);
    private EventAccessService service;



    public EventAccess(){
        service = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(EventAccessService.class);

    }

    public Call<Event> addEvent(NewEvent event){
        return service.addEvent(event);
    }

    public Call<Void> deleteEvent(int event_id){
        return service.deleteEvent(event_id);
    }

    public Call<Event> updateEvent(Event event){ return service.updateEvent(event, event.getEventID());}

    public Call<Optional<Event>> getEventByEventID(int event_id){ return service.getEventByEventID(event_id);}
    public Call<List<Event>> getEventsByUserID(int user_id){return service.getEventByUserID(user_id);}
}
