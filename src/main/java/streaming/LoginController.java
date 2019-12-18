package streaming;

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

import java.io.IOException;

public class LoginController {

    private AppController appController;

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button errorButton;

    @FXML
    private Button loginButton;

    public LoginController() {
        appController = new AppController(new SQLUserMapper(), new SQLMediaMapper());
    }

    public void initialize() {
        onButtonHover(loginButton);
        onButtonExit(loginButton);

    }

    public void login(ActionEvent event) throws IOException {
        String username = usernameField.getText();
        String password = passwordField.getText();

        boolean userFound = appController.validateLogin(username, password);

        if (userFound) {
            StateController.setCurrentUser(username);
            SceneController.changeScene("/OverviewScene.fxml");
        } else {
            wrongUser();
        }
    }

    public void register(ActionEvent event) throws IOException {
        SceneController.changeScene("/RegisterScene.fxml");
    }

    public void wrongUser() {
        errorButton.setFont(Font.font(25));
        errorButton.setVisible(true);
    }

    private void onButtonHover(final Button button) {
        button.setOnMouseEntered(new EventHandler<MouseEvent>() {

            public void handle(MouseEvent mouseEvent) {
                ColorAdjust colorAdjust = new ColorAdjust();
                colorAdjust.setBrightness(-0.5);
                button.setEffect(colorAdjust);
            }
        });
    }

    private void onButtonExit(final Button button) {
        button.setOnMouseExited(new EventHandler<MouseEvent>() {

            public void handle(MouseEvent mouseEvent) {
                ColorAdjust colorAdjust = new ColorAdjust();
                colorAdjust.setBrightness(0.0);
                button.setEffect(colorAdjust);
            }
        });
    }
}