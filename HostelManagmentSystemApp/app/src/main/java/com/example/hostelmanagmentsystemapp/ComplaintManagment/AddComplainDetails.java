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
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
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

import com.example.hostelmanagmentsystemapp.Login;
import com.example.hostelmanagmentsystemapp.R;
import com.example.hostelmanagmentsystemapp.entity.Hostel;
import com.example.hostelmanagmentsystemapp.entity.Student;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import android.os.Handler;
import android.os.Looper;

import retrofit2.Callback;
import retrofit2.Response;

public class AddComplainDetails extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private TextView assetId;
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



        assetId.setText(ID);
        studentID.setText(UserID);
        hostelName.setOnItemSelectedListener(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bitmap imageBitmap = ((BitmapDrawable) assetCameraImageView.getDrawable()).getBitmap();

                // Define the directory where you want to save the image
                File directory = new File("D:/image");

                // Check if the directory exists, and if not, create it
                if (!directory.exists()) {
                    directory.mkdirs(); // Create the directory and any necessary parent directories
                }

                // Create a file name with asset ID and timestamp
                String assetId = "404/TA/001"; // Replace with the actual asset ID
                String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());
                fileName = assetId + "_" + timeStamp + ".jpg";

                // Create a file object for the image in the directory
                File imageFile = new File(directory, fileName);

                // Use an AsyncTask to save the image in the background
                AsyncTask<Void, Void, File> saveImageTask = new AsyncTask<Void, Void, File>() {
                    @Override
                    protected File doInBackground(Void... params) {
                        File imageFile = new File(directory, fileName);
                        try {
                            FileOutputStream outStream = new FileOutputStream(imageFile);
                            imageBitmap.compress(Bitmap.CompressFormat.JPEG, 100, outStream);
                            outStream.flush();
                            outStream.close();
                            return imageFile;
                        } catch (IOException e) {
                            e.printStackTrace();
                            return null;
                        }
                    }

                    @Override
                    protected void onPostExecute(File result) {
                        if (result != null) {
                            // The image is saved, and you can update your database with the file name (result.getName()).
                            System.out.println("Image save");
                        } else {
                            // Handle the case where the image saving failed.
                            System.out.println("Image save failed");
                        }
                    }
                };

                // Execute the AsyncTask
                saveImageTask.execute();

                
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
}
