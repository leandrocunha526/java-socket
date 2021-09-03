package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
       try{
           try (ServerSocket server = new ServerSocket(3334)) {
               System.out.println("Server running on port 3334");
               Socket client = server.accept();
               System.out.println("Client ip: " + client.getInetAddress().getHostAddress());
               
               try (Scanner input = new Scanner(client.getInputStream())) {
                   while(input.hasNextLine()){
                       System.out.println(input.nextLine());
                   }
                   input.close();
                   server.close();
               }
           }
       }
       catch(IOException ex){
         System.out.println("Erro ao criar o servidor");
       }
    }   
}
