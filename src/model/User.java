/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.*;
/**
 * Kelas yang mengatur proses login
 * @author Arjun Hamdalah
 */
public class User implements Login {
    private Connection con;
    private int id;
    private Boolean hasil_login = false;
    /**
     * Metode untuk melakukan login
     * @param username String untuk username
     * @param password String untuk password
     */
    @Override
    public boolean login(String username, String password) {
        
        try {
            this.con = Koneksi.getConnection();
            
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        String queryUsername = "SELECT * FROM users WHERE username = ?";
        
        try {
            PreparedStatement pstmt = con.prepareStatement(queryUsername);
            pstmt.setString(1, username);
            pstmt.execute();
            ResultSet rs = pstmt.getResultSet();
            
            if (!rs.next()) {
                System.out.println("Login Failed! Wrong username");
                return false;
            } else {
                if (rs.getString("password").equals(password)) {
                    hasil_login = true;
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return hasil_login;
    }
}
