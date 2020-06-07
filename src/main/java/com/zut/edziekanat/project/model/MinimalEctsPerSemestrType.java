package com.zut.edziekanat.project.model;

/**
 * The enum Minimal ects per semestr type.
 *
 *  on 03.06.2020 - 21:40
 */
public enum MinimalEctsPerSemestrType
{
    /**
     * Non state s 1 minimal ects per semestr type.
     */
    NON_STATE_S1(11, StateType.NON_STATE, 1),
    /**
     * Non state s 2 minimal ects per semestr type.
     */
    NON_STATE_S2(32, StateType.NON_STATE, 2),
    /**
     * Non state s 3 minimal ects per semestr type.
     */
    NON_STATE_S3(58, StateType.NON_STATE, 3),
    /**
     * Non state s 4 minimal ects per semestr type.
     */
    NON_STATE_S4(84, StateType.NON_STATE, 4),
    /**
     * Non state s 5 minimal ects per semestr type.
     */
    NON_STATE_S5(110, StateType.NON_STATE, 5),
    /**
     * Non state s 6 minimal ects per semestr type.
     */
    NON_STATE_S6(144, StateType.NON_STATE, 6),
    /**
     * Non state s 7 minimal ects per semestr type.
     */
    NON_STATE_S7(179, StateType.NON_STATE, 7),

    /**
     * State s 1 minimal ects per semestr type.
     */
    STATE_S1(14, StateType.STATE, 1),
    /**
     * State s 2 minimal ects per semestr type.
     */
    STATE_S2(36, StateType.STATE, 2),
    /**
     * State s 3 minimal ects per semestr type.
     */
    STATE_S3(66, StateType.STATE, 3),
    /**
     * State s 4 minimal ects per semestr type.
     */
    STATE_S4(96, StateType.STATE, 4),
    /**
     * State s 5 minimal ects per semestr type.
     */
    STATE_S5(140, StateType.STATE, 5),
    /**
     * State s 6 minimal ects per semestr type.
     */
    STATE_S6(174, StateType.STATE, 6);

    /**
     * The Minimal ects.
     */
    private final int minimalEcts;

    /**
     * The Semestr.
     */
    private final int semestr;

    /**
     * The State.
     */
    private final StateType state;

    /**
     * Constructor.
     *
     * @param minimalEcts the minimal ects
     * @param state       the state
     * @param semestr     the semestr
     */
    MinimalEctsPerSemestrType(final int minimalEcts, final StateType state, final int semestr)
    {
        this.minimalEcts = minimalEcts;
        this.state = state;
        this.semestr = semestr;
    }

    /**
     * Minimal ects int.
     *
     * @param type    the type
     * @param semestr the semestr
     *
     * @return the int
     */
    public static int minimalEcts(StateType type, int semestr)
    {
        for (MinimalEctsPerSemestrType value : MinimalEctsPerSemestrType.values())
        {
            if (value.state.equals(type) && value.semestr == semestr)
            {
                return value.minimalEcts;
            }
        }
        throw new IllegalArgumentException(type + "is not recognized");
    }
}
