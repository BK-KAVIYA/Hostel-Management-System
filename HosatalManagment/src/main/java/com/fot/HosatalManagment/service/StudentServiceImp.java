package com.fot.HosatalManagment.service;

import com.fot.HosatalManagment.entity.Student;
import com.fot.HosatalManagment.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImp implements StudentService{

    @Autowired
    private StudentRepo studentRepo;

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
