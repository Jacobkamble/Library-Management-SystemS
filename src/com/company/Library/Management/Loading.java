package com.company.Library.Management;

import javax.swing.*;
import java.awt.*;

public class Loading extends JFrame implements Runnable{
    private JPanel contentPane;
    private JProgressBar progressBar;
   // int s;
    Thread th;

    public Loading(){
        super("Loading");
        th=new Thread((Runnable) this);

        setBounds(600,300,600,400);
        contentPane=new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel libraryManagement=new JLabel("Smart Library v2.1");
        libraryManagement.setForeground(new Color(72,209,204));
        libraryManagement.setFont(new Font("Trebuchet MS",Font.BOLD,35));
        libraryManagement.setBounds(130,46,500,35);
        contentPane.add(libraryManagement);

        progressBar=new JProgressBar();
        progressBar.setFont(new Font("Tahoma",Font.BOLD,12));
        progressBar.setStringPainted(true);
        progressBar.setBounds(130,135,300,25);
        contentPane.add(progressBar);

        JLabel label2=new JLabel("Please Wait....");
        label2.setFont(new Font("Yu Gothic UI Semibold",Font.BOLD,20));
        label2.setForeground(new Color(160,82,45));
        label2.setBounds(200,165,150,20);
        contentPane.add(label2);

//        JPanel panel=new JPanel();
//        panel.setBackground(Color.WHITE);
//        panel.setBounds(0,0,590,390);
//        contentPane.add(panel);



        //Testing

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUpLoading();

    }
    public void setUpLoading(){
        th.start();
    }

    @Override
    public void run() {
        try {
            int i;
            for ( i=0;i<200;i++){
                //s=s+1;
                int m=progressBar.getMaximum();
                int v=progressBar.getValue()+1;
                if (v<m){
                    progressBar.setValue(v);
                }
                else {
                    setVisible(false);

                 //   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    new Home().setVisible(true);
                    break;

                }
                Thread.sleep(50);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Loading();

    }
}
