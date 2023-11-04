package com.fot.HosatalManagment.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sub_warden")
public class SubWarden {
    @Id
    @Column(name = "subwarden_id")
    private String subWardenId;

    @Column(name = "name")
    private String name;

    @Column(name = "address_line1")
    private String addressLine1;

    @Column(name = "address_line2")
    private String addressLine2;

    @Column(name = "city")
    private String city;

    @Column(name = "nic")
    private String nic;

    @Column(name = "email")
    private String email;

    @Column(name = "mobile_no")
    private String mobileNo;

    @Column(name = "gender")
    private String gender;

    @Column(name = "date_of_employment")
    private String dateOfEmployment;

    // Constructors, getters, and setters

    public SubWarden() {
        // Default constructor
    }

    public SubWarden(String subWardenId, String name, String addressLine1, String addressLine2, String city, String nic, String email, String mobileNo, String gender, String dateOfEmployment) {
        this.subWardenId = subWardenId;
        this.name = name;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.nic = nic;
        this.email = email;
        this.mobileNo = mobileNo;
        this.gender = gender;
        this.dateOfEmployment = dateOfEmployment;
    }

    public String getSubWardenId() {
        return subWardenId;
    }

    public void setSubWardenId(String subWardenId) {
        this.subWardenId = subWardenId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
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

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateOfEmployment() {
        return dateOfEmployment;
    }

    public void setDateOfEmployment(String dateOfEmployment) {
        this.dateOfEmployment = dateOfEmployment;
    }
}

