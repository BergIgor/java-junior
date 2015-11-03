package com.acme.edu;

public class Logger {
    private StateFactory stateFactory;
    private State state;

    public Logger(Printer printer) {
        stateFactory = new StateFactory(printer);
        state = stateFactory.getInstanceStringState(null);
    }

    /**
     * Log integer
     *
     * @param message - int will be logged
     */
    public void log(int message) {
        state = stateFactory.getInstanceIntState(state);
        state.checkBuffer(String.valueOf(message));
    }

    /**
     *  Log string
     *
     * @param message - String will be logged
     */
    public void log(String message) {
        state = stateFactory.getInstanceStringState(state);
        state.checkBuffer(message);
    }
    /**
     *  Log character
     *
     * @param message - character will be logged
     */
    public void log(char message) {
        state.log(message);
    }

    /**
     * Log boolean
     *
     * @param message - boolean value will logged
     */
    public void log(boolean message) {
        state.log(message);
    }
    /**
     * Log set of integer
     *
     * @param messages - set of integer value will logged
     */
    public void log(int... messages) {
        state.log(messages);
    }
    /**
     *Log integer matrix
     *
     * @param matrix - integer matrix will be logged
     */
    public void log(int[][] matrix) {
        state.log(matrix);
    }
    /**
     * Log integer multiDimension array
     *
     * @param multiDimenArray - integer multiDimension array will be logged
     */
    public void log(int[][][][] multiDimenArray) {
        state.log(multiDimenArray);
    }

    /**
     * Log set of string
     *
     * @param args - Set of strings will be logged
     */
    public void log(String... args) {
        state.log(args);
    }

    /**
     *  Log Object reference
     *
     * @param message - reference value will be logged
     */
    public void log(Object message) {
        state.log(message);
    }

    public void close() {
        state.flush();
    }
}


