package com.zut.edziekanat.project.model;

import java.util.ArrayList;
import java.util.List;

import com.zut.edziekanat.project.model.dao.DegreeDAO;
import com.zut.edziekanat.project.model.dao.PlanDAO;
import com.zut.edziekanat.project.model.dao.StudentDAO;
import com.zut.edziekanat.project.model.repository.DegreeDAORepository;
import com.zut.edziekanat.project.model.repository.PlanDAORepository;
import com.zut.edziekanat.project.model.repository.StudentDAORepository;
import org.springframework.stereotype.Component;

/**
 * The type Student.
 */
@Component
public class Student implements Person
{
    /**
     * The Student dao repository.
     */
    private final StudentDAORepository studentDAORepository;

    /**
     * The Degree dao repository.
     */
    private final DegreeDAORepository degreeDAORepository;

    /**
     * The Plan dao repository.
     */
    private final PlanDAORepository planDAORepository;

    /**
     * Constructor.
     *
     * @param studentDAORepository the student dao repository
     * @param degreeDAORepository  the degree dao repository
     * @param planDAORepository    the plan dao repository
     */
    public Student(final StudentDAORepository studentDAORepository,
                   final DegreeDAORepository degreeDAORepository, PlanDAORepository planDAORepository)
    {
        this.studentDAORepository = studentDAORepository;
        this.degreeDAORepository = degreeDAORepository;
        this.planDAORepository = planDAORepository;
    }

    /**
     * Gets student.
     *
     * @param albumNumber the number
     * @return the student
     */
    public StudentDAO getStudent(final int albumNumber)
    {
        return studentDAORepository.findByAlbumNumber(albumNumber);
    }

    /**
     * Gets all students.
     *
     * @return the all students
     */
    public List<StudentDAO> getAllStudents()
    {
        return studentDAORepository.findAll();
    }

    /**
     * Gets student degrees by subject.
     *
     * @param albumNumber the album number
     * @return the student degrees by subject
     */
    public List<SubjectDegrees> getStudentDegreesByAlbumNumber(final int albumNumber)
    {
        final List<SubjectDegrees> result = new ArrayList<>();
        final List<DegreeDAO> all = degreeDAORepository.findAllByAlbumId_AlbumNumber(albumNumber);

        all.forEach(degreeDAO -> {
            if (result.stream().parallel().anyMatch(
                subjectDegrees -> subjectDegrees.getSubjectTitle().equals(degreeDAO.getSubjectId().getSubjectName())))
            {
                final SubjectDegrees degrees = result.stream().parallel().filter(
                    subjectDegrees -> subjectDegrees.getSubjectTitle().equals(
                        degreeDAO.getSubjectId().getSubjectName())).findFirst().get();
                final int index = result.indexOf(degrees);
                degrees.getDegree().add(degreeDAO.getDegree());
                result.set(index, degrees);
            }
            else //is new subject
            {
                final SubjectDegrees subjectDegrees = new SubjectDegrees(degreeDAO.getSubjectId().getSubjectName());
                subjectDegrees.getTeachers().addAll(degreeDAO.getSubjectId().getTeacherDAOList());
                subjectDegrees.getDegree().add(degreeDAO.getDegree());
                result.add(subjectDegrees);
            }
        });

        result.forEach(SubjectDegrees::makeAvg); //after all let's calculating avg of degrees
        return result;
    }

    /**
     * Is minimal ects reached boolean.
     *
     * @param studentDAO the student dao
     * @return the boolean
     */
    public int getMinimalEcts(final StudentDAO studentDAO)
    {
        final StateType state = StateType.getState(studentDAO.getForm());
        return MinimalEctsPerSemestrType.minimalEcts(state, studentDAO.getSemestr());
    }

    /**
     * Gets plan for student.
     *
     * @param studentDAO the student dao
     * @return the plan for student
     */
    public List<PlanDAO> getPlanForStudent(final StudentDAO studentDAO)
    {
        return planDAORepository.findAllByGroupId_Id(studentDAO.getGroupId().getId());
    }

    @Override
    public void planFilter()
    {

    }

    @Override
    public void writeMessage()
    {

    }

    @Override
    public double showAverageOfSubject(final int album)
    {
        final Double avg = degreeDAORepository.getAvgDegree(album);
        return avg == null ? 0 : avg;
    }
}
