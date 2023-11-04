package com.example.hostelmanagmentsystemapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Base64;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hostelmanagmentsystemapp.reotrfit.RetrofitClient;
import com.example.hostelmanagmentsystemapp.reotrfit.StudentAPI;
import com.example.hostelmanagmentsystemapp.securityofficer.SecurityOfficerDashboard;
import com.google.android.material.textfield.TextInputLayout;


import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Login extends AppCompatActivity {

    Button callSingup,login_btn;
    ImageView image;
    TextView logoText,sloganText;
    ProgressBar progressBar;
    TextInputLayout email,password;

    static String base64Credentials;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        //Hooks
        callSingup= findViewById(R.id.singup_screen);
        image= findViewById(R.id.LogiImage);
        logoText= findViewById(R.id.logo_name);
        sloganText= findViewById(R.id.slogo_name);
        login_btn= findViewById(R.id.login_btn);
        email=findViewById(R.id.username);
        password=findViewById(R.id.password);
        progressBar=findViewById(R.id.progress_bar);

        callSingup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Login.this,SignUp.class);

                Pair[] pairs=new Pair[7];

                pairs[0]=new Pair<View,String>(image,"logo_image");
                pairs[1]=new Pair<View,String>(logoText,"logo_text");
                pairs[2]=new Pair<View,String>(sloganText,"logo_desc");
                pairs[3]=new Pair<View,String>(email,"user_tran");
                pairs[4]=new Pair<View,String>(password,"password_tran");
                pairs[5]=new Pair<View,String>(login_btn,"login_tran");
                pairs[6]=new Pair<View,String>(callSingup,"button_tran");

                ActivityOptions options=ActivityOptions.makeSceneTransitionAnimation(Login.this,pairs);
                startActivity(intent,options.toBundle());

            }
        });

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Email=email.getEditText().getText().toString();
                String Password=password.getEditText().getText().toString();

                boolean isValidated=validateData(Email,Password);
                if (!isValidated){
                    return;
                }else {
                    changeInProgress(true);
                    loginAccount(Email,Password);
                }
            }


        });

    }


void loginAccount(String uname, String upassword) {

    String username = uname;
    String password = upassword;

    // Combine the username and password in the format "username:password"
    String credentials = username + ":" + password;

    // Encode the credentials in Base64
    base64Credentials = Base64.encodeToString(credentials.getBytes(), Base64.NO_WRAP);

    // Create a Retrofit instance with the Base64-encoded credentials
//    Retrofit retrofit = RetrofitClient.getClient(base64Credentials);
//    StudentAPI apiService = retrofit.create(StudentAPI.class);


    Login.getStudentApiService().authentication().enqueue(new Callback<Object>() {
        @Override
        public void onResponse(Call<Object> call, Response<Object> response) {
            if (response.isSuccessful()) {
                // Handle a successful response
                changeInProgress(false);

                SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("userID", username);
                editor.apply();
                if (username.startsWith("TG")){
                    startActivity(new Intent(Login.this,Dashboard.class).putExtra("Id",username));
                } else if (username.startsWith("S")) {
                    startActivity(new Intent(Login.this, SecurityOfficerDashboard.class).putExtra("Id",username));
                }else {
                    System.out.println("Invalid User");
                }


            } else {
                changeInProgress(false);
                Context context = getApplicationContext();
                Toast.makeText(context, "password or email incorrect!", Toast.LENGTH_SHORT).show();
            }
        }


        @Override
        public void onFailure(Call<Object> call, Throwable t) {
            changeInProgress(false);
            Toast.makeText(Login.this, "Authentication failed due to a network error!", Toast.LENGTH_SHORT).show();
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, "Error occurred", t);
        }
    });



    }

    void changeInProgress(boolean inProgress){
        if (inProgress){
            progressBar.setVisibility(View.VISIBLE);
            login_btn.setVisibility(View.GONE);
        }else {
            progressBar.setVisibility(View.GONE);
            login_btn.setVisibility(View.VISIBLE);
        }
    }
    boolean validateData(String testEmail,String TPassword){
        //validate user enter data
//        if(!Patterns.EMAIL_ADDRESS.matcher(testEmail).matches()){
//            email.setError("Email is Invalid");
//            return false;
//        }
//        if (TPassword.length()<6){
//            email.setError("");
//            password.setError("Password Length Invaild");
//            return false;
//        }
        return true;

    }

    public static StudentAPI getStudentApiService() {
        Retrofit retrofit = RetrofitClient.getClient(base64Credentials);
        //StudentAPI apiService = retrofit.create(StudentAPI.class);
        return retrofit.create(StudentAPI.class);
    }

}
