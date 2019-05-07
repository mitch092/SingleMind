package com.example.singlemind.backend.Http;

import java.util.concurrent.Future;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HttpRequester {
    private OkHttpClient client;

    public HttpRequester(OkHttpClient client){
        this.client = client;
    }

    public Future<Response> makeRequest(Request request){
        Call call = client.newCall(request);

        OkHttpResponseFuture result = new OkHttpResponseFuture();

        call.enqueue(result);

        return result.future;
    }

}
