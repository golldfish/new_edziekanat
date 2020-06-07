package com.zut.edziekanat.project.model.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

/**
 * The type Degree dao.
 */
@Getter
@Setter
@Entity
@Table(name = "ocena")
public class DegreeDAO
{
    /**
     * The Id.
     */
    @Id
    @GeneratedValue(
        strategy = GenerationType.AUTO,
        generator = "native"
    )
    @GenericGenerator(
        name = "native",
        strategy = "native"
    )
    @Column(name = "id_ocena")
    private int id;

    /**
     * The Degree.
     */
    @Column(name = "ocena")
    private Double degree;

    /**
     * The Album id.
     */
    @ManyToOne
    @JoinColumn(name = "nr_albumu")
    private StudentDAO albumId;

    /**
     * The Subject id.
     */
    @ManyToOne
    @JoinColumn(name = "id_przedmiot")
    private SubjectDAO subjectId;

    @Override
    public String toString()
    {
        return "DegreeDAO{" +
            "id=" + id +
            ", degree='" + degree + '\'' +
            '}';
    }
}
