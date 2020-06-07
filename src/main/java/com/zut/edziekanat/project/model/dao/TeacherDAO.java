package com.zut.edziekanat.project.model.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

/**
 * The type Teacher dao.
 *
 *  25.05.2020 - 19:51
 */
@Getter
@Setter
@Entity(name = "wykladowca")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "wykladowca")
public class TeacherDAO extends PersonDAO
{
    @Id
    @GeneratedValue(
        strategy = GenerationType.AUTO,
        generator = "native"
    )
    @GenericGenerator(
        name = "native",
        strategy = "native"
    )
    @Column(name = "id_wykladowca")
    private int idTeacher;

    /**
     * The Title.
     */
    @Column(name = "tytul_naukowy")
    private String title;

    /**
     * The Subject dao list.
     */
    @ManyToMany
    @JoinTable(
        name = "przedmiot_wykladowca",
        joinColumns = @JoinColumn(name = "id_wykladowca"),
        inverseJoinColumns = @JoinColumn(name = "id_przedmiot")
    )
    private List<SubjectDAO> subjectDAOList;

    @Override
    public String toString()
    {
        return "TeacherDAO{" +
            "idTeacher=" + idTeacher +
            ", title='" + title + '\'' +
            '}';
    }
}
