package com.fot.HosatalManagment.repository;

import com.fot.HosatalManagment.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import java.util.List;

public interface AttendanceRepository extends JpaRepository<Attendance, Integer> {
    @Procedure(name = "GetAttendanceDetailsByStudentId")
    List<Attendance> GetAttendanceDetailsByStudentId(String studentId);
}
