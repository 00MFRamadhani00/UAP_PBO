import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class PenjualanController {

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

}
