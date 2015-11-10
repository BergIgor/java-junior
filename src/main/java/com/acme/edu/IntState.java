package com.acme.edu;

import com.acme.edu.Exception.StateNullException;

/**
 * Class IntState extends Class State.
 */
public class IntState extends State {
    private static final String PRIMITIVE = "primitive: ";
    private int buffer=0;

    /**
     * IntState constructor
     * @param printers - Printer will be printed
     */
    public IntState(Printer... printers){
        super(printers);
    }

    /**
     *  Execute when state switched
     */
    @Override
    public void flush()throws StateNullException{
        if(buffer == 0) {
            return;
        }
        println(PRIMITIVE + buffer);
        buffer = 0;
    }

    /**
     * Check and Log string
     *
     * @param message - String will be logged
     */
    @Override
    public void log(String message) throws StateNullException{
        int intMessage = Integer.parseInt(message);
        if (intMessage != 0 && intMessage < Integer.MAX_VALUE) {
            sumBuffer(intMessage);
        } else if (intMessage == Integer.MAX_VALUE) {
            println(PRIMITIVE + buffer);
            println(PRIMITIVE + Integer.MAX_VALUE);
            buffer = 0;
        } else if (buffer == 0) {
            println(PRIMITIVE + 0);
        } else {
            println(PRIMITIVE + message);
        }
    }

    private void sumBuffer(int message) throws StateNullException{
        int currentBuffer = buffer;
        buffer += message;
        if (buffer < currentBuffer && message > 0) {
            println(PRIMITIVE + currentBuffer);
            buffer = message;
        }
    }
}

