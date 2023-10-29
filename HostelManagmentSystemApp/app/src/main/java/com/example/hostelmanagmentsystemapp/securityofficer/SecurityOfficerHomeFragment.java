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

import com.example.hostelmanagmentsystemapp.ComplaintManagment.ComplaintFragment;
import com.example.hostelmanagmentsystemapp.MyQr;
import com.example.hostelmanagmentsystemapp.MyRoom;
import com.example.hostelmanagmentsystemapp.R;
import com.example.hostelmanagmentsystemapp.entity.Asset;
import com.example.hostelmanagmentsystemapp.entity.Attendance;
import com.example.hostelmanagmentsystemapp.utill.AssetAdapter;
import com.example.hostelmanagmentsystemapp.utill.AttendanceAdapter;

import java.util.ArrayList;

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
                // Navigate to the Attendance component
            }
        });


        ArrayList<Attendance> attendanceList = new ArrayList<>();
        attendanceList.add(new Attendance("TG001", 100,"2023-10-29 12:25:23", "leave"));
        attendanceList.add(new Attendance("TG001", 100,"2023-10-29 12:25:23", "IN"));
        attendanceList.add(new Attendance("TG001", 100,"2023-10-29 12:25:23", "leave"));

        // Create the custom ArrayAdapter
        AttendanceAdapter adapter = new AttendanceAdapter(getContext(), R.layout.attendance_item_layout, attendanceList);

        // Find the ListView in your layout
        ListView listView = v.findViewById(R.id.listViewAttendance);

        // Set the adapter for the ListView
        listView.setAdapter(adapter);

        return v;

        //return super.onCreateView(inflater, container, savedInstanceState);
    }
}