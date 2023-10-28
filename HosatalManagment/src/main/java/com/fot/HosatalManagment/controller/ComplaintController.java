package com.fot.HosatalManagment.controller;


import com.fot.HosatalManagment.entity.Complaint;
import com.fot.HosatalManagment.entity.Student;
import com.fot.HosatalManagment.service.ComplaintServiceIMP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping("/complaint")
public class ComplaintController {

    @Autowired
    private ComplaintServiceIMP complaintServiceIMP;
    @GetMapping("/findscompaints/{registrationNumber}")
    public ResponseEntity<Iterable<Complaint>> getComplaintByStudent(@PathVariable String registrationNumber) {
        Iterable<Complaint> complaints = complaintServiceIMP.getComplaintByStId(registrationNumber);
        return ResponseEntity.ok(complaints);
    }
}
