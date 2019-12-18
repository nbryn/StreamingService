package streaming;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import streaming.data.setup.H2Init;


public class MainFX extends Application {

    static Parent root;
    static Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/LoginScene.fxml"));
        Scene scene = new Scene(root);
        MainFX.primaryStage = primaryStage;
        primaryStage.setScene(scene);
        primaryStage.show();
        startSQL();
    }

    public static void startSQL() {
        /* Initialisering af SQL database */
        H2Init.initialize();
    }


    static void setRoot(Parent root) {
        MainFX.root = root;
    }

    static Stage getStage() {
        return primaryStage;
    }

    static Parent getRoot() {
        return root;
    }

    public static void main(String[] args) {
        launch(args);

    }
}