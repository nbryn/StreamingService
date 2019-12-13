package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import sample.data.SQLMediaMapper;
import sample.data.SQLUserMapper;
import sample.logic.AppController;
import sample.logic.entities.User;

import java.io.IOException;


public class RegisterController
{
    private AppController appController;

    @FXML
    private TextField nameField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField birthdayField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private PasswordField passwordRepeatField;

    @FXML
    private Button errorButton;

    public RegisterController() {
        appController = new AppController(new SQLUserMapper(), new SQLMediaMapper());
    }

    public void register(ActionEvent event) throws IOException {
        String fullName = nameField.getText().trim();
        String email = emailField.getText().trim();
        String birthday = birthdayField.getText().trim();
        String password = passwordField.getText().trim();
        String repeatPassword = passwordRepeatField.getText().trim();

        if(!password.equals(repeatPassword))
        {
            wrongUser("Passwords does not match");

        } else {
            User user = new User(fullName, birthday, email, password);

            boolean success = appController.registerUser(user);

            SceneController.changeScene("LoginScene.fxml");

            if(!success)
            {
                wrongUser("Email already exist");
            }
        }
    }

    public void back(ActionEvent event) throws IOException {
        SceneController.changeScene("LoginScene.fxml");
    }

    public void wrongUser(String errorMessage)
    {
        errorButton.setFont(Font.font(25));
        errorButton.setText(errorMessage);
        errorButton.setVisible(true);
    }
}
