package com.acme.edu;

public class Logger {

    private static void print(String str)
    {
        System.out.println(str);
    }


    public static void log(int message) {
        Logger.print("primitive: " + message);
    }


    public static void log(byte message) {
        Logger.print("primitive: " + message);
    }


    public static void log(boolean message) {
        Logger.print("primitive: " + message);
    }


    public static void log(char message) {
        Logger.print("char: " + message);
    }

}
