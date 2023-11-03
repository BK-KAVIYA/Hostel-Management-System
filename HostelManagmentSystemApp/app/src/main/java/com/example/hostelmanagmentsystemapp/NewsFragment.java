package com.example.hostelmanagmentsystemapp;

import static androidx.camera.core.impl.utils.ContextUtil.getApplicationContext;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.hostelmanagmentsystemapp.entity.Asset;
import com.example.hostelmanagmentsystemapp.entity.Notice;
import com.example.hostelmanagmentsystemapp.utill.AssetAdapter;
import com.example.hostelmanagmentsystemapp.utill.NewsAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Callback;
import retrofit2.Response;

public class NewsFragment extends Fragment {

    private int Studentlevel;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_notification_fragment);

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        String UserID = sharedPreferences.getString("userID", "TG001");

        Login.getStudentApiService().getStudentLevel(UserID).enqueue(new Callback<Integer>() {
            @Override
            public void onResponse(retrofit2.Call<Integer> call, Response<Integer> responselevel) {
                if (responselevel.isSuccessful()) {
                    Studentlevel = responselevel.body();

                    Login.getStudentApiService().getNoticesByLevel(Studentlevel).enqueue(new Callback<List<Notice>>() {
                        @Override
                        public void onResponse(retrofit2.Call<List<Notice>> call, Response<List<Notice>> response) {
                            if (response.isSuccessful()) {

                                List<Notice> notices = response.body();
                                ArrayList<Notice> noticeArrayList = new ArrayList<>();
                                for (Notice nt: notices) {
                                    noticeArrayList.add(new Notice(nt.getNdate_time(),nt.getN_person(),nt.getN_topic(),nt.getNotice()));
                                }
                                // Create the custom ArrayAdapter
                                NewsAdapter adapter = new NewsAdapter(getContext(), R.layout.notice_item_layout, noticeArrayList);

                                ListView listView = getActivity().findViewById(R.id.listViewNews);

                                // Set the adapter for the ListView
                                listView.setAdapter(adapter);
                            } else {
                                System.out.println("It is unsucess!!");
                            }

                        }

                        @Override
                        public void onFailure(retrofit2.Call<List<Notice>> call, Throwable t) {
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
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_news_fragment, container, false);
        return v;
    }
}