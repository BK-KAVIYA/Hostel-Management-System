package com.example.hostelmanagmentsystemapp.securityofficer;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.hostelmanagmentsystemapp.AppData;
import com.example.hostelmanagmentsystemapp.HomeFragment;
import com.example.hostelmanagmentsystemapp.MessageFragment;
import com.example.hostelmanagmentsystemapp.NewsFragment;
import com.example.hostelmanagmentsystemapp.R;
import com.example.hostelmanagmentsystemapp.SettingFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.sql.Connection;

public class SecurityOfficerDashboard extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    SecurityOfficerHomeFragment homeFragment=new SecurityOfficerHomeFragment();
    SettingFragment settingFragment=new SettingFragment();
    NewsFragment newsFragment =new NewsFragment();
    ImageView LogoutButton,Avatar;
    String email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_security_officer_dashboard);
        getSupportActionBar().hide();


        Intent intent=getIntent();
        String Id=intent.getStringExtra("Id");

        AppData.getInstance().setId(Id);

        Avatar=findViewById(R.id.dash_avtr);

        bottomNavigationView =findViewById(R.id.bottom_navigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.container,homeFragment).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {@Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,homeFragment).commit();
                        return true;
                    case R.id.news:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, newsFragment).commit();
                        return true;
                    case R.id.setting:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,settingFragment).commit();
                        return true;
                }
                return false;
            }
        });
    }
}