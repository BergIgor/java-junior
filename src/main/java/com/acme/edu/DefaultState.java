package com.acme.edu;

import com.acme.edu.Exception.LogException;
import com.acme.edu.Exception.StateNullException;

import java.util.List;

/**
 * Class DefaultState extends Class State.
 */
public class DefaultState extends State {

    private List<Printer> printer;

    /**
     * DefaultState constructor
     * @param printers - Printer will be printed
     */
        public DefaultState(Printer... printers) {
            super(printers);
    }

    /**
     * Cap
     */
    @Override
    public void flush() {
    }

    /**
     * Log various string
     *
     * @param message - String will be logged
     */
    @Override
    public void log(String message) throws StateNullException {
        println(message);
    }
}

