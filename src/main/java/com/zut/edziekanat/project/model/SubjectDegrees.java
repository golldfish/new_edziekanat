package com.zut.edziekanat.project.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.zut.edziekanat.project.model.dao.TeacherDAO;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * The type Subject degrees.
 */
@Getter
@RequiredArgsConstructor
public class SubjectDegrees
{
    /**
     * The Subject title.
     */
    private final String subjectTitle;

    /**
     * The Degree.
     */
    private final List<Double> degree = new ArrayList<>();

    /**
     * The Teacher daos.
     */
    private final List<TeacherDAO> teachers = new ArrayList<>();

    /**
     * The Subject avg degree.
     */
    private Double subjectAvgDegree;

    /**
     * The End degree.
     */
    private Double endDegree;

    /**
     * Make avg.
     */
    public void makeAvg()
    {
        Double avg = 0d;
        for (Double value : degree)
        {
            avg += value;
        }
        subjectAvgDegree = 1.0d * avg / degree.size();

        if (subjectAvgDegree % 1 < 0.25)
        {
            endDegree = ((double) Math.round(subjectAvgDegree));
        }
        else if (0.25 <= (subjectAvgDegree % 1) && (subjectAvgDegree % 1) < 0.75)
        {
            endDegree = ((double) Math.round(subjectAvgDegree)) + 0.5;
        }
        else
        {
            endDegree = ((double) Math.round(subjectAvgDegree)) + 1;
        }
    }

    @Override
    public boolean equals(final Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        final SubjectDegrees that = (SubjectDegrees) o;
        return Objects.equals(subjectTitle, that.subjectTitle);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(subjectTitle, degree, teachers, subjectAvgDegree, endDegree);
    }
}
