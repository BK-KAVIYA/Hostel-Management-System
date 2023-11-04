package com.fot.HosatalManagment.repository;

import com.fot.HosatalManagment.entity.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends CrudRepository<Student,String> {
    @Procedure(name = "GetStudentDetails")
    Student getStudentDetails(String registrationNumber);


    @Query(value = "SELECT GetStudentLevel(:studentId) as level", nativeQuery = true)
    Integer callGetStudentLevel(@Param("studentId") String studentId);

    @Procedure(name = "GetStudentsByRoomNumber")
    List<Student> GetStudentsByRoomNumber(int roomNumber);

//        @Query(value = "CALL GetStudentDetails(:studentID)", nativeQuery = true)
//        Student getStudentDetails(@Param("studentID") String studentID);


}
