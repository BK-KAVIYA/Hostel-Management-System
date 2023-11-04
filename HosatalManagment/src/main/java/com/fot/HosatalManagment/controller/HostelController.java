package com.fot.HosatalManagment.controller;


import com.fot.HosatalManagment.entity.Hostel;
import com.fot.HosatalManagment.service.HostelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/hostels")
public class HostelController {
    private final HostelService hostelService;

    @Autowired
    public HostelController(HostelService hostelService) {
        this.hostelService = hostelService;
    }

    @GetMapping("/test")
    public ResponseEntity<String> getTest() {
        return ResponseEntity.ok("Student saved successfully");
    }
    @GetMapping("/{hostelName}")
    public Hostel getHostelInformation(@PathVariable String hostelName) {
        return hostelService.getHostelInformation(hostelName);
    }
}
