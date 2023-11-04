package com.fot.HosatalManagment.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "DailyComplaintReport")
public class DailyComplaintReport {
    @Id
    @Column(name = "complaint_id")
    private Long complaintId;

    @Column(name = "asset_id")
    private String assetId;

    @Column(name = "category")
    private String category;

    @Column(name = "complaint")
    private String complaint;

    @Column(name = "date_and_time")
    private String dateAndTime;

    @Column(name = "student_id")
    private String studentId;

    @Column(name = "student_name")
    private String studentName;

    @Column(name = "student_email")
    private String studentEmail;

    @Column(name = "student_mobile")
    private String studentMobile;

    @Column(name = "student_level")
    private Integer studentLevel;

    @Column(name = "hostel_name")
    private String hostelName;

    @Column(name = "complaint_status")
    private String complaintStatus;

    public DailyComplaintReport() {
    }

    public DailyComplaintReport(Long complaintId, String assetId, String category, String complaint, String dateAndTime, String studentId, String studentName, String studentEmail, String studentMobile, Integer studentLevel, String hostelName, String complaintStatus) {
        this.complaintId = complaintId;
        this.assetId = assetId;
        this.category = category;
        this.complaint = complaint;
        this.dateAndTime = dateAndTime;
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentEmail = studentEmail;
        this.studentMobile = studentMobile;
        this.studentLevel = studentLevel;
        this.hostelName = hostelName;
        this.complaintStatus = complaintStatus;
    }

    public Long getComplaintId() {
        return complaintId;
    }

    public void setComplaintId(Long complaintId) {
        this.complaintId = complaintId;
    }

    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getComplaint() {
        return complaint;
    }

    public void setComplaint(String complaint) {
        this.complaint = complaint;
    }

    public String getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(String dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getStudentMobile() {
        return studentMobile;
    }

    public void setStudentMobile(String studentMobile) {
        this.studentMobile = studentMobile;
    }

    public Integer getStudentLevel() {
        return studentLevel;
    }

    public void setStudentLevel(Integer studentLevel) {
        this.studentLevel = studentLevel;
    }

    public String getHostelName() {
        return hostelName;
    }

    public void setHostelName(String hostelName) {
        this.hostelName = hostelName;
    }

    public String getComplaintStatus() {
        return complaintStatus;
    }

    public void setComplaintStatus(String complaintStatus) {
        this.complaintStatus = complaintStatus;
    }
}
