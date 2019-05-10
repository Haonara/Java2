package ru.java2.dz6;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Client extends Thread{


    public static void main(String[] args) {
        int port = 8888;

        try
        {
            InetAddress inetAddress = InetAddress.getLocalHost();
            Socket socket = new Socket(inetAddress, port);
            System.out.println("We have the connection...");
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            DataInputStream dis = new DataInputStream(inputStream);
            DataOutputStream dos = new DataOutputStream(outputStream);

            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("We are beginning.... Enter something....");

            Thread receive = new Thread(new Runnable() {
                @Override
                public void run() {
                    while(true) {
                        try {
                            System.out.println("Server sent message. Message equals = " + dis.readUTF());
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
                            System.out.println("Enter something....");
                        } catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                }
            });

            receive.start();
            send.start();


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }



}
