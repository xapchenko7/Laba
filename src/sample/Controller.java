package sample;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;


import animations.Shake;
import db.DatabaseHandler;
import db.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button signUpButton;

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button signInButton;

    @FXML
    void initialize() {
        signInButton.setOnAction(event -> {
//            String username = usernameField.getText().trim();
//            String password = passwordField.getText().trim();
//
//            if (!username.equals("") && !password.equals("")) {
//                try {
//                    loginUser(username, password);
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }else System.out.println("wrong input");
            openNewPage("/settings/settings.fxml");
        });

        signUpButton.setOnAction(event -> {
            openNewPage("/signUp/signUp.fxml");
        });



    }

    private void loginUser(String username, String password) throws SQLException {
        DatabaseHandler dbHandler = new DatabaseHandler();
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        ResultSet resultSet = dbHandler.getUser(user);

        int counter = 0;

        while (resultSet.next()) {
            counter++;
        }

        if(counter>=1){
           openNewPage("/settings/settings.fxml");
        }else{
            Shake shakeUsername = new Shake(usernameField);
            Shake shakePassword = new Shake(passwordField);
            shakeUsername.playAnimation();
            shakePassword.playAnimation();
        }

    }

    public void openNewPage(String page){
        signInButton.getScene().getWindow().hide();

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

