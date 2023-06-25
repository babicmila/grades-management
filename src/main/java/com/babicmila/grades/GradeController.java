package com.babicmila.grades;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GradeController {

    List<Grade> gradeslist = new ArrayList<>();

    @GetMapping("/")
    public String gradeForm(Model model, @RequestParam(required = false) String id) {

        Grade grade;

        if (getGradeIndex(id) == -1) {
            grade = new Grade();
        } else {
            grade = gradeslist.get(getGradeIndex(id));
        }
        model.addAttribute("grade", grade);

        return "form";
    }

    @PostMapping("/handleSubmit")
    public String submitForm(Grade grade) {

        int index = getGradeIndex(grade.getId());

        if (index == -1) {
            gradeslist.add(grade);
        } else {
            gradeslist.set(index, grade);
        }
        return "redirect:/grades";
    }

    @GetMapping("/grades")
    public String getGrades(Model model) {

        model.addAttribute("grades", gradeslist);

        return "grades";
    }

    public Integer getGradeIndex(String id) {
        for (int i = 0; i < gradeslist.size(); i++) {
            if (gradeslist.get(i).getId().equals(id))
                return i;
        }
        return -1;
    }
}
