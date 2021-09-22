/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.sql.*;
import java.util.Scanner;
/**
 *
 * @author UG
 */
public class Buku {
    private final Connection con = Koneksi.getConnection();
    Statement st = null;
    ResultSet rs = null;
    public void tampilBuku() throws SQLException {
        String query = "SELECT * FROM buku";
        st = con.createStatement();
        rs = st.executeQuery(query);
        while(rs.next()){
                    System.out.println("-------------");
                    System.out.println("ID Buku : "+rs.getString("id_buku"));
                    System.out.println("Judul Buku : "+rs.getString("judul"));
                    System.out.println("Harga Buku : "+rs.getInt("harga"));
                    System.out.println("Stok Buku : "+rs.getInt("stok"));
                    System.out.println("-------------");
                }
    }
    
    
}
