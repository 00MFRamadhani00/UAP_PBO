/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package uap_pbo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class MakananController implements Initializable{

    @FXML
    private TableColumn<Makanan, Integer> dayatahan;

    @FXML
    private TableColumn<Makanan, Double> diskon;

    @FXML
    private TableColumn<Makanan, Double> harga;

    @FXML
    private Button homeBtn;

    @FXML
    private Button hpsMakanan;

    @FXML
    private TableColumn<Makanan, Integer> id;

    @FXML
    private TableColumn<Makanan, Integer> jumlah;

    @FXML
    private TableColumn<Makanan, String> nama;

    @FXML
    private TableView<Makanan> tableMakanan;

    @FXML
    private Button tbhMakanan;

    @FXML
    private TextField tbhdayaField;

    @FXML
    private TextField tbhdiskonField;

    @FXML
    private TextField tbhhargaField;

    @FXML
    private TextField tbhidField;

    @FXML
    private TextField tbhjumlahField;

    @FXML
    private TextField tbhnamaField;

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
    void toHpsMakanan(ActionEvent event) {
        ObservableList<Makanan> allItems,singleItem;
        allItems = tableMakanan.getItems();
        singleItem = tableMakanan.getSelectionModel().getSelectedItems();
        singleItem.forEach(allItems::remove);
    }

    @FXML
    void toTbhMakanan(ActionEvent event) {
        Makanan makanan = new Makanan(
                Integer.parseInt(tbhidField.getText()),
                Integer.parseInt(tbhdayaField.getText()),
                tbhnamaField.getText(),
                Double.parseDouble(tbhhargaField.getText()),
                Integer.parseInt(tbhjumlahField.getText()),
                Double.parseDouble(tbhdiskonField.getText())
        );
        tableMakanan.getItems().add(makanan);
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        id.setCellValueFactory(new PropertyValueFactory<>("Id"));
        nama.setCellValueFactory(new PropertyValueFactory<>("Nama_produk"));
        dayatahan.setCellValueFactory(new PropertyValueFactory<>("Dayatahan"));
        harga.setCellValueFactory(new PropertyValueFactory<>("Harga"));
        jumlah.setCellValueFactory(new PropertyValueFactory<>("Jumlah"));
        diskon.setCellValueFactory(new PropertyValueFactory<>("Diskon"));
        tableMakanan.setItems(observablelist);
    }
    ObservableList<Makanan> observablelist = FXCollections.observableArrayList();
}
