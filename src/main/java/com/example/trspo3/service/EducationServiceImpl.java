package com.example.trspo3.service;


import com.example.trspo3.model.Facultative;
import com.example.trspo3.model.Administrator;
import com.example.trspo3.model.Applicant;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class EducationServiceImpl implements EducationService {

    //збереження загального списку клієнтів, ключ-id, значення - клієнт
    private static final Map<Integer, Facultative> CLIENT_REPOSITORY_MAP = new HashMap<>();
    private static final Map<Integer, Administrator> LECTURER_REPOSITORY_MAP = new HashMap<>();
    private static final Map<Integer, Applicant> STUDENT_REPOSITORY_MAP = new HashMap<>();
    private static final Map<Integer, Facultative> COURSE_REPOSITORY_MAP = new HashMap<>();


    private static final AtomicInteger LECTURER_ID_HOLDER = new AtomicInteger();
    private static final AtomicInteger STUDENT_ID_HOLDER = new AtomicInteger();
    private static final AtomicInteger COURSE_ID_HOLDER = new AtomicInteger();



    @Override
    public void createApplicant(Applicant applicant) {
        final int studentId = STUDENT_ID_HOLDER.incrementAndGet();
        applicant.setApplicantId(studentId);

        STUDENT_REPOSITORY_MAP.put(studentId, applicant);
    }

    @Override
    public void createFacultative(Facultative facultative) {
        final int courseId = COURSE_ID_HOLDER.incrementAndGet();
        facultative.setFacultativeId(courseId);
        COURSE_REPOSITORY_MAP.put(courseId, facultative);
    }



    @Override
    public List<Administrator> readAllAdministrators() {
        return new ArrayList<>(LECTURER_REPOSITORY_MAP.values());
    }

    @Override
    public Administrator readAdministrators(int lecturerId) {
        return LECTURER_REPOSITORY_MAP.get(lecturerId);
    }

    @Override
    public List<Applicant> readAllApplicants() {
        return new ArrayList<>(STUDENT_REPOSITORY_MAP.values());
    }

    @Override
    public Applicant readApplicants(int applicantId) {return STUDENT_REPOSITORY_MAP.get(applicantId);}

    @Override
    public List<Facultative> readAllFacultative() {
        return new ArrayList<>(COURSE_REPOSITORY_MAP.values());
    }

    @Override
    public Facultative readFacultative(int facultativeId) {
        return COURSE_REPOSITORY_MAP.get(facultativeId);
    }

    @Override
    public int readPoints(int facultativeId, int applicantId) {
        int[][] studentEstimates = COURSE_REPOSITORY_MAP.get(facultativeId).getApplicantPoints();
        return studentEstimates[applicantId -1][1];
    }

    @Override
    public List<Applicant> readApplicantinFacultative(int facultativeId) {
        List studentList = new ArrayList();
        int[][] studentEstimates = COURSE_REPOSITORY_MAP.get(facultativeId).getApplicantPoints();
        for(int i=0;i<studentEstimates.length;i++){
            studentList.add(STUDENT_REPOSITORY_MAP.get(studentEstimates[i][0]));
        }

        return studentList;

    }




    @Override
    public boolean updateAdministrator(Administrator administrator, int administratorId) {
        if (LECTURER_REPOSITORY_MAP.containsKey(administratorId)) {
            administrator.setAdministratorId(administratorId);
            LECTURER_REPOSITORY_MAP.put(administratorId, administrator);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateApplicant(Applicant applicant, int applicantId) {
        if (STUDENT_REPOSITORY_MAP.containsKey(applicantId)) {
            applicant.setApplicantId(applicantId);
            STUDENT_REPOSITORY_MAP.put(applicantId, applicant);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateFacultative(Facultative facultative, int facultativeId) {
        if (COURSE_REPOSITORY_MAP.containsKey(facultativeId)) {
            facultative.setFacultativeId(facultativeId);
            COURSE_REPOSITORY_MAP.put(facultativeId, facultative);
            //CLIENT_REPOSITORY_MAP.get(id).getCLIENT_ORDER_MAP().put(id_order, order);
            //CLIENT_REPOSITORY_MAP.get(id).getCLIENT_ORDER_MAP().get(id_order).getORDER_ITEMS_MAP().put(id_item, item);
            return true;
        }
        return false;
    }




    @Override
    public boolean deleteApplicant(int applicantId) {
        return STUDENT_REPOSITORY_MAP.remove(applicantId) != null;
    }

    @Override
    public boolean deleteFacultative(int facultativeId) {
        return COURSE_REPOSITORY_MAP.remove(facultativeId) != null;
    }


}
