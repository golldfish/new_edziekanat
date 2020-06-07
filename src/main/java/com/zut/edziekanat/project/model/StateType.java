package com.zut.edziekanat.project.model;

/**
 * The enum State type.
 *
 *  on 03.06.2020 - 22:08
 */
public enum StateType
{
    /**
     * State state type.
     */
    STATE("stacjonarne"),
    /**
     * Non state state type.
     */
    NON_STATE("niestacjonarne");

    /**
     * The Type.
     */
    private final String type;

    /**
     * Constructor.
     *
     * @param type the type
     */
    StateType(final String type)
    {
        this.type = type;
    }

    /**
     * Gets state.
     *
     * @param type the type
     *
     * @return the state
     */
    public static StateType getState(final String type)
    {
        for (StateType value : StateType.values())
        {
            if(value.type.equals(type.toLowerCase())){
                return value;
            }
        }
throw new IllegalArgumentException(type + " is not recognized");
    }
}
