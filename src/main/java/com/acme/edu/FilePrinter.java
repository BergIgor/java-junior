package com.acme.edu;

import com.acme.edu.exception.DontPrintException;

import java.io.*;

public class FilePrinter implements Printer {
    private String SEP = System.lineSeparator();
    private StringBuilder str = new StringBuilder("");
    private BufferedWriter bufferWriter;
    private int countOfLogs = 0;

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
        try{
            bufferWriter.write(message+SEP);
            bufferWriter.flush();
        }
        catch (IOException e) {
            throw new DontPrintException(e);
        }
    }

}
