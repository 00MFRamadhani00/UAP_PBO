package uap_pbo;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class PilihController {

    @FXML
    private Button btnBarang;

    @FXML
    private Button btnMakanan;
    
    @FXML
    private Button homeBtn;

    @FXML
    void backHome(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        Scene scene = new Scene(root);
        
        Stage stage = (Stage) homeBtn.getScene().getWindow();
        stage.setTitle("PROGRAM KASIR");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void toPenjualanBarang(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("PenjualanBarang.fxml"));
        Scene scene = new Scene(root);
        
        Stage stage = (Stage) btnMakanan.getScene().getWindow();
        stage.setTitle("PROGRAM KASIR");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void toPenjualanMakanan(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("PenjualanMakanan.fxml"));
        Scene scene = new Scene(root);
        
        Stage stage = (Stage) btnMakanan.getScene().getWindow();
        stage.setTitle("PROGRAM KASIR");
        stage.setScene(scene);
        stage.show();
    }

}
