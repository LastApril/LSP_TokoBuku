/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.sql.*;

/**
 * Kelas yang mengatur data buku
 * @author Arjun Hamdalah
 */
public class Buku {
    private final Connection con = Koneksi.getConnection();
    Statement st = null;
    ResultSet rs = null;
    /**
     * Metode untuk menampilkan data buku
     */
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
    /**
     * Metode untuk menampilkan data buku dengan id yang dimasukkan
     * @param id_buku ID Buku bertipe Integer
     */
    public void tampilBuku(int id_buku) throws SQLException {
        String query = "SELECT * FROM buku where id_buku = "+id_buku;
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
    /**
     * Metode untuk menambah data buku
     * @param judul Judul bertipe String dengan panjang 255 karakter
     * @param stok Stok bertipe Integer
     * @param harga Harga bertipe Integer
     */
    public void tambahBuku(String judul, int stok, int harga) throws SQLException {
        String query = "INSERT INTO buku (judul, stok, harga) values (?,?,?)";
        PreparedStatement ps = this.con.prepareStatement(query);
        ps.setString(1, judul);
        ps.setInt(2, stok);
        ps.setInt(3, harga);
        ps.execute();
        System.out.println("Data Buku Telah Berhasil Dimasukkan");
        tampilBuku();
    }
    /**
     * Metode untuk menambah stok buku setelah menghapus transaksi
     * @param id_buku ID Buku bertipe Integer
     */
    public void tambahStokBuku(int id_buku) throws SQLException {
        String query = "UPDATE buku set stok = stok + 1 where id_buku = ?";
        PreparedStatement ps = this.con.prepareStatement(query);
        ps.setInt(1, id_buku);
        ps.execute();
        System.out.println("Transaksi berhasil dihapus dan stok buku ditambahkan");
    }
    /**
     * Metode untuk menghapus buku dengan ID Buku yang dimasukkan
     * @param id_buku ID Buku bertipe Integer
     */
    public void hapusBuku(int id_buku) throws SQLException {
        String query = "DELETE FROM buku where id_buku = ?";
        PreparedStatement ps = this.con.prepareStatement(query);
        ps.setInt(1, id_buku);
        ps.execute();
        System.out.println("Buku berhasil dihapus");
    }
    /**
     * Metode untuk mengubah data buku
     * @param id_buku ID Buku bertipe Integer
     * @param judul Judul bertipe String dengan panjang 255 karakter
     * @param stok Stok bertipe Integer
     * @param harga Harga bertipe Integer
     */
    public void ubahBuku(int id_buku, String judul, int stok, int harga) throws SQLException {
        String query = "UPDATE buku SET judul = ?, stok = ?, harga = ? WHERE id_buku = ?";
        PreparedStatement ps = this.con.prepareStatement(query);
        ps.setInt(4, id_buku);
        ps.setString(1, judul);
        ps.setInt(2, stok);
        ps.setInt(3, harga);
        ps.execute();
        System.out.println("Data Buku Telah Diubah");
    }
}
