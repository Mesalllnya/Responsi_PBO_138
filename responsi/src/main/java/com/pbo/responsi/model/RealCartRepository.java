/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pbo.responsi.model;

import com.pbo.responsi.dto.CartItemDTO;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import com.pbo.responsi.connection.DbConn;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author Lab Informatika
 */
public class RealCartRepository implements CartRepository{

    @Override
    public List<CartItemDTO> findAll() {
        List<CartItemDTO> item = new ArrayList<>();
        String query = "SELECT * FROM cart";
        
        try(Connection conn = DbConn.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query)) {
            while(rs.next()){
                item.add(new CartItemDTO(rs.getString("nama"),
                        rs.getInt("harga"), rs.getInt("qty")));
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public void save(CartItemDTO item) {
        String query = "INSERT INTO cart (nama, harga, qty) VALUES (?,?,?)";
        try(Connection conn = DbConn.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, item.getName());
            pstmt.setDouble(2, item.getPrice());
            pstmt.setInt(3, item.getQuantity());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateQuantity(String name, int newQty) {
        String query = "UPDATE cart SET qty=? WHERE nama=?";
        try(Connection conn = DbConn.getConnection(); 
                 PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, newQty);
            pstmt.setString(2, name);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public void delete(String name) {
        String query = "DELETE FROM cart WHERE nama=?";
        try(Connection conn = DbConn.getConnection(); 
                 PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, name);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
