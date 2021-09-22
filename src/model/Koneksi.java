/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
/**
 *
 * @author UG
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Koneksi {
    private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/tokobuku";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static Connection con;
    
    public static Connection getConnection() {
        try {
            Class.forName(DRIVER_NAME);
            try {
                con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            } catch (SQLException se) {
                System.out.println("Failed to create the database connection");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Cannot find the Driver specified");
        }

        return con;
    }
}
