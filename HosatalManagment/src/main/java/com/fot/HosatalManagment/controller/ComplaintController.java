package com.fot.HosatalManagment.controller;


import com.fot.HosatalManagment.entity.Complaint;
import com.fot.HosatalManagment.entity.Student;
import com.fot.HosatalManagment.service.ComplaintServiceIMP;
import com.fot.HosatalManagment.utill.ComplaintWithImageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping("/complaint")
public class ComplaintController {

    @Autowired
    private ComplaintServiceIMP complaintServiceIMP;
    @GetMapping("/findscompaints/{registrationNumber}")
    public ResponseEntity<List<Complaint>> getComplaintByStudent(@PathVariable String registrationNumber) {
        List<Complaint> complaints = complaintServiceIMP.getComplaintByStId(registrationNumber);

        return ResponseEntity.ok(complaints);
    }



    @PostMapping(value = "/create",consumes = {"*/*"})
    public ResponseEntity<String> createComplaint(@RequestBody  Complaint complaint) {
        // Handle the complaint and image data
        complaintServiceIMP.saveComplaint(complaint);
        return ResponseEntity.ok("Complaint created successfully");
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveComplaint(@RequestBody Complaint complaint) {
         complaintServiceIMP.saveComplaint(complaint);
        return ResponseEntity.ok("Complaint created successfully");
    }



//    @GetMapping("/{fileName}")
//    public ResponseEntity<?> downloadImage(@PathVariable int fileName){
//        byte[] imageData=complaintServiceIMP.downloadImage(fileName);
//        return ResponseEntity.status(HttpStatus.OK)
//                .contentType(MediaType.valueOf("image/png"))
//                .body(imageData);
//
//    }


    @GetMapping("/details/{complaintId}")
    public ResponseEntity<byte[]> getComplaintImage(@PathVariable int complaintId) {
        Optional<Complaint> complaint = complaintServiceIMP.getComplaintDetails(complaintId);
        if (complaint.isPresent()) {
            byte[] imageBytes = complaint.get().getImage();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.valueOf("image/png")); // Set the appropriate content type based on your image type (e.g., IMAGE_JPEG, IMAGE_PNG, etc.)
            headers.setContentLength(imageBytes.length);
            return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<Iterable<Complaint>> getComplaintImage() {
        Iterable<Complaint> complaint = complaintServiceIMP.getAllComplained();

//            byte[] imageBytes = complaint.get.getImage();
//            HttpHeaders headers = new HttpHeaders();
//            headers.setContentType(MediaType.valueOf("image/png")); // Set the appropriate content type based on your image type (e.g., IMAGE_JPEG, IMAGE_PNG, etc.)
//            headers.setContentLength(imageBytes.length);
           return  ResponseEntity.ok(complaint);
//        } else {
    //        return ResponseEntity.notFound().build();
       // }
    }

}
