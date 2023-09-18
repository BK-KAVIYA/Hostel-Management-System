package com.fot.HosatalManagment.controller;

import com.fot.HosatalManagment.entity.Student;
import com.fot.HosatalManagment.service.StudentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/Save")
    public ResponseEntity<String> saveStudent(Student student) {
        studentServiceImp.saveCustomer(student);
        return ResponseEntity.ok("Student saved successfully");
    }

    @GetMapping("/view")
    @ResponseBody
    public ResponseEntity<List<Student>> listStudent() {
        Iterable<Student> studentList = studentServiceImp.getAllCustomer();
        return ResponseEntity.ok((List<Student>) studentList);
    }

}
