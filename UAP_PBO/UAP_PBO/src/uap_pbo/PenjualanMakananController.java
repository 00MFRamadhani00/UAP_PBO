package uap_pbo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PenjualanMakananController implements Initializable{

    @FXML
    private Button back;
    
    @FXML
    private Button btnTbh;

    @FXML
    private Button homeBtn;

    @FXML
    private TableColumn<?, ?> id;

    @FXML
    private Label jumlahField;

    @FXML
    private TableColumn<?, ?> nama;

    @FXML
    private TableColumn<?, ?> stok;

    @FXML
    private TableView<?> tablePenjualan;

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
    void backPilih(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Pilih.fxml"));
        Scene scene = new Scene(root);
        
        Stage stage = (Stage) homeBtn.getScene().getWindow();
        stage.setTitle("PROGRAM KASIR");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        }

}