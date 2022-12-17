/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Asus
 */
public class DatabaseHelper {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static final String DB = "uap_pbo";
    private static final String MYCONN = "jdbc:mysql://localhost/"+DB;
    
    public static Connection getConnection(){
        Connection conn = null;
        
        try{
            conn = DriverManager.getConnection(MYCONN, USERNAME, PASSWORD);
            System.out.println("Koneksi Berhasil");
        } catch (SQLException ex){
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Koneksi Gagal");
        }
        return conn;
    }
}