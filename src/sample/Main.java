package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.data.setup.H2Init;

import java.io.File;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Parent loginRoot = FXMLLoader.load(getClass().getResource("OverviewScene.fxml"));
        Scene login = new Scene(loginRoot);
        primaryStage.setTitle("NKG");
        primaryStage.setScene(login);
        primaryStage.show();
    }

    public void startSQL(){
        /* Initialisering af SQL database */
        H2Init.initialize(true);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
