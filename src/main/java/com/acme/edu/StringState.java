package com.acme.edu;


public class StringState implements  State {
    private String buffer;
    private Printer printer;
    private int count;

    public StringState(Printer printer){
        this.printer = printer;
    }

    public void log(String message) {
        if ( message.equals(buffer)){
            count++;
        }
    }


    public void flush() {
        if(buffer.isEmpty()){
            return;
        }
        else {
            if(count == 0) {
                printer.print("string: " + buffer);
            }
            else if(count > 1) {
                printer.print("string: " + buffer + " (x" + count + ")");
            }
        }
        buffer = "";
        count = 0;
    }

}
