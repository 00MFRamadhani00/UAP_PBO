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
public class MakananModel {
    private final Connection CONN;

    public MakananModel() {
        this.CONN = DatabaseHelper.getConnection();
    }
    
    public void addMakanan(Makanan mkn, Produk prd){
        String insert = "INSERT INTO makanan (id_makanan, daya_tahan, id_produk) VALUES (" 
                +mkn.getId_makanan()+ ",'" +mkn.getDaya_tahan()+ "'," +prd.getId_produk()+ ")" ;
        
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
    
    public void delMakanan(Makanan mkn){
        String delete = "DELETE FROM produk WHERE id_makanan= " + mkn.getId_makanan();
        
        System.out.println(delete);
        try {
            PreparedStatement dlt = CONN.prepareStatement(delete);
            dlt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(MakananModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
