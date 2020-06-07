package com.zut.edziekanat.project.controller;

import java.util.List;

import com.zut.edziekanat.project.model.Student;
import com.zut.edziekanat.project.model.Teacher;
import com.zut.edziekanat.project.model.dao.StudentDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *  25.05.2020 - 16:04
 */
@Controller
public class MainController
{
    private final Student student;

    private final Teacher teacher;

    public MainController(final Student student, final Teacher teacher)
    {
        this.student = student;
        this.teacher = teacher;
    }

    @GetMapping(value = { "/", "/index" })
    public String index(final Model model)
    {
        return students(model);
    }

    @GetMapping(value = "students")
    public String students(final Model model)
    {
        final List<StudentDAO> allStudents = student.getAllStudents();
        model.addAttribute("studentList", allStudents);
        model.addAttribute("studentCount", allStudents.size());
        return "students";
    }
}
