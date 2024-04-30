package com.dev.honeycomb_mobile.models;

public class Bookings {
    private String date;
    private String time;
    private String doctor;
    private String hospital;

    public Bookings() {
    }

    public Bookings(String date, String time, String doctor, String hospital) {
        this.date = date;
        this.time = time;
        this.doctor = doctor;
        this.hospital = hospital;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
