package com.fot.HosatalManagment.controller;

import com.fot.HosatalManagment.entity.Notice;
import com.fot.HosatalManagment.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/notices") // Define a base path for your controller
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    // Define an endpoint to call the stored procedure
    @GetMapping("/getByLevel/{level}")
    public ResponseEntity<List<Notice>> getNoticesByLevel(@PathVariable Integer level) {
        List<Notice> notices = noticeService.getNoticesByLevel(level);
        return new ResponseEntity<>(notices, HttpStatus.OK);
    }
}

