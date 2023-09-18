package com.fot.HosatalManagment.service;

import com.fot.HosatalManagment.entity.Student;

public interface StudentService {
    Iterable<Student> getAllCustomer();
    Student saveCustomer(Student student);
    Student getCustomerById(int id);
    Student updateCustomer(Student student);
    void deleteStudentById(int id);

    public int getTotalCustomer();

    String findByStudentEmail(String email);
}
