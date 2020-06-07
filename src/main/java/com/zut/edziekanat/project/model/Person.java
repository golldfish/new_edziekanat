package com.zut.edziekanat.project.model;

/**
 * The interface Person.
 */
public interface Person
{
    /**
     * Plan filter.
     */
    void planFilter();

    /**
     * Write message.
     */
    void writeMessage();

    /**
     * Show average of subject.
     *
     * @param album the album
     * @return
     */
    double showAverageOfSubject(int album);
}
