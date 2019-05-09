package com.example.singlemind.backend.Event.AccessObjects;

import com.example.singlemind.backend.Event.TransferObjects.Event;
import com.example.singlemind.backend.Event.TransferObjects.NewEvent;
import com.example.singlemind.backend.User.TransferObjects.NewUser;

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
    @POST("")
    Call<Event> addEvent(@Body NewEvent event);

    @DELETE("/{id}")
    Call<Void> deleteEvent(@Path("id") int event_id);

    @Headers("Content-Type: application/json")
    @PUT("/{id}")
    Call<Event> updateEvent(@Body Event event, @Path("id") int event_id);

    @GET("/{id}")
    Call<Optional<Event>> getEventByEventID(@Path("id") int event_id);

    @GET("/user/{id}")
    Call<List<Event>> getEventByUserID(@Path("id") int user_id);
}
