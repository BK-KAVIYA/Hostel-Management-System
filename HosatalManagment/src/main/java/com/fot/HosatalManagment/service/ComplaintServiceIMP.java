package com.fot.HosatalManagment.service;

import com.fot.HosatalManagment.entity.Complaint;
import com.fot.HosatalManagment.repository.ComplaintRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ComplaintServiceIMP implements ComplaintService{

    @Autowired
    private ComplaintRepo complaintRepo;

    @Transactional
    @Override
    public Iterable<Complaint> getComplaintByStId(String ID) {
        return  complaintRepo.GetComplaintsByStudent(ID);
    }
}
