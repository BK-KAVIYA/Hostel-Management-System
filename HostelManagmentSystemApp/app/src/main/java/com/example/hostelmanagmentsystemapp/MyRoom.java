package com.example.hostelmanagmentsystemapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.hostelmanagmentsystemapp.entity.Asset;
import com.example.hostelmanagmentsystemapp.utill.AssetAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Callback;
import retrofit2.Response;

public class MyRoom extends AppCompatActivity {

    private TextView room;

    int room_id=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_room);

        room=findViewById(R.id.textRoomNumber);

        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        String UserID = sharedPreferences.getString("userID", "TG001");

        Login.getStudentApiService().getRoomIdByStudentId(UserID).enqueue(new Callback<Integer>() {
            @Override
            public void onResponse(retrofit2.Call<Integer> call, Response<Integer> response) {
                if (response.isSuccessful()) {
                    room_id = response.body();
                    room.setText(String.valueOf(room_id));
                    Login.getStudentApiService().getAssetsByRoomId(room_id).enqueue(new Callback<List<Asset>>() {
                        @Override
                        public void onResponse(retrofit2.Call<List<Asset>> call, Response<List<Asset>> response) {
                            if (response.isSuccessful()) {

                                List<Asset> assets = response.body();
                                ArrayList<Asset> assetList = new ArrayList<>();
                                for (Asset ass: assets ) {
                                    assetList.add(new Asset(ass.getAsset_id(), ass.getCategory(), ass.getStatus()));
                                }
                                // Create the custom ArrayAdapter
                                AssetAdapter adapter = new AssetAdapter(getApplicationContext(), R.layout.list_item_layout, assetList);

                                // Find the ListView in your layout
                                ListView listView = findViewById(R.id.listViewAssets);

                                // Set the adapter for the ListView
                                listView.setAdapter(adapter);
                            } else {
                                System.out.println("It is unsucess!!");
                            }

                        }

                        @Override
                        public void onFailure(retrofit2.Call<List<Asset>> call, Throwable t) {
                            System.out.println("Error occur");
                        }
                    });
                } else {
                    System.out.println("It is unsucess!!");
                }

            }

            @Override
            public void onFailure(retrofit2.Call<Integer> call, Throwable t) {
                System.out.println("Error occur");
            }
        });



//        ArrayList<Asset> assetList = new ArrayList<>();
//        assetList.add(new Asset("Asset 1", "Category A", "Active"));
//        assetList.add(new Asset("Asset 2", "Category B", "Inactive"));
//        assetList.add(new Asset("Asset 3", "Category A", "Active"));
//
//        // Create the custom ArrayAdapter
//        AssetAdapter adapter = new AssetAdapter(this, R.layout.list_item_layout, assetList);
//
//        // Find the ListView in your layout
//        ListView listView = findViewById(R.id.listViewAssets);
//
//        // Set the adapter for the ListView
//        listView.setAdapter(adapter);

    }
}