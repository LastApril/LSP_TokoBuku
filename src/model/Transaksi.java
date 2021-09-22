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
public class Transaksi {
    private final Connection con = Koneksi.getConnection();
    
    public void tambahTransaksi(int id_pembeli, int id_buku, String metode) throws SQLException {
        if(metode == null) {
            System.out.println();
        }
    }
}
