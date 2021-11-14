package com.company.Library.Management;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame implements ActionListener {

    private  JPanel contentPane;
    private JButton b1,b2,b3,b4,b5,b6;

    public Home(){

        super("Library Management System");
        setBounds(350,0,1000,800);
        contentPane=new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);


        JMenuBar menuBar=new JMenuBar();
       // menuBar.setBorder(new EtchedBorder(EtchedBorder.LOWERED,new Color(0,128,0),new Color(128,128,128)));
        menuBar.setBackground(Color.CYAN);
        menuBar.setBounds(0,0,1000,35);
        contentPane.add(menuBar);


        JMenu record=new JMenu("Record");
        record.setFont(new Font("Trebuchet MS",Font.BOLD,17));

        JMenuItem bookDetails=new JMenuItem("Book Details");
        bookDetails.addActionListener(this);
        bookDetails.setBackground(new Color(211,211,211));
        bookDetails.setForeground(Color.DARK_GRAY);
        record.add(bookDetails);

        JMenuItem studentDetails=new JMenuItem("Student Details");
        studentDetails.addActionListener(this);
        studentDetails.setBackground(new Color(211,211,211));
        studentDetails.setForeground(Color.DARK_GRAY);
        record.add(studentDetails);

        JMenu help=new JMenu("Help");
        help.setFont(new Font("Trebuchet MS",Font.BOLD,17));

        JMenuItem readme=new JMenuItem("Read Me");
        readme.addActionListener(this);
        readme.setBackground(new Color(211,211,211));
        readme.setForeground(Color.DARK_GRAY);
        help.add(readme);

        JMenuItem aboutus=new JMenuItem("About Us");
        aboutus.addActionListener(this);
        aboutus.setBackground(new Color(211,211,211));
        aboutus.setForeground(Color.DARK_GRAY);
        help.add(aboutus);

        JMenu exit=new JMenu("Exit");
        exit.setFont(new Font("Trebuchet MS",Font.BOLD,17));


        JMenuItem logout=new JMenuItem("Logout");
        logout.addActionListener(this);
        logout.setBackground(new Color(211,211,211));
        logout.setForeground(Color.DARK_GRAY);
        exit.add(logout);

        JMenuItem exitm=new JMenuItem("Exit");
        exitm.addActionListener(this);
        exitm.setBackground(new Color(211,211,211));
        exit.setForeground(Color.DARK_GRAY);
        exit.add(exitm);


        menuBar.add(record);
        menuBar.add(help);
        menuBar.add(exit);


        JLabel l1=new JLabel("Library Management System");
        l1.setBounds(268,30,701,80);
        l1.setFont(new Font("Segoe UI Semilight",Font.BOLD,30));
        l1.setForeground(new Color(204,52,102));
        contentPane.add(l1);


        JLabel l2=new JLabel("");
        l2.setVerticalAlignment(SwingConstants.TOP);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("com/company/Library/Management/Icon/second.png"));
        Image i2=i1.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        l2=new JLabel(i3);
        l2.setBounds(60,140,159,152);
        contentPane.add(l2);


        JLabel l3=new JLabel("");
        l3.setVerticalAlignment(SwingConstants.TOP);
        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("com/company/Library/Management/Icon/third.png"));
        Image i5=i4.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT);
        ImageIcon i6=new ImageIcon(i5);
        l3=new JLabel(i6);
        l3.setBounds(300,160,134,128);
        contentPane.add(l3);


        JLabel l4=new JLabel("");
        l4.setVerticalAlignment(SwingConstants.TOP);
        ImageIcon i7=new ImageIcon(ClassLoader.getSystemResource("com/company/Library/Management/Icon/fourth.png"));
        Image i8=i7.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT);
        ImageIcon i9=new ImageIcon(i8);
        l4=new JLabel(i9);
        l4.setBounds(530,140,225,152);
        contentPane.add(l4);

        b1=new JButton("Add Books");
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(60,320,159,44);
        contentPane.add(b1);

        b2=new JButton("Statics");
        b2.addActionListener(this);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(313,320,159,44);
        contentPane.add(b2);

        b3=new JButton("Add Student");
        b3.addActionListener(this);
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.setBounds(562,320,159,44);
        contentPane.add(b3);

        JPanel panel=new JPanel();
        panel.setBorder(new TitledBorder(new LineBorder(new Color(250,128,114),2),
                "Operation",TitledBorder.LEADING,TitledBorder.TOP,null, new Color(220,20,60)));
        panel.setBounds(20,120,750,260);
        panel.setBackground(Color.WHITE);
        contentPane.add(panel);

        b4=new JButton("Issue Book");
        b4.addActionListener(this);
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.WHITE);
        b4.setBounds(76,620,143,41);
        contentPane.add(b4);

        b5=new JButton("Return Book");
        b5.addActionListener(this);
        b5.setBackground(Color.BLACK);
        b5.setForeground(Color.WHITE);
        b5.setBounds(310,620,159,41);
        contentPane.add(b5);

        b6=new JButton("About Us");
        b6.addActionListener(this);
        b6.setBackground(Color.BLACK);
        b6.setForeground(Color.WHITE);
        b6.setBounds(562,620,159,41);
        contentPane.add(b6);


        JLabel l5=new JLabel("");
        ImageIcon i10=new ImageIcon(ClassLoader.getSystemResource("com/company/Library/Management/Icon/fifth.png"));
        Image i11=i10.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT);
        ImageIcon i12=new ImageIcon(i11);
        l5=new JLabel(i12);
        l5.setBounds(60,440,159,163);
        contentPane.add(l5);

        JLabel l6=new JLabel("");
        //l6.setVerticalAlignment(SwingConstants.TOP);
        ImageIcon i13=new ImageIcon(ClassLoader.getSystemResource("com/company/Library/Management/Icon/sixth.png"));
        Image i14=i13.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT);
        ImageIcon i15=new ImageIcon(i14);
        l6=new JLabel(i15);
        l6.setBounds(332,440,139,152);
        contentPane.add(l6);

        JLabel l7=new JLabel("");
        //l7.setVerticalAlignment(SwingConstants.TOP);
        ImageIcon i16=new ImageIcon(ClassLoader.getSystemResource("com/company/Library/Management/Icon/seventh.png"));
        Image i17=i16.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT);
        ImageIcon i18=new ImageIcon(i17);
        l7=new JLabel(i18);
        l7.setBounds(567,440,157,152);
        contentPane.add(l7);

        JPanel panel2=new JPanel();
        panel2.setBounds(20,420,750,270);
        panel2.setBackground(Color.WHITE);
        panel2.setBorder(new TitledBorder(new LineBorder(new Color(250,128,114),2),
                "Action",TitledBorder.LEADING,TitledBorder.TOP,null, new Color(220,20,60)));
        contentPane.add(panel2);

        getContentPane().setBackground(Color.WHITE);
        contentPane.setBackground(Color.WHITE);




        //testing
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {

        new Home().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        String msg=ae.getActionCommand();
        if (msg.equals("Logout")){
            setVisible(false);
            new Login_User().setVisible(true);
        }
        else if (msg.equals("Exit")){
            System.exit(ABORT);
        }
        else  if (msg.equals("About Us")){
            setVisible(false);
            new AboutUs().setVisible(true);
        }
        else if (msg.equals("Read Me")){

        }
        else if (msg.equals("Book Details")){
            setVisible(false);
            new BookDetails().setVisible(true);
        }
        else if (msg.equals("Student Details")){
            setVisible(false);
            new StudentDetails().setVisible(true);
        }

        if (ae.getSource()==b1){
            this.setVisible(false);
            new AddBooks().setVisible(true);
        }
        if (ae.getSource()==b2){
            this.setVisible(false);
            new Statistics().setVisible(true);
        }

        if (ae.getSource()==b3){
            this.setVisible(false);
            new AddStudent().setVisible(true);
        }

        if (ae.getSource()==b4){
            this.setVisible(false);
            new IssueBooks().setVisible(true);
        }

        if (ae.getSource()==b5){
            this.setVisible(false);
            new ReturnBooks().setVisible(true);
        }

        if (ae.getSource()==b6) {
            this.setVisible(false);
            new AboutUs().setVisible(true);
        }
    }
}
