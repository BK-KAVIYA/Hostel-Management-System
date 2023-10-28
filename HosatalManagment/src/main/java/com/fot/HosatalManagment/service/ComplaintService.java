package com.fot.HosatalManagment.service;

import com.fot.HosatalManagment.entity.Complaint;
import com.fot.HosatalManagment.repository.ComplaintRepo;
import org.springframework.beans.factory.annotation.Autowired;

public interface ComplaintService {


    Iterable<Complaint> getComplaintByStId(String ID);
}
