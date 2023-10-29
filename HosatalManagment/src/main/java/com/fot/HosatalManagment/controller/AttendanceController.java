package com.fot.HosatalManagment.controller;

import com.fot.HosatalManagment.entity.Attendance;
import com.fot.HosatalManagment.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {
    @Autowired
    private AttendanceService attendanceService;

    @PostMapping("/add")
    public ResponseEntity<Attendance> addAttendance(@RequestBody Attendance attendance) {
        Attendance savedAttendance = attendanceService.saveAttendance(attendance);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAttendance);
    }

    @PostMapping("/callAddAttendanceRecord")
    public ResponseEntity<String> callAddAttendanceRecord(
            @RequestParam String officerId,
            @RequestParam String studentId
    ) {
        attendanceService.callAddAttendanceRecord(officerId, studentId);
        return ResponseEntity.ok("Stored procedure executed successfully.");
    }

    @GetMapping("/getAllAttendance")
    public ResponseEntity<List<Attendance>> getAllAttendance() {
        List<Attendance> allAttendance = attendanceService.getAllAttendance();
        return ResponseEntity.status(HttpStatus.CREATED).body(allAttendance);
    }

    @GetMapping("/getByStudentId/{studentId}")
    public ResponseEntity<List<Attendance>> getAttendanceDetailsByStudentId(@PathVariable String studentId) {
        List<Attendance> attendanceDetails = attendanceService.getAttendanceDetailsByStudentId(studentId);
        return ResponseEntity.ok(attendanceDetails);
    }

}

