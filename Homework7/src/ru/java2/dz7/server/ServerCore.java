package ru.java2.dz7.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerCore {

    public static final int PORT = 8888;

    List<ClientHandler> clients=new ArrayList<>();

    public ServerCore() {
        Socket clientSocket=null;
        ServerSocket serverSocket= null;
        try {
            serverSocket = new ServerSocket(PORT);
            while(true){
                clientSocket=serverSocket.accept();
                System.out.println("We have a new client...");
                ClientHandler client=new ClientHandler(clientSocket, this);
                client.start();
                clients.add(client);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try{
            clientSocket.close();
            serverSocket.close();
            System.out.println("Server finished.");
            }catch(Exception e){
                e.printStackTrace();
            }
        }

    }

    public void sendMessageToAllClients(String message){
        for (ClientHandler client: clients) {
            client.sendMessage(message);
        }
    };

    public void sendMessageToClient(String message, String nick){
        for (ClientHandler client: clients) {
            if (client.getNick().equalsIgnoreCase(nick)){
                client.sendMessage(message);
                break;
            }
        }
    };


    public void removeClient (ClientHandler clientHandler){
        clients.remove(clientHandler);
    }
}
