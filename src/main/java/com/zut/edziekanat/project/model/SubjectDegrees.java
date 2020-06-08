package com.zut.edziekanat.project.model;

import com.zut.edziekanat.project.model.dao.TeacherDAO;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

/**
 * The type Subject degrees.
 */
@Getter
@RequiredArgsConstructor
public class SubjectDegrees {
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
    public void makeAvg() {
        Double sumDegree = 0d;
        if (degree.size() > 0) {
            for (Double value : degree) {
                sumDegree += value;
            }
            final DecimalFormat df = new DecimalFormat("###.##", DecimalFormatSymbols.getInstance(Locale.US));
            subjectAvgDegree = Double.parseDouble(df.format(1.0d * sumDegree / degree.size()));
            if (degree.size() < 3) {
                endDegree = 0d;
            } else if (subjectAvgDegree % 1 < 0.25) {
                endDegree = Math.floor(subjectAvgDegree);
            } else if (0.25 <= (subjectAvgDegree % 1) && (subjectAvgDegree % 1) < 0.75) {
                endDegree = Math.floor(subjectAvgDegree) + 0.5;
            } else {
                endDegree = Math.floor(subjectAvgDegree) + 1;
            }
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        final SubjectDegrees that = (SubjectDegrees) o;
        return Objects.equals(subjectTitle, that.subjectTitle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subjectTitle, degree, teachers, subjectAvgDegree, endDegree);
    }
}
