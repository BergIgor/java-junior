package com.acme.edu;

import com.acme.edu.Exception.LogException;

/**
 * Class IntState extends Class State.
 */
public class IntState extends State {
    private int buffer=0;
    private  Printer printer;

    /**
     * IntState constructor
     * @param printer - Printer will be printed
     */
    public IntState(Printer printer){
        this.printer = printer;
    }

    /**
     *  Execute when state switched
     */
    @Override
    public void flush() throws LogException{
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
    public void log(String message) throws LogException{
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

    private void SumBuffer(int message) throws LogException{
        int currentBuffer = buffer;
        buffer += message;
        if (buffer < currentBuffer && message > 0) {
            printer.print("primitive: " + currentBuffer);
            buffer = message;
        }
    }
}

