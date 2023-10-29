package com.fot.HosatalManagment.utill;

import com.fot.HosatalManagment.entity.Complaint;

public class ComplaintWithImageData {
    private Complaint complaint;
    private String base64Image; // A string to hold the base64-encoded image

    public ComplaintWithImageData(Complaint complaint, String base64Image) {
        this.complaint = complaint;
        this.base64Image = base64Image;
    }

    public Complaint getComplaint() {
        return complaint;
    }

    public void setComplaint(Complaint complaint) {
        this.complaint = complaint;
    }

    public String getBase64Image() {
        return base64Image;
    }

    public void setBase64Image(String base64Image) {
        this.base64Image = base64Image;
    }
}
