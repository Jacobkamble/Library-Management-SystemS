package com.company.Library.Management;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class FirstPage extends JFrame implements ActionListener{

    JLabel l1;
    JButton b1;

    public FirstPage() {

        super("Library Management System");
        setSize(1000,390);
        setLayout(null);
        setLocation(250,250);

        l1 = new JLabel("");
        b1 = new JButton("Next");

        b1.setBackground(Color.WHITE);
        b1.setForeground(Color.BLACK);



        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("com/company/Library/Management/Icon/first.jpg"));
        Image i3 = i1.getImage().getScaledInstance(1365, 390,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        l1 = new JLabel(i2);

        b1.setBounds(700,250,200,60);
        l1.setBounds(0, 0, 1366, 390);

        l1.add(b1);
        add(l1);

        b1.addActionListener(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae){
        new Login_User().setVisible(true);
        this.setVisible(false);

    }


    public static void main(String[] args)
    {
        new FirstPage().setVisible(true);
    }
}