/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.*;
/**
 *
 * @author UG
 */
public class User implements Login {
    private Connection con;
    private int id;
    private Boolean hasil_login = false;

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
                    //System.out.println("Login Succsess");
                    hasil_login = true;
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return hasil_login;
    }
}
