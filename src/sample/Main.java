package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.data.h2.setup.H2Init;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Parent loginRoot = FXMLLoader.load(getClass().getResource("Resources/OverviewScene.fxml"));
        Scene login = new Scene(loginRoot);
        primaryStage.setTitle("NKG");
        primaryStage.setScene(login);
        primaryStage.show();
    }
    public void startSQL(){
        /* Initialisering af SQL database */
        H2Init.initialize();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
