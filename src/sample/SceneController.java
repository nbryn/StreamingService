package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneController
{
    public static void changeScene(ActionEvent event, String scene) throws IOException
    {
        Parent overviewRoot = FXMLLoader.load(SceneController.class.getResource(scene));
        Scene overviewScene = new Scene(overviewRoot);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(overviewScene);
        window.show();
    }
}
