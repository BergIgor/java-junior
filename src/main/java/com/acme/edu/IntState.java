package com.acme.edu;

import com.acme.edu.Exception.DontPrintException;

/**
 * Class IntState extends Class State.
 */
public class IntState extends State {
    private int buffer=0;
    private  Printer printer;

    public IntState(Printer printer){
        this.printer = printer;
    }

    /**
     *  Execute when state switched
     */
    @Override
    public void flush() throws DontPrintException{
        if(buffer == 0) {
            return;
        }
        printer.print("primitive: " + buffer);
        buffer = 0;
    }

    /**
     * Check and Log string
     *
     * @param message - String will be logged
     */
    @Override
    public void log(String message) throws  DontPrintException{
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

    private void SumBuffer(int message) throws DontPrintException{
        int currentBuffer = buffer;
        buffer += message;
        if (buffer < currentBuffer && message > 0) {
            printer.print("primitive: " + currentBuffer);
            buffer = message;
        }
    }
}

