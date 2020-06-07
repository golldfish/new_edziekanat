package com.zut.edziekanat.project.model;

import java.util.List;

import com.zut.edziekanat.project.model.dao.TeacherDAO;
import com.zut.edziekanat.project.model.repository.TeacherDAORepository;
import org.springframework.stereotype.Component;

/**
 * The type Teacher.
 *
 *  25.05.2020 - 20:34
 */
@Component
public class Teacher implements Person
{
    /**
     * The Repository.
     */
    private final TeacherDAORepository repository;

    /**
     * Instantiates a new Teacher.
     *
     * @param repository the repository
     */
    public Teacher(final TeacherDAORepository repository)
    {
        this.repository = repository;
    }

    /**
     * Gets teacher.
     *
     * @param id the id
     *
     * @return the teacher
     */
    public TeacherDAO getTeacher(int id)
    {
        return repository.findByIdTeacher(id);
    }

    /**
     * Gets all teachers.
     *
     * @return the all teachers
     */
    public List<TeacherDAO> getAllTeachers()
    {
        return repository.findAll();
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

        return 0;
    }

}
