package com.acme.edu;

import com.acme.edu.Exception.LogException;
import com.acme.edu.Exception.StateNullException;

/**
 *  Class StringState extends Class State.
 */
public class StringState extends State {
    private String buffer="";
    private int count=1;

    /**
     * StringState constructor
     * @param printers - Printer will be printed
     */
    public StringState(Printer... printers){
            super(printers);
    }

    /**
     *  Execute when state switched
     */
    @Override
    public void flush()throws StateNullException{
        if(buffer.isEmpty()){
            return;
        }
        else {
            if(count > 1) {
                println("string: " + buffer + " (x" + count + ")");
                count = 1;
            } else {
                println("string: " + buffer);
            }
        }
        buffer = "";
    }
    /**
     * Compare String with buffer
     *
     * @param message - String will be logged
     */
    @Override
    public void log(String message)throws StateNullException{
        if (buffer.equals(message)) {
            count++;
        } else {
            flush();
            buffer = message;
        }
    }
}

