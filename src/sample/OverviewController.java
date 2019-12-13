package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import sample.data.SQLMediaMapper;
import sample.data.SQLUserMapper;
import sample.logic.AppController;
import sample.logic.entities.Media;
import sample.logic.entities.Movie;
import sample.logic.entities.Series;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.net.URL;
import java.util.stream.Collectors;


public class OverviewController {

    private AppController appController;

    private List<Media> allMedia;

    private List<File> fileList;

    @FXML
    private GridPane gridPane;

    @FXML
    private ComboBox comboBox;

    @FXML
    ScrollPane scrollPane;

    @FXML
    private TextField searchTextField;

    @FXML
    private VBox Selections;

    @FXML
    private VBox Users;

    public OverviewController() {
        appController = new AppController(new SQLUserMapper(), new SQLMediaMapper());
        fileList = new ArrayList<>();
        allMedia = new ArrayList<>();
    }

    public void initialize() {
        allMedia = appController.fetchAll("all");
        showAll(new ActionEvent());

        comboBox.getItems().removeAll(comboBox.getItems());
        comboBox.getItems().addAll("Movies", "Series", "Release > 2000", "Rating > 8");
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

        StateController.setImages(images);

        addToFileList(images, mediaList);
        generateView();
    }

    public void showSelections(ActionEvent event) {
        closeAll();
        Selections.setVisible(true);
    }

    public void showUsers(ActionEvent event) {
        closeAll();
        Users.setVisible(true);
    }

    public void closeAll() {
        Selections.setVisible(false);
        Users.setVisible(false);
    }

    @FXML
    public void search(ActionEvent event) {
        String searchString = searchTextField.getText().trim();

        List<Media> result = appController.fetchByName(searchString, "all");

        updateView(result);
    }

    @FXML
    public void showMyList(ActionEvent e) {
        List<Media> result = new ArrayList<>();
        List<String> titles = StateController.getUserList();

        for (String title : titles) {
            result.add(appController.fetchByName(title, "all").get(0));
        }
        updateView(result);

//        List<Media> result = appController.fetchUserList(StateController.currentUser);
//
//        updateView(result);
    }

    public void showAll(ActionEvent event) {
        List<Media> result = appController.fetchAll("all");

        updateView(result);
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
    public void showAction(ActionEvent event) {
        List<Media> result = appController.fetchAllFromGenre("Action", "all");

        updateView(result);
    }

    @FXML
    public void showAdventure(ActionEvent event) {
        List<Media> result = appController.fetchAllFromGenre("Adventure", "all");

        updateView(result);
    }

    @FXML
    public void showCrime(ActionEvent event) {
        List<Media> result = appController.fetchAllFromGenre("Crime", "all");

        updateView(result);
    }

    @FXML
    public void showComedy(ActionEvent event) {
        List<Media> result = appController.fetchAllFromGenre("Comedy", "all");


        updateView(result);
    }

    @FXML
    public void showDocumentary(ActionEvent event) {
        List<Media> result = appController.fetchAllFromGenre("Documentary", "all");

        updateView(result);
    }

    @FXML
    public void showDrama(ActionEvent event) {
        List<Media> result = appController.fetchAllFromGenre("Drama", "all");

        updateView(result);
    }


    @FXML
    public void showHorror(ActionEvent event) {
        List<Media> result = appController.fetchAllFromGenre("Horror", "all");

        updateView(result);
    }


    @FXML
    public void showHistory(ActionEvent event) {
        List<Media> result = appController.fetchAllFromGenre("History", "all");

        updateView(result);
    }


    @FXML
    public void showThriller(ActionEvent event) {
        List<Media> result = appController.fetchAllFromGenre("Thriller", "all");

        updateView(result);
    }

    public void sort(ActionEvent event) {
        String sortBy = comboBox.getValue().toString();
        List<Media> result = null;

        switch (sortBy) {

            case "Series":
                showAllSeries(event);
                break;

            case "Movies":
                showAllMovies(event);
                break;


            case "Release > 2000":
                result = appController.fetchReleaseAfter(2000, "all");
                updateView(result);
                break;

            case "Rating > 8":
                result = appController.fetchRatingOver(8, "all");
                updateView(result);
                break;
        }
    }

    private void addToFileList(List<File> images, List<Media> mediaList) {
        for (File file : images) {
            for (Media media : mediaList) {
                if (file.getName().equals(media.getTitle() + ".jpg")) {
                    fileList.add(new File(file.toURI().toString()));
                    mediaList.remove(media);
                    break;
                }
            }
        }
    }

    private void generateView() {
        int rows = 7;
        int columns = (fileList.size() / 7) + 1;
        int index = 0;

        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                if (index < fileList.size()) {
                    addImage(index, j, i);
                    index++;
                }
            }
        }
    }

    private void addImage(int index, int column, int row) {
        Image img = new Image(String.valueOf(fileList.get(index)));
        ColorAdjust colorAdjust = new ColorAdjust();

        ImageView imgView = new ImageView(img);

        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.setPadding(new Insets(5, 5, 5, 5));

        imgView.setFitWidth(175);
        imgView.setFitHeight(250);

        GridPane.setConstraints(imgView, column, row);
        gridPane.getChildren().add(imgView);

        onImageHover(imgView, colorAdjust);

        onImageExit(imgView, colorAdjust);

        onImageClick(imgView);
    }

    private void onImageClick(ImageView imgView) {
        imgView.setOnMouseClicked(picture -> {
            Image image = imgView.getImage();
            String url = image.getUrl();
            String shortUrl = image.getUrl().substring(url.lastIndexOf("/") + 1, url.length() - 4);

            String mediaTitle = shortUrl.replaceAll("%", " ").replaceAll("20", "");

            try {
                StateController.setCurrentMedia(mediaTitle);
                SceneController.changeScene("MediaViewScene.fxml");

            } catch (IOException e) {
                e.printStackTrace();
            }

        });
    }

    private void onImageHover(ImageView imgView, ColorAdjust colorAdjust) {
        imgView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                colorAdjust.setBrightness(-0.5);
                imgView.setEffect(colorAdjust);
            }
        });
    }

    private void onImageExit(ImageView imgView, ColorAdjust colorAdjust) {
        imgView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                colorAdjust.setBrightness(0.0);
                imgView.setEffect(colorAdjust);
            }
        });
    }

    public void logOut(ActionEvent event) throws IOException {
        SceneController.changeScene("LoginScene.fxml");
    }
}