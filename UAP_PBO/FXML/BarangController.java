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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class BarangController implements Initializable{

    @FXML
    private TableColumn<Barang, String> barcode;

    @FXML
    private TableColumn<Barang, Double> diskon;

    @FXML
    private TableColumn<Barang, String> expired;

    @FXML
    private TableColumn<Barang, Double> harga;

    @FXML
    private Button homeBtn;

    @FXML
    private Button hpsBarang;

    @FXML
    private TableColumn<Barang, Integer> jumlah;

    @FXML
    private TableColumn<Barang, String> kategori;

    @FXML
    private ChoiceBox<ArrayList<Kategori>> kategoriField;

    @FXML
    private TableColumn<Barang, String> nama;

    @FXML
    private TableView<Barang> tableBarang;

    @FXML
    private Button tbhBarang;

    @FXML
    private TextField tbhdiskonField;

    @FXML
    private TextField tbhexpiredField;

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
    void toHpsBarang(ActionEvent event) {
        ObservableList<Barang> allItems,singleItem;
        allItems = tableBarang.getItems();
        singleItem = tableBarang.getSelectionModel().getSelectedItems();
        singleItem.forEach(allItems::remove);
    }

    @FXML
    void toTbhBarang(ActionEvent event) {

        Barang barang = new Barang(
                tbhidField.getText(),
                tbhexpiredField.getText(),
                kategoriField.getValue(),
                tbhnamaField.getText(),
                Double.parseDouble(tbhhargaField.getText()),
                Integer.parseInt(tbhjumlahField.getText()),
                Double.parseDouble(tbhdiskonField.getText())
        );
        tableBarang.getItems().add(barang);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        barcode.setCellValueFactory(new PropertyValueFactory<>("Barcode"));
        nama.setCellValueFactory(new PropertyValueFactory<>("Nama_produk"));
        expired.setCellValueFactory(new PropertyValueFactory<>("Expired"));
        kategori.setCellValueFactory(new PropertyValueFactory<>("Kategori"));
        harga.setCellValueFactory(new PropertyValueFactory<>("Harga"));
        jumlah.setCellValueFactory(new PropertyValueFactory<>("Jumlah"));
        diskon.setCellValueFactory(new PropertyValueFactory<>("Diskon"));
        tableBarang.setItems(observablelist);
    }
    ObservableList<Barang> observablelist = FXCollections.observableArrayList();
}
