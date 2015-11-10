package com.acme.edu;

import com.acme.edu.exception.DontPrintException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.concurrent.*;
import java.io.*;

public class Server {

    public static void main(String[] args) throws DontPrintException{

            Executor service = Executors.newFixedThreadPool(6);

        try {

            ServerSocket serverSocket = new ServerSocket(7777);
            while (true){
                try(Socket client = serverSocket.accept()){
                    service.execute(() -> {
                        try {
                            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
                            //BufferedWriter bufferWriter = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
                            readFromClient(bufferedReader);
                        }
                        catch (IOException e){
                        }
                    });
                }
                catch (SocketTimeoutException e){
                }
            }
        }
        catch (IOException e){
            throw  new DontPrintException(e);
        }
    }

    private static void readFromClient(BufferedReader bufferedReader) throws IOException {
        try {

            File file = new File("logOutput.txt");
            RemotePrinter remotePrinter = new RemotePrinter(file, "UTF-8");

            String currentString;

            while ((currentString = bufferedReader.readLine()) != null) {
                remotePrinter.print(currentString);
            }
            /*
            bufferWriter.write("");
            bufferWriter.flush();
            */
        } catch (DontPrintException e) {

        }

    }
}
