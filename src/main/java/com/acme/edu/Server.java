package com.acme.edu;

import com.acme.edu.Exception.DontPrintException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;

public class Server {

    public static void main(String[] args) throws DontPrintException{
        try {
            String currentString;

            File file = new File("logOutput.txt");

            ServerSocket serverSocket = new ServerSocket(7777);

            Socket client = serverSocket.accept();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));

            RemotePrinter remotePrinter = new RemotePrinter(file,"UTF-8");

            while((currentString=bufferedReader.readLine())!=null){
                remotePrinter.print(currentString);
            }
        }
        catch (IOException e){
            throw  new DontPrintException(e);
        }

    }
}
