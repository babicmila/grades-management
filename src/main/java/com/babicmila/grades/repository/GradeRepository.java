package com.babicmila.grades.repository;

import java.util.ArrayList;
import java.util.List;

import com.babicmila.grades.Grade;

public class GradeRepository {

    private List<Grade> gradeslist = new ArrayList<>();

    public Grade getGrade(int index) {
        return gradeslist.get(index);
    }

    public void addGrade(Grade grade) {
        gradeslist.add(grade);
    }

    public void updateGrade(int index, Grade grade) {
        gradeslist.set(index, grade);
    }

    public List<Grade> getAllGrades() {
        return gradeslist;
    }
}
