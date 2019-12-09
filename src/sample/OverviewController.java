package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import sample.data.SQLMediaMapper;
import sample.data.SQLUserMapper;
import sample.logic.AppController;
import sample.logic.entities.Media;
import sample.logic.entities.Movie;
import sample.logic.entities.Series;
import sample.logic.interfaces.MediaMapper;

import java.io.File;
import java.util.ArrayList;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class OverviewController {

    private AppController appController;

    private List<Media> allMedia;

    private List<File> fileList;

    @FXML
    private GridPane gridPane;

    @FXML
    private TextField searchTextField;

    @FXML
    private VBox Selections;

    @FXML
    private AnchorPane Settings;

    public OverviewController() {
        appController = new AppController(new SQLUserMapper(), new SQLMediaMapper());
        fileList = new ArrayList<>();
        allMedia = appController.fetchAll("all");
    }

    public void updateView(List<Media> mediaList) {
        fileList.clear();

        gridPane.getChildren().clear();

        String os = System.getProperty("os.name");

        URL movieURL = getClass().getResource("resources/movieimg");
        URL seriesURL = getClass().getResource("resources/seriesimg");
        String moviePath = "/" + movieURL.toString().substring(6, movieURL.toString().length() - 1);
        String seriesPath = "/" + seriesURL.toString().substring(6, seriesURL.toString().length() - 1);

        File[] seriesImg = new File(seriesPath).listFiles();
        File[] moviesImg = new File(moviePath).listFiles();

        List<File> images = new ArrayList<>(Arrays.asList(seriesImg));
        Collections.addAll(images, moviesImg);

        addToFileList(images, mediaList);

        generateView();

    }


    public void showSelections(ActionEvent event) {
        closeAll();
        Selections.setVisible(true);
    }

    public void showSettings(ActionEvent event) {
        closeAll();
        Settings.setVisible(true);
    }

    public void showUsers(ActionEvent event) {
        closeAll();
    }

    public void closeAll() {
        Selections.setVisible(false);
        Settings.setVisible(false);
    }

    @FXML
    public void search(ActionEvent event) {
        String searchString = searchTextField.getText().trim();

        List<Media> result = appController.fetchByName(searchString, "all");

        updateView(result);

    }

    @FXML
    public void showAll(ActionEvent event) {
        updateView(allMedia);

    }

    @FXML
    public void showAllSeries(ActionEvent event) {
        List<Media> series = allMedia
                .stream()
                .filter(media -> media instanceof Series)
                .collect(Collectors.toList());

        updateView(series);

    }

    @FXML
    public void showAllMovies(ActionEvent event) {
        List<Media> movies = allMedia
                .stream()
                .filter(media -> media instanceof Movie)
                .collect(Collectors.toList());

        updateView(movies);
    }

    @FXML
    public void sortByRating(ActionEvent event) {
        allMedia.sort((m1, m2) -> {
            if (m1.getRating() > m2.getRating()) {
                return 1;
            } else if (m1.getRating() < m2.getRating()) {
                return -1;
            } else {
                return 0;
            }
        });

    }

    @FXML
    public void sortByRelease(ActionEvent event) {
        List<Media> result = appController.fetchRatingOver(7.00, "all");

    }


    @FXML
    public void releaseAfter2000(ActionEvent event) {
        List<Media> result = appController.fetchReleaseAfter(2000, "all");

    }

    @FXML
    public void releaseAfter2015(ActionEvent event) {
        List<Media> result = appController.fetchReleaseAfter(2015, "all");

    }

    @FXML
    public void loadHorror(ActionEvent event) {
        List<Media> result = appController.fetchAllFromGenre("Horror", "all");

        updateView(result);
    }

    @FXML
    public void loadAdventure(ActionEvent event) {
        List<Media> result = appController.fetchAllFromGenre("Adventure", "all");

        updateView(result);
    }

    @FXML
    public void loadThriller(ActionEvent event) {
        List<Media> result = appController.fetchAllFromGenre("Thriller", "all");

        updateView(result);
    }

    @FXML
    public void loadDocumentary(ActionEvent event) {
        List<Media> result = appController.fetchAllFromGenre("Documentary", "all");

        updateView(result);
    }

    @FXML
    public void loadComedy(ActionEvent event) {
        List<Media> result = appController.fetchAllFromGenre("Comedy", "all");


        updateView(result);
    }

    @FXML
    public void loadAction(ActionEvent event) {
        List<Media> result = appController.fetchAllFromGenre("Action", "all");

        updateView(result);
    }

    @FXML
    public void loadCrime(ActionEvent event) {
        List<Media> result = appController.fetchAllFromGenre("Crime", "all");

        updateView(result);
    }

    @FXML
    public void loadDrama(ActionEvent event) {
        List<Media> result = appController.fetchAllFromGenre("Drama", "all");

        updateView(result);
    }

    private void addToFileList(List<File> images, List<Media> mediaList) {
        for (File file : images) {
            for (Media media : mediaList) {
                if (file.getName().equals(media.getName() + ".jpg")) {
                    fileList.add(new File(file.toURI().toString()));
                    mediaList.remove(media);
                    break;
                }
            }
        }
    }

    private void generateView() {
        int rows = (fileList.size() / 4) + 1;
        int columns = 4;
        int index = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (index < fileList.size()) {
                    addImage(index, j, i);
                    index++;
                }
            }
        }
    }

    private void addImage(int index, int row, int column) {
        Image img = new Image(String.valueOf(fileList.get(index)));

        ImageView imgView = new ImageView(img);
        imgView.setFitWidth(175);
        imgView.setFitHeight(250);

        gridPane.setHgap(5);
        gridPane.setVgap(5);
        GridPane.setConstraints(imgView, column, row);
        gridPane.getChildren().add(imgView);
    }
}