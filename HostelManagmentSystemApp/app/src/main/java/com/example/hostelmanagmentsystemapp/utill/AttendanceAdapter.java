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
import com.example.hostelmanagmentsystemapp.entity.Attendance;

import java.util.List;

public class AttendanceAdapter extends ArrayAdapter<Attendance> {
    public AttendanceAdapter(Context context, int resource, List<Attendance> attendances) {
        super(context, resource, attendances);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Get the data item for this position
        Attendance attendance = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.attendance_item_layout, parent, false);
        }

        // Lookup view for data population
        TextView studentId = convertView.findViewById(R.id.textStudentId);
        TextView room = convertView.findViewById(R.id.textRoom);
        TextView dateandtime = convertView.findViewById(R.id.dateandtime);
        TextView status = convertView.findViewById(R.id.textStatus);

        // Populate the data into the template view using the data object
        studentId.setText(attendance.getStudent_id());
        room.setText(attendance.getRoom_id());
        dateandtime.setText(attendance.getDate_and_time());
        status.setText(attendance.getStatus());

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
