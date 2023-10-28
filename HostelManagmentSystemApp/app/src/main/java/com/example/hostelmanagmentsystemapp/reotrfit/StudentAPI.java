package com.example.hostelmanagmentsystemapp.reotrfit;

import com.example.hostelmanagmentsystemapp.ComplaintManagment.Complaint;
import com.example.hostelmanagmentsystemapp.entity.Hostel;
import com.example.hostelmanagmentsystemapp.entity.Student;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface StudentAPI {

    @GET("/student/login")
    Call<Object> authentication();

    @POST("/register")
    Call<Student> save(@Body Student student);

    @GET("/student/findstudents/{registrationNumber}")
    Call<Student> getStudentDetails(@Path("registrationNumber") String studentID);

    @GET("/complaint/findscompaints/{registrationNumber}")
    Call<List<Complaint>> getComplaintByStudent(@Path("registrationNumber") String studentID);

    @GET("/hostels/{hostelName}")
    Call<Hostel> getHostelInformationByName(@Path("hostelName") String hostelName);
}
