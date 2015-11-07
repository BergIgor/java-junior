package com.acme.edu;

import com.acme.edu.Exception.DontPrintException;

import java.io.*;

public class FilePrinter implements Printer {
    private String SEP = System.lineSeparator();
    private static StringBuilder str = new StringBuilder("");
    private BufferedWriter bufferWriter;
    private static int countOfLogs = 0;

    /**
     * Constructor FilePriner
     * @param codeString
     * @throws DontPrintException
     */
    public FilePrinter(String codeString) throws DontPrintException{
        File file = new File("output.txt");
        try{
                 bufferWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file,true), codeString));
        }
        catch (UnsupportedEncodingException e) {
                throw new DontPrintException(e);
        }
        catch (FileNotFoundException e){
            throw new DontPrintException(e);
        }
    }

    public void print(String message) throws DontPrintException{
        File file = new File("output.txt");
        try{
            if (countOfLogs < 50){
                str.append(message);
                countOfLogs++;
            }else {
                bufferWriter.write(message+SEP);
                str.delete(0, message.length());
                countOfLogs = 0;
                bufferWriter.flush();
            }
        }
        catch (IOException e) {
            throw new DontPrintException(e);
        }
    }

    public void stop()throws DontPrintException{
        try {
            if (bufferWriter == null) return;
            bufferWriter.write(str.toString());
            str.delete(0, str.length());
            bufferWriter.close();
        } catch (IOException e) {
            throw new DontPrintException(e);
        }
    }
}
