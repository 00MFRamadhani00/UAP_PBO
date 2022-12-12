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
public class Barang extends Produk{
    private String barcode;
    private String expired;
    ArrayList<Kategori> kategori = new ArrayList();
    
    public void isExpired(){
        System.out.println("Sudah basi");
    }
    
    public void addKategori(){
        System.out.println("Sudah nambah");
    }
}
