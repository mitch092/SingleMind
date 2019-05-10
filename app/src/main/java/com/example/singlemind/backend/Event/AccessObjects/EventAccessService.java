package com.example.singlemind.backend.Event.AccessObjects;

import com.example.singlemind.backend.Event.TransferObjects.Event;

import java.util.List;
import java.util.Optional;

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
    @POST("/events")
    Call<Void> addEvent(@Body Event event);

    @DELETE("/events/{id}")
    Call<Void> deleteEvent(@Path("id") int event_id);

    @Headers("Content-Type: application/json")
    @PUT("/events/{id}")
    Call<Void> updateEvent(@Body Event event, @Path("id") int event_id);

    @GET("/events/{id}")
    Call<List<Event>> getEventByEventID(@Path("id") int event_id);

    @GET("/events/user/{id}")
    Call<List<Event>> getEventByUserID(@Path("id") int user_id);
}