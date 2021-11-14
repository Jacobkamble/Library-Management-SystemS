package com.company.Library.Management;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class SignUP extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JTextField textField;
    private  JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;

    private JButton b1,b2;
    private JComboBox comboBox;


    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            Connection con=ConnectionClass.getConnection();

            if (ae.getSource()==b1){
                String sql="insert into  account (username, name, " +
                        "password,sec_q, sec_ans)values(?,?,?,?,?)";
                PreparedStatement pstmt=con.prepareStatement(sql);
                pstmt.setString(1,textField.getText());
                pstmt.setString(2,textField1.getText());
                pstmt.setString(3,textField2.getText());
                pstmt.setString(4,(String)comboBox.getSelectedItem());
                pstmt.setString(5,textField3.getText());
                int i=pstmt.executeUpdate();
                if (i>0){
                    JOptionPane.showMessageDialog(null,"Successfully Created");
                }
                textField.setText("");
                textField1.setText("");
                textField2.setText("");
                textField3.setText("");

            }
            if (ae.getSource()==b2){
                this.setVisible(false);
                new Login_User().setVisible(true);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new SignUP().setVisible(true);
    }
    public SignUP(){
        super("Library Management System");
        setBounds(600,250,606,406);
        contentPane=new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(contentPane);
        contentPane.setBackground(Color.WHITE);
        contentPane.setLayout(null);

        JLabel lblusername=new JLabel("Username : ");
        lblusername.setForeground(Color.DARK_GRAY);
        lblusername.setFont(new Font("Tahoma",Font.BOLD,14));
        lblusername.setBounds(99,86,92,26);
        contentPane.add(lblusername);

        JLabel lblName=new JLabel("Name : ");
        lblName.setForeground(Color.DARK_GRAY);
        lblName.setFont(new Font("Tahoma",Font.BOLD,14));
        lblName.setBounds(99,123,92,26);
        contentPane.add(lblName);

        JLabel lblpassword=new JLabel("Password : ");
        lblpassword.setForeground(Color.DARK_GRAY);
        lblpassword.setFont(new Font("Tahoma",Font.BOLD,14));
        lblpassword.setBounds(99,160,92,26);
        contentPane.add(lblpassword);

        JLabel lblAnswer=new JLabel("Answer : ");
        lblAnswer.setForeground(Color.DARK_GRAY);
        lblAnswer.setFont(new Font("Tahoma",Font.BOLD,14));
        lblAnswer.setBounds(99,234,92,26);
        contentPane.add(lblAnswer);


        JLabel lblSecurityQuestion=new JLabel("Security Question : ");
        lblSecurityQuestion.setForeground(Color.DARK_GRAY);
        lblSecurityQuestion.setFont(new Font("Tahoma",Font.BOLD,14));
        lblSecurityQuestion.setBounds(99,197,135,26);
        contentPane.add(lblSecurityQuestion);

        comboBox=new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[]{"Your NickName?","Your Lucky Number?",
        "Your child SuperHero?","Your childhood Name ?"}));
        comboBox.setBounds(265,202,148,20);
        contentPane.add(comboBox);

        textField=new JTextField();
        textField.setBounds(265,91,148,20);
        textField.setColumns(10);
        contentPane.add(textField);

        textField1=new JTextField();
        textField1.setBounds(265,128,148,20);
        textField1.setColumns(10);
        contentPane.add(textField1);

        textField2=new JTextField();
        textField2.setBounds(265,165,148,20);
        textField2.setColumns(10);
        contentPane.add(textField2);

        textField3=new JTextField();
        textField3.setBounds(265,239,148,20);
        textField3.setColumns(10);
        contentPane.add(textField3);

        b1=new JButton("Create");
        b1.addActionListener(this);
        b1.setFont(new Font("Tahoma",Font.BOLD,13));
        b1.setBounds(140,289,100,30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        contentPane.add(b1);


        b2=new JButton("Back");
        b2.addActionListener(this);
        b2.setFont(new Font("Tahoma",Font.BOLD,13));
        b2.setBounds(300,289,100,30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        contentPane.add(b2);

        JPanel panel=new JPanel();
        panel.setBounds(31,46,476,296);
        panel.setForeground(new Color(34,139,34));panel.setBorder(new TitledBorder(new LineBorder(new Color(128,128,0),2),"Create Account",
                TitledBorder.LEADING,TitledBorder.TOP,
        null,new Color(34,139,34)));
        panel.setBackground(Color.WHITE);
        contentPane.add(panel);


        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }
}

