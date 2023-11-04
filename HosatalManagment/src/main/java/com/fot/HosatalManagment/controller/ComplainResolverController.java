package com.fot.HosatalManagment.controller;

import com.fot.HosatalManagment.entity.ComplaintResolve;
import com.fot.HosatalManagment.entity.Student;
import com.fot.HosatalManagment.service.ComplaintResolveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/complainResolve")
public class ComplainResolverController {

    @Autowired
    private ComplaintResolveService complaintResolveService;

    @PostMapping("/save")
    public ResponseEntity<String> saveStudent(ComplaintResolve complaintResolve) {
        complaintResolveService.addComplainResolver(complaintResolve);
        return ResponseEntity.ok("Complain resolver saved successfully");
    }
}
