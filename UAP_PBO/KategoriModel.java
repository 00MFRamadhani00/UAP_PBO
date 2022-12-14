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
public class KategoriModel {
    private final Connection CONN;

    public KategoriModel() {
        this.CONN = DatabaseHelper.getConnection();
    }
    
    public void addKategori(Kategori ktg){
        String insert = "INSERT INTO kategori (id_kategori, nama_kategori) VALUES ("
                +ktg.getId_kategori()+ ",'" +ktg.getNama_kategori()+"')";
        
        System.out.println(insert);
        
        try {
            if(CONN.createStatement().executeUpdate(insert) > 0){
                System.out.println("Berhasil Memasukkan Data");
            }else{
                System.out.println("Gagal Memasukkan Data");
            }
        } catch (SQLException ex) {
            Logger.getLogger(KategoriModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Gagal Memasukkan Data");
        }
    }
    
    public void delKategori(Kategori ktg){
        String delete = "DELETE FROM produk WHERE id_kategori= " + ktg.getId_kategori();
        
        System.out.println(delete);
        try {
            PreparedStatement dlt = CONN.prepareStatement(delete);
            dlt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(KategoriModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Kategori> getKategori(){
        String query = "SELECT * FROM kategori";
        ArrayList<Kategori> ktg = new ArrayList<>();
        
        System.out.println(query);
        try {
            ResultSet rs = CONN.createStatement().executeQuery(query);
            while(rs.next()){
                Kategori temp = new Kategori(rs.getInt("id_kategori"), rs.getString("nama_kategori"));
                ktg.add(temp);
            }
            System.out.println("Berhasil Mengambil Data");
        } catch (SQLException ex) {
            Logger.getLogger(ProdukModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Gagal Mengambil Data");
        }
        return ktg;
    }
    
    public void upKategori(Kategori ktg){
        String update = "UPDATE kategori SET nama_produk='" +ktg.getNama_kategori()+ " WHERE id_produk= " +ktg.getId_kategori();

        System.out.println(update);
        try {
            PreparedStatement upd = CONN.prepareStatement(update);
            upd.executeUpdate();
            System.out.println("Berhasil Update Data");
        } catch (SQLException ex) {
            Logger.getLogger(KategoriModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Gagal Update Data");
        }
    }
}
