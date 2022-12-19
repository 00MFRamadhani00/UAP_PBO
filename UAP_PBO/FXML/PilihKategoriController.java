/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package uap_pbo;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PilihKategoriController implements Initializable{
    
    @FXML
    private ChoiceBox<String> choiceKategori;

    @FXML
    private Button homeBtn;

    @FXML
    private Button hpsBtn;

    @FXML
    private TextField kategoriField;

    @FXML
    private Button plhBtn;

    @FXML
    private Button tbhBtn;

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
    void hpsKategori(ActionEvent event) {
        String delKategori = choiceKategori.getValue();
        choiceKategori.getItems().remove(delKategori);
    }

    @FXML
    void plhKategori(ActionEvent event) {

    }

    @FXML
    void tbhKategori(ActionEvent event) {
        Kategori tbh = new Kategori(kategoriField.getText());
        choiceKategori.getItems().add(tbh.getNama_kategori());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }

}
