package com.example.hostelmanagmentsystemapp;

public class AppData {
    private static AppData instance;
    private String id;

    private AppData() {}

    public static AppData getInstance() {
        if (instance == null) {
            instance = new AppData();
        }
        return instance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
