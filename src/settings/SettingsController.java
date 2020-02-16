package settings;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class SettingsController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private MenuBar menuBar;

    @FXML
    private MenuItem changePasswordButton;

    @FXML
    private MenuItem passwordLimitButton;

    @FXML
    private MenuItem showUserButton;

    @FXML
    private MenuItem addUserButton;

    @FXML
    private MenuItem blockUserButton;

    @FXML
    private MenuItem aboutButton;

    @FXML
    private MenuItem exitButton;

    @FXML
    private Menu settingsMenu;

    @FXML
    private Button homeButton;

    @FXML
    void initialize() {

        exitButton.setOnAction((ActionEvent event) -> {
            System.exit(0);
        });

        aboutButton.setOnAction((ActionEvent event) -> {
            openNewPage("/settings/aboutProgram/about.fxml");
        });

        changePasswordButton.setOnAction((ActionEvent event) -> {
            openNewPage("/settings/changePassword/changePassword.fxml");
        });

        passwordLimitButton.setOnAction((ActionEvent event) -> {
            openNewPage("/settings/passwordLimit/passwordLimit.fxml");
        });

        showUserButton.setOnAction(event-> openNewPage("/settings/showUsers/showUser.fxml"));

    }

    public void openNewPage(String page) {
        menuBar.getScene().getWindow().hide();
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
