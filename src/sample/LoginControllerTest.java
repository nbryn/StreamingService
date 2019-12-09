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
import sample.data.SQLMediaMapper;
import sample.data.SQLUserMapper;
import sample.data.mock.MockMediaMapper;
import sample.data.mock.MockUserMapper;
import sample.logic.AppController;

import java.io.IOException;

public class LoginControllerTest
{
    private AppController appController;

    public Button loginButton;
    public TextField usernameField;
    public PasswordField passwordField;

    public LoginControllerTest()
    {
        appController = new AppController(new SQLUserMapper(), new SQLMediaMapper());
    }

    public void buttonClicked(ActionEvent event) throws IOException
    {
        String username = usernameField.getText();
        String password = passwordField.getText();

        boolean userFound = appController.validateLogin(username, password);

        if (userFound)
        {
            Parent streamingRoot = FXMLLoader.load(getClass().getResource("Streaming.fxml"));
            Scene streamingScene = new Scene(streamingRoot);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(streamingScene);
            window.show();
            System.out.println("JA");
        }
        else {
            System.out.println("NEJ");
            System.out.println(usernameField.getText());
            System.out.println(passwordField.getText());
        }
    }
}