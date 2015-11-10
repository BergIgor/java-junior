package com.acme.edu;

import com.acme.edu.Exception.StateNullException;

/**
 * Class StateFactory have to create various types State
 */
public class StateFactory {
    private State intState;
    private State stringState;
    private State defaultState;

    /**
     * StateFactory constructor
     * @param printers
     */
    public StateFactory(Printer... printers) {
        intState = new IntState(printers);
        stringState = new StringState(printers);
        defaultState = new DefaultState(printers);
    }

    /**
     * Create state of type IntState
     *
     * @return IntState
     */
    public State getInstanceIntState(State state) throws StateNullException{
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
    public State getInstanceStringState(State state) throws StateNullException{
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
