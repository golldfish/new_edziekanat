package com.zut.edziekanat.project.model.repository;

import com.zut.edziekanat.project.model.dao.SubjectDAO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Subject dao repository.
 * <p>
 * 01.06.2020 - 20:54
 */
public interface SubjectDAORepository extends JpaRepository<SubjectDAO, Long> {
    /**
     * Find by id subject dao.
     *
     * @param id the id
     * @return the subject dao
     */
    SubjectDAO findById(int id);
}
