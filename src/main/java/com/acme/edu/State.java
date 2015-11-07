package com.acme.edu;

import com.acme.edu.Exception.DontPrintException;
import com.acme.edu.Exception.LogException;
import com.acme.edu.Exception.StateNullException;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract class State
 */
public abstract class State {

    private List<Printer> printerList  = new ArrayList<Printer>();

    public State(Printer... printers){
        for(Printer printer : printers)
            printerList.add(printer);
    }
    /**
     *
     * @param str - string will be logged
     * @throws LogException
     */
    public abstract void log(String str)throws StateNullException;

    /**
     * Method for release buffer
     * @throws LogException
     */
    public abstract  void flush()throws StateNullException;

    public void println(String message)throws StateNullException{
        try {
            for (Printer printer : printerList)
                printer.print(message);
        }
        catch (DontPrintException e) {
            throw new StateNullException(e);
        }

    }



}



