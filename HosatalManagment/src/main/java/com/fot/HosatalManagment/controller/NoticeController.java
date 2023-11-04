package com.fot.HosatalManagment.controller;

import com.fot.HosatalManagment.entity.Notice;
import com.fot.HosatalManagment.entity.Student;
import com.fot.HosatalManagment.repository.NoticeRepository;
import com.fot.HosatalManagment.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/notices") // Define a base path for your controller
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @Autowired
    private NoticeRepository  noticeRepository;

    // Define an endpoint to call the stored procedure
    @GetMapping("/getByLevel/{level}")
    public ResponseEntity<List<Notice>> getNoticesByLevel(@PathVariable Integer level) {
        List<Notice> notices = noticeService.getNoticesByLevel(level);
        return new ResponseEntity<>(notices, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Notice>> getAllNotices() {
        List<Notice> notices = noticeService.getAllNotices();
        return new ResponseEntity<>(notices, HttpStatus.OK);
    }


    @GetMapping("/getById/{noticeId}")
    public Notice getNoticeDetails(@PathVariable int noticeId) {
        return noticeService.callGetNoticeDetails(noticeId);
    }

    @PutMapping("/update/{nid}")
    public ResponseEntity<String> updateStudent(@PathVariable long nid, @RequestBody Notice updatedNotice) {
        // Check if the student with the given nid exists
        Optional<Notice> optionalNotice = noticeRepository.findById(nid);

        if (optionalNotice.isPresent()) {
            // Update the notice data
            Notice existingNotice = optionalNotice.get();
            existingNotice.setN_topic(updatedNotice.getN_topic());
            existingNotice.setNotice(updatedNotice.getNotice());
            existingNotice.setN_person(updatedNotice.getN_person());
            existingNotice.setN_level(updatedNotice.getN_level());
            // Update other fields as needed
            noticeRepository.save(existingNotice);
            return ResponseEntity.ok("Notice updated successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

