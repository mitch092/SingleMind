package com.example.singlemind.backend.Event.AccessObjects;

import com.example.singlemind.backend.Event.TransferObjects.Event;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface EventAccessService {
    @Headers("Content-Type: application/json")
    @POST("singlemind/events")
    Call<Void> addEvent(@Body Event event);

    @DELETE("singlemind/events/{id}")
    Call<Void> deleteEvent(@Path("id") int event_id);

    @Headers("Content-Type: application/json")
    @PUT("singlemind/events/{id}")
    Call<Void> updateEvent(@Body Event event, @Path("id") int event_id);

    @GET("singlemind/events/{id}")
    Call<Event> getEventByEventID(@Path("id") int event_id);

    @GET("singlemind/events/user/{id}")
    Call<ArrayList<Event>> getEventByUserID(@Path("id") int user_id);
}
