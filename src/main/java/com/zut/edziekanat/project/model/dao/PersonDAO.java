package com.zut.edziekanat.project.model.dao;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.Data;

/**
 * The type Person dao.
 */
@Data
@MappedSuperclass
public abstract class PersonDAO
{
    /**
     * The Name.
     */
    @Column(name = "imie")
    private String name;

    /**
     * The Last name.
     */
    @Column(name = "nazwisko")
    private String lastName;

    /**
     * The Department.
     */
    @Column(name = "wydzial")
    private String department;

    /**
     * The Mail.
     */
    @Column(name = "email")
    private String mail;

}
