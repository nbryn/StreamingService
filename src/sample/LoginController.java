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

import java.io.File;
import java.io.IOException;
import java.net.URL;
import javafx.fxml.LoadException;

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

    public void buttonClicked(ActionEvent event) throws IOException
    {
        String username = usernameField.getText();
        String password = passwordField.getText();

        boolean userFound = appController.validateLogin(username, password);

        if (userFound)
        {
            changeToOverviewScene(event);
            System.out.println("Correct");
        }
        else {
            System.out.println("Wrong");
            System.out.println(usernameField.getText());
            System.out.println(passwordField.getText());
        }
    }

    public void changeToOverviewScene(ActionEvent event) throws IOException
    {
        Parent overviewRoot = FXMLLoader.load(getClass().getResource("OverviewScene.fxml"));
        Scene overviewScene = new Scene(overviewRoot);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(overviewScene);
        window.show();
    }
}