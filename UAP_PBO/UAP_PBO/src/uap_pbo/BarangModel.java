///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
package uap_pbo;
import Database.DatabaseHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.sql.ResultSet;
///**
// *
// * @author Asus
// */
public class BarangModel {
    private final Connection CONN;

    public BarangModel() {
        this.CONN = DatabaseHelper.getConnection();
    }
    
    public void addBarang(Barang brg){
        String insert = "INSERT INTO barang(barcode, expired, kategori, nama_barang, harga, jumlah, diskon) "
                + "VALUES ('"+brg.getBarcode()+"','"+brg.getExpired()+"','"+brg.getKategori()+"','"
                +brg.getNama_produk()+"',"+brg.getHarga()+","+brg.getJumlah()+","+brg.getDiskon()+")";
               
        
        System.out.println(insert);
        
        try {
            if(CONN.createStatement().executeUpdate(insert) > 0){
                System.out.println("Berhasil Memasukkan Data");
            }else{
                System.out.println("Gagal Memasukkan Data");
            }
        } catch (SQLException ex) {
            Logger.getLogger(BarangModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Gagal Memasukkan Data");
        }
    }   
    
    public void delBarang(String brg){
        String delete = "DELETE FROM barang WHERE barcode= '" + brg+ "'";
        
        System.out.println(delete);
        try {
            PreparedStatement dlt = CONN.prepareStatement(delete);
            dlt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(BarangModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
