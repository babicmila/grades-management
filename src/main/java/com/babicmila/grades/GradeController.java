package com.babicmila.grades;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.babicmila.Grade;

@Controller
public class GradeController {

    @GetMapping("/grades")
    public String getGrades(Model model) {

        Grade grade = new Grade("Mila", "OOP", "A+");
        model.addAttribute("grade", grade);

        return "grades";
    }

}
