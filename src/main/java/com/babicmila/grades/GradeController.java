package com.babicmila.grades;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.babicmila.Grade;

@Controller
public class GradeController {

    List<Grade> gradeslist = Arrays.asList(
        new Grade("Mila", "OOP", "A+"),
        new Grade("Ana", "Math", "B+"),
        new Grade("Milos", "Art history", "A-")
    );

    @GetMapping("/grades")
    public String getGrades(Model model) {

        model.addAttribute("grades", gradeslist);

        return "grades";
    }

}
