package com.fot.HosatalManagment.controller;

import com.fot.HosatalManagment.entity.DailyComplaintReport;
import com.fot.HosatalManagment.service.DailyComplaintReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reports")
public class DailyComplaintReportController {
    @Autowired
    private DailyComplaintReportService service;

    @GetMapping("/today")
    public ResponseEntity<List<DailyComplaintReport>> getComplaintsForToday() {
        List<DailyComplaintReport> complaints = service.getComplaintsForToday();
        return ResponseEntity.ok(complaints);
    }
}

