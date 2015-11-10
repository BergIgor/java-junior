package com.acme.edu;

import com.acme.edu.exception.LogException;
import com.acme.edu.exception.NullMessageException;
import com.acme.edu.exception.StateNullException;

/**
 * Class Logger have to log messages
 */
public class Logger {
    private StateFactory stateFactory;
    private State state;
    private static final String SEP = System.lineSeparator();

    /**
     * Logger constructor
     * @param printers
     */
    public Logger(Printer... printers) {
        stateFactory = new StateFactory(printers);
        state = stateFactory.getInstanceDefaultState();
    }

    /**
     * Log integer
     *
     * @param message - int will be logged
     */
    public void log(int message) throws  LogException{
        state = stateFactory.getInstanceIntState(state);
        state.log(String.valueOf(message));
    }

    /**
     *  Log string
     *
     * @param message - String will be logged
     */
    public void log(String message) throws  LogException{
        if(message == null){
            throw new NullMessageException("String is null");
        }
        state = stateFactory.getInstanceStringState(state);
        state.log(message);
    }
    /**
     *  Log character
     *
     * @param message - character will be logged
     */
    public void log(char message) throws LogException{
        logDifferentMessages("char: ", String.valueOf(message));
    }

    /**
     * Log boolean
     *
     * @param message - boolean value will logged
     */
    public void log(boolean message) throws LogException{
        logDifferentMessages("primitive: ", String.valueOf(message));
    }
    /**
     * Log set of integer
     *
     * @param messages - set of integer value will logged
     */
    public void log(int... messages) throws LogException {
        if(messages==null){
            throw new NullMessageException("Vararg is null");
        }
        logDifferentMessages("", getSumOfIntSet(messages));
    }
    /**
     *Log integer matrix
     *
     * @param matrix - integer matrix will be logged
     */
    public void log(int[][] matrix) throws LogException{
        if(matrix==null){
            throw  new NullMessageException("Matrix is null");
        }
        logDifferentMessages("primitives matrix: {", getMatrix(matrix) + SEP + "}");
    }
    /**
     * Log integer multiDimension array
     *
     * @param multiDimenArray - integer multiDimension array will be logged
     */
    public void log(int[][][][] multiDimenArray) throws LogException{
        if(multiDimenArray==null){
            throw new NullMessageException("MultiDimenArray is null");
        }
        logDifferentMessages("primitives multimatrix: ", getMultiDimensionArray(multiDimenArray));
    }

    /**
     * Log set of string
     *
     * @param args - Set of strings will be logged
     */
    public void log(String... args) throws LogException{
        if(args==null){
            throw new NullMessageException("Vararg string is null");
        }
        logDifferentMessages("", getStringOfStringSet(args));
    }

    /**
     *  Log Object reference
     *
     * @param message - reference value will be logged
     */
    public void log(Object message) throws LogException{
        if(message==null){
            throw new NullMessageException("Object is null");
        }
        logDifferentMessages("reference: ",message.toString());
    }

    /**
     *  Check and log buffer
     */
    public void close() throws LogException{
        if(state==null){
            throw new StateNullException("Don't close a Null State");
        }
        else {
            state.flush();
        }
    }

    private void logDifferentMessages(String typeString, String message) throws LogException{
        state = stateFactory.getInstanceDefaultState();
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


