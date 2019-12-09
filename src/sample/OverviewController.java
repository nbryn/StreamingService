package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OverviewController {

    private AppController appController;

    @FXML
    private ListView<Media> mediaListView;

    @FXML
    private TextField searchField;

    public OverviewController()
    {
        appController = new AppController(new SQLUserMapper(), new SQLMediaMapper());
    }

    @FXML
    public void search(ActionEvent event) {
        String searchString = searchField.getText().trim();

        List<Media> result = appController.fetchByName(searchString, "all");

        setListView(result);
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

        Initialize(result);
    }

    @FXML
    public void loadAdventure(ActionEvent event) {
        List<Media> result = appController.fetchAllFromGenre("Adventure", "all");

        setListView(result);

        Initialize(result);
    }

    @FXML
    public void loadThriller(ActionEvent event) {
        List<Media> result = appController.fetchAllFromGenre("Thriller", "all");

        setListView(result);

        Initialize(result);
    }

    @FXML
    public void loadDocumentary(ActionEvent event) {
        List<Media> result = appController.fetchAllFromGenre("Documentary", "all");

        setListView(result);

        Initialize(result);
    }

    @FXML
    public void loadComedy(ActionEvent event) {
        List<Media> result = appController.fetchAllFromGenre("Comedy", "all");

        setListView(result);

        Initialize(result);
    }

    @FXML
    public void loadAction(ActionEvent event) {
        List<Media> result = appController.fetchAllFromGenre("Action", "all");

        setListView(result);

        Initialize(result);
    }

    @FXML
    public void loadCrime(ActionEvent event) {
        List<Media> result = appController.fetchAllFromGenre("Crime", "all");

        setListView(result);

        Initialize(result);
    }

    @FXML
    public void loadDrama(ActionEvent event) {
        List<Media> result = appController.fetchAllFromGenre("Drama", "all");

        setListView(result);

        Initialize(result);
    }

    private void setListView(List<Media> medias) {
        ObservableList<Media> mediaList = FXCollections.observableArrayList();
        medias.forEach(media -> mediaList.add(media));

        mediaListView.setItems(mediaList);
    }

    ArrayList<File> fileList = new ArrayList<>();

    @FXML
    private GridPane gridPane;

    public void Initialize(List <Media> mediaList)
    {
        fileList.clear();
        URL movieURL = getClass().getResource("resources/movieimg");
        URL seriesURL = getClass().getResource("resources/seriesimg");
        String moviePath = "/" + movieURL.toString().substring(6, movieURL.toString().length()-1);
        String seriesPath = "/" + seriesURL.toString().substring(6, seriesURL.toString().length()-1);


        File[] seriesImg = new File(seriesPath).listFiles();
        File[] moviesImg = new File(moviePath).listFiles();

        List<File> images = new ArrayList<>(Arrays.asList(seriesImg));
        Collections.addAll(images, moviesImg);

        System.out.println(images.size());

        for (File file : images) {
            for (Media media : mediaList) {
                if (file.getName().equals(media.getName() + ".jpg")) {
                    fileList.add(new File(file.toURI().toString()));
                }
            }
        }

        int rows = (fileList.size() / 4) + 1;
        int columns = 1;
        int index = 0;

        for (int i = 0 ; i < rows; i++)
        {
            for (int j = 0; j < columns; j++)
            {
                if (index < fileList.size())
                {
                    addImage(index, j, i);
                    index++;
                }
            }
        }
    }

    public void addImage(int index, int row, int column)
    {
        Image img = new Image(String.valueOf(fileList.get(index)));

        ImageView imgView = new ImageView(img);
        imgView.setFitWidth(175);
        imgView.setFitHeight(250);

        /*gridPane.setHgap(5);
        gridPane.setVgap(5);*/
        GridPane.setConstraints(imgView, column, row);
        gridPane.getChildren().add(imgView);
    }

    @FXML
    private HBox Menu;
    @FXML
    private Button menuButton;
    @FXML
    private VBox Selections;
    @FXML
    private AnchorPane Settings;

    public void openMenu(ActionEvent event)
    {
        Menu.setVisible(true);
        menuButton.setVisible(false);
        Selections.setVisible(true);
    }

    public void closeMenu(ActionEvent event)
    {
        closeAll();
        menuButton.setVisible(true);
        Menu.setVisible(false);
    }

    public void showSelections(ActionEvent event)
    {
        closeAll();
        Selections.setVisible(true);
    }

    public void showSettings(ActionEvent event)
    {
        closeAll();
        Settings.setVisible(true);
    }

    public void showUsers(ActionEvent event)
    {
        closeAll();
    }

    public void closeAll()
    {
        Selections.setVisible(false);
        Settings.setVisible(false);
    }
}