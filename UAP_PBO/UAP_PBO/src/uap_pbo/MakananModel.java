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
public class MakananModel {
    private final Connection CONN;

    public MakananModel() {
        this.CONN = DatabaseHelper.getConnection();
    }
    
    public void addMakanan(Makanan mkn){
        String insert = "INSERT INTO makanan (id_makanan, nama_makanan, daya_tahan, harga_makanan, jumlah, diskon) "
                + "VALUES (" +mkn.getId()+ ",'" +mkn.getNama_produk()+ "'," +mkn.getDayatahan()+ "," 
                +mkn.getHarga()+ "," +mkn.getJumlah()+ "," +mkn.getDiskon()+ ")";
     
        System.out.println(insert);
        
        try {
            if(CONN.createStatement().executeUpdate(insert) > 0){
                System.out.println("Berhasil Memasukkan Data");
            }else{
                System.out.println("Gagal Memasukkan Data");
            }
        } catch (SQLException ex) {
            Logger.getLogger(MakananModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Gagal Memasukkan Data");
        }
    }   
    
    public void delMakanan(int id){
        String insert ="DELETE FROM makanan WHERE id_makanan="+id;
        try {
            if(CONN.createStatement().executeUpdate(insert)>0){
                System.out.println("berhasil menghapus data"); 
            }else{
                System.out.println("Gagal menghapus data");
            }
        } catch (SQLException ex) {
            Logger.getLogger(MakananModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Gagal menghapus data");
        }
    }

}
