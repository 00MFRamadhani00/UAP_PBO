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
public class Makanan extends Produk{
    private int id_makanan; //Primary
    private LocalDate daya_tahan;
    private ArrayList<Kategori> kategori; //Foreign
    
    public Makanan(int id_makanan, LocalDate daya_tahan, int id_produk, String nama_produk, double harga, int jumlah, double diskon) {
        super(id_produk, nama_produk, harga, jumlah, diskon);
        this.id_makanan = id_makanan;
        this.daya_tahan = daya_tahan;
    }

    public int getId_makanan() {
        return id_makanan;
    }

    public void setId_makanan(int id_makanan) {
        this.id_makanan = id_makanan;
    }

    public ArrayList<Kategori> getKategori() {
        return kategori;
    }

    public void setKategori(ArrayList<Kategori> kategori) {
        this.kategori = kategori;
    }

    public LocalDate getDaya_tahan() {
        return daya_tahan;
    }

    public void setDaya_tahan(LocalDate daya_tahan) {
        this.daya_tahan = daya_tahan;
    }
    
    public void isSpoiled(){
        LocalDate today = LocalDate.now();
        if(today.compareTo(daya_tahan) > 0){
            System.out.println("Makanan Sudah Rusak");
        }
    }    
    
    public double hargaDiskon() {
        return super.getHarga() - (super.getDiskon() * super.getHarga());
    }
}
