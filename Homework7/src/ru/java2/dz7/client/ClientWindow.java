package ru.java2.dz7.client;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;


import javax.swing.*;

public class ClientWindow extends JFrame{
    private static final int PORT = 8888;
    Socket clientSocket;
    JTextArea jTextArea;
    JTextField jtfMessage;
    JTextField jtfNickname;
    private DataInputStream dis;
    private DataOutputStream dos;


    public ClientWindow() throws HeadlessException
    {
        try
        {
            clientSocket = new Socket("localhost", PORT);
            clientSocket.setSoTimeout(120000);
            dis = new DataInputStream(clientSocket.getInputStream());
            dos = new DataOutputStream(clientSocket.getOutputStream());

        }catch (Exception e)
        {
            e.printStackTrace();
        }

        setBounds(600, 300, 600, 300);
        setTitle("Client of chat");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jTextArea = new JTextArea();
        jTextArea.setEditable(false);
        jTextArea.setLineWrap(true);
        JScrollPane jScrollPane = new JScrollPane(jTextArea);
        add(jScrollPane, BorderLayout.CENTER);

        JLabel numberOfClientsLabel = new JLabel("Clients count in chat = ");
        add(numberOfClientsLabel, BorderLayout.NORTH);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        add(bottomPanel, BorderLayout.SOUTH);

        JButton sendButton = new JButton("Send");
        bottomPanel.add(sendButton, BorderLayout.EAST);

        jtfMessage = new JTextField("Введите ваше сообщение");
        bottomPanel.add(jtfMessage, BorderLayout.CENTER);

        jtfNickname = new JTextField(("Введите ваше имя: "));
        bottomPanel.add(jtfNickname, BorderLayout.WEST);

        sendButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {

                String text = jtfMessage.getText().trim();
                if (!text.trim().isEmpty())
                {
                    String nickname = jtfNickname.getText();
                    if (nickname.isEmpty() || nickname.equalsIgnoreCase("Введите ваше имя: "))
                    {
                        nickname = "Anonymus";
                    }
                    text = nickname + " : " + text;
                    sendMsg(text);
                    jtfMessage.setText("");
                    jtfMessage.grabFocus();
                }

            }
        });

        jtfMessage.addFocusListener(new FocusAdapter()
        {
            @Override
            public void focusGained(FocusEvent e)
            {
                jtfMessage.setText("");
            }
        });

        jtfNickname.addFocusListener(new FocusAdapter()
        {
            @Override
            public void focusGained(FocusEvent e)
            {
                jtfNickname.setText("");
            }
        });

        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                while (true)
                {
                    try
                    {
                        String msg = dis.readUTF();

                        if (msg.indexOf("Clients count in chat = ") == 0)
                        {
                            numberOfClientsLabel.setText(msg);
                        }
                        else
                        {
                            jTextArea.append(msg);
                            jTextArea.append("\n");
                        }
                    }catch (SocketTimeoutException s){
                        System.out.println("Socket timed out!");
                        s.printStackTrace();
                        break;
                    }catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                try
                {
                    super.windowClosing(e);
                    sendMsg("EXIT");
                    dos.close();
                    dis.close();
                    clientSocket.close();
                }
                catch (Exception e1)
                {
                    e1.printStackTrace();
                }
            }
        });

        setVisible(true);

    }

    private void sendMsg(String msg)
    {
        try
        {
            dos.writeUTF(msg);
            dos.flush();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}

