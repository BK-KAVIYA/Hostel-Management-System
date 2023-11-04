package com.fot.HosatalManagment.controller;

import com.fot.HosatalManagment.service.TotalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/totals")
public class TotalController {
    @Autowired
    private TotalService totalService;

    @GetMapping("/complaints")
    public ResponseEntity<Integer> getTotalComplaints() {
        return ResponseEntity.ok(totalService.getTotalComplaints());
    }

    @GetMapping("/students")
    public ResponseEntity<Integer> getTotalStudents() {
        return ResponseEntity.ok(totalService.getTotalStudents());
    }

    @GetMapping("/assets")
    public ResponseEntity<Integer> getTotalAssets() {
        return ResponseEntity.ok(totalService.getTotalAssets());
    }

    @GetMapping("/level/{studentId}")
    public ResponseEntity<Integer> getStudentLevel(@PathVariable String studentId) {
        Integer level = totalService.getStudentLevel(studentId);
        if (level != null) {
            return ResponseEntity.ok(level);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

//    @GetMapping("/complaincount/{studentId}")
//    public ResponseEntity<Integer> getStudentComplaintLevel(@PathVariable String studentId) {
//        Integer level = totalService.GetStudentComplaintCount(studentId);
//        if (level != null) {
//            return ResponseEntity.ok(level);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
}

