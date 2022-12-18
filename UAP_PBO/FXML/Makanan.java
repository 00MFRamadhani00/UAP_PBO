import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;


public class Makanan extends Produk {
    private SimpleIntegerProperty id;
    private SimpleIntegerProperty dayatahan;

    public Makanan(int id, int dayatahan, String nama_produk, double harga, int jumlah, double diskon) {
        super(nama_produk, harga, jumlah, diskon);
        this.id = new SimpleIntegerProperty(id);
        this.dayatahan = new SimpleIntegerProperty(dayatahan);
    }

    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id = new SimpleIntegerProperty(id);
    }

    public int getDayatahan() {
        return dayatahan.get();
    }

    public void setDayatahan(int dayatahan) {
        this.dayatahan = new SimpleIntegerProperty(dayatahan);
    }
    
    public void isSpoiled(){
        
    }
}
