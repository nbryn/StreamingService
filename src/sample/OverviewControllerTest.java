package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import sample.data.SQLMediaMapper;
import sample.data.SQLUserMapper;
import sample.logic.AppController;
import sample.logic.entities.Media;
import java.util.List;



public class OverviewControllerTest {

    private AppController appController;

    @FXML
    private ListView<Media> mediaListView;

    @FXML
    private TextField searchField;


    public OverviewControllerTest() {
        appController = new AppController(new SQLUserMapper(), new SQLMediaMapper());
    }

    @FXML
    public void loadAllMedia(ActionEvent event) {
        List<Media> medias = appController.fetchAll("all");

        setListView(medias);
    }

    @FXML
    public void loadAllSeries(ActionEvent event) {
        List<Media> series = appController.fetchAll("series");

        setListView(series);
    }

    @FXML
    public void loadAllMovies(ActionEvent event) {
        List<Media> movies = appController.fetchAll("movies");

        setListView(movies);
    }

    @FXML
    public void search(ActionEvent event) {
        String searchString = searchField.getText().trim();

        List<Media> result = appController.fetchByName(searchString, "all");

        setListView(result);
    }

    @FXML
    public void loadRatingOver8(ActionEvent event) {
        List<Media> result = appController.fetchRatingOver(8.00, "all");

        setListView(result);
    }

    @FXML
    public void loadRatingOver5(ActionEvent event) {
        List<Media> result = appController.fetchRatingOver(5.00, "all");

        setListView(result);
    }

    @FXML
    public void releaseAfter2000(ActionEvent event) {
        List<Media> result = appController.fetchReleaseAfter(2000, "all");

        setListView(result);
    }

    @FXML
    public void releaseAfter2015(ActionEvent event) {
        List<Media> result = appController.fetchReleaseAfter(2015, "all");

        setListView(result);
    }

    @FXML
    public void loadHorror(ActionEvent event) {
        List<Media> result = appController.fetchAllFromGenre("Horror", "all");

        setListView(result);
    }

    @FXML
    public void loadAdventure(ActionEvent event) {
        List<Media> result = appController.fetchAllFromGenre("Adventure", "all");

        setListView(result);
    }

    @FXML
    public void loadThriller(ActionEvent event) {
        List<Media> result = appController.fetchAllFromGenre("Thriller", "all");

        setListView(result);
    }

    @FXML
    public void loadDocumentary(ActionEvent event) {
        List<Media> result = appController.fetchAllFromGenre("Documentary", "all");

        setListView(result);

    }

    @FXML
    public void loadComedy(ActionEvent event) {
        List<Media> result = appController.fetchAllFromGenre("Comedy", "all");

        setListView(result);

    }

    @FXML
    public void loadAction(ActionEvent event) {
        List<Media> result = appController.fetchAllFromGenre("Action", "all");

        setListView(result);

    }

    @FXML
    public void loadCrime(ActionEvent event) {
        List<Media> result = appController.fetchAllFromGenre("Crime", "all");

        setListView(result);;

    }

    private void setListView(List<Media> medias) {
        ObservableList<Media> mediaList = FXCollections.observableArrayList();
        medias.forEach(media -> mediaList.add(media));

        mediaListView.setItems(mediaList);
    }
}

