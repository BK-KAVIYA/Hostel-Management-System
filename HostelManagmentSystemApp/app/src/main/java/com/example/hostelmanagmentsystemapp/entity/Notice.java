package com.example.hostelmanagmentsystemapp.entity;

import java.sql.Timestamp;

public class Notice {
    private Long nid;
    private String ndate_time;
    private String n_person;
    private String n_topic;
    private String notice;
    private Integer n_level;

    public Notice() {

    }

    public Notice(String ndate_time, String n_person, String n_topic, String notice) {
        this.ndate_time = ndate_time;
        this.n_person = n_person;
        this.n_topic = n_topic;
        this.notice = notice;
    }

    public Notice(String ndate_time, String n_person, String n_topic, String notice, Integer n_level) {
        this.ndate_time = ndate_time;
        this.n_person = n_person;
        this.n_topic = n_topic;
        this.notice = notice;
        this.n_level = n_level;
    }

    public Long getNid() {
        return nid;
    }

    public void setNid(Long nid) {
        this.nid = nid;
    }

    public String getNdate_time() {
        return ndate_time;
    }

    public void setNdate_time(String ndate_time) {
        this.ndate_time = ndate_time;
    }

    public String getN_person() {
        return n_person;
    }

    public void setN_person(String n_person) {
        this.n_person = n_person;
    }

    public String getN_topic() {
        return n_topic;
    }

    public void setN_topic(String n_topic) {
        this.n_topic = n_topic;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public Integer getN_level() {
        return n_level;
    }

    public void setN_level(Integer n_level) {
        this.n_level = n_level;
    }
}
