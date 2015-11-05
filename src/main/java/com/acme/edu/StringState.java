package com.acme.edu;

/**
 *  Class StringState extends Class State.
 */
public class StringState extends State {
    private String buffer="";
    private int count=1;
    private  Printer printer;

    public StringState(Printer printer){
        this.printer = printer;
    }

    /**
     *  Execute when state switched
     */
    @Override
    public void flush() {
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
    public void log(String message) {
        if (buffer.equals(message)) {
            count++;
        } else {
            flush();
            buffer = message;
        }
    }
}

