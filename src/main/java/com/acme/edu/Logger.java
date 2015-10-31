package com.acme.edu;

public class Logger {
    private static boolean flag=false;
    private static int sum=0;
    private static int countStr=0;
    private static String previousSubString = "" ;
    private static final String SEP = System.lineSeparator();

    /**
     *  Print integer to console
     *
     * @param message - int will be printed
     */
    public static void log(int message) {
        Logger.checkString();
        long currentSum = sum;
        if( message + currentSum > Integer.MAX_VALUE){
            Logger.checkInteger();
            Logger.print("primitive: "  + message);
        }else{
            sum+=message;
            flag = true;
        }

    }

    /**
     *  Print byte to console
     *
     * @param message - byte will be printed
     */
    public static void log(byte message) {
        Logger.checkString();
        if( sum + message > Byte.MAX_VALUE) {
            Logger.checkInteger();
            Logger.print("primitive: "  + message);
        }
        else {
            flag =true;
            sum+=message;
        }


    }
    /**
     *  Print boolean to console
     *
     * @param message - boolean value will be printed
     */
    public static void log(boolean message) {
        Logger.print("primitive: " + message);
    }

    /**
     *  Print character to console
     *
     * @param message - character will be printed
     */
    public static void log(char message) {
        Logger.print("char: " + message);
    }

    /**
     *  Print string to console
     *
     * @param message - String will be printed
     */
    public static void log(String message) {
        Logger.checkInteger();
        if(previousSubString.equals(message)){
            countStr++;
        }
        else{
            Logger.checkString();
            previousSubString=message;
            countStr =1;
        }

    }
    /**
     *  Print Object reference to console
     *
     * @param message - reference value will be printed
     */
    public static void log(Object message) {
        Logger.print("reference: " +message.toString());
    }


    /**
     *Print integer matrix
     *
     * @param matrix - integer matrix will be printed
     */
    public static void log(int[][] matrix) {
        String subString = "";
       for(int[] array : matrix){
           subString += SEP + "{" + getOneDimensionArray(array) + "}";
       }
        Logger.print("primitives matrix: {" +  subString + SEP +  "}");
    }

    /**
     * Print integer multiDimension array
     *
     * @param multiDimenArray - integer multiDimension array will be printed
      */
    public static void log(int[][][][] multiDimenArray) {
        String subString = "";
        for(int[][][] threeDimenArray : multiDimenArray){
            subString += "{" + SEP;
            for(int[][] twoDimenArray : threeDimenArray){
                subString += "{" + SEP;
                for(int[] oneDimenArray : twoDimenArray){
                    subString += "{" + SEP ;
                    subString +=  "{" + SEP +  getOneDimensionArray(oneDimenArray)+SEP + "}" + SEP;
                }
                subString += "}" + SEP;
            }
            subString += "}" + SEP ;
        }
        subString += "}";
        Logger.print("primitives multimatrix: " +  subString  );
    }

    /**
     * Print sum of integers
     *
     * @param setInt - Set of integer
     */
    public static void log(int... setInt) {
        int sum = 0;
        for(int item:setInt){
            sum += item;
        }
        Logger.print(String.valueOf(sum));
    }

    /**
     * Print set of string
     *
     * @param args - Set of strings
     */
    public static void log(String... args) {
        StringBuilder outputString = new StringBuilder("");
        for(String subString: args) {
            outputString.append(subString);
            outputString.append(SEP);
        }
        Logger.print(outputString.toString());
    }

    /**
     * This method will be called in the end tests
     */
    public static void close() {
        Logger.checkString();
        Logger.checkInteger();

    }

    private static String getOneDimensionArray(int[] array) {
        String subString = "";
        for(int i=0 ;i< array.length;i++) {
            if(i==0) {
                subString += array[i];
            }
            else{
                subString += " " + array[i];
            }
            if(i!=array.length-1) {
                subString+=",";
            }
        }
        return subString ;
    }

    private static void checkString() {
        if(countStr!=0){
            if(countStr>1) {
                Logger.print("string: " + previousSubString + " (x" + countStr + ")");
            }
            else if(countStr==1) {
                Logger.print("string: " + previousSubString);
            }
        }else {
            return;
        }
        countStr=0;
    }

    private static void checkInteger() {
        if(flag) {
            Logger.print("primitive: " + sum);
            flag=false;
            sum = 0;
        }
    }

    private static void print(String str) {
        System.out.println(str);

    }



}
