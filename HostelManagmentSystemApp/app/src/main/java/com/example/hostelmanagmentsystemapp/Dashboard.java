package com.example.hostelmanagmentsystemapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.sql.Connection;

public class Dashboard extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    HomeFragment homeFragment=new HomeFragment();
    SettingFragment settingFragment=new SettingFragment();
    NewsFragment newsFragment =new NewsFragment();
    MessageFragment messageFragment=new MessageFragment();
    ImageView LogoutButton,Avatar;
    String email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        getSupportActionBar().hide();


        Intent intent=getIntent();
        String Id=intent.getStringExtra("Id");

        AppData.getInstance().setId(Id);

        Avatar=findViewById(R.id.dash_avtr);
        LogoutButton=findViewById(R.id.logout_btn);

        LogoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        Avatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container,settingFragment).commit();
            }
        });

        bottomNavigationView =findViewById(R.id.bottom_navigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.container,homeFragment).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {

            @Override
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