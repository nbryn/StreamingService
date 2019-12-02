package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import sample.data.mock.MockMediaMapper;
import sample.data.mock.MockUserMapper;
import sample.logic.AppController;
import sample.logic.entities.Media;

import java.util.List;


public class OverviewControllerTest {

    private AppController appController;


    @FXML
    private MenuItem horror;
    @FXML
    private MenuItem thriller;
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

        setOutputText(movies);
    }

    @FXML
    public void loadHorror(ActionEvent event) {
        MenuItem h = (MenuItem) event.getSource();

        String genre = h.getText();

        List<Media> media = appController.fetchAllFromGenre(genre, "all");

        setOutputText(media);

    }

    @FXML
    public void loadAdventure(ActionEvent event) {
        MenuItem h = (MenuItem) event.getSource();

        String genre = h.getText();

        List<Media> media = appController.fetchAllFromGenre(genre, "all");

        setOutputText(media);
    }

    @FXML
    public void loadThriller(ActionEvent event) {
        MenuItem h = (MenuItem) event.getSource();

        String genre = h.getText();

        List<Media> media = appController.fetchAllFromGenre(genre, "all");

        setOutputText(media);
    }

    private void setOutputText(List<Media> list) {
        StringBuilder sb = new StringBuilder("");

        list.forEach(media -> sb.append(media.toString()));

        output.setText(sb.toString());
    }

}

