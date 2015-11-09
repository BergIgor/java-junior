package com.acme.edu;

import com.acme.edu.Exception.DontPrintException;

import java.io.*;
import java.net.ServerSocket;
import  java.net.Socket;


public class RemotePrinter {

    private  BufferedWriter bufferWriter;
    private Socket socket;
    private static StringBuilder str = new StringBuilder("");
    private static int countOfLogs = 0;
    private String SEP = System.lineSeparator();

    public RemotePrinter(File fileName,String codeString) throws DontPrintException {
        try{
            bufferWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName,true), codeString));
        }
        catch (UnsupportedEncodingException e) {
            throw new DontPrintException(e);
        }
        catch (FileNotFoundException e){
            throw new DontPrintException(e);
        }
    }

    public RemotePrinter(String hostName,int portNumber)throws DontPrintException{
        try{
            socket=new Socket(hostName, portNumber);

            bufferWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        }
        catch (IOException e){
            throw new DontPrintException(e);
        }
    }


    public void print(String message) throws DontPrintException{
        try{
            if (countOfLogs < 50){
                str.append(message + SEP);
                countOfLogs++;
            }else {
                bufferWriter.write(str.toString());
                str.delete(0, str.length());
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
