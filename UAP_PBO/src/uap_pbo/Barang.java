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
public class Barang extends Produk{
    private String barcode;
    private String expired;
    ArrayList<Kategori> kategori = new ArrayList();

    public Barang(String barcode, String expired, String nama_produk, double harga, int jumlah, double diskon) {
        super(nama_produk, harga, jumlah, diskon);
        this.barcode = barcode;
        this.expired = expired;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getExpired() {
        return expired;
    }

    public void setExpired(String expired) {
        this.expired = expired;
    }

    public ArrayList<Kategori> getKategori() {
        return kategori;
    }

    public void setKategori(ArrayList<Kategori> kategori) {
        this.kategori = kategori;
    }
    
    public void isExpired(){
        System.out.println("Sudah Basi");
    }
    
    public void addKategori(){
        System.out.println("Sudah Nambah");
    }
}
