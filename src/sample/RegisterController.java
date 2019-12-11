package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import sample.data.mock.MockMediaMapper;
import sample.data.mock.MockUserMapper;
import sample.logic.AppController;
import sample.logic.entities.User;

import java.io.IOException;

import static sample.SceneController.changeScene;

public class RegisterController
{
    private AppController appController;

    @FXML
    private TextArea output;

    @FXML
    private TextField nameField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField birthdayField;

    @FXML
    private TextField passwordField;

    @FXML
    private TextField repeatPasswordField;

    public RegisterController() {
        appController = new AppController(new MockUserMapper(), new MockMediaMapper());
    }

    public void register(ActionEvent event) throws IOException {
        String fullName = nameField.getText().trim();
        String email = emailField.getText().trim();
        String birthday = birthdayField.getText().trim();
        String password = passwordField.getText().trim();
        String repeatPassword = repeatPasswordField.getText().trim();

        if(!password.equals(repeatPassword)) {
            setOutput("Passwords Does Not Match");

        } else {
            User user = new User(fullName, birthday, email, password);

            boolean success = appController.registerUser(user);

            SceneController.changeScene("Login.fxml");

            if(!success) {
                setOutput("Email already exists in the system");
            }
        }
    }

    public void back(ActionEvent event) throws IOException {
        SceneController.changeScene("Login.fxml");
    }

    private void setOutput(String text) {
        output.setText(text);
    }
}
