package com.acme.edu;

public class StateFactory {
    public State intState;
    public State stringState;

    public StateFactory(Printer printer) {
       intState = new IntState(printer);
        stringState = new StringState(printer);
    }

    public State getInstanceIntState(State state) {
        if (state != null && state != intState) {
            state.flush();
        }
        return intState;
    }

    public State getInstanceStringState(State state) {
        if (state!= null && state != stringState) {
            state.flush();
        }
        return stringState;
    }
}
