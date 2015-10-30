package com.acme.edu;

public class Logger {


    /** Print integer
     *
     * @param message - int will be printed
     */
    public static void log(int message) {
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
        Logger.print("string: " + message);
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
