package com.example.singlemind.backend.Http;

import android.util.Log;

import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;

public class HttpLogger {
    public void logRequest(Request request){
        Headers requestHeaders = request.headers();

        Log.d("http_outgoing_request", request.toString());
        for (int i = 0, size = requestHeaders.size(); i < size; i++) {
            Log.d("http_outgoing_header",(requestHeaders.name(i) + ": " + requestHeaders.value(i)));
        }
        Log.d("http_outgoing_body", request.body().toString());
    }

    public void logResponse(Response response){
        Headers responseHeaders = response.headers();

        Log.d("http_incoming_response", response.toString());
        Log.d("http_incoming_message", response.message());
        Log.d("http_incoming_code", "The response has code: " + response.code());
        for (int i = 0, size = responseHeaders.size(); i < size; i++) {
            Log.d("http_incoming_header",(responseHeaders.name(i) + ": " + responseHeaders.value(i)));
        }
        try{
            Log.d("http_incoming_body", response.body().string());
        } catch (Exception e){
            Log.d("http_incoming_error", e.getMessage());
        }
    }
}
