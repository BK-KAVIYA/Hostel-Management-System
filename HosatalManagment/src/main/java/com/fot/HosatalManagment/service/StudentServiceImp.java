package com.fot.HosatalManagment.service;

import com.fot.HosatalManagment.entity.Student;
import com.fot.HosatalManagment.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImp implements StudentService{

    @Autowired
    private StudentRepo studentRepo;

    public StudentServiceImp(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public Iterable<Student> getAllCustomer() {
        return (List<Student>) studentRepo.findAll();
    }

    @Override
    public Student saveCustomer(Student student) {
        return studentRepo.save(student);
    }

    @Override
    public Student getCustomerById(int id) {
        return null;
    }

    @Override
    public Student updateCustomer(Student student) {
        return null;
    }

    @Override
    public void deleteStudentById(int id) {

    }

    @Override
    public int getTotalCustomer() {
        return 0;
    }

    @Override
    public String findByStudentEmail(String email) {
        return null;
    }
}
