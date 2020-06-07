package com.zut.edziekanat.project.model.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

/**
 * The type Student.
 */
@Getter
@Setter
@Entity(name = "student")
@Table(name = "student")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class StudentDAO extends PersonDAO
{
    /**
     * The Album number.
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
    @Column(name = "nr_albumu")
    private int albumNumber;

    /**
     * The Semestr.
     */
    @Column(name = "semestr")
    private int semestr;

    /**
     * The Field of study.
     */
    @Column(name = "kierunek")
    private String fieldOfStudy;

    /**
     * The Degree of study.
     */
    @Column(name = "stopien")
    private String degreeOfStudy;

    /**
     * The Form.
     */
    @Column(name = "forma")
    private String form;

    /**
     * The Ects points
     */
    @Column(name = "punkty_ECTS")
    private int ectsPoints;

    /**
     * The Group id.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_grupa")
    private GroupDAO groupId;

    /**
     * The Group id.
     */
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_ocena")
    private List<DegreeDAO> degreeId;

    @Override
    public String toString()
    {
        return "StudentDAO{" +
            "albumNumber=" + albumNumber +
            ", semestr=" + semestr +
            ", fieldOfStudy='" + fieldOfStudy + '\'' +
            ", degreeOfStudy='" + degreeOfStudy + '\'' +
            ", form='" + form + '\'' +
            ", ectsPoints=" + ectsPoints +
            "} " + super.toString();
    }
}
