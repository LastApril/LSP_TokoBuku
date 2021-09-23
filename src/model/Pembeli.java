/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Kelas mengatur data pembeli
 * @author Arjun Hamdalah
 */
public class Pembeli {
    private final Connection con = Koneksi.getConnection();
    Statement st = null;
    ResultSet rs = null;
    /**
     * Metode untuk menampilkan pembeli
     */
    public void tampilPembeli() throws SQLException {
        String query = "SELECT * FROM pembeli";
        st = con.createStatement();
        rs = st.executeQuery(query);
        while(rs.next()){
                    System.out.println("-------------");
                    System.out.println("ID Pembeli : "+rs.getString("id_pembeli"));
                    System.out.println("Nama Pembeli : "+rs.getString("nama"));
                    System.out.println("-------------");
                }
    }
    /**
     * Metode untuk menampilkan pembeli berdasarkan ID Pembeli yang dimasukkan
     * @param id_pembeli ID Pembeli bertipe integer
     */
    public void tampilPembeli(int id_pembeli) throws SQLException {
        String query = "SELECT * FROM pembeli where id_pembeli = "+id_pembeli;
        st = con.createStatement();
        rs = st.executeQuery(query);
        while(rs.next()){
                    System.out.println("-------------");
                    System.out.println("ID Pembeli : "+rs.getString("id_pembeli"));
                    System.out.println("Nama Pembeli : "+rs.getString("nama"));
                    System.out.println("-------------");
                }
    }
}
