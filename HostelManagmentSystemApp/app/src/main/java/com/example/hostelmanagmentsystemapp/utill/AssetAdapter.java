package com.example.hostelmanagmentsystemapp.utill;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.example.hostelmanagmentsystemapp.R;
import com.example.hostelmanagmentsystemapp.entity.Asset;

import java.util.List;

public class AssetAdapter extends ArrayAdapter<Asset> {
    public AssetAdapter(Context context, int resource, List<Asset> assets) {
        super(context, resource, assets);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Get the data item for this position
        Asset asset = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_layout, parent, false);
        }

        // Lookup view for data population
        TextView assetId = convertView.findViewById(R.id.textAssetId);
        TextView category = convertView.findViewById(R.id.textCategory);
        TextView status = convertView.findViewById(R.id.textStatus);

        // Populate the data into the template view using the data object
        assetId.setText(asset.getAsset_id());
        category.setText(asset.getCategory());
        status.setText(asset.getStatus());

        // Set background color based on position (alternating colors)
        if (position % 2 == 0) {
            convertView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.evenItemColor));
        } else {
            convertView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.oddItemColor));
        }

        // Return the completed view to render on screen
        return convertView;
    }
}
