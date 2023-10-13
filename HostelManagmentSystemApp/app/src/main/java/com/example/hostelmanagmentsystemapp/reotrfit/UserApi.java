package com.example.hostelmanagmentsystemapp.reotrfit;

import android.util.Base64;

import com.example.hostelmanagmentsystemapp.entity.Student;
import com.example.hostelmanagmentsystemapp.entity.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface UserApi {

    @GET("/user")
    Call<String> authentication();

    @POST("/register")
    Call<Student> save(@Body Student student);
}
