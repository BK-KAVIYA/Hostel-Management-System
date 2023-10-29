package com.example.hostelmanagmentsystemapp.AttendanceManagment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.example.hostelmanagmentsystemapp.Login;
import com.example.hostelmanagmentsystemapp.R;
import com.example.hostelmanagmentsystemapp.entity.Attendance;
import com.example.hostelmanagmentsystemapp.utill.AttendanceAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Callback;
import retrofit2.Response;

public class MyAttendance extends AppCompatActivity {

    private TextView regNo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_attendance);

        regNo=findViewById(R.id.textRegistartionNum);

        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        String UserID = sharedPreferences.getString("userID", "TG001");

        regNo.setText(UserID);
        Login.getStudentApiService().getAttendanceDetailsByStudentId(UserID).enqueue(new Callback<List<Attendance>>() {
            @Override
            public void onResponse(retrofit2.Call<List<Attendance>> call, Response<List<Attendance>> response) {
                if (response.isSuccessful()) {
                    ArrayList<Attendance> attendanceList = new ArrayList<>();
                    List<Attendance> allAttendance = response.body();
                    for (Attendance att: allAttendance) {
                        attendanceList.add(new Attendance(att.getSecurity_officer_id(), att.getRoom_id(),att.getDate_and_time(), att.getStatus()));
                    }
                    // Create the custom ArrayAdapter
                    AttendanceAdapter adapter = new AttendanceAdapter(getApplicationContext(), R.layout.attendance_item_layout, attendanceList);

                    // Find the ListView in your layout
                    ListView listView = findViewById(R.id.listViewAttendances);

                    // Set the adapter for the ListView
                    listView.setAdapter(adapter);
                } else {
                    // Handle an unsuccessful response here
                }
            }

            @Override
            public void onFailure(retrofit2.Call<List<Attendance>> call, Throwable t) {
                System.out.println("Error occur");
            }
        });
    }
}