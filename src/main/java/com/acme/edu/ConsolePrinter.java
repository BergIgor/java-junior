package com.acme.edu;

/**
 * Class ConsolePrinter implements Interface Printer
 */
public class ConsolePrinter implements Printer{

    /**
     *
     * @param message - message will be printed
     */
    @Override
    public void print(String message){
        System.out.println(message);
    }

}
