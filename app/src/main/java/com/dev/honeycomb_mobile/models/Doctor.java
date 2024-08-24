package com.dev.honeycomb_mobile.models;

import java.io.Serializable;

public class Doctor implements Serializable {
    private String firstName;

    private String lastName;

    private String image;

    private Double phone;

    private Double rating;

    private String about;

    private String specialization;

    private Double id;

    private String hospital;

    private Double experience;

    public Doctor(String firstName, String lastName, String image, Double phone, Double rating,
                  String about, String specialization, Double id, String hospital, Double experience) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.image = image;
        this.phone = phone;
        this.rating = rating;
        this.about = about;
        this.specialization = specialization;
        this.id = id;
        this.hospital = hospital;
        this.experience = experience;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Double getPhone() {
        return this.phone;
    }

    public void setPhone(Double phone) {
        this.phone = phone;
    }

    public Double getRating() {
        return this.rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getAbout() {
        return this.about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getSpecialization() {
        return this.specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public Double getId() {
        return this.id;
    }

    public void setId(Double id) {
        this.id = id;
    }

    public String getHospital() {
        return this.hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public Double getExperience() {
        return this.experience;
    }

    public void setExperience(Double experience) {
        this.experience = experience;
    }

}
