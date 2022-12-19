/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package uap_pbo;

import Database.DatabaseHelper;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import uap_pbo.Kategori;

public class BarangController implements Initializable{

    @FXML
    private TextField delBrc;
    
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
    private ChoiceBox<Kategori> kategoriField;

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
    void toHpsBarang(ActionEvent event) throws IOException {
        String brc = barcode.getText();
        BarangModel bm = new BarangModel();
        bm.delBarang(brc);
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Barang.fxml"));
        Parent root = loader.load();
        BarangController barangController = loader.getController();
        Stage stage = (Stage) hpsBarang.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    void toTbhBarang(ActionEvent event) throws IOException {
        Barang brg = new Barang(tbhidField.getText(),
                tbhexpiredField.getText(),
                kategoriField.getValue(),
                tbhnamaField.getText(),
                Double.parseDouble(tbhhargaField.getText()),
                Integer.parseInt(tbhjumlahField.getText()),
                Double.parseDouble(tbhdiskonField.getText()));
        
        BarangModel bm = new BarangModel();
        bm.addBarang(brg);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Barang.fxml"));
        Parent root = loader.load();
        BarangController barangController = loader.getController();
        Stage stage = (Stage) tbhBarang.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    public ObservableList<Barang> getBarangList(){
        ObservableList<Barang> barangList = FXCollections.observableArrayList();
        Connection CONN = DatabaseHelper.getConnection();
        String query ="SELECT * FROM barang;";
        Statement st;
        ResultSet rs; 
        
        
        try{
            st = CONN.createStatement();
            rs = st.executeQuery(query);
            System.out.println(rs);
            Barang barang;
            while(rs.next()){
            barang = new Barang(rs.getString("barcode"),rs.getString("expired"), (Kategori) rs.getObject("kategori"),
                    rs.getString("nama_barang"),rs.getDouble("harga"),rs.getInt("jumlah"),rs.getDouble("diskon")); 
                barangList.add(barang);
            }
            System.out.println(rs.getString("barcode"));
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return barangList;
    }
    public void showBarang(){
        ObservableList<Barang> list = getBarangList();
        barcode.setCellValueFactory(new PropertyValueFactory<Barang,String>("barcode"));
        expired.setCellValueFactory(new PropertyValueFactory<Barang,String>("expired"));
        kategori.setCellValueFactory(new PropertyValueFactory<Barang,String>("kategori"));
        nama.setCellValueFactory(new PropertyValueFactory<Barang,String>("nama_barang"));
        harga.setCellValueFactory(new PropertyValueFactory<Barang,Double>("harga"));
        jumlah.setCellValueFactory(new PropertyValueFactory<Barang,Integer>("jumlah"));
        diskon.setCellValueFactory(new PropertyValueFactory<Barang,Double>("diskon"));
        tableBarang.setItems(list);
    }
    public ObservableList<Kategori> getKategoriList(){
        ObservableList<Kategori> kategoriList = FXCollections.observableArrayList();
        Connection CONN = DatabaseHelper.getConnection();
        String query ="SELECT * FROM kategori;";
        Statement st;
        ResultSet rs; 
        
        try{
            st = CONN.createStatement();
            rs = st.executeQuery(query);
            System.out.println(rs);
            Kategori kategori;
            while(rs.next()){
                kategori = new Kategori(rs.getString("nama_kategori")); 
                kategoriList.add(kategori);
            }
            System.out.println(rs.getInt("nama_kategori"));
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return kategoriList;
    }
    public void showKategori(){
        ObservableList<Kategori> list = getKategoriList();
        for (Kategori list1 : list) {
            kategoriField.setItems(list);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        showBarang();
        showKategori();
    }
}