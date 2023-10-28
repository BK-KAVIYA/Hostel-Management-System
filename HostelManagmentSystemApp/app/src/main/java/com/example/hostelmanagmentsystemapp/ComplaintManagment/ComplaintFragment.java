package com.example.hostelmanagmentsystemapp.ComplaintManagment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.example.hostelmanagmentsystemapp.Login;
import com.example.hostelmanagmentsystemapp.R;
import com.example.hostelmanagmentsystemapp.entity.Student;

import java.sql.Connection;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Callback;
import retrofit2.Response;

public class ComplaintFragment extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ComplainManager complainManager;
    private List<Complaint> complaintList;
    private Button Addcomplaint;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Hide the title bar (action bar)
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_complaint);



        Addcomplaint =findViewById(R.id.hmbtn);
        Addcomplaint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ComplaintFragment.this, AddComplain.class);
                startActivity(intent);
            }
        });

        recyclerView = findViewById(R.id.booking_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        complaintList = new ArrayList<>();
        String dateStr = "2023-10-16 17:00:00";
        LocalDateTime dateTime = null;
        DateTimeFormatter formatter = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            dateTime = LocalDateTime.parse(dateStr, formatter);
        }

        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        String UserID = sharedPreferences.getString("userID", "TG001");

        Login.getStudentApiService().getComplaintByStudent(UserID).enqueue(new Callback<List<Complaint>>() {
            @Override
            public void onResponse(retrofit2.Call<List<Complaint>> call, Response<List<Complaint>> response) {

                if (response.isSuccessful()) {
                    List<Complaint> complaints = response.body();

                    if (complaints != null) {
                        for (Complaint complaint : complaints) {
                            complaintList.add(new Complaint(complaint.getAsset_id(),complaint.getComplaint(),complaint.getImage(),complaint.getDate_and_time(),complaint.getStatus()));
                        }
                        complainManager = new ComplainManager(getApplicationContext(), complaintList);
                        recyclerView.setAdapter(complainManager);
                    } else {
                        System.out.println("er1");
                    }
                } else {
                    System.out.println("er2");
                }

            }

            @Override
            public void onFailure(retrofit2.Call<List<Complaint>> call, Throwable t) {
                System.out.println("Error occur"+t.getMessage());
            }
        });

//        complaintList.add(new Complaint("101/TP/006","Fan is not working","image","dateTime","Open"));
//        complaintList.add(new Complaint("101/TP/006","Fan is not working","image","dateTime","Open"));


    }
}