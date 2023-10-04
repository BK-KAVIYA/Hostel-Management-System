package com.example.hostelmanagmentsystemapp.reotrfit;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class AuthInterceptor implements Interceptor {
    private String credentials;

    public AuthInterceptor(String credentials) {
        this.credentials = credentials;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request().newBuilder()
                .addHeader("Authorization", "Basic " + credentials)
                .build();
        return chain.proceed(request);
    }
}

