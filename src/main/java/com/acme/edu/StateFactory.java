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

    public State getInstanceIntState(State state) {
        return intState;
    }

    public State getInstanceStringState(State state) {
        return stringState;
    }

    public State getInstanceDefaultState(State state) {
        return defaultState;
    }
}
