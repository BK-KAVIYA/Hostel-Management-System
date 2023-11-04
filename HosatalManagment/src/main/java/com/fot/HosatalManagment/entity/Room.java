package com.fot.HosatalManagment.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Room {
    @Id
    private int room_id;
    private String status;
    private int hostel_id;

    public Room() {
    }

    public Room(String status, int hostel_id) {
        this.status = status;
        this.hostel_id = hostel_id;
    }

    public Room(int room_id, String status, int hostel_id) {
        this.room_id = room_id;
        this.status = status;
        this.hostel_id = hostel_id;
    }
}
