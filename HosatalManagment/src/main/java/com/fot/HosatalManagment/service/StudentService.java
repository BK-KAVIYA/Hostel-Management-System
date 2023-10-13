package com.fot.HosatalManagment.service;

import com.fot.HosatalManagment.entity.Student;

public interface StudentService {
    Iterable<Student> getAllStudent();
    Student registerStudent(Student student);
    Student getStudentDetails(String registrationNumber);
    Student updateStudent(Student student);
    void deleteStudentById(int id);

    public int getTotalStudent();

  //  String findByStudentEmail(String email);
}
