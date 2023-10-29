package com.example.hostelmanagmentsystemapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.hostelmanagmentsystemapp.entity.Asset;
import com.example.hostelmanagmentsystemapp.utill.AssetAdapter;

import java.util.ArrayList;

public class MyRoom extends AppCompatActivity {

    private TextView room;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_room);

        room=findViewById(R.id.textRoomNumber);
        room.setText("101");

        ArrayList<Asset> assetList = new ArrayList<>();
        assetList.add(new Asset("Asset 1", "Category A", "Active"));
        assetList.add(new Asset("Asset 2", "Category B", "Inactive"));
        assetList.add(new Asset("Asset 3", "Category A", "Active"));

        // Create the custom ArrayAdapter
        AssetAdapter adapter = new AssetAdapter(this, R.layout.list_item_layout, assetList);

        // Find the ListView in your layout
        ListView listView = findViewById(R.id.listViewAssets);

        // Set the adapter for the ListView
        listView.setAdapter(adapter);

    }
}