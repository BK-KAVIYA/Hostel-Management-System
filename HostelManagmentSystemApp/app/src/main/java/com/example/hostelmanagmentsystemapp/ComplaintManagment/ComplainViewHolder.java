package com.example.hostelmanagmentsystemapp.ComplaintManagment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hostelmanagmentsystemapp.R;
public class ComplainViewHolder extends RecyclerView.ViewHolder {
    ImageView imageView;
    TextView title,Date,complain,status;
    public ComplainViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView=itemView.findViewById(R.id.imageViewIcon);
        title=itemView.findViewById(R.id.textViewTitle);
        Date=itemView.findViewById(R.id.complain_datee);
        complain=itemView.findViewById(R.id.complain);
        status=itemView.findViewById(R.id.status);
    }
}
