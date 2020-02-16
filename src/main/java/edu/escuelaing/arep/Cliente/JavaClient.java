package edu.escuelaing.arep.Cliente;

import java.io.*;
import java.net.*;

public class JavaClient {


    public JavaClient() {
    }
    public static void main(String[] args) throws IOException {
        
        Socket echoSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;
        int port = getPort();
        
        try {
            echoSocket = new Socket("https://polar-fortress-20616.herokuapp.com",80);
            out = new PrintWriter(echoSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Don’t know about host!.");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn’t get I/O for "
            + "the connection to: localhost.");
            System.exit(1);
        }
        
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        String userInput;
        
        while ((userInput = stdIn.readLine()) != null) {
            out.println(userInput);
            System.out.println("echo: " + in.readLine());
        }
        out.close();
        in.close();
        stdIn.close();
        echoSocket.close();
    }
    
    static int getPort() {
        if (System.getenv("PORT") != null) {
        return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't set
        }

}