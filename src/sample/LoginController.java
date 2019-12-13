package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javafx.scene.text.Font;
import sample.data.SQLMediaMapper;
import sample.data.SQLUserMapper;
import sample.logic.AppController;

import java.io.IOException;

public class LoginController
{
    private AppController appController;
    public Button loginButton;
    public TextField usernameField;
    public PasswordField passwordField;

    @FXML
    private Button errorButton;

    public LoginController()
    {
        appController = new AppController(new SQLUserMapper(), new SQLMediaMapper());
    }

    public void login(ActionEvent event) throws IOException
    {
        String username = usernameField.getText();
        String password = passwordField.getText();

        boolean userFound = appController.validateLogin(username, password);

        if (userFound)
        {
            StateController.setCurrentUser(username);
            SceneController.changeScene("OverviewScene.fxml");
        }
        else {
            wrongUser();
        }
    }

    public void register(ActionEvent event) throws IOException {
        SceneController.changeScene("RegisterScene.fxml");
    }

    public void wrongUser()
    {
        errorButton.setFont(Font.font(25));
        errorButton.setVisible(true);
    }
}