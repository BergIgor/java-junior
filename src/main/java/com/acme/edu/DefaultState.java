package com.acme.edu;

import com.acme.edu.Exception.LogException;

/**
 * Class DefaultState extends Class State.
 */
public class DefaultState extends State {
    private Printer printer;

    /**
     * DefaultState constructor
     * @param printable - Printer will be printed
     */
    public DefaultState(Printer printable) {
        this.printer = printable;
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
    public void log(String message) throws LogException{
        printer.print(message);
    }
}

