package com.zut.edziekanat.project.model.repository;

import com.zut.edziekanat.project.model.dao.TeacherDAO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Teacher dao repository.
 *
 *  01.06.2020 - 20:51
 */
public interface TeacherDAORepository extends JpaRepository<TeacherDAO, Long>
{

    /**
     * Find by id teacher teacher dao.
     *
     * @param idTeacher the id teacher
     *
     * @return the teacher dao
     */
    TeacherDAO findByIdTeacher(int idTeacher);
}
