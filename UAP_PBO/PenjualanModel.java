/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uap_pbo_jdbc;

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
public class PenjualanModel {
    private final Connection CONN;

    public PenjualanModel() {
        this.CONN = DatabaseHelper.getConnection();
    }
    
    public void addPenjualan(Penjualan pjl, Produk prd){
        String insert = "INSERT INTO penjualan (id_penjualan, id_produk, jumlah_produk, stok) VALUES (" 
                +pjl.getId_penjualan()+ ",'" +pjl.getProduk(prd)+ "'," +pjl.getJumlahProduk()+ "," +pjl.getStok()+ ")" ;
        
        System.out.println(insert);
        
        try {
            if(CONN.createStatement().executeUpdate(insert) > 0){
                System.out.println("Berhasil Memasukkan Data");
            }else{
                System.out.println("Gagal Memasukkan Data");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PenjualanModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Gagal Memasukkan Data");
        }
    }
    
    public void delPenjualan(Penjualan pjl){
        String delete = "DELETE FROM penjualan WHERE id_penjualan= " + pjl.getId_penjualan();
        
        System.out.println(delete);
        try {
            PreparedStatement dlt = CONN.prepareStatement(delete);
            dlt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(PenjualanModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
