package com.acme.edu;

import com.acme.edu.Exception.DontPrintException;

import java.io.*;
import java.net.ServerSocket;
import  java.net.Socket;
import java.util.LinkedList;
import java.util.List;


public class RemotePrinter {

    private BufferedWriter bufferWriter;
    private BufferedReader bufferReader;
    private Socket socket;
    private List<String> buffMess = new LinkedList<String>();
    private int countOfLogs = 0;
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
            bufferReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        }
        catch (IOException e){
            throw new DontPrintException(e);
        }
    }


    public void print(String message) throws DontPrintException{
        try{
            if (countOfLogs < 50){
                if(message.indexOf("ERROR")>=0) {
                    buffMess.add(0, message + SEP);
                }
                else{
                    buffMess.add( message + SEP );
                }
                countOfLogs++;
            }else {
                bufferWriter.write(buffMess.toString());
                buffMess.clear();
                countOfLogs = 0;
                bufferWriter.flush();
                /*
                while (true) {
                    if (bufferReader.ready()) {
                        if ("ERROR".equals(bufferReader.readLine())) {
                        } else {
                            break;
                        }
                    }
                }*/
            }
        }
        catch (IOException e) {
            throw new DontPrintException(e);
        }
    }

    public void stop()throws DontPrintException{
        try {
            if (bufferWriter == null) return;
            bufferWriter.write(buffMess.toString());
            buffMess.clear();
            bufferWriter.close();
        } catch (IOException e) {
            throw new DontPrintException(e);
        }
    }
}
