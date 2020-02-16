package signUp;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import db.DatabaseHandler;
import db.User;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class ControllerSignUp {

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
    void initialize() {

        signUpButton.setOnAction(event -> {
            signUpNewUser();
        });

    }

    private void signUpNewUser() {
        DatabaseHandler dbHandler = new DatabaseHandler();
        String username = usernameField.getText().trim();
        String password = passwordField.getText().trim();
        try {
            User user = new User(username, password);
            dbHandler.signUpUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
