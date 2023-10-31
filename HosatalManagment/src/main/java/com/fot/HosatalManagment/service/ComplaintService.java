package com.fot.HosatalManagment.service;

import com.fot.HosatalManagment.entity.Complaint;

import java.util.Optional;

public interface ComplaintService {


    Optional<Complaint> getComplaintByStId(String ID);

    void saveComplaint(Complaint complaint);
}
