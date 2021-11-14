package com.company.Library.Management;

import javax.swing.*;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class AboutUs extends JFrame{

    private JPanel contentPane;

    public static void main(String[] args) {
        new AboutUs().setVisible(true);
    }

    public AboutUs(){
        setBackground(new Color(173, 216, 230));
        setBounds(500, 250, 700, 500);

        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel l3 = new JLabel("Library");
        l3.setForeground(new Color(0, 250, 154));
        l3.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 34));
        l3.setBounds(160, 40, 150, 55);
        contentPane.add(l3);

        JLabel l4 = new JLabel("Mangement System");
        l4.setForeground(new Color(127, 255, 0));
        l4.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 34));
        l4.setBounds(70, 90, 405, 40);
        contentPane.add(l4);

        JLabel l5 = new JLabel("v2.1");
        l5.setForeground(new Color(30, 144, 255));
        l5.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
        l5.setBounds(185, 140, 100, 21);
        contentPane.add(l5);


        JLabel l6 = new JLabel("Developed By : Jacob");
        l6.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
        l6.setBounds(70, 198, 600, 35);
        contentPane.add(l6);

        JLabel l7 = new JLabel("Contact Us : jacobkamble@gmail.com");
        l7.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
        l7.setBounds(70, 260, 600, 34);
        contentPane.add(l7);

        contentPane.setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


}
