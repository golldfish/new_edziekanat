package com.zut.edziekanat.project.model.repository;

import com.zut.edziekanat.project.model.dao.StudentDAO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Student dao repository.
 */
public interface StudentDAORepository extends JpaRepository<StudentDAO, Long>
{
    /**
     * Find by album number student dao.
     *
     * @param albumNumber the album number
     *
     * @return the student dao
     */
    StudentDAO findByAlbumNumber(int albumNumber);
}
