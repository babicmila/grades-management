package com.babicmila.grades;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.babicmila.grades.pojo.Grade;
import com.babicmila.grades.repository.GradeRepository;
import com.babicmila.grades.service.GradeService;

@RunWith(MockitoJUnitRunner.class)
public class GradeServiceTest {

    @Mock
    private GradeRepository gradeRepositoryMock;

    @InjectMocks
    private GradeService gradeService;

    @Test
    public void getGradesFromRepoTest() {

        when(gradeRepositoryMock.getAllGrades()).thenReturn(Arrays.asList(
            new Grade("Ana", "OOP", "A+"),
            new Grade("Milos", "History", "B+")
        ));

       List<Grade> result = gradeService.getAllGrades();

       assertEquals("Ana", result.get(0).getName());
       assertEquals("History", result.get(1).getSubject());

    }

    @Test
    public void gradeIndexTest() {

        Grade grade = new Grade("Ana", "OOP", "A+");

        when(gradeRepositoryMock.getAllGrades()).thenReturn(Arrays.asList(grade));
        when(gradeRepositoryMock.getGrade(0)).thenReturn(grade);

        int valid = gradeService.getGradeIndex(grade.getId());
        int notFound = gradeService.getGradeIndex("123");

        assertEquals(0, valid);
        assertEquals(-1, notFound);
    }

    @Test
    public void returnGradeByIdTest() {

        Grade grade = new Grade("Ana", "OOP", "A+");

        when(gradeRepositoryMock.getAllGrades()).thenReturn(Arrays.asList(grade));
        when(gradeRepositoryMock.getGrade(0)).thenReturn(grade);

        String id = grade.getId();
        Grade result = gradeService.getGradeById(id);

        assertEquals(grade, result);
    }

    @Test
    public void addGradeTest() {

        Grade grade = new Grade("Ana", "OOP", "A+");

        when(gradeRepositoryMock.getAllGrades()).thenReturn(Arrays.asList(grade));
        when(gradeRepositoryMock.getGrade(0)).thenReturn(grade);

        Grade newGrade = new Grade("Milos", "History", "A-");

        gradeService.submitGrade(newGrade);

        verify(gradeRepositoryMock, times(1)).addGrade(newGrade);

    }

    @Test
    public void updateGradeTest() {

        Grade grade = new Grade("Ana", "OOP", "A+");

        when(gradeRepositoryMock.getAllGrades()).thenReturn(Arrays.asList(grade));
        when(gradeRepositoryMock.getGrade(0)).thenReturn(grade);

        grade.setScore("A-");

        gradeService.submitGrade(grade);

        verify(gradeRepositoryMock, times(1)).updateGrade(0, grade);

    }

}
