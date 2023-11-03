package com.example.hostelmanagmentsystemapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;



import android.content.Context;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.hostelmanagmentsystemapp.entity.Student;
import com.example.hostelmanagmentsystemapp.reotrfit.RetrofitService;
import com.example.hostelmanagmentsystemapp.reotrfit.StudentAPI;
import com.google.android.material.textfield.TextInputLayout;

import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SignUp extends AppCompatActivity {

    TextInputLayout regNum,userName,address1,address2,city,email,phonenNumber,idNumber,Password,cPassword;
    Button regBtn,regToLoginbtn;
    String selectedGender;
    int selectedLevel;
    Spinner genderSpinner,levelSpinner;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        getSupportActionBar().hide();


        genderSpinner = findViewById(R.id.gender_spinner);
        ArrayAdapter<CharSequence> genderadapter = ArrayAdapter.createFromResource(this, R.array.genders_array, android.R.layout.simple_spinner_item);
        genderadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        genderSpinner.setAdapter(genderadapter);


        levelSpinner = findViewById(R.id.level_spinner);
        ArrayAdapter<CharSequence> leveladapter = ArrayAdapter.createFromResource(this, R.array.level_array, android.R.layout.simple_spinner_item);
        leveladapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        levelSpinner.setAdapter(leveladapter);


        //Hooks to all xml element in activity sing up
        regNum=findViewById(R.id.regno);
        userName=findViewById(R.id.name);
        address1=findViewById(R.id.name);
        address2=findViewById(R.id.name);
        city=findViewById(R.id.name);
        email=findViewById(R.id.email);
        phonenNumber=findViewById(R.id.phonenumber);
        idNumber=findViewById(R.id.idnumber);
        Password=findViewById(R.id.password);
        cPassword=findViewById(R.id.confirmpassword);
        regBtn=findViewById(R.id.reg_btn);
        regToLoginbtn=findViewById(R.id.reg_login_btn);
        progressBar=findViewById(R.id.progress_bar);


        regToLoginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SignUp.this,Login.class);
                startActivity(intent);
            }
        });

        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //get all the values
                String Email=email.getEditText().getText().toString();
                String Pwd=Password.getEditText().getText().toString();
                String cPwd=cPassword.getEditText().getText().toString();

                boolean isValidated=validateData(Email,Pwd,cPwd);
                if (!isValidated){
                    return;
                }else {
                    createAccount(Email,Pwd);
                }


            }
        });

    }

    void createAccount(String email,String password){
        changeInProgress(true);

        genderSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                selectedGender = parentView.getItemAtPosition(position).toString();
                // Do something with the selected gender (e.g., store it in a variable or pass it to another function)
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Handle case where nothing is selected (if needed)
            }
        });

        levelSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                selectedLevel = Integer.parseInt(parentView.getItemAtPosition(position).toString());
                // Do something with the selected gender (e.g., store it in a variable or pass it to another function)
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Handle case where nothing is selected (if needed)
            }
        });


//        if (connection != null) {
            String regno=regNum.getEditText().getText().toString();
            String uName=userName.getEditText().getText().toString();
            String addressL1=address1.getEditText().getText().toString();
            String addressL2=address2.getEditText().getText().toString();
            String city=userName.getEditText().getText().toString();
            Long phoneNumber= Long.valueOf(Integer.parseInt(phonenNumber.getEditText().getText().toString()));
            String IDNumber=idNumber.getEditText().getText().toString();
            String cPwd=cPassword.getEditText().getText().toString();

            Student student=new Student();
            student.setStId(regno);
            student.setName(uName);
            student.setAddress_line1(addressL1);
            student.setAddress_line2(addressL2);
            student.setCity(city);
            student.setEmail(email);
            student.setMobile_no(phoneNumber);
            student.setNic(IDNumber);
            student.setLevel(selectedLevel);
            student.setGender(selectedGender);
            //student.setRoom_id(404);


        Login.getStudentApiService().save(student)
                .enqueue(new Callback<Student>() {
                    @Override
                    public void onResponse(Call<Student> call, Response<Student> response) {
                        Context context = getApplicationContext();
                        Toast.makeText(context, "Register Success!", Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onFailure(Call<Student> call, Throwable t) {
                        Toast.makeText(SignUp.this, "Registartion Failed!", Toast.LENGTH_SHORT).show();
                        Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, "Error occurred", t);
                    }
                });


    }

    void changeInProgress(boolean inProgress){
        if (inProgress){
            progressBar.setVisibility(View.VISIBLE);
            regBtn.setVisibility(View.GONE);
        }else {
            progressBar.setVisibility(View.GONE);
            regBtn.setVisibility(View.VISIBLE);
        }
    }
    boolean validateData(String testEmail,String TPassword,String TcPassword){
        //validate user enter data
        if(!Patterns.EMAIL_ADDRESS.matcher(testEmail).matches()){
            email.setError("Email is Invalid");
            return false;
        }
        if (TPassword.length()<6){
            email.setError("");
            Password.setError("Password Length Invaild");
            return false;
        }
        if (!TPassword.equals(TcPassword)){
            Password.setError("");
            cPassword.setError("Password not matched");
            return false;
        }
        return true;

    }


}