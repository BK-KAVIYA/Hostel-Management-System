package com.example.hostelmanagmentsystemapp.ComplaintManagment;



import java.time.LocalDateTime;


public class Complaint {

    private int compalint_id;
    private String asset_id;
    private String complaint;
    private byte[] image;
    private String sub_warden_id;
    private String warden_id;
    private String student_id;
    private String date_and_time;
    private String status;

    public Complaint() {
    }

    public Complaint(int compalint_id, String asset_id, String complaint, byte[] image, String sub_warden_id, String warden_id, String student_id, String date_and_time, String status) {
        this.compalint_id = compalint_id;
        this.asset_id = asset_id;
        this.complaint = complaint;
        this.image = image;
        this.sub_warden_id = sub_warden_id;
        this.warden_id = warden_id;
        this.student_id = student_id;
        this.date_and_time = date_and_time;
        this.status = status;
    }

    public Complaint(String asset_id, String complaint, byte[] image, String sub_warden_id, String warden_id, String student_id, String date_and_time, String status) {
        this.asset_id = asset_id;
        this.complaint = complaint;
        this.image = image;
        this.sub_warden_id = sub_warden_id;
        this.warden_id = warden_id;
        this.student_id = student_id;
        this.date_and_time = date_and_time;
        this.status = status;
    }

    public Complaint(String asset_id, String complaint, byte[] image, String date_and_time, String status) {
        this.asset_id = asset_id;
        this.complaint = complaint;
        this.image = image;
        this.date_and_time = date_and_time;
        this.status = status;
    }

    public int getCompalint_id() {
        return compalint_id;
    }

    public void setCompalint_id(int compalint_id) {
        this.compalint_id = compalint_id;
    }

    public String getAsset_id() {
        return asset_id;
    }

    public void setAsset_id(String asset_id) {
        this.asset_id = asset_id;
    }

    public String getComplaint() {
        return complaint;
    }

    public void setComplaint(String complaint) {
        this.complaint = complaint;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
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

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
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
