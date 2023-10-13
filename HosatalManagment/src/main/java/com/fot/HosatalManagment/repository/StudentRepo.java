package com.fot.HosatalManagment.repository;

import com.fot.HosatalManagment.entity.Student;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends CrudRepository<Student,Integer> {
    @Procedure(name = "GetStudentDetails")
    Student getStudentDetails(String registrationNumber);
}
