/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package uap_pbo_jdbc;

import Database.DatabaseHelper;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
/**
 *
 * @author Asus
 */
public class JDBCforConnect {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        DatabaseHelper.getConnection();

        // Add Tabel
        ProdukModel prd = new ProdukModel();
        Produk prd1 = new Produk(1, "Soni", 130000.0, 1, 0.1); //Perlu buat Barang
        Produk prd2 = new Produk(2, "Sari Rempah", 10000.0, 1, 0.05); //Perlu buat Makanan
//        prd.addProduk(prd1);
//        prd.addProduk(prd2);
//        
        KategoriModel ktg = new KategoriModel();
        Kategori ktg1 = new Kategori(1,"Gaming"); //Perlu buat Barang
        Kategori ktg2 = new Kategori(2,"Sport"); //Perlu buat Makanan
//        ktg.addKategori(ktg1);
//        ktg.addKategori(ktg2);
//
        BarangModel brg = new BarangModel();
        LocalDate dateExp = LocalDate.of(2022, 12, 30);
        Barang brg1 = new Barang("1234abcd",dateExp,1,"Soni",130000.0,1,0.1);
//        brg.addBarang(brg1, ktg1, prd1);
//        
        MakananModel mkn = new MakananModel();
        LocalDate dateTa = LocalDate.of(2023, 1, 1);
        Makanan mkn1  = new Makanan(1,dateTa,2,"Sari Rempah",10000.0,1,0.05);
//        mkn.addMakanan(mkn1, prd2);
        // Add Tabel
        
        // Show Tabel Produk
        ArrayList<Produk> listProduk = prd.getProduk();
        for(int i = 0; i<listProduk.size(); i++){
            System.out.println("ID\t: " + listProduk.get(i).getId_produk());
            System.out.println("Nama\t: " + listProduk.get(i).getNama_produk());
            System.out.println("Harga\t: " + listProduk.get(i).getHarga());
            System.out.println("Jumlah\t: " + listProduk.get(i).getJumlah());
            System.out.println("Diskon\t: " + listProduk.get(i).getDiskon());
            System.out.println("");
        }
        // Show tabel Produk
        
        // Update
        Produk prd3 = new Produk(2, "Onigiri", 12000.0, 1, 0.1);
        prd.upProduk(prd3);
        ArrayList<Produk> listProduk1 = prd.getProduk();
        for(int i = 0; i<listProduk1.size(); i++){
            System.out.println("ID\t: " + listProduk1.get(i).getId_produk());
            System.out.println("Nama\t: " + listProduk1.get(i).getNama_produk());
            System.out.println("Harga\t: " + listProduk1.get(i).getHarga());
            System.out.println("Jumlah\t: " + listProduk1.get(i).getJumlah());
            System.out.println("Diskon\t: " + listProduk1.get(i).getDiskon());
            System.out.println("");
        }
        // Update
        
        // Delete
        prd.delProduk(prd3);
        ArrayList<Produk> listProduk3 = prd.getProduk();
        for(int i = 0; i<listProduk3.size(); i++){
            System.out.println("ID\t: " + listProduk3.get(i).getId_produk());
            System.out.println("Nama\t: " + listProduk3.get(i).getNama_produk());
            System.out.println("Harga\t: " + listProduk3.get(i).getHarga());
            System.out.println("Jumlah\t: " + listProduk3.get(i).getJumlah());
            System.out.println("Diskon\t: " + listProduk3.get(i).getDiskon());
            System.out.println("");
        }
    }
    
}
