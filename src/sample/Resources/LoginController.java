package sample.Resources;

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
            //Parent overviewRoot = FXMLLoader.load(getClass().getResource("Resources/Login.fxml"));
            URL url = new File("D:\\Streaming\\StreamingService\\src\\sample\\OverviewTest.fxml").toURI().toURL();
            Parent overviewRoot = FXMLLoader.load(url);
            Scene overviewScene = new Scene(overviewRoot);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(overviewScene);
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
