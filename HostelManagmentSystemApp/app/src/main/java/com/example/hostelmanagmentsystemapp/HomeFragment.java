package com.example.hostelmanagmentsystemapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class HomeFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_home_fragment, container, false);
        Button myRoomButton = (Button) v.findViewById(R.id.my_room_button);
        myRoomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to the My Room component
            }
        });

        Button attendanceButton = (Button) v.findViewById(R.id.attendance_button);
        attendanceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to the Attendance component
            }
        });

        Button myQrButton = (Button) v.findViewById(R.id.my_qr_button);
        myQrButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to the My QR component
            }
        });


        Button complainButton = (Button) v.findViewById(R.id.complain_button);
        complainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to the Complain component
            }
        });

        return v;

        //return super.onCreateView(inflater, container, savedInstanceState);
    }
}