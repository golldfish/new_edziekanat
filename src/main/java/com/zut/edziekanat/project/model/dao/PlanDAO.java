package com.zut.edziekanat.project.model.dao;

import lombok.Getter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * The type Plan dao.
 */
@Getter
@Entity
@Table(name = "plan_zajec")
public class
PlanDAO {
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
    @Column(name = "id_plan_zajec")
    private int id;

    @Column(name = "data", columnDefinition = "DATE")
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(name = "data_czas_od", columnDefinition = "TIME")
    @Temporal(TemporalType.TIME)
    private Date dateTimeFrom;

    @Column(name = "data_czas_do", columnDefinition = "TIME")
    @Temporal(TemporalType.TIME)
    private Date dateTimeTo;

    @Column(name = "sala")
    private int room;

    @JoinColumn(name = "id_przedmiot")
    @ManyToOne(fetch = FetchType.EAGER)
    private SubjectDAO subjectId;

    @JoinColumn(name = "id_grupa")
    @ManyToOne(fetch = FetchType.LAZY)
    private GroupDAO groupId;
}
