package ru.java2.dz7.server;

import java.io.*;
import java.net.Socket;


public class ClientHandler extends Thread{

    private ServerCore serverCore;
    private DataInputStream dis;
    private DataOutputStream dos;
    private static int clientsCount=0;
    private String nick;


    public ClientHandler(Socket socket, ServerCore server) {
        try {
            clientsCount++;
            serverCore = server;
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            dis = new DataInputStream(inputStream);
            dos = new DataOutputStream(outputStream);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try{
        serverCore.sendMessageToAllClients("We have a new clients in our chat!");
        serverCore.sendMessageToAllClients("Clients count in chat = "+clientsCount);
        while(true){
            String message=dis.readUTF();
            if (message.equalsIgnoreCase("EXIT")){
                break;
            }
            System.out.println("Введите ник:");
            if (nick==null) {
                this.nick = message;
                continue;
            }

            String s[] =message.split(" ");
            boolean toClientNick=s[0].equalsIgnoreCase("/w");
            System.out.println(message);
            if (toClientNick){

                String nick=s[1];
                for (int i = 2; i < s.length; i++) {
                    s[2]=s[2]+" "+s[i];
                }
                    serverCore.sendMessageToClient(s[2], nick);

            }else{
                serverCore.sendMessageToAllClients(message);
            }
            Thread.sleep(100);
        }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            close();
        }
    }

    public String getNick() {
        return nick;
    }

    private void close() {
        serverCore.removeClient(this);
        clientsCount--;
        serverCore.sendMessageToAllClients("Clients count in chat = "+clientsCount);

    }

    public void sendMessage(String message){

        try {
            System.out.print("Сообщение от "+nick+": ");
            dos.writeUTF(message);
            dos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
