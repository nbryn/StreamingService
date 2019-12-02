package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sample.data.H2DataBase;
import sample.data.H2Init;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = (AnchorPane) FXMLLoader.load(getClass().getResource("OverviewTest.fxml"));
        primaryStage.setTitle("StreamingService");
        primaryStage.setScene(new Scene(root, 300, 275));
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
