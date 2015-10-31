package com.acme.edu;

public class Logger {
    private static boolean flag=false;
    private static int sum=0;
    private static int countStr=0;
    private static String previousSubString = "" ;

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
     * This method will be called in the end tests
     */
    public static void close() {
        Logger.checkString();
        Logger.checkInteger();

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
