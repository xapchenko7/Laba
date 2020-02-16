package settings.passwordLimit;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class PasswordLimit {


        @FXML
        private ResourceBundle resources;

        @FXML
        private URL location;

        @FXML
        private RadioButton passMismatchClicker;

        @FXML
        private ImageView homeIconPassLimite;

        @FXML
        void initialize() {
                homeIconPassLimite.setOnMouseClicked(event -> {
                        openNewPage("/settings/settings.fxml");
                });


        }

        public void openNewPage(String page){
                homeIconPassLimite.getScene().getWindow().hide();

                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource(page));
                try {
                        loader.load();
                } catch (IOException e) {
                        e.printStackTrace();
                }
                Parent root = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.setResizable(false);
                stage.showAndWait();
        }
}
