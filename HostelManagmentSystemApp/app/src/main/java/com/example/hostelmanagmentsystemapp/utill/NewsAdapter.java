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
import com.example.hostelmanagmentsystemapp.entity.Notice;

import java.util.List;

public class NewsAdapter extends ArrayAdapter<Notice> {
    public NewsAdapter(Context context, int resource, List<Notice> assets) {
        super(context, resource, assets);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Get the data item for this position
        Notice notice = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.notice_item_layout, parent, false);
        }

        // Lookup view for data population
        TextView person = convertView.findViewById(R.id.textntperson);
        TextView noticeTitle = convertView.findViewById(R.id.textNtTitle);
        TextView noticeBody = convertView.findViewById(R.id.txtNotice);
        TextView dateAndTime=convertView.findViewById(R.id.textdateAndTime);

        // Populate the data into the template view using the data object
        person.setText(notice.getN_person());
        noticeTitle.setText(notice.getN_topic());
        noticeBody.setText(notice.getNotice());
        dateAndTime.setText(notice.getNdate_time().toString());

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
