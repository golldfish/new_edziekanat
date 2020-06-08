package com.zut.edziekanat.project.controller;

import com.zut.edziekanat.project.model.Student;
import com.zut.edziekanat.project.model.SubjectDegrees;
import com.zut.edziekanat.project.model.Teacher;
import com.zut.edziekanat.project.model.dao.PlanDAO;
import com.zut.edziekanat.project.model.dao.StudentDAO;
import com.zut.edziekanat.project.model.dao.TeacherDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;
import java.util.Locale;

/**
 * 02.06.2020 - 00:13
 */
@Controller
@RequestMapping("/student")
public class StudentController {
    /**
     * The Student.
     */
    private final Student student;

    /**
     * The Teacher.
     */
    private final Teacher teacher;

    /**
     * Constructor.
     *
     * @param student the student
     * @param teacher the teacher
     */
    public StudentController(final Student student, final Teacher teacher) {
        this.student = student;
        this.teacher = teacher;
    }

    /**
     * General info string.
     *
     * @param model the model
     * @param album the album
     * @return the string
     */
    @GetMapping("{album}")
    public String generalInfo(final Model model, @PathVariable String album) {
        final StudentDAO studentDAO = student.getStudent(Integer.parseInt(album));

        model.addAttribute("student", studentDAO);

        return "student/info";
    }

    /**
     * Degree info string.
     *
     * @param model the model
     * @param album the album
     * @return the string
     */
    @GetMapping("{album}/degree")
    public String degreeInfo(final Model model, @PathVariable final String album) {
        final StudentDAO studentDAO = student.getStudent(Integer.parseInt(album));

        final List<SubjectDegrees> degrees = student.getStudentDegreesByAlbumNumber(studentDAO.getAlbumNumber());
        double averageDegree = getEndAvgDegree(degrees);
        model.addAttribute("student", studentDAO);
        model.addAttribute("subjectDegrees", degrees);
        model.addAttribute("avg", averageDegree);

        model.addAttribute("ects", student.getMinimalEcts(studentDAO));

        if (averageDegree >= 4.0) {
            model.addAttribute("stypendium", true);
        }

        return "student/degree";
    }

    private double getEndAvgDegree(List<SubjectDegrees> degrees) {
        final DecimalFormat df = new DecimalFormat("###.##", DecimalFormatSymbols.getInstance(Locale.US));
        double degree = 0;
        if(degrees.size() > 0){
            for (final SubjectDegrees subjectDegrees : degrees) {
                degree += subjectDegrees.getEndDegree();
            }
            degree = degree / degrees.size();
        }
        return Double.parseDouble(df.format(degree));
    }

    /**
     * Contact with teacher string.
     *
     * @param model the model
     * @param id    the id
     * @return the string
     */
    @GetMapping("teacher/{id}")
    public String contactWithTeacher(final Model model, @PathVariable final String id) {
        final TeacherDAO teacher = this.teacher.getTeacher(Integer.parseInt(id));
        model.addAttribute("teacher", teacher);
        return "student/teacherInfo";
    }

    /**
     * Contact with teacher string.
     *
     * @param model the model
     * @param id    the id
     * @return the string
     */
    @GetMapping("teacher/{id}/panel")
    public String contactWithTeacherPanel(final Model model, @PathVariable final String id) {
        final TeacherDAO teacher = this.teacher.getTeacher(Integer.parseInt(id));
        model.addAttribute("teacher", teacher);
        return "student/teacherInfoPanel";
    }

    @GetMapping("{albumNumber}/plan")
    public String showPlan(final Model model, @PathVariable final String albumNumber) {
        final StudentDAO studentDAO = student.getStudent(Integer.parseInt(albumNumber));
        final List<PlanDAO> planForStudent = student.getPlanForStudent(studentDAO);
        model.addAttribute("plan", planForStudent);
        model.addAttribute("student", studentDAO);
        model.addAttribute("subjects", studentDAO.getGroupId().getSubjectList());
        return "student/plan";
    }
}
