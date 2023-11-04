package com.example.hostelmanagmentsystemapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.hostelmanagmentsystemapp.entity.Student;
import com.google.android.material.textfield.TextInputEditText;

import java.sql.Connection;

import retrofit2.Callback;
import retrofit2.Response;


public class SettingFragment extends Fragment {

    private String email=null;

    private Connection connection;
    private TextInputEditText fullname,uemail,uname,address,idNumber,mobile,password;
    private Button profileButton;
    RelativeLayout myRelativeLayout;

    TextView stLevel,complainCount,fullNamehead,RegNum;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        String UserID = sharedPreferences.getString("userID", "TG001");
        Login.getStudentApiService().getStudentDetails(UserID).enqueue(new Callback<Student>() {
            @Override
            public void onResponse(retrofit2.Call<Student> call, Response<Student> response) {
                //String responseBody = response.body(); // Get the plain text response
                Student student = response.body();
                fullNamehead.setText(student.getName());
                RegNum.setText(student.getStId());
                fullname.setText(student.getName());
                uemail.setText(student.getEmail());
                address.setText(student.getAddress_line1()+", "+student.getAddress_line2()+", "+student.getCity());
                idNumber.setText(student.getNic());
                mobile.setText(student.getMobile_no().toString());
                stLevel.setText(String.valueOf(student.getLevel()));

            }

            @Override
            public void onFailure(retrofit2.Call<Student> call, Throwable t) {
                System.out.println("Error occur");
            }
        });

        Login.getStudentApiService().getStudentComplaintLevel(UserID).enqueue(new Callback<Integer>() {
            @Override
            public void onResponse(retrofit2.Call<Integer> call, Response<Integer> response) {

                if (response.isSuccessful()){
                    Integer ccount = response.body();
                    complainCount.setText(ccount.toString());
                }else {
                    System.out.println("Response is unsuccessfull !!");
                }

            }

            @Override
            public void onFailure(retrofit2.Call<Integer> call, Throwable t) {
                System.out.println("Error occur");
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_setting_fragment, container, false);

        fullname=view.findViewById(R.id.full_name_profile);
        uemail=view.findViewById(R.id.email_profile);
        address=view.findViewById(R.id.user_address_profile);
        idNumber=view.findViewById(R.id.id_number_profile);
        mobile=view.findViewById(R.id.phone_number_profile);
        password=view.findViewById(R.id.password_profile);
        profileButton=view.findViewById(R.id.usr_profile_btn);
        myRelativeLayout = view.findViewById(R.id.mybooking);
        stLevel=view.findViewById(R.id.level_label);
        complainCount=view.findViewById(R.id.complain_label);
        fullNamehead=view.findViewById(R.id.fullname_field);
        RegNum=view.findViewById(R.id.profile_regno);
        return view;
    }
}