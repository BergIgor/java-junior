package com.acme.edu;

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
    public void log(String message) {
        printer.print(message);
    }
}

