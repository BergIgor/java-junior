package com.acme.edu;

public class DefaultState extends State {
    private Printer printer;

    public DefaultState(Printer printable) {
        this.printer = printable;
    }

    @Override
    public void flush() {
    }

    @Override
    public void log(String message) {
        printer.print(message);
    }
}

