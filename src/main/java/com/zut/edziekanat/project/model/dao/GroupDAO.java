package com.zut.edziekanat.project.model.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

/**
 * The type Group dao.
 */
@Getter
@Setter
@Entity(name = "grupa")
@Table(name = "grupa")
public class GroupDAO
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
    @Column(name = "id_grupa")
    private int id;

    /**
     * The Field of study.
     */
    @Column(name = "kierunek")
    private String fieldOfStudy;

    /**
     * The Subject list.
     */
    @ManyToMany
    @JoinTable(
        name = "grupa_przedmiot",
        joinColumns = @JoinColumn(name = "id_grupa"),
        inverseJoinColumns = @JoinColumn(name = "id_przedmiot")
    )
    private List<SubjectDAO> subjectList;

    /**
     * The Student dao list.
     */
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "nr_albumu")
    private List<StudentDAO> studentDAOList;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_plan_zajec")
    private List<PlanDAO> planDAOList;

    @Override
    public String toString()
    {
        return "GroupDAO{" +
            "id=" + id +
            ", fieldOfStudy='" + fieldOfStudy + '\'' +
            '}';
    }
}

