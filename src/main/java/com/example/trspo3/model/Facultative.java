package com.example.trspo3.model;

public class Facultative {
    private Integer facultativeId;
    private String name;
    private Integer numberofplace;

    int[][] archive = new int[6][2];

    public int[][] getApplicantPoints() {
        return archive;
    }

    public void setApplicantEstimates(int[][] studentEstimates) {
        this.archive = studentEstimates;
    }

    public Integer getFacultativeId() {
        return facultativeId;
    }

    public void setFacultativeId(Integer courseId) {
        this.facultativeId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Integer getNumberofplace() {
        return numberofplace;
    }

    public void setNumberofplace(Integer numberofplace) {
        this.numberofplace = numberofplace;
    }
}
