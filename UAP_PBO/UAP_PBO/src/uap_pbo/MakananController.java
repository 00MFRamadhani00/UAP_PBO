package uap_pbo;

import Database.DatabaseHelper;
import static Database.DatabaseHelper.getConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import uap_pbo.Makanan;

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
    private TextField hpsDgIdMakanan;

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
    void toHpsMakanan(ActionEvent event) throws IOException{
        int ID = Integer.parseInt(hpsDgIdMakanan.getText());
        MakananModel mm = new MakananModel();
        mm.delMakanan(ID);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Makanan.fxml"));
        Parent root = loader.load();
        MakananController makananController = loader.getController();
        Stage stage = (Stage) hpsMakanan.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    void toTbhMakanan(ActionEvent event) throws IOException {        
        Makanan mkn = new Makanan(Integer.parseInt(tbhidField.getText()), 
                Integer.parseInt(tbhdayaField.getText()),
                tbhnamaField.getText(),
                Double.parseDouble(tbhhargaField.getText()),
                Integer.parseInt(tbhjumlahField.getText()),
                Double.parseDouble(tbhdiskonField.getText()));
        
        MakananModel mm = new MakananModel();
        mm.addMakanan(mkn);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Makanan.fxml"));
        Parent root = loader.load();
        MakananController makananController = loader.getController();
        Stage stage = (Stage) tbhMakanan.getScene().getWindow();
        stage.setScene(new Scene(root));
    }
    
     public ObservableList<Makanan> getMakananList(){
        ObservableList<Makanan> makananList = FXCollections.observableArrayList();
        Connection CONN = DatabaseHelper.getConnection();
        String query ="SELECT * FROM makanan;";
        Statement st;
        ResultSet rs; 
        
        try{
            st = CONN.createStatement();
            rs = st.executeQuery(query);
            System.out.println(rs);
            Makanan makanan;
            while(rs.next()){
            makanan = new Makanan(rs.getInt("id_makanan"),rs.getInt("daya_tahan"),rs.getString("nama_makanan"),
                    rs.getDouble("harga_makanan"),rs.getInt("jumlah"),rs.getDouble("diskon")); 
                makananList.add(makanan);
            }
            System.out.println(rs.getInt("id"));
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return makananList;
    }
    public void showMakanan(){
        ObservableList<Makanan> list = getMakananList();
        id.setCellValueFactory(new PropertyValueFactory<Makanan,Integer>("id"));
        dayatahan.setCellValueFactory(new PropertyValueFactory<Makanan,Integer>("daya_tahan"));        
        nama.setCellValueFactory(new PropertyValueFactory<Makanan,String>("nama_produk"));
        harga.setCellValueFactory(new PropertyValueFactory<Makanan,Double>("harga"));
        jumlah.setCellValueFactory(new PropertyValueFactory<Makanan,Integer>("jumlah"));
        diskon.setCellValueFactory(new PropertyValueFactory<Makanan,Double>("diskon"));
        tableMakanan.setItems(list);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb){
        showMakanan();
    }
}
