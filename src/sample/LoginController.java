package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import sample.data.mock.MockMediaMapper;
import sample.data.mock.MockUserMapper;
import sample.logic.AppController;

import java.io.IOException;

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
            StateController.setCurrentUser(username);
            SceneController.changeScene("OverviewScene.fxml");
            System.out.println("Correct");
        }
        else {
            System.out.println("Wrong");
            System.out.println(usernameField.getText());
            System.out.println(passwordField.getText());
        }
    }

    public void registerButtonClicked(ActionEvent event) throws IOException {
        SceneController.changeScene("RegisterScene.fxml");
    }
}