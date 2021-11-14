package com.company.Library.Management;

import com.mysql.cj.xdevapi.DbDoc;
import com.mysql.cj.xdevapi.DbDocFactory;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;

public class BookDetails extends JFrame implements ActionListener {

    private JPanel contentpane;
    private JTable table;
    private JTextField search;
    private  JButton b1,b2,b3;

    public BookDetails (){
        super("Library Management System");
        setBounds(350,200,890,475);
        contentpane=new JPanel();
        contentpane.setBackground(Color.WHITE);
        setContentPane(contentpane);
        contentpane.setLayout(null);

        JScrollPane scrollPane=new JScrollPane();
        scrollPane.setBounds(79,133,771,282);
        contentpane.add(scrollPane);

        table=new JTable();
        table.setBackground(new Color(240,248,255));
        table.setForeground(Color.DARK_GRAY);
        table.setFont(new Font("Trebuchet MS",Font.BOLD,16));
        scrollPane.setViewportView(table);

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row=table.getSelectedRow();
                search.setText(table.getModel().getValueAt(row,1).toString());
            }
    });
        b1=new JButton("Search");
        b1.addActionListener(this);
        b1.setBorder(new LineBorder(new Color(255,20,147),2,true));
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("com/company/Library/Management/Icon/eight.png"));
        Image i2=i1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        b1.setIcon(i3);
        b1.setForeground(new Color(199,21,133));
        b1.setFont(new Font("Trebuchet MS",Font.BOLD,18));
        b1.setBounds(564,89,138,33);
        contentpane.add(b1);


 b2=new JButton("Delete");
        b2.addActionListener(this);
        b2.setBorder(new LineBorder(new Color(255,20,147),2,true));
        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("com/company/Library/Management/Icon/eight.png"));
        Image i5=i4.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        ImageIcon i6=new ImageIcon(i5);
        b2.setIcon(i6);
        b2.setForeground(new Color(199,21,133));
        b2.setFont(new Font("Trebuchet MS",Font.BOLD,18));
        b2.setBounds(712,89,138,33);
        contentpane.add(b2);

        search=new JTextField();
        search.setBounds(189,89,357,33);
        search.setBackground(new Color(255,240,245));
        search.setBorder(new LineBorder(new Color(255,105,180),2,true));
        search.setFont(new Font("Trebuchet MS",Font.BOLD | Font.ITALIC,17));
        search.setForeground(new Color(47,79,79));
        contentpane.add(search);
        search.setColumns(10);



        JLabel l1=new JLabel( "Books Details");
        l1.setForeground(new Color(107,142,35));
        l1.setFont(new Font("Trebuchet MS",Font.BOLD| Font.ITALIC,30));
        l1.setBounds(300,15,400,47);
        contentpane.add(l1);

        JLabel l2=new JLabel("Back");
        l2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                new Home().setVisible(true);
            }
        });
        l2.setForeground(Color.GRAY);
        l2.setFont(new Font("Trebuchet MS",Font.BOLD,18));
        ImageIcon i7=new ImageIcon(
                ClassLoader.getSystemResource("com/company/Library/Management/Icon/tenth.png"));
        Image i8=i7.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        ImageIcon i9=new ImageIcon(i8);
        l2.setIcon(i9);
        l2.setBounds(97,89,72,33);
        contentpane.add(l2);

        JPanel panel=new JPanel();
        panel.setBounds(67,54,793,368);
        panel.setBackground(Color.WHITE);
        contentpane.setBackground(Color.WHITE);
        contentpane.add(panel);
        panel.setBorder(new TitledBorder(new LineBorder(new Color(0,128,128),3),"Books Details",TitledBorder.LEADING,
                TitledBorder.TOP,null,new Color(0,128,0)));

        book();
//
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            Connection con=ConnectionClass.getConnection();
            if (ae.getSource()==b1){
                String sql="select * from book where concat(name,book_id) like ?";
                PreparedStatement pstmt=con.prepareStatement(sql);
                pstmt.setString(1,"%"+search.getText()+"%");
                ResultSet rs=pstmt.executeQuery();
                table.setModel(DbUtils.resultSetToTableModel(rs));
               // rs.close();
               // con.close();
               // pstmt.close();
            }
            if (ae.getSource()==b2){
                String sql="delete from book where name = '"+search.getText()+"'";
                PreparedStatement pstmt=con.prepareStatement(sql);
                JDialog.setDefaultLookAndFeelDecorated(true);

                int respone=JOptionPane.showConfirmDialog(null,"Do you want to continue?",
                        "Confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                if (respone==JOptionPane.NO_OPTION){

                }
                else  if (respone==JOptionPane.YES_OPTION){
                    int rs=pstmt.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Deleted..!!");
                }
                else if (respone==JOptionPane.CLOSED_OPTION){

                }
              //  con.close();

            }
           // con.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }


    }

    public void book(){
        try {
            String sql = "select * from book";
            Connection con=ConnectionClass.getConnection();
            PreparedStatement pstmt=con.prepareStatement(sql);
            ResultSet rs=pstmt.executeQuery();

            table.setModel(DbUtils.resultSetToTableModel(rs));
         //   rs.close();
           // pstmt.close();
            //con.close();

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        new BookDetails().setVisible(true);
    }
}
