package com.example.hostelmanagmentsystemapp.ComplaintManagment;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.hostelmanagmentsystemapp.R;


import java.time.Instant;
import java.util.List;

import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.internal.http.HttpHeaders;

public class ComplainManager extends RecyclerView.Adapter<ComplainViewHolder> {
    Context context;
    List<Complaint> complaintList;

    public ComplainManager(Context context, List<Complaint> complaintList) {
        this.context = context;
        this.complaintList = complaintList;
    }

    @NonNull
    @Override
    public ComplainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ComplainViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.complain_details_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ComplainViewHolder holder, int position) {
        holder.title.setText(complaintList.get(position).getAsset_id());
        holder.Date.setText(complaintList.get(position).getDate_and_time().toString());
        holder.complain.setText(String.valueOf(complaintList.get(position).getComplaint()));
        String status;
        if(String.valueOf(complaintList.get(position).getStatus()).equals("Open")){
            status="Open";
        }else{
            status="Under Review";
        }
        holder.status.setText(status);

        byte[] imageBytes = complaintList.get(position).getImage();

        // Check if imageBytes is not null before using it
        if (imageBytes != null) {
            Glide.with(holder.imageView.getContext())
                    .load(imageBytes)
                    .apply(new RequestOptions())
                    .into(holder.imageView);
        }




        // Decode the base64 string to obtain a byte array representing the image
      //  byte[] imageData = Base64.decode(complaintList.get(position).getImage(), Base64.DEFAULT);

        // Create a Bitmap from the byte array
      //  Bitmap bitmap = BitmapFactory.decodeByteArray(imageData, 0, imageData.length);

        // Set the Bitmap as the source for an ImageView
//        ImageView imageView = findViewById(R.id.imageView); // Replace with your ImageView ID
//        imageView.setImageBitmap(bitmap);

     //   holder.imageView.setImageBitmap(bitmap);


//        if (imageData != null) {
//            Instant Glide=null;
//            Glide.with(holder.imageView.getContext())
//                    .load(imageUrl)
//                    .into(holder.imageView);
//        }

    }

    @Override
    public int getItemCount() {
        return complaintList.size();
    }
}
