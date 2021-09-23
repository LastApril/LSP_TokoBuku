/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import model.Buku;
import java.sql.*;
import java.util.Scanner;
/**
 * Kelas yang mengatur data transaksi
 * @author Arjun Hamdalah
 */
public class Transaksi {
    private final Connection con = Koneksi.getConnection();
    Statement st = null;
    ResultSet rs = null;
    /**
     * Metode untuk menambah transaksi
     * @param id_pembeli ID Pembeli bertipe Integer
     * @param id_buku ID Buku bertipe Integer
     * @param metode Metode bertipe String yang bisa berisi tunai atau non-tunai
     */
    public void tambahTransaksi(int id_pembeli, int id_buku, String metode) throws SQLException {
        System.out.println(metode);
        String query = "INSERT INTO transaksi (id_pembeli, id_buku, metode) values (?,?,?)";
        PreparedStatement ps = this.con.prepareStatement(query);
        ps.setInt(1, id_pembeli);
        ps.setInt(2, id_buku);
        ps.setString(3, metode);
        ps.execute();
    }
    /**
     * Metode untuk mengubah transaksi berdasarkan ID Transaksinya
     * @param id_transaksi ID Transaksi bertipe Integer
     * @param id_pembeli ID Pembeli bertipe Integer
     * @param id_buku ID Buku bertipe Integer
     * @param metode Metode bertipe String yang bisa berisi tunai atau non-tunai
     */
    public void ubahTransaksi(int id_transaksi, int id_pembeli, int id_buku, String metode) throws SQLException {
        String query = "UPDATE transaksi SET id_pembeli = ?, id_buku = ?, metode = ? WHERE id_transaksi = ?";
        PreparedStatement ps = this.con.prepareStatement(query);
        ps.setInt(1, id_pembeli);
        ps.setInt(2, id_buku);
        ps.setString(3, metode);
        ps.setInt(4, id_transaksi);
        ps.execute();
    }
    /**
     * Metode untuk menghapus transaksi berdasarkan ID Transaksi
     * @param id_transaksi ID Transaksi bertipe Integer
     */
    public void hapusTransaksi(int id_transaksi) throws SQLException {
        Buku buku = new Buku();
        int id_buku;
        String queryBuku = "SELECT id_buku FROM transaksi where id_transaksi = "+id_transaksi;
        st = con.createStatement();
        rs = st.executeQuery(queryBuku);
        while(rs.next()){
            id_buku = rs.getInt("id_buku");
            buku.tambahStokBuku(id_buku);
        }
        String query = "DELETE FROM transaksi where id_transaksi = ?";
        PreparedStatement ps = this.con.prepareStatement(query);
        ps.setInt(1, id_transaksi);
        ps.execute();
    }
    /**
     * Metode untuk melihat transaksi
     */
    public void lihatTransaksi() throws SQLException {
        String query = "SELECT t.id_transaksi, b.judul, p.nama, b.harga, t.metode "
                + "FROM transaksi t "
                + "INNER JOIN buku b ON t.id_buku = b.id_buku "
                + "INNER JOIN pembeli p on t.id_pembeli = p.id_pembeli "
                + "ORDER BY t.id_transaksi;";
        st = con.createStatement();
        rs = st.executeQuery(query);
        while(rs.next()){
                    System.out.println("-------------");
                    System.out.println("ID Transaksi : "+rs.getString("id_transaksi"));
                    System.out.println("Judul Buku : "+rs.getString("judul"));
                    System.out.println("Nama Pembeli : "+rs.getString("nama"));
                    System.out.println("Harga Buku : "+rs.getInt("harga"));
                    System.out.println("Metode Pembayaran : "+rs.getString("metode"));
                    System.out.println("-------------");
                }
        
    }
    /**
     * Metode untuk melihat transaksi berdasarkan ID Transaksi
     * @param id_transaksi ID Transaksi bertipe Integer
     */
    public void lihatTransaksi(int id_transaksi) throws SQLException {
        String query = "SELECT t.id_transaksi, b.judul, p.nama, b.harga, t.metode "
                + "FROM transaksi t "
                + "INNER JOIN buku b ON t.id_buku = b.id_buku "
                + "INNER JOIN pembeli p on t.id_pembeli = p.id_pembeli "
                + "WHERE t.id_transaksi = "+id_transaksi+" ORDER BY t.id_transaksi;";
        st = con.createStatement();
        rs = st.executeQuery(query);
        while(rs.next()){
            System.out.println("-------------");
            System.out.println("ID Transaksi : "+rs.getString("id_transaksi"));
            System.out.println("Judul Buku : "+rs.getString("judul"));
            System.out.println("Nama Pembeli : "+rs.getString("nama"));
            System.out.println("Harga Buku : "+rs.getInt("harga"));
            System.out.println("Metode Pembayaran : "+rs.getString("metode"));
            System.out.println("-------------");
        }
        
    }
    
}
