package com.example.hostelmanagmentsystemapp.reotrfit;

import com.example.hostelmanagmentsystemapp.ComplaintManagment.Complaint;
import com.example.hostelmanagmentsystemapp.entity.Asset;
import com.example.hostelmanagmentsystemapp.entity.Attendance;
import com.example.hostelmanagmentsystemapp.entity.Hostel;
import com.example.hostelmanagmentsystemapp.entity.Notice;
import com.example.hostelmanagmentsystemapp.entity.Student;

import java.util.List;
import java.util.Optional;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

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

    @GET("/status/currentStatus/{studentId}")
    Call<String> getCurrentStatus(@Path("studentId") String studentId);

    @GET("/status/roomIdByStudentId/{studentId}")
    Call<Integer> getRoomIdByStudentId(@Path("studentId") String studentId);


    @POST("/attendance/callAddAttendanceRecord")
    Call<ResponseBody> callAddAttendanceRecord(
            @Query("officerId") String officerId,
            @Query("studentId") String studentId
    );

    @GET("/attendance/getAllAttendance")
    Call<List<Attendance>> getAllAttendance();

    @GET("/assets/getByRoomId/{roomId}")
    Call<List<Asset>> getAssetsByRoomId(@Path("roomId") int roomId);

    @GET("/attendance/getByStudentId/{studentId}")
    Call<List<Attendance>> getAttendanceDetailsByStudentId(@Path("studentId") String studentId);


    //add complaint to database
    @POST("/complaint/save")
    Call<Void> saveComplaint(@Body Complaint complaint);

    //Get News By level
    @GET("/notices/getByLevel/{level}")
    Call<List<Notice>> getNoticesByLevel(@Path("level") int level);

    //GET Student Level
    @GET("/student/studentLevel/{studentId}")
    Call<Integer> getStudentLevel(@Path("studentId") String studentId);
}
