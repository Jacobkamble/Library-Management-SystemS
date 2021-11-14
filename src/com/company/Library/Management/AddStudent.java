package com.company.Library.Management;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Random;

public class AddStudent extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JTextField t1,t2,t3;
    private JComboBox comboBox1,comboBox2,comboBox3,comboBox4;
    private JButton b1,b2;

    public void random(){
        Random rd=new Random();
        t1.setText(""+rd.nextInt(10000+1));
    }


    @Override
    public void actionPerformed(ActionEvent ae) {

        try {
            Connection con=ConnectionClass.getConnection();
            if (ae.getSource()==b1){
                String sql="insert into student(student_id,name,father,course," +
                        "branch,year,semester) " +
                        "values(?,?,?,?,?,?,?)";

                PreparedStatement pstmt=con.prepareStatement(sql);
                pstmt.setString(1,t1.getText());
                pstmt.setString(2,t2.getText());
                pstmt.setString(3,t3.getText());
                pstmt.setString(4,(String)comboBox4.getSelectedItem());
                pstmt.setString(5,(String) comboBox1.getSelectedItem());
                pstmt.setString(6,(String) comboBox2.getSelectedItem());
                pstmt.setString(7,(String)comboBox3.getSelectedItem() );

                int rs=pstmt.executeUpdate();
                if (rs>0){
                    JOptionPane.showMessageDialog(null,"Successfully Added");
                }
                else
                    JOptionPane.showMessageDialog(null,"Error");
//                t1.setText("");
//                t2.setText("");
//                t3.setText("");
//                t4.setText("");
//                t5.setText("");
           //     con.close();
            }
            if (ae.getSource()==b2){
                this.setVisible(false);
                new Home().setVisible(true);
            }
        }
        catch (Exception e){
            e.printStackTrace();

        }

    }

    public static void main(String[] args) {
        new AddStudent().setVisible(true);


    }
    public AddStudent(){
        super("Library Management System");
        setBounds(700,200,550,450);
        contentPane=new JPanel();
        contentPane.setLayout(null);
        setContentPane(contentPane);

        JLabel l1=new JLabel("Student_id");
        l1.setForeground(new Color(25,25,112));
        l1.setFont(new Font("Tahoma",Font.BOLD,14));
        l1.setBounds(64,63,102,22);
        contentPane.add(l1);


        JLabel l2=new JLabel("Name");
        l2.setForeground(new Color(25,25,112));
        l2.setFont(new Font("Tahoma",Font.BOLD,14));
        l2.setBounds(64,97,102,22);
        contentPane.add(l2);


        JLabel l3=new JLabel("Surname");
        l3.setForeground(new Color(25,25,112));
        l3.setFont(new Font("Tahoma",Font.BOLD,14));
        l3.setBounds(64,130,102,22);
        contentPane.add(l3);


        JLabel l4=new JLabel("Course");
        l4.setForeground(new Color(25,25,112));
        l4.setFont(new Font("Tahoma",Font.BOLD,14));
        l4.setBounds(64,173,102,22);
        contentPane.add(l4);


        JLabel l5=new JLabel("Branch");
        l5.setForeground(new Color(25,25,112));
        l5.setFont(new Font("Tahoma",Font.BOLD,14));
        l5.setBounds(64,209,102,22);
        contentPane.add(l5);

        JLabel l6=new JLabel("Year");
        l6.setForeground(new Color(25,25,112));
        l6.setFont(new Font("Tahoma",Font.BOLD,14));
        l6.setBounds(64,242,102,22);
        contentPane.add(l6);


        JLabel l7=new JLabel("Semester");
        l7.setForeground(new Color(25,25,112));
        l7.setFont(new Font("Tahoma",Font.BOLD,14));
        l7.setBounds(64,273,102,22);
        contentPane.add(l7);


        t1=new JTextField();
        t1.setEditable(false);
        t1.setForeground(new Color(47,79,79));
        t1.setFont(new Font("Trebuchet MS",Font.BOLD,14));
        t1.setBounds(174,66,156,20);
        t1.setColumns(10);
        contentPane.add(t1);


        t2=new JTextField();
        t2.setForeground(new Color(47,79,79));
        t2.setFont(new Font("Trebuchet MS",Font.BOLD,14));
        t2.setBounds(174,100,156,20);
        t2.setColumns(10);
        contentPane.add(t2);


        t3=new JTextField();
        t3.setForeground(new Color(47,79,79));
        t3.setFont(new Font("Trebuchet MS",Font.BOLD,14));
        t3.setBounds(174,133,156,20);
        t3.setColumns(10);
        contentPane.add(t3);

        comboBox1=new JComboBox();
        comboBox1.setModel(new DefaultComboBoxModel(new String[] {"Mechanical",
                "CSE","IT","Civil","Automobile","EEE","Other"}));
        comboBox1.setForeground(new Color(47,79,79));
        comboBox1.setFont(new Font("Trebuchet MS",Font.BOLD,14));
        comboBox1.setBounds(176,211,154,20);
        contentPane.add(comboBox1);

        comboBox2=new JComboBox();
        comboBox2.setModel(new DefaultComboBoxModel(new String[] {"First",
                "Second","Third","Fourth"}));
        comboBox2.setForeground(new Color(47,79,79));
        comboBox2.setFont(new Font("Trebuchet MS",Font.BOLD,14));
        comboBox2.setBounds(176,244,154,20);
        contentPane.add(comboBox2);

        comboBox3=new JComboBox();
        comboBox3.setModel(new DefaultComboBoxModel(new String[] {"1st",
                "2nd","3rd","4th","5th","6th","7th","8th"}));
        comboBox3.setForeground(new Color(47,79,79));
        comboBox3.setFont(new Font("Trebuchet MS",Font.BOLD,14));
        comboBox3.setBounds(176,277,154,20);
        contentPane.add(comboBox3);


        comboBox4=new JComboBox();
        comboBox4.setModel(new DefaultComboBoxModel(new String[] {"B.E",
                "B.Tech","M.Tech","M.B.A.","B.B.A","B.C.A","B.Sc","M.Sc","M.Com"}));
        comboBox4.setForeground(new Color(47,79,79));
        comboBox4.setFont(new Font("Trebuchet MS",Font.BOLD,14));
        comboBox4.setBounds(176,176,154,20);
        contentPane.add(comboBox4);

//        comboBox1=new JComboBox();
//        comboBox1.setModel(new DefaultComboBoxModel(new String[] {"Mechanical",
//                "CSE","IT","Civil","Automobile","EEE","Other"}));
//        comboBox1.setForeground(new Color(47,79,79));
//        comboBox1.setFont(new Font("Trebuchet MS",Font.BOLD,14));
//        comboBox1.setBounds(176,211,154,20);
//        contentPane.add(comboBox1);

        b1=new JButton("Add");
        b1.addActionListener(this);
        b1.setBorder(new CompoundBorder(new LineBorder(new Color(105,105,105)),null));
        b1.setFont(new Font("Trebuchet MS",Font.BOLD,15));
        b1.setBounds(64,321,111,33);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        contentPane.add(b1);

        b2=new JButton("Back");
        b2.addActionListener(this);
        b2.setBorder(new CompoundBorder(new LineBorder(new Color(105,105,105)),null));
        b2.setFont(new Font("Trebuchet MS",Font.BOLD,15));
        b2.setBounds(198,321,111,33);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        contentPane.add(b2);

        JPanel panel=new JPanel();
        panel.setBounds(10,38,358,348);
        panel.setBackground(Color.WHITE);
        contentPane.setBackground(Color.WHITE);
        contentPane.add(panel);
        panel.setBorder(new TitledBorder(new LineBorder(new Color(102,205,170),2),"Add Students",TitledBorder.LEADING,
                TitledBorder.TOP,null,new Color(30,144,255)));
        random();

//
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
