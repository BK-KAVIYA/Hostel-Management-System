package com.fot.HosatalManagment.service;

import com.fot.HosatalManagment.entity.Student;
import com.fot.HosatalManagment.repository.StudentRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImp implements StudentService{

    @Autowired
    private StudentRepo studentRepo;

    private final EntityManager entityManager;

    public StudentServiceImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Iterable<Student> getAllStudent() {
        return  studentRepo.findAll();
    }

    @Override
    public Student registerStudent(Student student) {
       return studentRepo.save(student);
    }

    @Override
    @Transactional
    public Student getStudentDetails(String registrationNumber) {
        return studentRepo.getStudentDetails(registrationNumber);
    }

    public Integer getStudentLevel(String studentId) {
        return studentRepo.callGetStudentLevel(studentId);
    }

    public int getRoomStudentCount(int roomNumber) {
        StoredProcedureQuery query = entityManager.createNamedStoredProcedureQuery("GetRoomStudentCount");
        query.setParameter("roomNumber", roomNumber);
        query.execute();

        return (int) query.getOutputParameterValue("studentCount");
    }

    @Transactional
    public List<Student> getStudentsByRoomNumber(int roomNumber) {
        return studentRepo.GetStudentsByRoomNumber(roomNumber);
    }

    @Transactional
    public void updateStudentRoomID(String studentID, int newRoomID) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("UpdateStudentRoomID");
        query.registerStoredProcedureParameter("studentID", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("newRoomID", Integer.class, ParameterMode.IN);

        query.setParameter("studentID", studentID);
        query.setParameter("newRoomID", newRoomID);

        query.execute();
    }
    @Override
    public Student updateStudent(Student student) {
        return null;
    }

    @Override
    public void deleteStudentById(int id) {

    }

    @Override
    public int getTotalStudent() {
        return 0;
    }
}
