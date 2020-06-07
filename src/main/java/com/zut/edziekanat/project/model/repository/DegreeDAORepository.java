package com.zut.edziekanat.project.model.repository;

import java.util.List;

import com.zut.edziekanat.project.model.dao.DegreeDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * The interface Degree dao repository.
 */
public interface DegreeDAORepository extends JpaRepository<DegreeDAO, Long>
{
    /**
     * Find by subject id degree dao.
     *
     * @param subjectId the subject id
     *
     * @return the degree dao
     */
    DegreeDAO findBySubjectId(int subjectId);

    /**
     * Find all by album id list.
     *
     * @param albumId the album id
     *
     * @return the list
     */
    List<DegreeDAO> findAllByAlbumId_AlbumNumber(final int albumId);

    /**
     * Gets avg degree.
     *
     * @param album the album
     *
     * @return the avg degree
     */
    @Query("select avg(degree.degree) from DegreeDAO degree where degree.albumId.albumNumber = :album")
    Double getAvgDegree(final @Param("album") int album);

    /**
     * Gets avg subject degree.
     *
     * @param album     the album
     * @param subjectId the subject id
     *
     * @return the avg subject degree
     */
    @Query("select avg(degree.degree) from DegreeDAO degree where degree.albumId.albumNumber = :album and degree.subjectId.id = :subjectId")
    Double getAvgSubjectDegree(final @Param("album") int album, final @Param("subjectId") int subjectId);

    /**
     * Find all by subject id list.
     *
     * @param subjectId the subject id
     *
     * @return the list
     */
    List<DegreeDAO> findAllBySubjectId_Id(int subjectId);
}
