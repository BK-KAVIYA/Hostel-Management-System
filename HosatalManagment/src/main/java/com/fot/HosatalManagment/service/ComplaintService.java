package com.fot.HosatalManagment.service;

import com.fot.HosatalManagment.entity.Complaint;

import java.util.List;

public interface ComplaintService {


    List<Complaint> getComplaintByStId(String ID);

    void saveComplaint(Complaint complaint);
}
