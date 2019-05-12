package com.example.singlemind.backend.Event.AccessObjects;

import com.example.singlemind.backend.Event.TransferObjects.Event;
import com.example.singlemind.backend.Event.TransferObjects.Events;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.Future;

import retrofit2.Call;
import retrofit2.Response;
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
    Future<Response> addEvent(@Body Event event);

    @DELETE("/events/{id}")
    Future<Void> deleteEvent(@Path("id") int event_id);

    @Headers("Content-Type: application/json")
    @PUT("/events/{id}")
    Future<Void> updateEvent(@Body Event event, @Path("id") int event_id);

    @GET("/events/{id}")
    Future<Events> getEventByEventID(@Path("id") int event_id);

    @GET("/events/user/{id}")
    Future<Events> getEventByUserID(@Path("id") int user_id);
}
