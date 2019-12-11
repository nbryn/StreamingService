package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.data.mock.MockMediaMapper;
import sample.data.mock.MockUserMapper;
import sample.logic.AppController;

import java.io.IOException;

import static sample.SceneController.changeScene;

public class LoginController
{
    private AppController appController;
    public Button loginButton;
    public TextField usernameField;
    public PasswordField passwordField;

    public LoginController()
    {
        appController = new AppController(new MockUserMapper(), new MockMediaMapper());
    }

    public void logInButtonClicked(ActionEvent event) throws IOException
    {
        String username = usernameField.getText();
        String password = passwordField.getText();

        boolean userFound = appController.validateLogin(username, password);

        if (userFound)
        {
            changeScene(event, "OverviewScene.fxml");
            System.out.println("Correct");
        }
        else {
            System.out.println("Wrong");
            System.out.println(usernameField.getText());
            System.out.println(passwordField.getText());
        }
    }

    public void registerButtonClicked(ActionEvent event) throws IOException {
        changeScene(event, "RegisterScene.fxml");
    }
}