package com.fot.HosatalManagment.controller;


import com.fot.HosatalManagment.entity.Complaint;
import com.fot.HosatalManagment.entity.Student;
import com.fot.HosatalManagment.service.ComplaintServiceIMP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(value = "/create",consumes = {"*/*"})
    public ResponseEntity<String> createComplaint(@RequestBody  Complaint complaint) {
        // Handle the complaint and image data
        complaintServiceIMP.saveComplaint(complaint);
        return ResponseEntity.ok("Complaint created successfully");
    }
}
