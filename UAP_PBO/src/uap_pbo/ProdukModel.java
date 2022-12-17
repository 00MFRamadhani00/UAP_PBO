/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uap_pbo;
import Database.DatabaseHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.sql.ResultSet;
/**
 *
 * @author Asus
 */
public class ProdukModel {
    private final Connection CONN;

    public ProdukModel() {
        this.CONN = DatabaseHelper.getConnection();
    }
    
    public void addProduk(Produk prd){
        String insert = "INSERT INTO produk (nama_produk, harga, jumlah, diskon) VALUES ('"
                +prd.getNama_produk()+ "'," +prd.getHarga()+ "," +prd.getJumlah()+ "," +prd.getDiskon()+ ")" ;
        
        System.out.println(insert);
        
        try {
            if(CONN.createStatement().executeUpdate(insert) > 0){
                System.out.println("Berhasil Memasukkan Data");
            }else{
                System.out.println("Gagal Memasukkan Data");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdukModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Gagal Memasukkan Data");
        }
    }   
}
