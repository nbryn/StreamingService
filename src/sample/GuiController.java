package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import sample.data.MockMediaDAO;
import sample.data.MockUserDAO;
import sample.logic.AppController;

public class GuiController {

    private AppController appController;

    @FXML
    private Button loginButton;
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextArea errorMsg;

    public GuiController() {
        appController = new AppController(new MockUserDAO(), new MockMediaDAO());
    }

    @FXML
    public void buttonClicked(MouseEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        boolean userFound = appController.validateUser(username, password);

        if (userFound) {
            usernameField.setText("Succes");
        } else {
            errorMsg.setText("Wrong username/password");

            usernameField.setText("");
            passwordField.setText("");
        }

        }


    }

