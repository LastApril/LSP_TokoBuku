/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.User;
import model.Buku;
import model.Transaksi;
import model.Pembeli;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
/**
 * Kelas utama yang menampilkan menu
 * @author Arjun Hamdalah
 */
public class MainActivity {
    /**
     * Metode untuk menjalankan aplikasi dari awal dan menampilkan text serta input
     */
    public static void main(String[] args) throws SQLException {
        User user = new User();
        Scanner scanner = new Scanner(System.in);
        String username;
        String password;
        int choice;
        boolean exit = false;
        
        while(!exit) {
            choice = menu();
            
            switch(choice) {
                case 1:
                    System.out.print("Username: ");
                    username = scanner.nextLine();
                    System.out.print("Password: ");
                    password = scanner.nextLine();
                    
                    if (user.login(username, password)) {
                        System.out.println("Berhasil Login!");
                        menu2();
                    } else 
                        System.out.println("Gagal Login! Salah Password");
                    break;
                    
                case 2:
                    System.out.println("Exiting...");
                    exit = true;
                    break;
                default:
                    System.out.println("Pilih menu yang anda ingin akses");
            }
        }
    }
    /**
     * Metode menu utama
     */
     public static int menu() {
        int choice;
        Scanner scanner = new Scanner(System.in);
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("====\tToko Buku\t====");
        System.out.println("1. Login\n2. Exit");
        System.out.print("Pilih: ");
        choice = scanner.nextInt();
        return choice;
    }
    /**
     * Metode menu transaksi
     */
     public static void menu2() throws SQLException {
        int choice,id_buku,id_pembeli;
        Scanner scanner = new Scanner(System.in);
        boolean logOut = false;
        Buku buku = new Buku();
        Pembeli pembeli = new Pembeli();
        Transaksi transaksi = new Transaksi();
        while (!logOut) {
            String metode = null;
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("====\tToko Buku\t====");
            System.out.println("1. Tambah Transaksi\n2. Lihat Transaksi\n"
                    + "3. Hapus Transaksi\n4. Ubah Transaksi\n5. Menu Buku\n6. Logout");
            System.out.print("Pilih: ");
            choice = scanner.nextInt();
        
            switch(choice) {
                case 1:
                    pembeli.tampilPembeli();
                    System.out.print("Pilih ID Pembeli : ");
                    id_pembeli = scanner.nextInt();
                    buku.tampilBuku();
                    System.out.print("Pilih ID Buku :");
                    id_buku = scanner.nextInt();
                    while(metode==null) {
                        System.out.println("Pilih Metode Pembayaran :");
                        System.out.println("1.Tunia\n2.Non-Tunai");
                        System.out.print("Pilih: ");
                        choice = scanner.nextInt();

                        switch(choice) {
                            case 1:
                              metode = "tunai";
                              break;
                            case 2:
                              metode = "non-tunai";
                              break;
                        }
                        transaksi.tambahTransaksi(id_pembeli, id_buku, metode);
                    }
                    break;
                    
                case 2:
                    transaksi.lihatTransaksi();
                    break;
                    
                case 3:
                    transaksi.lihatTransaksi();
                    System.out.print("Pilih id yang ingin dihapus :");
                    int id_transaksi = scanner.nextInt();
                    transaksi.hapusTransaksi(id_transaksi);
                    break;
                
                case 4:
                    transaksi.lihatTransaksi();
                    System.out.print("Pilih ID Transaksi : ");
                    id_transaksi = scanner.nextInt();
                    transaksi.lihatTransaksi(id_transaksi);
                    pembeli.tampilPembeli();
                    System.out.print("Masukkan ID Pembeli : ");
                    id_pembeli = scanner.nextInt();
                    buku.tampilBuku();
                    System.out.print("Masukkan ID Buku : ");
                    id_buku = scanner.nextInt();
                    while(metode==null) {
                        System.out.println("Pilih Metode Pembayaran : ");
                        System.out.println("1.Tunia\n2.Non-Tunai");
                        System.out.print("Pilih : ");
                        choice = scanner.nextInt();

                        switch(choice) {
                            case 1:
                              metode = "tunai";
                              break;
                            case 2:
                              metode = "non-tunai";
                              break;
                        }
                        transaksi.ubahTransaksi(id_transaksi, id_pembeli, id_buku, metode);
                    }
                    break;
                case 5:
                    menuBuku();
                    break;
                case 6:
                    logOut = true;
                    break;
            }
        }
     }
     /**
      * Metode menu buku
      */
     public static void menuBuku() throws SQLException{
        Scanner scanner = new Scanner(System.in);
        int choice;
        boolean kembali = false;
        Buku buku = new Buku();
        while(!kembali) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("====\tManajemen Buku\t====");
            System.out.println("1. Tambah Buku\n2. Lihat Buku\n3. Ubah Buku\n4. Hapus Buku\n5. Kembali");
            System.out.print("Pilih: ");
            choice = Integer.parseInt(scanner.nextLine());
            String judul;
            int harga;
            int stok;
            int id_buku;
            switch(choice) {
                case 1:
                    try {
                        System.out.print("Masukkan Judul Buku : ");
                        judul = scanner.nextLine();
                        System.out.print("Masukkan Harga Buku : ");
                        harga = Integer.parseInt(scanner.nextLine());
                        System.out.print("Masukkan Jumlah Stok Buku : ");
                        stok = Integer.parseInt(scanner.nextLine());
                        buku.tambahBuku(judul, stok, harga);
                        break;
                    } catch(SQLException e) {
                        System.out.println(e);
                        break;
                    }
                case 2:
                    buku.tampilBuku();
                    break;
                    
                case 3:
                    try {
                        buku.tampilBuku();
                        System.out.print("Pilih ID Buku :");
                        id_buku = Integer.parseInt(scanner.nextLine());
                        buku.tampilBuku(id_buku);
                        System.out.print("Masukkan Judul Buku :");
                        judul = scanner.nextLine();
                        System.out.print("Masukkan Harga Buku : ");
                        harga = Integer.parseInt(scanner.nextLine());
                        System.out.print("Masukkan Jumlah Stok Buku :");
                        stok = Integer.parseInt(scanner.nextLine());
                        buku.ubahBuku(id_buku, judul, stok, harga);
                        break;
                    } catch(SQLException e) {
                        System.out.println(e);
                        break;
                    }
                    
                case 4:
                    buku.tampilBuku();
                    System.out.print("Pilih ID Buku untuk dihapus : ");
                    id_buku = Integer.parseInt(scanner.nextLine());
                    buku.hapusBuku(id_buku);
                    break;
                case 5:
                    kembali = true;
                    break;
                    
                default:
                    System.out.println("Pilih menu yang anda ingin akses");
                    break;
            }
        }
     }
}
