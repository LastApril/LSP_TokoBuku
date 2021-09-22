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
 *
 * @author UG
 */
public class MainActivity {
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
                        System.out.println("Successfully Logged In!");
                        menu2();
                    } else 
                        System.out.println("Login Failed! Wrong Password");
                    break;
                    
                case 2:
                    System.out.println("Exiting...");
                    exit = true;
                    break;
                default:
                    System.out.println("Please select the number of the menu you want to access");
            }
        }
    }
    
     public static int menu() {
        int choice;
        Scanner scanner = new Scanner(System.in);
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("====\tToko Buku\t====");
        System.out.println("1. Login\n2. Exit");
        System.out.print("Selection: ");
        choice = scanner.nextInt();
        return choice;
    }
     
     public static void menu2() throws SQLException {
        int choice,id_buku,id_pembeli;
        String metode;
        Scanner scanner = new Scanner(System.in);
        boolean logOut = false;
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("====\tToko Buku\t====");
        System.out.println("1. Transaksi\n2. Logout");
        System.out.print("Selection: ");
        choice = scanner.nextInt();
        
        while (!logOut) {
            switch(choice) {
                case 1:
                    Buku buku = new Buku();
                    Pembeli pembeli = new Pembeli();
                    pembeli.tampilPembeli();
                    System.out.print("Pilih ID Pembeli : ");
                    id_pembeli = scanner.nextInt();
                    buku.tampilBuku();
                    System.out.print("Pilih ID Buku :");
                    id_buku = scanner.nextInt();
                    System.out.println("Pilih Metode Pembayaran :");
                    System.out.println("1.Tunia\n2.Non-Tunai");
                    System.out.print("Selection: ");
                    choice = scanner.nextInt();

                    switch(choice) {
                        case 1:
                          metode = "tunai";
                          break;
                        case 2:
                          metode = "non-tunai";
                          break;
                    }
                    
                    
                    break;
            }
        }
        
     }
}
