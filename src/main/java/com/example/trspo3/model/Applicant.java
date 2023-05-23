package com.example.trspo3.model;

public class Applicant {
    private Integer applicantId;
    private String name;
    private String email;
    private String phone;
    private String facultative;
    private String points;

    public Integer getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(Integer applicantId) {
        this.applicantId = applicantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFacultative() {
        return facultative;
    }

    public void setFacultative(String facultative) {
        this.facultative = facultative;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

}
