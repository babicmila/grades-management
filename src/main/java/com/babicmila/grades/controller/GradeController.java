package com.babicmila.grades.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.babicmila.grades.Grade;
import com.babicmila.grades.repository.GradeRepository;
import com.babicmila.grades.service.GradeService;

import jakarta.validation.Valid;

@Controller
public class GradeController {

    GradeService gradeService = new GradeService();

    @GetMapping("/")
    public String gradeForm(Model model, @RequestParam(required = false) String id) {

        model.addAttribute("grade", gradeService.getGradeById(id));

        return "form";
    }

    @PostMapping("/handleSubmit")
    public String submitForm(@Valid Grade grade, BindingResult result) {

        if (result.hasErrors())
            return "form";

        gradeService.submitGrade(grade);

        return "redirect:/grades";
    }

    @GetMapping("/grades")
    public String getGrades(Model model) {

        model.addAttribute("grades", gradeService.getAllGrades());

        return "grades";
    }

}
