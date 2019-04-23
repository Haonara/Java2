package ru.java2.dz4;

import ru.java2.dz4.service.BaseService;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.*;
import java.util.Date;

import javax.swing.*;

public class ChatGui extends JFrame{
    BaseService baseService = new BaseService();

    public ChatGui() throws HeadlessException
    {
        setTitle("Chat Frame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        JMenuBar jMenuBar = new JMenuBar();
        JMenu m1 = new JMenu("File");
        JMenu m2 = new JMenu("Help");
        jMenuBar.add(m1);
        jMenuBar.add(m2);

        JMenuItem m11 = new JMenuItem("Open");
        JMenuItem m12 = new JMenuItem("Save");
        m1.add(m11);
        m1.add(m12);

        JTextArea jTextArea = new JTextArea();
        jTextArea.setLineWrap(true);
        jTextArea.setWrapStyleWord(false);


        JPanel jPanel = new JPanel();
        JTextField tf = new JTextField(10);
        JButton sendButton = new JButton("Send");
        sendButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                jTextArea.append(tf.getText()+System.lineSeparator());

            }
        });

        tf.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int key=e.getKeyCode();
                if (key==KeyEvent.VK_ENTER){
                    jTextArea.append(tf.getText()+System.lineSeparator());
                }
            }
        });


        JButton resetButton = new JButton("Reset");


        JRadioButton yesButton = new JRadioButton("YES", true);
        JRadioButton falseButton = new JRadioButton("FALSE", false);

        yesButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (yesButton.isSelected())
                {
                    falseButton.setSelected(false);
                }
                else
                {
                    falseButton.setSelected(true);
                }

            }
        });

        falseButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (falseButton.isSelected())
                {
                    yesButton.setSelected(false);
                }
                else
                {
                    yesButton.setSelected(true);
                }
            }
        });


        jPanel.add(tf);
        jPanel.add(sendButton);
        jPanel.add(resetButton);
        jPanel.add(yesButton);
        jPanel.add(falseButton);


        getContentPane().add(BorderLayout.NORTH, jMenuBar);
        getContentPane().add(BorderLayout.CENTER, jTextArea);
        getContentPane().add(BorderLayout.SOUTH, jPanel);

        setVisible(true);


    }
}