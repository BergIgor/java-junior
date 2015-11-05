package com.acme.edu;

import com.acme.edu.Exception.DontPrintException;
import com.acme.edu.Exception.NullMessageException;
import com.acme.edu.Exception.PreviousNullStateException;

/**
 * Class Logger have to log messages
 */
public class Logger {
    private StateFactory stateFactory;
    private State state;
    private static final String SEP = System.lineSeparator();

    public Logger(Printer printer) {
        stateFactory = new StateFactory(printer);
        state = stateFactory.getInstanceStringState(null);
    }

    /**
     * Log integer
     *
     * @param message - int will be logged
     */
    public void log(int message) throws  PreviousNullStateException, DontPrintException{
        if(state == null){
            throw new PreviousNullStateException("");
        }
        if ( state != null && state != stateFactory.intState) {
            state.flush();
        }
        state = stateFactory.getInstanceIntState(state);
        state.log(String.valueOf(message));
    }

    /**
     *  Log string
     *
     * @param message - String will be logged
     */
    public void log(String message) throws  PreviousNullStateException,DontPrintException{
        if(state == null){
            throw new PreviousNullStateException();
        }
        if ( state != null && state != stateFactory.stringState) {
            state.flush();
        }
        state = stateFactory.getInstanceStringState(state);
        state.log(message);
    }
    /**
     *  Log character
     *
     * @param message - character will be logged
     */
    public void log(char message) throws NullMessageException,DontPrintException{
        logDifferentMessages("char: ", String.valueOf(message));
    }

    /**
     * Log boolean
     *
     * @param message - boolean value will logged
     */
    public void log(boolean message) throws DontPrintException{
        logDifferentMessages("primitive: ", String.valueOf(message));
    }
    /**
     * Log set of integer
     *
     * @param messages - set of integer value will logged
     */
    public void log(int... messages) throws NullMessageException,DontPrintException{
        if(messages==null){
            throw new NullMessageException("Null vararg");
        }
        logDifferentMessages("", getSumOfIntSet(messages));
    }
    /**
     *Log integer matrix
     *
     * @param matrix - integer matrix will be logged
     */
    public void log(int[][] matrix) throws NullMessageException,DontPrintException{
        if(matrix==null){
            throw new NullMessageException("Null vararg");
        }
        logDifferentMessages("primitives matrix: {", getMatrix(matrix) + SEP + "}");
    }
    /**
     * Log integer multiDimension array
     *
     * @param multiDimenArray - integer multiDimension array will be logged
     */
    public void log(int[][][][] multiDimenArray) throws NullMessageException,DontPrintException{
        if(multiDimenArray==null){
            throw new NullMessageException("Null vararg");
        }
        logDifferentMessages("primitives multimatrix: ", getMultiDimensionArray(multiDimenArray));
    }

    /**
     * Log set of string
     *
     * @param args - Set of strings will be logged
     */
    public void log(String... args) throws NullMessageException,DontPrintException{
        if(args==null){
            throw new NullMessageException("Null vararg");
        }
        logDifferentMessages("", getStringOfStringSet(args));
    }

    /**
     *  Log Object reference
     *
     * @param message - reference value will be logged
     */
    public void log(Object message) throws NullMessageException,DontPrintException{
        if(message==null){
            throw new NullMessageException();
        }
        logDifferentMessages("reference: ",message.toString());
    }

    /**
     *  Check and log buffer
     */
    public void close() throws PreviousNullStateException,DontPrintException{
        if(state==null){
            throw new PreviousNullStateException();
        }
        else {
            state.flush();
        }
    }

    private void logDifferentMessages(String typeString, String message) throws  DontPrintException{
        state = stateFactory.getInstanceDefaultState(state);
        state.log(typeString + message);
    }

    private String getSumOfIntSet(int... setInt) {
        int sumItems = 0;
        for(int item:setInt){
            sumItems += item;
        }
        return  String.valueOf(sumItems);
    }

    private String getMatrix(int[][] matrix) {
        StringBuilder subString = new StringBuilder("");
        for(int[] array : matrix){
            subString.append( SEP + getOneDimensionArray(array));
        }
        return subString.toString();
    }

    private  String getOneDimensionArray(int[] array) {
        String subString = "";
        subString += "{";
        for(int i=0 ;i< array.length;i++) {
            if(i == 0) {
                subString += array[i];
            }
            else{
                subString += " " + array[i];
            }
            if(i != array.length-1) {
                subString += ",";
            }
        }
        subString += "}";
        return subString ;
    }


    private String getStringOfStringSet(String... args) {
        StringBuilder outputString = new StringBuilder("");
        for(String subString: args) {
            outputString.append(subString);
            outputString.append(SEP);
        }
        return  outputString.toString();
    }


    private String getMultiDimensionArray(int[][][][] multiDimenArray) {
        String subString = "";
        for(int[][][] threeDimenArray : multiDimenArray){
            subString += "{" + SEP;
            for(int[][] twoDimenArray : threeDimenArray){
                subString += "{" + SEP + "{" + getMatrix(twoDimenArray) + SEP + "}"+ SEP;
            }
            subString += "}"  + SEP;
        }
        subString += "}";
       return  subString;
    }
}


