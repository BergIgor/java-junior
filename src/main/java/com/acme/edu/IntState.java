package com.acme.edu;

public class IntState extends State {
    private int buffer=0;
    private  Printer printer;

    public IntState(Printer printer){
        this.printer = printer;
    }

    @Override
    public void flush() {
        if(buffer == 0) {
            return;
        }
        printer.print("primitive: " + buffer);
        buffer = 0;
    }

    @Override
    public void log(String message) {
        int intMessage = Integer.parseInt(message);
        if (intMessage != 0 && intMessage < Integer.MAX_VALUE) {
            SumBuffer(intMessage);
        } else if (intMessage == Integer.MAX_VALUE) {
            printer.print("primitive: " + buffer);
            printer.print("primitive: " + Integer.MAX_VALUE);
            buffer = 0;
        } else if (buffer == 0) {
            printer.print("primitive: " + 0);
        } else {
            printer.print("primitive: " + message);
        }
    }

    private void SumBuffer(int message) {
        int currentBuffer = buffer;
        buffer += message;
        if (buffer < currentBuffer && message > 0) {
            printer.print("primitive: " + currentBuffer);
            buffer = message;
        }
    }
}

