/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pbo.responsi.connection;

/**
 *
 * @author Lab Informatika
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConn {
    private static final String URL = "jdbc:mysql://localhost:3306/db_cart";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    
    public static Connection getConnection(){
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
        }catch(Exception e){
            System.out.println("koneksi ke database gagal "+e.getMessage());
        }
        return conn;
    }
    
}
