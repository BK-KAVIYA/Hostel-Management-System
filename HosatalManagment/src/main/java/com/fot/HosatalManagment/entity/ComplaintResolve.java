package com.fot.HosatalManagment.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "complaint_resolve")
public class ComplaintResolve {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int complaintId;

    private String note;

    public ComplaintResolve() {
    }

    public ComplaintResolve(int id, int complaintId, String note) {
        this.id = id;
        this.complaintId = complaintId;
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getComplaintId() {
        return complaintId;
    }

    public void setComplaintId(int complaintId) {
        this.complaintId = complaintId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
