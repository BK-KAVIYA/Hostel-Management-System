package com.fot.HosatalManagment.service;

import com.fot.HosatalManagment.entity.Attendance;
import com.fot.HosatalManagment.repository.AttendanceRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AttendanceService {
    @Autowired
    private AttendanceRepository attendanceRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public Attendance saveAttendance(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }

    public void callAddAttendanceRecord(String officerId, String studentId) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("AddAttendanceRecord");
        query.registerStoredProcedureParameter("officerId", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("studentId", String.class, ParameterMode.IN);

        query.setParameter("officerId", officerId);
        query.setParameter("studentId", studentId);

        query.execute();
    }

    public List<Attendance> getAllAttendance(){
        return attendanceRepository.findAll();
    }

    @Transactional
    public List<Attendance> getAttendanceDetailsByStudentId(String studentId) {
        return attendanceRepository.GetAttendanceDetailsByStudentId(studentId);
    }
}

