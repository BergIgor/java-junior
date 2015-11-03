package com.acme.edu;

public class Logger {
    private static final String SEP = System.lineSeparator();
    //public Printer printer;
    public State state;

    /**
     *  Log integer
     *
     * @param message - int will be logged
     */
    public void log(int message) {
        if(!(state instanceof  StringState))
        {
            state.flush();
        }
        state = new IntState(new ConsolePrinter());
        state.log(message+"");
        //state.close();
    }

    /**
     *  Log string
     *
     * @param message - String will be logged
     */
    public void log(String message) {
        if(!(state instanceof IntState))
        {
            state.flush();
        }
        state = new StringState(new ConsolePrinter());
        state.log(message);
    }

}

