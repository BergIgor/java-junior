package com.acme.edu;

import com.acme.edu.Exception.LogException;

/**
 *  Class StringState extends Class State.
 */
public class StringState extends State {
    private String buffer="";
    private int count=1;
    private  Printer printer;

    /**
     * StringState constructor
     * @param printer - Printer will be printed
     */
    public StringState(Printer printer){
        this.printer = printer;
    }

    /**
     *  Execute when state switched
     */
    @Override
    public void flush()throws LogException{
        if(buffer.isEmpty()){
            return;
        }
        else {
            if(count > 1) {
                printer.print("string: " + buffer + " (x" + count + ")");
                count = 1;
            } else {
                printer.print("string: " + buffer);
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
    public void log(String message)throws LogException{
        if (buffer.equals(message)) {
            count++;
        } else {
            flush();
            buffer = message;
        }
    }
}

