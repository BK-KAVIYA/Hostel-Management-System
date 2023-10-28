package com.example.hostelmanagmentsystemapp.entity;

public class Hostel {
    private int h_id;
    private String hostel_name;
    private int capacity;
    private String sub_warden_id;
    private String warden_id;

    public Hostel() {

    }

    public Hostel(int h_id, String hostel_name, int capacity, String sub_warden_id, String warden_id) {
        this.h_id = h_id;
        this.hostel_name = hostel_name;
        this.capacity = capacity;
        this.sub_warden_id = sub_warden_id;
        this.warden_id = warden_id;
    }

    public Hostel(String hostel_name, int capacity, String sub_warden_id, String warden_id) {
        this.hostel_name = hostel_name;
        this.capacity = capacity;
        this.sub_warden_id = sub_warden_id;
        this.warden_id = warden_id;
    }

    public int getH_id() {
        return h_id;
    }

    public void setH_id(int h_id) {
        this.h_id = h_id;
    }

    public String getHostel_name() {
        return hostel_name;
    }

    public void setHostel_name(String hostel_name) {
        this.hostel_name = hostel_name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getSub_warden_id() {
        return sub_warden_id;
    }

    public void setSub_warden_id(String sub_warden_id) {
        this.sub_warden_id = sub_warden_id;
    }

    public String getWarden_id() {
        return warden_id;
    }

    public void setWarden_id(String warden_id) {
        this.warden_id = warden_id;
    }
}
