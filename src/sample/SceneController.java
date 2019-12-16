package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;

public class SceneController

{

    public static void changeScene(String sceneToGo) throws IOException
    {
        FXMLLoader loader = new FXMLLoader(MainFX.class.getResource(sceneToGo));
        MainFX.setRoot(loader.load());
        Scene scene = new Scene(MainFX.getRoot());
        MainFX.getStage().setScene(scene);
        MainFX.getStage().show();
    }

}
