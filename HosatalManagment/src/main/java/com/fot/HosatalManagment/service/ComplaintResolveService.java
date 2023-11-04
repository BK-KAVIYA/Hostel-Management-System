package com.fot.HosatalManagment.service;


import com.fot.HosatalManagment.entity.ComplaintResolve;
import com.fot.HosatalManagment.entity.Student;
import com.fot.HosatalManagment.repository.ComplaintResolveRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComplaintResolveService {

    @Autowired
    private ComplaintResolveRepo complaintResolveRepo;

    public void addComplainResolver(ComplaintResolve complaintResolve) {
         complaintResolveRepo.save(complaintResolve);
    }
}
