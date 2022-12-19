///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package uap_pbo;
//import Database.DatabaseHelper;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import java.util.ArrayList;
//import java.sql.ResultSet;
///**
// *
// * @author Asus
// */
//public class ProdukModel {
//    private final Connection CONN;
//
//    public ProdukModel() {
//        this.CONN = DatabaseHelper.getConnection();
//    }
//    
//    public void addProduk(Produk prd){
//        String insert = "INSERT INTO produk (id_produk, nama_produk, harga, jumlah, diskon) VALUES (" 
//                +prd.getId_produk()+ ",'" +prd.getNama_produk()+ "'," +prd.getHarga()+ "," +prd.getJumlah()+ "," +prd.getDiskon()+ ")" ;
//        
//        System.out.println(insert);
//        
//        try {
//            if(CONN.createStatement().executeUpdate(insert) > 0){
//                System.out.println("Berhasil Memasukkan Data");
//            }else{
//                System.out.println("Gagal Memasukkan Data");
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(ProdukModel.class.getName()).log(Level.SEVERE, null, ex);
//            System.out.println("Gagal Memasukkan Data");
//        }
//    }
//    
//    public ArrayList<Produk> getProduk(){
//        String query = "SELECT * FROM produk";
//        ArrayList<Produk> prd = new ArrayList<>();
//        
//        System.out.println(query);
//        try {
//            ResultSet rs = CONN.createStatement().executeQuery(query);
//            while(rs.next()){
//                Produk temp = new Produk(rs.getInt("id_produk"), rs.getString("nama_produk"), 
//                        rs.getDouble("harga"), rs.getInt("jumlah"), rs.getDouble("diskon"));
//                prd.add(temp);
//            }
//            System.out.println("Berhasil Mengambil Data");
//        } catch (SQLException ex) {
//            Logger.getLogger(ProdukModel.class.getName()).log(Level.SEVERE, null, ex);
//            System.out.println("Gagal Mengambil Data");
//        }
//        return prd;
//    }
//    
//    public void upProduk(Produk prd){
//        String update = "UPDATE produk SET nama_produk='" +prd.getNama_produk()+ "', harga= " 
//                +prd.getHarga()+ ", jumlah= " +prd.getJumlah()+", diskon= " +prd.getDiskon()+ 
//                " WHERE id_produk= " +prd.getId_produk();
//
//        System.out.println(update);
//        try {
//            PreparedStatement upd = CONN.prepareStatement(update);
//            upd.executeUpdate();
//            System.out.println("Berhasil Update Data");
//        } catch (SQLException ex) {
//            Logger.getLogger(ProdukModel.class.getName()).log(Level.SEVERE, null, ex);
//            System.out.println("Gagal Update Data");
//        }
//    }
//    
//    public void delProduk(Produk prd){
//        String delete = "DELETE FROM produk WHERE id_produk= " + prd.getId_produk();
//        
//        System.out.println(delete);
//        try {
//            PreparedStatement dlt = CONN.prepareStatement(delete);
//            dlt.execute();
//        } catch (SQLException ex) {
//            Logger.getLogger(ProdukModel.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//    }
//}