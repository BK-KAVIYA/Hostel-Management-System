package com.fot.HosatalManagment.entity;

public class RoomAndCount {
    private int room_id;
    private int student_count;

    public RoomAndCount() {
    }

    public RoomAndCount(int room_id, int student_count) {
        this.room_id = room_id;
        this.student_count = student_count;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public int getStudent_count() {
        return student_count;
    }

    public void setStudent_count(int student_count) {
        this.student_count = student_count;
    }
}
