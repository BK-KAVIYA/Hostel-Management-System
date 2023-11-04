package com.example.hostelmanagmentsystemapp.ComplaintManagment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.Preview;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.view.PreviewView;
import androidx.core.content.ContextCompat;

import com.example.hostelmanagmentsystemapp.AttendanceManagment.AddAttendanceDetails;
import com.example.hostelmanagmentsystemapp.Login;
import com.example.hostelmanagmentsystemapp.R;
import com.example.hostelmanagmentsystemapp.entity.Hostel;
import com.example.hostelmanagmentsystemapp.entity.Student;
import com.google.common.util.concurrent.ListenableFuture;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import retrofit2.Callback;
import retrofit2.Response;

public class AddComplainDetails extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private TextView assetId;

    private TextView complaintxt;
    private PreviewView previewView;
    private ImageCapture imageCapture;
    private Executor executor = Executors.newSingleThreadExecutor();
    private Button openCamera;
    private Button retakeButton;
    private ImageView assetCameraImageView;
    private boolean isPreviewVisible = true;
    private File capturedImageFile;
    String selectedHostel=null;
    String fileName=null;

    ProgressBar progressBar;

    private EditText assetID;
    private EditText studentID;
    private EditText subWardenID;
    private EditText wardenID;
    private Spinner hostelName;
    private Button button;


    String[] hostel={"Select Hostel","Boys Hostel","Girls Hostel"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_complain_details);

        Intent intent = getIntent();
        String ID = intent.getStringExtra("assetID");

        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        String UserID = sharedPreferences.getString("userID", "TG001");

        previewView = findViewById(R.id.previewView);
        retakeButton = findViewById(R.id.retakeButton);
        assetCameraImageView = findViewById(R.id.assetcamera);
        studentID=findViewById(R.id.studemtID_txt);
        assetId=findViewById(R.id.assetID_txt);
        subWardenID=findViewById(R.id.subwarden_txt);
        wardenID=findViewById(R.id.warden_txt);
        hostelName=findViewById(R.id.hostelName);
        button=findViewById(R.id.comp_btn);
        complaintxt=findViewById(R.id.complaint_txt);
        progressBar=findViewById(R.id.progress_bar_inCom);



        assetId.setText(ID);
        studentID.setText(UserID);
        hostelName.setOnItemSelectedListener(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeInProgress(true);

// Create a SimpleDateFormat to format the date as desired
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String currentDate = dateFormat.format(new Date());

                String complaintText = complaintxt.getText().toString();
                String subWardenId = subWardenID.getText().toString();
                String wardenId = wardenID.getText().toString();

                if (TextUtils.isEmpty(complaintText) || TextUtils.isEmpty(subWardenId) || TextUtils.isEmpty(wardenId)) {
                    Toast.makeText(AddComplainDetails.this, "Please fill in all the fields.", Toast.LENGTH_SHORT).show();
                    changeInProgress(false);
                } else {
                    AsyncTask.execute(() -> {
                        // Move image compression to a background thread
                        BitmapDrawable drawable = (BitmapDrawable) assetCameraImageView.getDrawable();
                        Bitmap bitmap = drawable.getBitmap();

                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

                        // Use JPEG format with lower quality (adjust quality as needed, e.g., 10 for high compression)
                        bitmap.compress(Bitmap.CompressFormat.JPEG, 10, byteArrayOutputStream);

                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        String base64Image = Base64.encodeToString(byteArray, Base64.DEFAULT);


                        Complaint complaint = new Complaint();
                        complaint.setAsset_id(assetId.getText().toString());
                        complaint.setComplaint(complaintText);
                        complaint.setImage(base64Image);
                        complaint.setSub_warden_id(subWardenId);
                        complaint.setWarden_id(wardenId);
                        complaint.setStudent_id(studentID.getText().toString());
                        complaint.setDate_and_time(currentDate);
                        complaint.setStatus("Open");

                        // Perform network request in the background
                        Login.getStudentApiService().saveComplaint(complaint).enqueue(new Callback<Void>() {
                            @Override
                            public void onResponse(retrofit2.Call<Void> call, Response<Void> response) {
                                runOnUiThread(() -> {
                                    changeInProgress(false);
                                    Intent intent = new Intent(AddComplainDetails.this, ComplaintFragment.class);
                                    Toast.makeText(AddComplainDetails.this, "Complaint is Added!!", Toast.LENGTH_SHORT).show();
                                    startActivity(intent);
                                    finish();
                                });
                            }

                            @Override
                            public void onFailure(retrofit2.Call<Void> call, Throwable t) {
                                runOnUiThread(() -> {
                                    changeInProgress(false);
                                    Toast.makeText(AddComplainDetails.this, "Error Occurred!!", Toast.LENGTH_SHORT).show();
                                });
                            }
                        });
                    });
                }



            }
        });


        ArrayAdapter ad
                = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                hostel);
        ad.setDropDownViewResource(
                android.R.layout
                        .simple_spinner_dropdown_item);
        hostelName.setAdapter(ad);

        ListenableFuture<ProcessCameraProvider> cameraProviderFuture = ProcessCameraProvider.getInstance(this);

        cameraProviderFuture.addListener(() -> {
            try {
                ProcessCameraProvider cameraProvider = cameraProviderFuture.get();
                bindPreview(cameraProvider);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, ContextCompat.getMainExecutor(this));
    }

    private void bindPreview(ProcessCameraProvider cameraProvider) {
        Preview preview = new Preview.Builder().build();
        preview.setSurfaceProvider(previewView.getSurfaceProvider());

        CameraSelector cameraSelector = new CameraSelector.Builder()
                .requireLensFacing(CameraSelector.LENS_FACING_BACK)
                .build();

        imageCapture = new ImageCapture.Builder()
                .setTargetRotation(getWindowManager().getDefaultDisplay().getRotation())
                .build();

        cameraProvider.unbindAll();
        cameraProvider.bindToLifecycle(this, cameraSelector, preview, imageCapture);
    }

    public void captureImage(View view) {
        File file = new File(getExternalMediaDirs()[0], "image.jpg");

        ImageCapture.OutputFileOptions outputFileOptions =
                new ImageCapture.OutputFileOptions.Builder(file).build();

        imageCapture.takePicture(outputFileOptions, executor, new ImageCapture.OnImageSavedCallback() {
            @Override
            public void onImageSaved(@Nullable ImageCapture.OutputFileResults outputFileResults) {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        // Update UI elements on the main thread
                        assetCameraImageView.setImageURI(Uri.fromFile(file));
                        previewView.setVisibility(View.INVISIBLE);
                        isPreviewVisible = false;
                        retakeButton.setVisibility(View.VISIBLE);
                    }
                });
            }

            @Override
            public void onError(@Nullable ImageCaptureException exception) {
                // Handle error
            }
        });
    }

    public void retakeImage(View view) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                // Switch back to the camera preview
                previewView.setVisibility(View.VISIBLE);
                isPreviewVisible = true;

                // Hide the captured image in the ImageView
                assetCameraImageView.setImageDrawable(null);

                // Hide the "Retake" button
                retakeButton.setVisibility(View.GONE);
            }
        });
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        ((TextView) adapterView.getChildAt(0)).setTextColor(Color.BLACK);
        // make toastof name of course
        // which is selected in spinner
        if (adapterView.getId() == R.id.hostelName) {
            // Handle Spinner 1 selection
            selectedHostel = hostel[i];
            Login.getStudentApiService().getHostelInformationByName(selectedHostel).enqueue(new Callback<Hostel>() {
                @Override
                public void onResponse(retrofit2.Call<Hostel> call, Response<Hostel> response) {

                    Hostel hostel1 = response.body();
                    subWardenID.setText(hostel1.getSub_warden_id());
                    wardenID.setText(hostel1.getWarden_id());

                }

                @Override
                public void onFailure(retrofit2.Call<Hostel> call, Throwable t) {
                    System.out.println("Error occur");
                }
            });


        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    void changeInProgress(boolean inProgress){
        if (inProgress){
            progressBar.setVisibility(View.VISIBLE);
            button.setVisibility(View.GONE);
        }else {
            progressBar.setVisibility(View.GONE);
            button.setVisibility(View.VISIBLE);
        }
    }
}
