package com.acme.edu;

import com.acme.edu.Exception.DontPrintException;

/**
 * Class DefaultState extends Class State.
 */
public class DefaultState extends State {
    private Printer printer;

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
    public void log(String message) throws DontPrintException{
        printer.print(message);
    }
}

