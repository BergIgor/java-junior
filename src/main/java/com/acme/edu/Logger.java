package com.acme.edu;

public class Logger {

    private static int COUNT=0;
    /** Print integer
     *
     * @param message - int will be printed
     */
    public static void log(int message) {
        if(message==0) {
            if (COUNT > 0) {
                Logger.print("primitive: " + COUNT);
                COUNT = 0;
            }
            Logger.print("primitive: " + message);
        }
        if(message + COUNT < 0) {
            Logger.print("primitive: " + COUNT);
            Logger.print("primitive: "  + message);

        }
        COUNT+=message;

    }

    public static void log(byte message) {
            Logger.print("primitive: " + message);

    }
    /** Print boolean
     *
     * @param message - boolean value will be printed
     */
    public static void log(boolean message) {
        Logger.print("primitive: " + message);
    }

    /** Print character
     *
     * @param message - char will be printed
     */
    public static void log(char message) {
        Logger.print("char: " + message);
    }

    /** Print string
     *
     * @param message - String will be printed
     */
    public static void log(String message) {
        if(COUNT>0){
            Logger.print("primitive: " + COUNT);
        }
        Logger.print("string: " + message);
        COUNT =0;
    }
    /** Print Object
     *
     * @param message - Object will be printed
     */
    public static void log(Object message) {
        Logger.print("reference: " +message.toString());
    }

    private static void print(String str) {
        System.out.println(str);

    }


}
