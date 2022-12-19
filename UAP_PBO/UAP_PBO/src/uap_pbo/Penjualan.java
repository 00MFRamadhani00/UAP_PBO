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
    private int id_penjualan;
    private String nama_produk;
    private int jumlah_barang;
    private int stok_produk;

    public Penjualan(int id_penjualan, String nama_produk, int jumlah_barang, int stok_produk) {
        this.id_penjualan = id_penjualan;
        this.nama_produk = nama_produk;
        this.jumlah_barang = jumlah_barang;
        this.stok_produk = stok_produk;
    }

    public int getId_penjualan() {
        return id_penjualan;
    }

    public void setId_penjualan(int id_penjualan) {
        this.id_penjualan = id_penjualan;
    }

    public String getNama_produk() {
        return nama_produk;
    }

    public void setNama_produk(String nama_produk) {
        this.nama_produk = nama_produk;
    }

    public int getJumlah_barang() {
        return jumlah_barang;
    }

    public void setJumlah_barang(int jumlah_barang) {
        this.jumlah_barang = jumlah_barang;
    }

    public int getStok_produk() {
        return stok_produk;
    }

    public void setStok_produk(int stok_produk) {
        this.stok_produk = stok_produk;
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
