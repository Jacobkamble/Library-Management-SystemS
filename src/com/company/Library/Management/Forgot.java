package com.company.Library.Management;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Forgot extends JFrame implements ActionListener {
    private JPanel contentPane;
    private JTextField t1,t2,t3,t4,t5;
    private JButton b1,b2,b3;
    public Forgot(){

        super("Library Management System");
        setBounds(500,200,650,500);
        contentPane=new JPanel();
        setContentPane(contentPane);
        contentPane.setBackground(Color.WHITE);
        contentPane.setLayout(null);

        JLabel l1=new JLabel("Username :");
        l1.setFont(new Font("Tahonma",Font.BOLD,13));
        l1.setBounds(109,83,87,29);
        contentPane.add(l1);

        JLabel l2=new JLabel("Name :");
        l2.setFont(new Font("Tahonma",Font.BOLD,13));
        l2.setBounds(109,122,75,21);
        contentPane.add(l2);

        JLabel l3=new JLabel("Your Security question :");
        l3.setFont(new Font("Tahonma",Font.BOLD,13));
        l3.setBounds(109,154,156,27);
        contentPane.add(l3);

        JLabel l4=new JLabel("Answer :");
        l4.setFont(new Font("Tahonma",Font.BOLD,13));
        l4.setBounds(109,192,104,21);
        contentPane.add(l4);

        JLabel l5=new JLabel("Password :");
        l5.setFont(new Font("Tahonma",Font.BOLD,13));
        l5.setBounds(109,224,104,21);
        contentPane.add(l5);


        t1=new JTextField();
        t1.setFont(new Font("Tahoma",Font.BOLD,13));
        t1.setForeground(new Color(105,105,105));
        t1.setBounds(277,88,139,20);
        t1.setColumns(10);
        t1.setEditable(true);
        contentPane.add(t1);

        t2=new JTextField();
        t2.setFont(new Font("Tahoma",Font.BOLD,13));
        t2.setForeground(new Color(105,105,105));
        t2.setBounds(277,123,139,20);
        t2.setColumns(10);
        t2.setEditable(false);
        contentPane.add(t2);


        t3=new JTextField();
        t3.setFont(new Font("Tahoma",Font.BOLD,13));
        t3.setForeground(new Color(105,105,105));
        t3.setBounds(277,161,221,20);
        t3.setColumns(10);
        t3.setEditable(false);
        contentPane.add(t3);

        t4=new JTextField();
        t4.setFont(new Font("Tahoma",Font.BOLD,13));
        t4.setForeground(new Color(205,92,92));
        t4.setBounds(277,193,139,20);
        t4.setColumns(10);
        t4.setEditable(true);
        contentPane.add(t4);

        t5=new JTextField();
        t5.setFont(new Font("Tahoma",Font.BOLD,13));
        t5.setForeground(new Color(50,205,50));
        t5.setBounds(277,225,139,20);
        t5.setColumns(10);
        t5.setEditable(false);
        contentPane.add(t5);


        b1=new JButton("Search");
        b1.addActionListener(this);
        b1.setFont(new Font("Tahoma",Font.BOLD,12));
        b1.setBounds(428,83,80,29);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        contentPane.add(b1);


        b2=new JButton("Retrieve");
        b2.addActionListener(this);
        b2.setFont(new Font("Tahoma",Font.BOLD,12));
        b2.setBounds(426,188,85,29);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        contentPane.add(b2);


        b3=new JButton("Back");
        b3.addActionListener(this);
        b3.setFont(new Font("Tahoma",Font.BOLD,12));
        b3.setBounds(233,270,101,29);
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        contentPane.add(b3);

        JPanel panel=new JPanel();
        panel.setBorder(new TitledBorder(new LineBorder(new Color(128,128,0),2),"Forgot-Panel",
                TitledBorder.LEADING,TitledBorder.TOP,
                null,new Color(34,139,34)));
        panel.setBounds(47,45,508,281);
        panel.setBackground(Color.WHITE);
        contentPane.add(panel);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Forgot().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            Connection con=ConnectionClass.getConnection();
            if (ae.getSource()==b1){
                String sql="select * from account where username=?";
                PreparedStatement pstmt=con.prepareStatement(sql);
                pstmt.setString(1,t1.getText());

                ResultSet rs=pstmt.executeQuery();
                while (rs.next()){
                    t2.setText(rs.getNString("name"));
                    t3.setText(rs.getNString("sec_q"));
                }
            }
            if (ae.getSource()==b2){
                String sql="select * from account where sec_ans=?";
                PreparedStatement pstmt=con.prepareStatement(sql);

                pstmt.setString(1,t4.getText());
                ResultSet rs=pstmt.executeQuery();
                while (rs.next()){
                    t5.setText(rs.getNString("password"));
                }
            }
            if (ae.getSource()==b3){
                this.setVisible(false);
                new Login_User().setVisible(true);

            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
