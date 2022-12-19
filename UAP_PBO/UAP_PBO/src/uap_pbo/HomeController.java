package uap_pbo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class HomeController {
    
    @FXML
    private Button kategoriBtn;

    @FXML
    private Button lbarangBtn;

    @FXML
    private Button lmakananBtn;

    @FXML
    private Button lpenjualanBtn;

    @FXML
    void toBarang(ActionEvent event) throws IOException  {
        Parent root = FXMLLoader.load(getClass().getResource("Barang.fxml"));
        Scene scene = new Scene(root);
        
        Stage stage = (Stage) lbarangBtn.getScene().getWindow();
        stage.setTitle("LIST BARANG");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void toMakanan(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Makanan.fxml"));
        Scene scene = new Scene(root);
        
        Stage stage = (Stage) lmakananBtn.getScene().getWindow();
        stage.setTitle("LIST MAKANAN");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void toPenjualan(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Pilih.fxml"));
        Scene scene = new Scene(root);
        
        Stage stage = (Stage) lpenjualanBtn.getScene().getWindow();
        stage.setTitle("DATA PENJUALAN");
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    void toKategori(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Kategori.fxml"));
        Scene scene = new Scene(root);
        
        Stage stage = (Stage) kategoriBtn.getScene().getWindow();
        stage.setTitle("MASUKKAN KATEGORI");
        stage.setScene(scene);
        stage.show();
    }

}