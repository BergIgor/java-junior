package com.acme.edu;

import com.acme.edu.Exception.LogException;

/**
 * Abstract class State
 */
public abstract class State {

    /**
     *
     * @param str - string will be logged
     * @throws LogException
     */
    public abstract void log(String str)throws LogException;

    /**
     * Method for release buffer
     * @throws LogException
     */
    public abstract  void flush()throws LogException;
}



