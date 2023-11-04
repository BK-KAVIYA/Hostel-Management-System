package com.fot.HosatalManagment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/status")
public class StatusController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/currentStatus/{studentId}")
    public ResponseEntity<String> getCurrentStatus(@PathVariable String studentId) {
        String sql = "SELECT GetCurrentStatus(?)";
        String status = jdbcTemplate.queryForObject(sql, new Object[]{studentId}, String.class);
        return ResponseEntity.ok(status);
    }

    @GetMapping("/roomIdByStudentId/{studentId}")
    public ResponseEntity<Integer> getRoomIdByStudentId(@PathVariable String studentId) {
        String sql = "SELECT GetRoomIdByStudentId(?)";
        Integer roomId = jdbcTemplate.queryForObject(sql, new Object[]{studentId}, Integer.class);
        return ResponseEntity.ok(roomId);
    }
}

