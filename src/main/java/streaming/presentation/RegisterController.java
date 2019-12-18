package streaming.presentation;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import streaming.data.SQLMediaMapper;
import streaming.data.SQLUserMapper;
import streaming.logic.AppController;
import streaming.logic.entities.User;

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
    private Button registerButton;

    @FXML
    private Button errorButton;

    public RegisterController() {
        appController = new AppController(new SQLUserMapper(), new SQLMediaMapper());
    }

    public void initialize() {
        onButtonHover(registerButton);
        onButtonExit(registerButton);

    }

    public void register(ActionEvent event) throws IOException {
        String fullName = nameField.getText().trim();
        String email = emailField.getText().trim();
        String birthday = birthdayField.getText().trim();
        String password = passwordField.getText().trim();
        String repeatPassword = passwordRepeatField.getText().trim();
        
        if (fullName.isEmpty() || email.isEmpty() || birthday.isEmpty() || password.isEmpty() || password.isEmpty()) {
            setErrorMessage("Please fill all fields");
        }

        if(!password.equals(repeatPassword))
        {
            setErrorMessage("Passwords does not match");

        } else {
            User user = new User(fullName, birthday, email, password);

            boolean success = appController.registerUser(user);

            SceneController.changeScene("/LoginScene.fxml");

            if(!success)
            {
                setErrorMessage("Email already exist");
            }
        }
    }

    public void back(ActionEvent event) throws IOException {
        SceneController.changeScene("/LoginScene.fxml");
    }

    private void setErrorMessage(String errorMessage)
    {
        errorButton.setFont(Font.font(25));
        errorButton.setText(errorMessage);
        errorButton.setVisible(true);
    }

    private void onButtonHover(Button button) {
        button.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                ColorAdjust colorAdjust = new ColorAdjust();
                colorAdjust.setBrightness(-0.5);
                button.setEffect(colorAdjust);
            }
        });
    }

    private void onButtonExit(Button button) {
        button.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                ColorAdjust colorAdjust = new ColorAdjust();
                colorAdjust.setBrightness(0.0);
                button.setEffect(colorAdjust);
            }
        });
    }
}
