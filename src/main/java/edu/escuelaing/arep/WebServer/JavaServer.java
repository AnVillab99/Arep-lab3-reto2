package edu.escuelaing.arep.WebServer;

import java.net.*;


import java.io.*;

public class JavaServer {
    public static db db;
    public static int port;

    public JavaServer(){
        
    }
    public static void main(String[] args) throws IOException {
        db = new db();
        port =getPort();
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            System.err.println("Could not listen on port: "+port);
            System.exit(1);
        }
        Socket clientSocket = null;
        try {
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.err.println("Accept failed.");
            System.exit(1);
        }
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String inputLine, outputLine;
        while ((inputLine = in.readLine()) != null) {
            if (inputLine.equals("Bye")){
                out.close();
                in.close();
                clientSocket.close();
                serverSocket.close();
            }
            System.out.println("Mensaje:" + inputLine);
            try {  
                
                db.connect();
                outputLine = db.consultarUsuarios();
                
            } catch(NumberFormatException e){  
                outputLine = "Respuesta" + inputLine ; 
            }  
            out.println(outputLine);
        } 
        outputLine = "Respuesta" + inputLine ;
        

            
            
        }



        // private static String respuesta(Double[] ordenados, Double sum) {
        //     String ord ="[";
        //     for (int i=0; i<ordenados.length;i++){
        //         if(!(i==ordenados.length-1)){
        //             ord+=String.valueOf(ordenados[i])+",";
        //         }
        //         else{ ord+=String.valueOf(ordenados[i]);}
        //     }
        //     ord+="]";
        //     System.out.println(ord);
            
        //     String suma = String.valueOf(sum);
        //     String res ="DatosOrdenados\":"+ord+",\"Sumatoria\":"+suma;
        //     return res;
    
        // }

        static int getPort() {
            if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
            }
            return 4567; //returns default port if heroku-port isn't set
            }
        
    }




