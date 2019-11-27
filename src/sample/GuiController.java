package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class GuiController {

    @FXML
    public Button loginButton;

    public GuiController() {

    }

    @FXML
    public void buttonClicked(MouseEvent event) {
        System.out.println("Clicked " + event.getSource());
    }
}
