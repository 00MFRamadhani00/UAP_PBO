/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uap_pbo_jdbc;

import java.util.ArrayList;

/**
 *
 * @author Asus
 */
public class Penjualan implements ProductCounter{
    private int id_penjualan; //Primary
    private ArrayList<Produk> listProduk = new ArrayList();
    private int jumlahProduk;
    private int stok;

    public Penjualan(int id_penjualan, int jumlahProduk, int stok) {
        this.id_penjualan = id_penjualan;
        this.jumlahProduk = jumlahProduk;
        this.stok = stok;
    }    

    public int getId_penjualan() {
        return id_penjualan;
    }

    public void setId_penjualan(int id_penjualan) {
        this.id_penjualan = id_penjualan;
    }

    public ArrayList<Produk> getListProduk() {
        return listProduk;
    }

    public void setListProduk(ArrayList<Produk> listProduk){
        this.listProduk = listProduk;
    }
    
    public int getJumlahProduk() {
        return jumlahProduk;
    }

    public void setJumlahProduk(int jumlahProduk) {
        this.jumlahProduk = jumlahProduk;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }
    
    public ArrayList<Produk> getProduk(Produk p){
        listProduk.add(p);
        return listProduk;
    }
    @Override
    public void hitungJumlahProduk(){
        System.out.println("Pokoknya Ada");
    }
    
    @Override
    public void hitungHargaProduk(){
        System.out.println("Pokoknya Murah");
    }   
}
