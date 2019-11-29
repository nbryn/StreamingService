package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import sample.data.mock.MockMediaMapper;
import sample.data.mock.MockUserMapper;
import sample.logic.AppController;
import sample.logic.entities.Media;

import java.util.List;


public class OverviewControllerTest {

    private AppController appController;

    @FXML
    private ComboBox genres;
    @FXML
    private Button loadAll;
    @FXML
    private TextArea output;

    public OverviewControllerTest() {
        appController = new AppController(new MockUserMapper(), new MockMediaMapper());
    }

    @FXML
    public void loadAllMedia(MouseEvent event) {
        StringBuilder sb = new StringBuilder("");

        List<Media> medias = appController.fetchAllMedia();

        medias.forEach(media -> sb.append(media.toString() + "\n"));

        output.setText(sb.toString());

    }

    @FXML
    public void loadAllSeries(MouseEvent event) {
        StringBuilder sb = new StringBuilder("");

        List<Media> series = appController.fetchAllSeries();

        series.forEach(media -> sb.append(media.toString() + "\n"));

        output.setText(sb.toString());
    }

    @FXML
    public void loadAllMovies(MouseEvent event) {
        StringBuilder sb = new StringBuilder("");

        List<Media> movies = appController.fetchAllMovies();

        movies.forEach(media -> sb.append(media.toString() + "\n"));

        output.setText(sb.toString());
    }


}

