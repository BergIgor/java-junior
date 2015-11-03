package com.acme.edu;

public class StringState extends State {
    private String buffer="";
    private int count=1;


    public StringState(Printer printer){
        super(printer);
    }

    public void log(String message) {
        if ( message.equals(buffer)){
            count++;
        }
    }

    @Override
    public void flush() {
        if(buffer.isEmpty()){
            return;
        }
        else {
            if(count > 1) {
                getPrinter().print("string: " + buffer + " (x" + count + ")");
                count = 0;
            } else {
                getPrinter().print("string: " + buffer);
            }
        }
        buffer = "";
    }

    @Override
    public void checkBuffer(String message) {
        if (buffer.equals(message)) {
            count++;
        } else {
            flush();
            buffer = message;
        }
    }
}

