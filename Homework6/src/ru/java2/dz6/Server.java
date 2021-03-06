package ru.java2.dz6;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread {

    public static void main(String[] args){
        int port=8888;

        try{
            ServerSocket serverSocket=new ServerSocket(port);
            System.out.println("Waiting for connection");
            Socket clientSocket=serverSocket.accept();
            System.out.println("Connection accepted");
            InputStream inputStream=clientSocket.getInputStream(); //поток входящих сообщений от клиента
            OutputStream outputStream=clientSocket.getOutputStream(); //поток исходящих сообщений клиенту

            DataInputStream dis=new DataInputStream(inputStream);
            DataOutputStream dos=new DataOutputStream(outputStream);

            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

            Thread receive = new Thread(new Runnable() {
                @Override
                public void run() {
                    while(true) {
                        try {
                            System.out.println("Client sent message. Message equals = " + dis.readUTF());
                        } catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                }
            });

            Thread send=new Thread(new Runnable() {
                @Override
                public void run() {
                    while(true) {
                        try {
                            String msgForClients = keyboard.readLine();
                            dos.writeUTF(msgForClients);
                            dos.flush();
                            System.out.println("Server waiting a new message....");
                        } catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                }
            });

            receive.start();
            send.start();


        }catch(IOException e){
            System.out.println("Initialization error.");
            System.exit(0);
        }









    }

}
