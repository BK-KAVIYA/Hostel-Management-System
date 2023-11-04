package com.fot.HosatalManagment.controller;


import com.fot.HosatalManagment.entity.Room;
import com.fot.HosatalManagment.entity.RoomAndCount;
import com.fot.HosatalManagment.entity.Student;
import com.fot.HosatalManagment.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {
    @Autowired
    private RoomService roomService;

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/all")
    public ResponseEntity<List<RoomAndCount>> getAllRoomNumbers() {

        List<RoomAndCount> roomList=  roomService.GetAllRoomNumbers();
        return ResponseEntity.ok(roomList);

    }
}
