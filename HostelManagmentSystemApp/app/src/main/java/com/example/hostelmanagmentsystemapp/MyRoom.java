package com.example.hostelmanagmentsystemapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.hostelmanagmentsystemapp.entity.Asset;

import java.util.ArrayList;

public class MyRoom extends AppCompatActivity {

    private TextView room;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_room);

        room=findViewById(R.id.textRoomNumber);
        room.setText("101");

        // Sample data for your asset list
        ArrayList<Asset> assetList = new ArrayList<>();
        assetList.add(new Asset("Asset 1", "Category A", "Active"));
        assetList.add(new Asset("Asset 2", "Category B", "Inactive"));
        assetList.add(new Asset("Asset 3", "Category A", "Active"));

        // Create an ArrayAdapter to bind data to the ListView
        ArrayAdapter<Asset> adapter = new ArrayAdapter<>(
                this,
                R.layout.list_item_layout, // The custom list item layout
                R.id.textAssetId, // The TextView for Asset ID
                assetList
        );

        // Find the ListView in your layout
        ListView listView = findViewById(R.id.listViewAssets);

        // Set the adapter for the ListView
        listView.setAdapter(adapter);
    }
}