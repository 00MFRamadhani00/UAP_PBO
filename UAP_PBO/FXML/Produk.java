
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;


public class Produk {
    private SimpleStringProperty nama_produk;
    private SimpleDoubleProperty harga;
    private SimpleIntegerProperty jumlah;
    private SimpleDoubleProperty diskon;

    public Produk() {
    }

    public Produk(String nama_produk, double harga, int jumlah, double diskon) {
        this.nama_produk = new SimpleStringProperty(nama_produk);
        this.harga = new SimpleDoubleProperty(harga);
        this.jumlah = new SimpleIntegerProperty(jumlah);
        this.diskon = new SimpleDoubleProperty(diskon);
    }

    public String getNama_produk() {
        return nama_produk.get();
    }

    public void setNama_produk(String nama_produk) {
        this.nama_produk = new SimpleStringProperty(nama_produk);
    }

    public double getHarga() {
        return harga.get();
    }

    public void setHarga(double harga) {
        this.harga = new SimpleDoubleProperty(harga);
    }

    public int getJumlah() {
        return jumlah.get();
    }

    public void setJumlah(int jumlah) {
        this.jumlah = new SimpleIntegerProperty(jumlah);
    }

    public double getDiskon() {
        return diskon.get();
    }

    public void setDiskon(double diskon) {
        this.diskon = new SimpleDoubleProperty(diskon);
    }
    
    public void hargaDiskon(){
        
    }
}
