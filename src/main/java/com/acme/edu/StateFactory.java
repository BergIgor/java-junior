package com.acme.edu;

public class StateFactory {
    public static State intState;
    public static State stringState;
    public static State defaultState;

    public StateFactory(Printer printer) {
        intState = new IntState(printer);
        stringState = new StringState(printer);
        defaultState = new DefaultState(printer);
    }

    /**
     * Create state of type IntState
     *
     * @param state - State will be created
     * @return IntState
     */
    public State getInstanceIntState(State state) {
        return intState;
    }
    /**
     * Create state of type StringState
     *
     * @param state - State will be created
     * @return StringState
     */
    public State getInstanceStringState(State state) {
        return stringState;
    }
    /**
     * Create state of type DefaultState
     *
     * @param state - State will be created
     * @return DefaultState
     */
    public State getInstanceDefaultState(State state) {
        return defaultState;
    }
}
