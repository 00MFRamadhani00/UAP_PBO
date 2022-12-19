/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uap_pbo;

/**
 *
 * @author Asus
 */


public class Makanan extends Produk {
    private int id;
    private int dayatahan;

    public Makanan(int id, int dayatahan, String nama_produk, double harga, int jumlah, double diskon) {
        super(nama_produk, harga, jumlah, diskon);
        this.id = id;
        this.dayatahan = dayatahan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDayatahan() {
        return dayatahan;
    }

    public void setDayatahan(int dayatahan) {
        this.dayatahan = dayatahan;
    }
    
    public void isSpoiled(){
        
    }
}