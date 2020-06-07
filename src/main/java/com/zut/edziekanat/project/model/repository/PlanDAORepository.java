package com.zut.edziekanat.project.model.repository;

import com.zut.edziekanat.project.model.dao.PlanDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlanDAORepository extends JpaRepository<PlanDAO, Long> {

    @Query("Select plan from PlanDAO plan WHERE plan.groupId.id = :id ORDER BY plan.date")
    List<PlanDAO> findAllByGroupId_Id(final @Param("id") int id);
}
