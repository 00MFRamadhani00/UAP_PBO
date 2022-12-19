/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uap_pbo;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleListProperty;
import java.util.ArrayList;

/**
 *
 * @author Acer
 */
public class Barang extends Produk{
    private SimpleStringProperty barcode;
    private SimpleStringProperty expired;
    private ArrayList<Kategori> kategori;

    public Barang(String barcode, String expired, ArrayList<Kategori> kategori, String nama_produk, double harga, int jumlah, double diskon) {
        super(nama_produk, harga, jumlah, diskon);
        this.barcode = new SimpleStringProperty(barcode);
        this.expired = new SimpleStringProperty(expired);
        this.kategori = kategori;
    }

    public String getBarcode() {
        return barcode.get();
    }

    public void setBarcode(String barcode) {
        this.barcode = new SimpleStringProperty(barcode);
    }

    public String getExpired() {
        return expired.get();
    }

    public void setExpired(String expired) {
        this.expired = new SimpleStringProperty(expired);
    }

    public ArrayList<Kategori> getKategori() {
        return kategori;
    }

    public void setKategori(ArrayList<Kategori> kategori) {
        this.kategori = kategori;
    }
    
}
