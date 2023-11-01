package com.fot.HosatalManagment.controller;

import com.fot.HosatalManagment.entity.Student;
import com.fot.HosatalManagment.service.StudentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentServiceImp studentServiceImp;

    @PostMapping("/register")
    public ResponseEntity<String> saveStudent(Student student) {
        studentServiceImp.registerStudent(student);
        return ResponseEntity.ok("Student saved successfully");
    }

    @GetMapping("/viewallstudent")
    @ResponseBody
    public ResponseEntity<List<Student>> listStudent() {
        Iterable<Student> studentList = studentServiceImp.getAllStudent();
        return ResponseEntity.ok((List<Student>) studentList);
    }

    @GetMapping("/findstudents/{registrationNumber}")
    public ResponseEntity<Student> getStudentDetails(@PathVariable String registrationNumber) {
        Student student = studentServiceImp.getStudentDetails(registrationNumber);
        return ResponseEntity.ok(student);
    }

    @GetMapping("/login")
    public ResponseEntity<Object> userhome(){
        String message = "login successfully";
        return ResponseEntity.status(HttpStatus.OK).body("{\"message\": \"" + message + "\"}");
    }


    @GetMapping("/studentLevel/{studentId}")
    public ResponseEntity<Integer> getStudentLevel(@PathVariable String studentId) {
        Integer studentLevel = studentServiceImp.getStudentLevel(studentId);
        return new ResponseEntity<>(studentLevel, HttpStatus.OK);
    }
}
