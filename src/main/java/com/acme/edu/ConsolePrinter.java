package com.acme.edu;

/**
 * Class ConsolePrinter implements Interface Printer
 */
public class ConsolePrinter implements Printer{

    public void print(String message){
        System.out.println(message);
    }

}
