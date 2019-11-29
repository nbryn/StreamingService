package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import sample.data.MockMediaMapper;
import sample.data.MockUserMapper;
import sample.logic.AppController;


public class OverviewController {

    private AppController appController;

    @FXML
    private Button load;

    @FXML
    private TextArea movies;

    public OverviewController() {
        appController = new AppController(new MockUserMapper(), new MockMediaMapper());
    }

    @FXML
    public void loadMovies(MouseEvent event) {


    }


}

