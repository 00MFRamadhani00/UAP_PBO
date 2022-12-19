package uap_pbo;

import Database.DatabaseHelper;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class KategoriController implements Initializable{
    
    @FXML
    private Button backHome;
    
    @FXML
    private Label cek;

    @FXML
    private TextField delKtg;

    @FXML
    private Button hpsKtg;
    
    @FXML
    private TableView<Kategori> listKtg;

    @FXML
    private TextField inKtg;

    @FXML
    private TableColumn<Kategori, String> lstKtg;

    @FXML
    private Button tbhKtg;
    
    @FXML
    void toBackHome(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        Scene scene = new Scene(root);
        
        Stage stage = (Stage) backHome.getScene().getWindow();
        stage.setTitle("PROGRAM KASIR");
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    void toHpsKtg(ActionEvent event) throws IOException {
        Kategori ktg = new Kategori(delKtg.getText());
        KategoriModel km = new KategoriModel();
        km.delKategori(ktg);
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Kategori.fxml"));
        Parent root = loader.load();
        KategoriController kategoriController = loader.getController();
        Stage stage = (Stage) hpsKtg.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    void toTbhKtg(ActionEvent event) throws IOException {
        Kategori ktg = new Kategori(inKtg.getText());
        KategoriModel km = new KategoriModel();
        km.addKategori(ktg);
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Kategori.fxml"));
        Parent root = loader.load();
        KategoriController kategoriController = loader.getController();
        Stage stage = (Stage) tbhKtg.getScene().getWindow();
        stage.setScene(new Scene(root));
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
        lstKtg.setCellValueFactory(new PropertyValueFactory<Kategori,String>("nama_kategori"));
        listKtg.setItems(list);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb){
        showKategori();
    }
}


