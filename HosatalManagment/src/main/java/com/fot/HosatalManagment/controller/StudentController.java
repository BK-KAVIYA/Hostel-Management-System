package com.fot.HosatalManagment.controller;

import com.fot.HosatalManagment.entity.Student;
import com.fot.HosatalManagment.repository.StudentRepo;
import com.fot.HosatalManagment.service.StudentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentServiceImp studentServiceImp;

    @Autowired
    private StudentRepo studentRepo;

    @PostMapping("/register")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
       return ResponseEntity.ok(studentServiceImp.registerStudent(student));
      //  return ResponseEntity.ok("Student saved successfully");
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

    @GetMapping("/getRoomStudentCount")
    public int getRoomStudentCount(@RequestParam int roomNumber) {
        return studentServiceImp.getRoomStudentCount(roomNumber);
    }

    @GetMapping("/getByRoom")
    public List<Student> getStudentsByRoom(@RequestParam int roomNumber) {
        return studentServiceImp.getStudentsByRoomNumber(roomNumber);
    }

    @PutMapping("/updateRoomID")
    public ResponseEntity<String> updateStudentRoomID(
            @RequestParam String studentID,
            @RequestParam int newRoomID) {
        studentServiceImp.updateStudentRoomID(studentID, newRoomID);
        return ResponseEntity.ok("Student room updated successfully");
    }

    @PutMapping("/update/{stId}")
    public ResponseEntity<String> updateStudent(@PathVariable String stId, @RequestBody Student updatedStudent) {
        // Check if the student with the given stId exists
        Optional<Student> optionalStudent = studentRepo.findById(stId);

        if (optionalStudent.isPresent()) {
            // Update the student data
            Student existingStudent = optionalStudent.get();
            existingStudent.setName(updatedStudent.getName());
            existingStudent.setAddress_line1(updatedStudent.getAddress_line1());
            existingStudent.setAddress_line2(updatedStudent.getAddress_line2());
            existingStudent.setCity(updatedStudent.getCity());
            // Update other fields as needed
            studentRepo.save(existingStudent);
            return ResponseEntity.ok("Student updated successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{stId}")
    public ResponseEntity<?> deleteStudent(@PathVariable String stId) {
        // Check if the student with the given stId exists
        if (studentRepo.existsById(stId)) {
            // Delete the student
            studentRepo.deleteById(stId);
            return ResponseEntity.ok("Student deleted successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
