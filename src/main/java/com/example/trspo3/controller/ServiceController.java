package com.example.trspo3.controller;

import com.example.trspo3.model.Facultative;
import com.example.trspo3.model.Administrator;
import com.example.trspo3.model.Applicant;
import com.example.trspo3.service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ServiceController {


    private final EducationService educationService;
    @Autowired
    public ServiceController(EducationService educationService) {
        this.educationService = educationService;
    }

    //post


    @PostMapping(value = "/applicant")
    public ResponseEntity<?> create(@RequestBody Applicant applicant) {
        educationService.createApplicant(applicant);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping(value = "/facultative")
    public ResponseEntity<?> create(@RequestBody Facultative facultative) {
        educationService.createFacultative(facultative);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    //get

    @GetMapping(value = "/administrator")
    public ResponseEntity<List<Administrator>> readAdministrator() {
        final List<Administrator> administrators = educationService.readAllAdministrators();

        return administrators != null && !administrators.isEmpty()
                ? new ResponseEntity<>(administrators, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/administrators/{administratorId}")
    public ResponseEntity<Administrator> readAdministrator(@PathVariable(name = "administratorId") int administratorId) {
        final Administrator administrator = educationService.readAdministrators(administratorId);

        return administrator != null
                ? new ResponseEntity<>(administrator, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/applicants")
    public ResponseEntity<List<Applicant>> readApplicants() {
        final List<Applicant> applicants = educationService.readAllApplicants();

        return applicants != null && !applicants.isEmpty()
                ? new ResponseEntity<>(applicants, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/applicants/{applicantId}")
    public ResponseEntity<Applicant> readApplicants(@PathVariable(name = "applicantId") int studentId) {
        final Applicant applicant = educationService.readApplicants(studentId);

        return applicant != null
                ? new ResponseEntity<>(applicant, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @GetMapping(value = "/facultatives")
    public ResponseEntity<List<Facultative>> readFacultatives() {
        final List<Facultative> cours = educationService.readAllFacultative();

        return cours != null && !cours.isEmpty()
                ? new ResponseEntity<>(cours, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/facultatives/{facultativeId}")
    public ResponseEntity<Facultative> readFacultatives(@PathVariable(name = "facultativeId") int facultativeId) {
        final Facultative facultative = educationService.readFacultative(facultativeId);

        return facultative != null
                ? new ResponseEntity<>(facultative, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/facultative/{facultativeId}/applicants/{applicantId}/points")
    public ResponseEntity<Integer> readPoints(@PathVariable(name = "facultativeId") int facultativeId, @PathVariable(name = "applicantId") int applicantId) {
        final Integer points = educationService.readPoints(facultativeId,applicantId);

        return points != null
                ? new ResponseEntity<>(points, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/facultatives/{facultativeId}/applicants")
    public ResponseEntity<List<Applicant>> readApplicantsinFacultative(@PathVariable(name = "facultativeId") int facultativeId) {
        final List<Applicant> applicants = educationService.readApplicantinFacultative(facultativeId);

        return applicants != null
                ? new ResponseEntity<>(applicants, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    //put

    @PutMapping(value = "/administrators/{administratorId}")
    public ResponseEntity<?> updateAdministrator(@PathVariable(name = "administratorId") int administratorId, @RequestBody Administrator administrator) {
        final boolean updated = educationService.updateAdministrator(administrator, administratorId);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @PutMapping(value = "/applicants/{applicantId}")
    public ResponseEntity<?> updateApplicant(@PathVariable(name = "applicantId") int applicantId, @RequestBody Applicant applicant) {
        final boolean updated = educationService.updateApplicant(applicant, applicantId);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @PutMapping(value = "/facultatives/{facultativeId}")
    public ResponseEntity<?> updateFacultative(@PathVariable(name = "facultativeId") int facultativeId, @RequestBody Facultative facultative) {
        final boolean updated = educationService.updateFacultative(facultative, facultativeId);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    //delete


    @DeleteMapping(value = "/applicants/{applicantId}")
    public ResponseEntity<?> deleteApplicant(@PathVariable(name = "applicantId") int applicantId) {
        final boolean deleted = educationService.deleteApplicant(applicantId);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}


