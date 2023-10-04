package com.example.hostelmanagmentsystemapp.reotrfit;

import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {
    private Retrofit retrofit;

    public RetrofitService() {
        initializeRetrofit();
    }

    private void initializeRetrofit() {
//        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
//        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//
//        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
//        retrofit = new Retrofit.Builder()
//                .baseUrl("http://192.168.8.100:8090")
//                .addConverterFactory(GsonConverterFactory.create(new Gson()))
//                .client(okHttpClient)
//                .build();
    }


    public Retrofit getRetrofit() {
        return retrofit;
    }
}
