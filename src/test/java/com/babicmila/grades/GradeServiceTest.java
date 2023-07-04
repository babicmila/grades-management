package com.babicmila.grades;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.babicmila.grades.repository.GradeRepository;
import com.babicmila.grades.service.GradeService;

@RunWith(MockitoJUnitRunner.class)
public class GradeServiceTest {

    @Mock
    private GradeRepository gradeRepositoryMock;

    @InjectMocks
    private GradeService gradeService;

}
