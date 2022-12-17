/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uap_pbo;

import java.util.ArrayList;

/**
 *
 * @author Asus
 */
public class Penjualan implements ProductCounter{
    private ArrayList<Produk> listProduk = new ArrayList();
    private int jumlahProduk;
    private int stok;

    public Penjualan(int jumlahProduk, int stok) {
        this.jumlahProduk = jumlahProduk;
        this.stok = stok;
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
    
    @Override
    public void hitungJumlahProduk(){
        System.out.println("Pokoknya Ada");
    }
    
    @Override
    public void hitungHargaProduk(){
        System.out.println("Pokoknya Murah");
    }   
}
