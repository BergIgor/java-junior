package com.acme.edu;

import com.acme.edu.Exception.LogException;
/**
 * Class StateFactory have to create various types State
 */
public class StateFactory {
    private State intState;
    private State stringState;
    private State defaultState;

    /**
     * StateFactory constructor
     * @param printer
     */
    public StateFactory(Printer printer) {
        intState = new IntState(printer);
        stringState = new StringState(printer);
        defaultState = new DefaultState(printer);
    }

    /**
     * Create state of type IntState
     *
     * @return IntState
     */
    public State getInstanceIntState(State state) throws LogException{
        if ( state != null && state != intState) {
            state.flush();
        }
        return intState;
    }
    /**
     * Create state of type StringState
     *
     * @return StringState
     */
    public State getInstanceStringState(State state) throws LogException{
        if ( state != null && state != stringState) {
            state.flush();
        }
        return stringState;
    }
    /**
     * Create state of type DefaultState
     *
     * @return DefaultState
     */
    public State getInstanceDefaultState()  {
        return defaultState;
    }
}
