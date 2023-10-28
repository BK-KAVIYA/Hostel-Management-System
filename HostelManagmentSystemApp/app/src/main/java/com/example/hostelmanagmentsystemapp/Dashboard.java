package com.example.hostelmanagmentsystemapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
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

    Connection connection;

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

//        email= UserSingleton.getInstance().getUserEmail();
//        Avatar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                getSupportFragmentManager().beginTransaction().replace(R.id.container,settingFragment).commit();
//            }
//        });
//
//        LogoutButton=findViewById(R.id.logout_btn);
//
//        LogoutButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                FirebaseAuth.getInstance().signOut();
//                startActivity(new Intent(Dashboard.this,Login.class));
//                finish();
//            }
//        });

        bottomNavigationView =findViewById(R.id.bottom_navigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.container,homeFragment).commit();



//        try {
//            BadgeDrawable badgeDrawable=bottomNavigationView.getOrCreateBadge(R.id.notification);
//            badgeDrawable.setVisible(true);
//            DBConnection dbConnection=new DBConnection();
//            connection=dbConnection.getConnection();
//            if (connection != null) {
//
//
//                String query = "select count(id) AS row_count  FROM [slcrms].[dbo].[customer_notification] WHERE user_email=?";
//                PreparedStatement statement = connection.prepareStatement(query);
//                statement.setString(1, email);
//
//                ResultSet resultSet = statement.executeQuery();
//                int rowCount=0;
//                if (resultSet.next()) {
//                    rowCount=resultSet.getInt("row_count");
//                }
//                badgeDrawable.setNumber(rowCount);
//            }
//        }catch (Exception e){
//            System.out.println("Exception Occur :"+e.getMessage());
//        }

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