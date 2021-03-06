package com.company.Library.Management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Login_User extends JFrame implements ActionListener {

    private JPanel panel;
    private JTextField textField;
    private JPasswordField passwordField;
    private JButton b1,b2,b3;

    public Login_User(){
        super("Library Management System");
        setBackground(new Color(169,169,169));
        setBounds(600,300,600,400);


        panel=new JPanel();
        panel.setBackground(new Color(176,224,230));
        setContentPane(panel);
        panel.setLayout(null);

        JLabel l1=new JLabel("Username : ");
        l1.setBounds(124,89,95,24);
        panel.add(l1);

        JLabel l2=new JLabel("Password : ");
        l2.setBounds(124,124,95,24);
        panel.add(l2);

        textField=new JTextField();
        textField.setBounds(210,93,157,20);
        panel.add(textField);

        passwordField=new JPasswordField();
        passwordField.setBounds(210,128,157,20);
        panel.add(passwordField);

        b1=new JButton("Login");
        b1.addActionListener(this);

        b1.setForeground(new Color(46,139,87));
        b1.setBackground(new Color(250,250,210));
        b1.setBounds(149,181,113,39);
        panel.add(b1);

        b2=new JButton("SignUP");
        b2.addActionListener(this);

        b2.setForeground(new Color(139,69,19));
        b2.setBackground(new Color(255,235,205));
        b2.setBounds(289,181,113,39);
        panel.add(b2);

        b3=new JButton("Forgot Password");
        b3.addActionListener(this);

        b3.setForeground(new Color(205,92,92));
        b3.setBackground(new Color(253,245,230));
        b3.setBounds(199,231,179,39);
        panel.add(b3);


        JLabel l5=new JLabel("Trouble in Login?");
        l5.setFont(new Font("Tahoma",Font.PLAIN,15));
        l5.setForeground(new Color(255,0,0));
        l5.setBounds(70,240,130,20);
        panel.add(l5);



        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


    public static void main(String[] args) {

        new Login_User().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        try {

            if (ae.getSource()==b1) {
                Boolean status=false;
                Connection con=ConnectionClass.getConnection();
                String sql="select * from account where username=? and password=?";
                PreparedStatement pstmt=con.prepareStatement(sql);


                char [] pass=passwordField.getPassword();
                  String pas=new String(pass);
                //arr[]=passwordField.getPassword();
                pstmt.setString(1,textField.getText());
                pstmt.setString(2,pas);



                ResultSet rs=pstmt.executeQuery();
               // rs.getString("password");
                if (rs.next()){
                    this.setVisible(false);
                    new Loading();
                }
                else
                    JOptionPane.showMessageDialog(null,"Invalid Login....!");
            }

            if (ae.getSource()==b2){
                setVisible(false);
                new SignUP().setVisible(true);
            }
            if (ae.getSource()==b3){
                setVisible(false);
                new Forgot().setVisible(true);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
    public char[] getPss(){
        return passwordField.getPassword();
    }

}

