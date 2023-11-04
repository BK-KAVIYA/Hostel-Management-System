package com.example.hostelmanagmentsystemapp.AttendanceManagment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.Preview;
import androidx.camera.core.TorchState;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.view.PreviewView;
import androidx.core.content.ContextCompat;

import com.example.hostelmanagmentsystemapp.ComplaintManagment.AddComplain;
import com.example.hostelmanagmentsystemapp.Login;
import com.example.hostelmanagmentsystemapp.R;
import com.example.hostelmanagmentsystemapp.entity.Hostel;
import com.example.hostelmanagmentsystemapp.entity.Student;
import com.example.hostelmanagmentsystemapp.securityofficer.SecurityOfficerDashboard;
import com.example.hostelmanagmentsystemapp.securityofficer.SecurityOfficerHomeFragment;
import com.google.common.util.concurrent.ListenableFuture;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import okhttp3.ResponseBody;
import retrofit2.Callback;
import retrofit2.Response;

public class AddAttendanceDetails extends AppCompatActivity {

    private Executor executor = Executors.newSingleThreadExecutor();
    private EditText dateandtime;
    private EditText studentID;
    private EditText officertID;
    private EditText roomid;

    private EditText status;
    private Button button;

    String formattedDateTime=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_attendance_details);

        Intent intent = getIntent();
        String ID = intent.getStringExtra("studentID");

        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        String UserID = sharedPreferences.getString("userID", "TG001");

        studentID=findViewById(R.id.studentID_txt);
        dateandtime=findViewById(R.id.date_txt);
        officertID=findViewById(R.id.officertID_txt);
        status=findViewById(R.id.status_txt);
        roomid=findViewById(R.id.roomid_txt);
        button=findViewById(R.id.att_btn);



        studentID.setText(ID);
        officertID.setText(UserID);

        // Create a formatter to specify the desired date and time format
        DateTimeFormatter formatter = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime currentDateTime = LocalDateTime.now();
            formattedDateTime = currentDateTime.format(formatter);
        }
        dateandtime.setText(formattedDateTime);


        Login.getStudentApiService().getCurrentStatus(ID).enqueue(new Callback<String>() {
            @Override
            public void onResponse(retrofit2.Call<String> call, Response<String> response) {
                if (response.isSuccessful()) {
                    String st_status = response.body();
                    String studenStatus=null;
                    if (st_status.equals("In")){
                        studenStatus="Leave";
                    } else if (st_status.equals("leave")) {
                        studenStatus="Leave";
                    }else{
                        studenStatus="warning";
                    }
                    status.setText(studenStatus);
                } else {
                    System.out.println("It is unsucess!!");
                }

            }

            @Override
            public void onFailure(retrofit2.Call<String> call, Throwable t) {
                System.out.println("Error occur");
            }
        });

        Login.getStudentApiService().getRoomIdByStudentId(ID).enqueue(new Callback<Integer>() {
            @Override
            public void onResponse(retrofit2.Call<Integer> call, Response<Integer> response) {
                if (response.isSuccessful()) {
                    int room_id = response.body();
                    roomid.setText(String.valueOf(room_id));
                } else {
                    System.out.println("It is unsucess!!");
                }

            }

            @Override
            public void onFailure(retrofit2.Call<Integer> call, Throwable t) {
                System.out.println("Error occur");
            }
        });

        String studentIDText = studentID.getText().toString();
        String dateandtimeText = dateandtime.getText().toString();
        String officertIDText = officertID.getText().toString();
        String statusText = status.getText().toString();
        String roomidText = roomid.getText().toString();

        if (!studentIDText.isEmpty() && !dateandtimeText.isEmpty() && !officertIDText.isEmpty() && !statusText.isEmpty() && !roomidText.isEmpty()) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Login.getStudentApiService().callAddAttendanceRecord(ID,UserID).enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(retrofit2.Call<ResponseBody> call, Response<ResponseBody> response) {
                            if (response.isSuccessful()) {
                                Intent intent=new Intent(AddAttendanceDetails.this, SecurityOfficerDashboard.class);
                                startActivity(intent);
                                Toast.makeText(AddAttendanceDetails.this, "Attendance is added!!", Toast.LENGTH_LONG).show();
                            } else {
                                Toast.makeText(AddAttendanceDetails.this, "Error Occur", Toast.LENGTH_LONG).show();
                            }

                        }

                        @Override
                        public void onFailure(retrofit2.Call<ResponseBody> call, Throwable t) {
                            System.out.println("Error occur");
                        }
                    });
                }

            });
        } else {
            Toast.makeText(AddAttendanceDetails.this, "Somthing went wrong!!", Toast.LENGTH_LONG).show();
        }



    }

}


