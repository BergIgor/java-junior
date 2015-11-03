package com.acme.edu;


public class IntState implements State {
    private int buffer;
    private Printer printer;

    public IntState(Printer printer){
        this.printer = printer;
    }

    public void log(String message) {
        buffer=0;
        if ( Integer.parseInt(message) > Integer.MAX_VALUE){
            printer.print("primitive: " + message);
        }else{
            buffer += Integer.parseInt(message);
        }
    }


    public void flush() {
        if(buffer == 0){
            return;
        }
        else {
            printer.print("primitive: " +  buffer);
        }
        buffer = 0;
    }
/*
    public void close() {
        checkString();
        checkInteger();
    }

    private void checkString() {
        if(countStr == 0){
            return;
        }
        else {
            if(countStr > 1) {
                print("string: " + previousSubString + " (x" + countStr + ")");
            }
            else if(countStr == 1) {
                print("string: " + previousSubString);
            }
        }
        countStr = 0;
    }

    private void checkInteger() {
        if(buffer != null) {
            print("primitive: " + buffer);
            buffer = null;
        }
    }

*/
}
