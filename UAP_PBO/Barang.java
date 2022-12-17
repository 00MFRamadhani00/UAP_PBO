/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uap_pbo_jdbc;
import java.time.LocalDate;
import java.util.ArrayList;
/**
 *
 * @author Asus
 */
public class Barang extends Produk{
    private String barcode; //Primary
    private LocalDate expired;
    ArrayList<Kategori> kategori = new ArrayList(); //Foreign

    public Barang(String barcode, LocalDate expired, int id_produk, 
                  String nama_produk, double harga, int jumlah, 
                  double diskon) {
        super(id_produk, nama_produk, harga, jumlah, diskon);
        this.barcode = barcode;
        this.expired = expired;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public LocalDate getExpired() {
        return expired;
    }

    public void setExpired(LocalDate expired) {
        this.expired = expired;
    }

    public ArrayList<Kategori> getKategori() {
        return kategori;
    }

    public void setKategori(ArrayList<Kategori> kategori) {
        this.kategori = kategori;
    }
    
    public void isExpired(){
        LocalDate today = LocalDate.now();
        if(today.compareTo(expired) > 0){
            System.out.println("Barang Sudah Kadaluarsa");
        }
    }
    
    public void addKategori(Kategori k){
        kategori.add(k);
    }
    
    public double hargaDiskon() {
        return super.getHarga() - (super.getDiskon() * super.getHarga());
    }
}
