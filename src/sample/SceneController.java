package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;

public class SceneController
{
    public static void changeScene(String sceneToGo) throws IOException
    {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource(sceneToGo));
        Main.setRoot(loader.load());
        Scene scene = new Scene(Main.getRoot());
        Main.getStage().setScene(scene);
        Main.getStage().show();
    }
}
