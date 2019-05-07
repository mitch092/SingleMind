package com.example.singlemind.backend.Event.AccessObjects;

import android.content.res.Resources;

import com.example.singlemind.R;
import com.example.singlemind.backend.Event.TransferObjects.NewEvent;
import com.example.singlemind.backend.Http.HttpLogger;
import com.example.singlemind.backend.Http.HttpRequester;

import java.util.Optional;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;

public class EventAccess {
    public static final String URL = Resources.getSystem().getString(R.string.event_http);
    public static final MediaType JSON
            = MediaType.get("application/json; charset=utf-8");

    OkHttpClient client;
    HttpRequester httpRequester;
    HttpLogger logger;


    public EventAccess(){
        client = new OkHttpClient();
        httpRequester = new HttpRequester(client);
        logger = new HttpLogger();
    }

    public Boolean addEvent(NewEvent event){}
    
    public Boolean deleteEvent(int event_id){}

    public Optional<NewEvent> getEventByEventID(int event_id){}
    public Optional<NewEvent> getEventByUserID(int user_id){}

    public Boolean updateEventName(int event_id){}
    public Boolean updateEventDesc(int event_id){}
    public Boolean updateEventDate(int event_id){}


}
