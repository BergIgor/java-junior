package com.acme.edu;

public class IntState extends State {
    private int buffer=0;

    public IntState(Printer printer){
        super(printer);
    }

    public void log(String message) {
        if ( Integer.parseInt(message) > Integer.MAX_VALUE){
            getPrinter().print("primitive: " + message);
        }else{
            buffer += Integer.parseInt(message);
        }
    }


    public void flush() {
        if(buffer == 0) {
            return;
        }
        getPrinter().print("primitive: " + buffer);
        buffer = 0;
    }

    @Override
    public void checkBuffer(String message) {
        int intMessage = Integer.parseInt(message);
        if (intMessage != 0 && intMessage < Integer.MAX_VALUE) {
            SumBuffer(intMessage);
        } else if (intMessage == Integer.MAX_VALUE) {
            getPrinter().print("primitive: " + buffer);
            getPrinter().print("primitive: " + Integer.MAX_VALUE);
            buffer = 0;
        } else if (buffer == 0) {
            getPrinter().print("primitive: " + 0);
        } else {
            getPrinter().print("primitive: " + message);
        }
    }

    private void SumBuffer(int message) {
        int currentBuffer = buffer;
        buffer += message;
        if (buffer < currentBuffer && message > 0) {
            getPrinter().print("primitive: " + currentBuffer);
            buffer = message;
        }
    }
}

