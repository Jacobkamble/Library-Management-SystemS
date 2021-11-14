package com.company.Library.Management;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionClass {
   public static Connection con;
   public static Connection getConnection(){
       try {
           if (con==null){
               Class.forName("com.mysql.cj.jdbc.Driver");
               con= DriverManager.getConnection("jdbc:mysql://localhost:3306/lib","root","Jacob@1234");
           }
           {
               if (con.isClosed()){
                   System.out.println("Still not Connected to db");
           }
               else
                   System.out.println("Connected to db");
           }
       }
       catch (Exception e){
           e.printStackTrace();
       }
       return con;
   }
    public static void main(String[] args) {
        getConnection();
    }
}
