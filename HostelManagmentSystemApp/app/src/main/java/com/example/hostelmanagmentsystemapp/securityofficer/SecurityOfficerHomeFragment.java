package com.example.hostelmanagmentsystemapp.securityofficer;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.hostelmanagmentsystemapp.AttendanceManagment.AddAttendanceDetails;
import com.example.hostelmanagmentsystemapp.ComplaintManagment.AddComplain;
import com.example.hostelmanagmentsystemapp.ComplaintManagment.ComplaintFragment;
import com.example.hostelmanagmentsystemapp.Login;
import com.example.hostelmanagmentsystemapp.MyQr;
import com.example.hostelmanagmentsystemapp.MyRoom;
import com.example.hostelmanagmentsystemapp.R;
import com.example.hostelmanagmentsystemapp.entity.Asset;
import com.example.hostelmanagmentsystemapp.entity.Attendance;
import com.example.hostelmanagmentsystemapp.entity.Student;
import com.example.hostelmanagmentsystemapp.utill.AssetAdapter;
import com.example.hostelmanagmentsystemapp.utill.AttendanceAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Callback;
import retrofit2.Response;

public class SecurityOfficerHomeFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_security_officer_home_fragment, container, false);


        Button attendanceButton = (Button) v.findViewById(R.id.attendance_button);
        attendanceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent=new Intent(getActivity(), AddComplain.class);
               startActivity(intent);

            }
        });


        Login.getStudentApiService().getAllAttendance().enqueue(new Callback<List<Attendance>>() {
            @Override
            public void onResponse(retrofit2.Call<List<Attendance>> call, Response<List<Attendance>> response) {
                if (response.isSuccessful()) {
                    ArrayList<Attendance> attendanceList = new ArrayList<>();
                    List<Attendance> allAttendance = response.body();
                    for (Attendance att: allAttendance) {
                        attendanceList.add(new Attendance(att.getStudent_id(), att.getRoom_id(),att.getDate_and_time(), att.getStatus()));
                    }
                    // Create the custom ArrayAdapter
                    AttendanceAdapter adapter = new AttendanceAdapter(getContext(), R.layout.attendance_item_layout, attendanceList);

                    // Find the ListView in your layout
                    ListView listView = v.findViewById(R.id.listViewAttendance);

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


        return v;

        //return super.onCreateView(inflater, container, savedInstanceState);
    }
}