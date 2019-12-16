package sample;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.data.setup.H2Init;

public class MainFX extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        root = FXMLLoader.load(getClass().getResource("LoginScene.fxml"));
        MainFX.primaryStage = primaryStage;
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
        startSQL();
    }

    public static void startSQL() {
        /* Initialisering af SQL database */
        H2Init.initialize();
    }

    static Parent root;
    static Stage primaryStage;

    static void setRoot(Parent root)
    {
        MainFX.root = root;
    }

    static Stage getStage()
    {
        return primaryStage;
    }

    static Parent getRoot()
    {
        return root;
    }

    public static void main(String[] args) {
        launch(args);

    }
}