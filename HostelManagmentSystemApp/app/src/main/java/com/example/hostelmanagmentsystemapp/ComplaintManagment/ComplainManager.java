package com.example.hostelmanagmentsystemapp.ComplaintManagment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.hostelmanagmentsystemapp.R;


import java.time.Instant;
import java.util.List;

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

        byte[] imageUrl = complaintList.get(position).getImage();

//        if (imageUrl != null) {
//            Instant Glide;
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
