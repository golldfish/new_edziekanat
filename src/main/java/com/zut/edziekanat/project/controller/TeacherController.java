package com.zut.edziekanat.project.controller;

import com.zut.edziekanat.project.model.Teacher;
import com.zut.edziekanat.project.model.dao.TeacherDAO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * The type Teacher controller.
 *
 *  02.06.2020 - 15:52
 */
@RequestMapping("/teacher")
public class TeacherController
{
    /**
     * The Teacher.
     */
    private final Teacher teacher;

    /**
     * Controller.
     *
     * @param teacher the teacher
     */
    public TeacherController(final Teacher teacher)
    {
        this.teacher = teacher;
    }

    @RequestMapping("{id}")
    public String generalInfo(@PathVariable final String id)
    {
        final TeacherDAO teacher = this.teacher.getTeacher(Integer.parseInt(id));
        return "index";
    }
}
