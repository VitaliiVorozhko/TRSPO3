package com.example.trspo3.service;

import com.example.trspo3.model.Facultative;
import com.example.trspo3.model.Administrator;
import com.example.trspo3.model.Applicant;

import java.util.List;

public interface EducationService {

    void createApplicant(Applicant applicant);

    void createFacultative(Facultative facultative);

    List<Administrator> readAllAdministrators();

    Administrator readAdministrators(int lecturerId);

    List<Applicant> readAllApplicants();

    Applicant readApplicants(int applicantId);

    List<Facultative> readAllFacultative();

    Facultative readFacultative(int facultativeId);

    int readPoints(int facultativeId, int applicantId);


    List<Applicant> readApplicantinFacultative(int facultativeId);

    boolean updateAdministrator(Administrator administrator, int administratorId);

    boolean updateApplicant(Applicant applicant, int applicantId);

    boolean updateFacultative(Facultative facultative, int facultativeId);

    boolean deleteApplicant(int applicantId);

    boolean deleteFacultative(int facultativeId);
}
