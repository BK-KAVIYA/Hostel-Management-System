package com.example.hostelmanagmentsystemapp.entity;

public class Attendance {
    private int attendance_id;
    private String student_id;
    private String security_officer_id;
    private int room_id;
    private String date_and_time;
    private String status;

    public Attendance() {
    }

    public Attendance(String student_id, String security_officer_id, int room_id, String date_and_time, String status) {
        this.student_id = student_id;
        this.security_officer_id = security_officer_id;
        this.room_id = room_id;
        this.date_and_time = date_and_time;
        this.status = status;
    }

    public Attendance(int attendance_id, String student_id, String security_officer_id, int room_id, String date_and_time, String status) {
        this.attendance_id = attendance_id;
        this.student_id = student_id;
        this.security_officer_id = security_officer_id;
        this.room_id = room_id;
        this.date_and_time = date_and_time;
        this.status = status;
    }

    public Attendance(String student_id, int room_id, String date_and_time, String status) {
        this.student_id = student_id;
        this.room_id = room_id;
        this.date_and_time = date_and_time;
        this.status = status;
    }

    public int getAttendance_id() {
        return attendance_id;
    }

    public void setAttendance_id(int attendance_id) {
        this.attendance_id = attendance_id;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getSecurity_officer_id() {
        return security_officer_id;
    }

    public void setSecurity_officer_id(String security_officer_id) {
        this.security_officer_id = security_officer_id;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public String getDate_and_time() {
        return date_and_time;
    }

    public void setDate_and_time(String date_and_time) {
        this.date_and_time = date_and_time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
