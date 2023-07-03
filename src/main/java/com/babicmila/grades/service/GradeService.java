package com.babicmila.grades.service;

import java.util.List;

import com.babicmila.grades.Grade;
import com.babicmila.grades.repository.GradeRepository;

public class GradeService {

    GradeRepository gradeRepository = new GradeRepository();

    public Grade getGrade(int index) {
        return gradeRepository.getGrade(index);
    }

    public void addGrade(Grade grade) {
        gradeRepository.addGrade(grade);
    }

    public void updateGrade(int index, Grade grade) {
        gradeRepository.updateGrade(index, grade);
    }

    public List<Grade> getAllGrades() {
        return gradeRepository.getAllGrades();
    }

    public int getGradeIndex(String id) {

        int size = getAllGrades().size();
        for (int i = 0; i < size; i++) {
            if (getAllGrades().get(i).getId().equals(id))
                return i;
        }
        return -1;
    }

    public Grade getGradeById(String id) {

        int index = getGradeIndex(id);

        return index == -1 ? new Grade() : getGrade(index);
    }

    public void submitGrade(Grade grade) {

        int index = getGradeIndex(grade.getId());

        if (index == -1) {
            addGrade(grade);
        } else {
            updateGrade(index, grade);
        }
    }
}
