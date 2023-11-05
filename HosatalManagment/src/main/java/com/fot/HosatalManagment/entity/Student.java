package com.fot.HosatalManagment.entity;

import jakarta.persistence.*;

@Entity
public class Student {
    @Id
    private String st_id;
    private String name;
    private String address_line1;
    private String address_line2;
    private String city;
    private String nic;
    private String email;
    private String gender;
    private Long mobile_no;
    private int level;
    private int room_id;

    // Constructors, getters, and setters

    public Student() {
        // Default constructor
    }

    public Student(String st_id, String name, String address_line1, String address_line2, String city, String nic, String email, String gender, Long mobile_no, int level, int room_id) {
        this.st_id = st_id;
        this.name = name;
        this.address_line1 = address_line1;
        this.address_line2 = address_line2;
        this.city = city;
        this.nic = nic;
        this.email = email;
        this.gender = gender;
        this.mobile_no = mobile_no;
        this.level = level;
        this.room_id = room_id;
    }

    public String getSt_id() {
        return st_id;
    }

    public void setSt_id(String stId) {
        this.st_id = stId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress_line1() {
        return address_line1;
    }

    public void setAddress_line1(String address_line1) {
        this.address_line1 = address_line1;
    }

    public String getAddress_line2() {
        return address_line2;
    }

    public void setAddress_line2(String address_line2) {
        this.address_line2 = address_line2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Long getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(Long mobile_no) {
        this.mobile_no = mobile_no;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stId='" + st_id + '\'' +
                ", name='" + name + '\'' +
                ", address_line1='" + address_line1 + '\'' +
                ", address_line2='" + address_line2 + '\'' +
                ", city='" + city + '\'' +
                ", nic='" + nic + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", mobile_no=" + mobile_no +
                ", level=" + level +
                ", room_id=" + room_id +
                '}';
    }
}
