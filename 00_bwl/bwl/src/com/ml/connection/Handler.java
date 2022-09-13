package com.ml.connection;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.net.Socket;


public class Handler implements Runnable{
    protected Socket clientSocket = null;
    protected String serverText   = null;
    public String upload;
    
    public Handler(Socket clientSocket, String serverText) {
        this.clientSocket = clientSocket;
        this.serverText   = serverText;
    }
    public void run() {
        try {
            InputStream input  = clientSocket.getInputStream();
            PrintWriter output = new PrintWriter (clientSocket.getOutputStream());
            output.println("HTTP/1.1 200 OK");
            output.println("Conttent-Type: xml");
            output.println("Server: Bot");
            output.println("");
            output.println(serverText);
            output.close();
            input.close();
        } catch (IOException e) {
            //report exception somewhere.
            e.printStackTrace();
        }
    }
    
}
