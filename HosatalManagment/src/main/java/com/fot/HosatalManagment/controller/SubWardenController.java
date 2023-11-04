package com.fot.HosatalManagment.controller;

import com.fot.HosatalManagment.entity.Student;
import com.fot.HosatalManagment.entity.SubWarden;
import com.fot.HosatalManagment.repository.SubWardenRepository;
import com.fot.HosatalManagment.service.SubWardenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/subwarden")
public class SubWardenController {

    @Autowired
    private final SubWardenService subWardenService;

    @Autowired
    private final SubWardenRepository subWardenRepository;

    @Autowired
    public SubWardenController(SubWardenService subWardenService, SubWardenRepository subWardenRepository) {
        this.subWardenService = subWardenService;
        this.subWardenRepository = subWardenRepository;
    }


    @GetMapping("/getById/{subWardenId}")
    public ResponseEntity<SubWarden> getSubWardenById(@PathVariable String subWardenId) {
        SubWarden subWarden = subWardenService.getSubWardenById(subWardenId);
        if (subWarden != null) {
            return new ResponseEntity<>(subWarden, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/update/{subwardenId}")
    public ResponseEntity<String> updateSubWarden(@PathVariable String subwardenId, @RequestBody SubWarden subWarden) {
        // Check if the student with the given stId exists
        Optional<SubWarden> optionalSubWarden = subWardenRepository.findById(subwardenId);

        if (optionalSubWarden.isPresent()) {
            // Update the sub warden data
            SubWarden existingSubWarden = optionalSubWarden.get();
            existingSubWarden.setName(subWarden.getName());
            existingSubWarden.setAddressLine1(subWarden.getAddressLine1());
            existingSubWarden.setAddressLine2(subWarden.getAddressLine2());
            existingSubWarden.setCity(subWarden.getCity());
            existingSubWarden.setMobileNo(subWarden.getMobileNo());
            existingSubWarden.setDateOfEmployment(subWarden.getDateOfEmployment());
            // Update other fields as needed
            subWardenRepository.save(existingSubWarden);
            return ResponseEntity.ok("Sub Warden updated successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
