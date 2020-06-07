package com.zut.edziekanat.project.model.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

/**
 * The type Subject dao.
 *
 *  25.05.2020 - 20:16
 */
@Getter
@Setter
@Entity(name = "przedmiot")
@Table(name = "przedmiot")
public class SubjectDAO
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
    @Column(name = "id_przedmiot")
    private int id;

    /**
     * The Subject name.
     */
    @Column(name = "nazwa_przedmiot")
    private String subjectName;

    /**
     * The Group dao list.
     */
    @ManyToMany
    @JoinTable(
        name = "grupa_przedmiot",
        joinColumns = @JoinColumn(name = "id_grupa"),
        inverseJoinColumns = @JoinColumn(name = "id_przedmiot"))
    private List<GroupDAO> groupDAOList;

    /**
     * The Teacher dao list.
     */
    @ManyToMany
    @JoinTable(
        name = "przedmiot_wykladowca",
        joinColumns = @JoinColumn(name = "id_przedmiot"),
        inverseJoinColumns = @JoinColumn(name = "id_wykladowca"))
    private List<TeacherDAO> teacherDAOList;

    @Override
    public String toString()
    {
        return "SubjectDAO{" +
            "id=" + id +
            ", subjectName='" + subjectName + '\'' +
            '}';
    }
}

