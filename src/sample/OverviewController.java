package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import sample.data.SQLMediaMapper;
import sample.data.SQLUserMapper;
import sample.logic.AppController;
import sample.logic.entities.Media;
import sample.logic.entities.Movie;
import sample.logic.entities.Series;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import java.net.URI;
import java.net.URISyntaxException;
import java.io.*;
import java.nio.file.*;

import org.apache.commons.io.FileUtils;


public class OverviewController {

    private AppController appController;

    private List<Media> allMedia;

    private List<File> fileList;

    private List<File> images;

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

    @FXML
    private Button userButton;


    @FXML
    private Button genreButton;


    public OverviewController() {
        appController = new AppController(new SQLUserMapper(), new SQLMediaMapper());
        fileList = new ArrayList<>();
        allMedia = new ArrayList<>();
        images = new ArrayList<>();
    }

    public void initialize() throws IOException, URISyntaxException {
        allMedia = appController.fetchAll("all");

        onButtonHover(userButton);
        onButtonExit(userButton);

        onButtonHover(genreButton);
        onButtonExit(genreButton);

        comboBox.getItems().removeAll(comboBox.getItems());
        comboBox.getItems().addAll("Movies", "Series", "Release > 2000", "Rating > 8");

        images.addAll(loadImages("/resources/movieimg"));
        images.addAll(loadImages("/resources/seriesimg"));

        StateController.setImages(images);

        showAll(new ActionEvent());

    }

    public void updateView(List<Media> mediaList) {
        fileList.clear();
        gridPane.getChildren().clear();

        addToFileList(mediaList);

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
    public void search(ActionEvent event) throws IOException, URISyntaxException {
        String searchString = searchTextField.getText().trim();

        List<Media> result = appController.fetchByName(searchString, "all");

        updateView(result);
    }

    @FXML
    public void showMyList(ActionEvent e) throws IOException, URISyntaxException {
        List<Media> result = appController.fetchUserList(StateController.currentUser);

        updateView(result);
    }

    public void showAll(ActionEvent event) throws IOException, URISyntaxException {
        List<Media> result = appController.fetchAll("all");

        updateView(result);
    }

    @FXML
    public void showAllSeries(ActionEvent event) throws IOException, URISyntaxException {
        List<Media> series = allMedia
                .stream()
                .filter(media -> media instanceof Series)
                .collect(Collectors.toList());

        updateView(series);
    }

    @FXML
    public void showAllMovies(ActionEvent event) throws IOException, URISyntaxException {
        List<Media> movies = allMedia
                .stream()
                .filter(media -> media instanceof Movie)
                .collect(Collectors.toList());

        updateView(movies);
    }

    @FXML
    public void showAction(ActionEvent event) throws IOException, URISyntaxException {
        List<Media> result = appController.fetchAllFromGenre("Action", "all");

        updateView(result);
    }

    @FXML
    public void showAdventure(ActionEvent event) throws IOException, URISyntaxException {
        List<Media> result = appController.fetchAllFromGenre("Adventure", "all");

        updateView(result);
    }

    @FXML
    public void showCrime(ActionEvent event) throws IOException, URISyntaxException {
        List<Media> result = appController.fetchAllFromGenre("Crime", "all");

        updateView(result);
    }

    @FXML
    public void showComedy(ActionEvent event) throws IOException, URISyntaxException {
        List<Media> result = appController.fetchAllFromGenre("Comedy", "all");


        updateView(result);
    }

    @FXML
    public void showDocumentary(ActionEvent event) throws IOException, URISyntaxException {
        List<Media> result = appController.fetchAllFromGenre("Documentary", "all");

        updateView(result);
    }

    @FXML
    public void showDrama(ActionEvent event) throws IOException, URISyntaxException {
        List<Media> result = appController.fetchAllFromGenre("Drama", "all");

        updateView(result);
    }


    @FXML
    public void showHorror(ActionEvent event) throws IOException, URISyntaxException {
        List<Media> result = appController.fetchAllFromGenre("Horror", "all");

        updateView(result);
    }


    @FXML
    public void showHistory(ActionEvent event) throws IOException, URISyntaxException {
        List<Media> result = appController.fetchAllFromGenre("History", "all");

        updateView(result);
    }


    @FXML
    public void showThriller(ActionEvent event) throws IOException, URISyntaxException {
        List<Media> result = appController.fetchAllFromGenre("Thriller", "all");

        updateView(result);
    }

    public void sort(ActionEvent event) throws IOException, URISyntaxException {
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

    public void logOut(ActionEvent event) throws IOException {
        SceneController.changeScene("LoginScene.fxml");
    }

    private void addToFileList(List<Media> mediaList) {
        for (File file : images) {
            for (Media media : mediaList) {
                String url = file.getName().substring(file.getName().lastIndexOf("  ") + 2);
                System.out.println(file.getName());
                if (url.equalsIgnoreCase(media.getTitle() + ".jpg")) {
                    fileList.add(new File(file.toURI()));
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
        Image img = new Image(String.valueOf(fileList.get(index).toURI()));

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

    private void onButtonHover(Button button) {
        button.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                ColorAdjust colorAdjust = new ColorAdjust();
                colorAdjust.setBrightness(-0.5);
                button.setEffect(colorAdjust);
            }
        });
    }

    private void onButtonExit(Button button) {
        button.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                ColorAdjust colorAdjust = new ColorAdjust();
                colorAdjust.setBrightness(0.0);
                button.setEffect(colorAdjust);
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


    private List<File> loadImages(String resource) throws IOException, URISyntaxException {
        List<File> images = new ArrayList<>();

        URI uri = OverviewController.class.getResource(resource).toURI();
        Path myPath;
        FileSystem fileSystem = null;
        if (uri.getScheme().equals("jar")) {
            fileSystem = FileSystems.newFileSystem(uri, Collections.<String, Object>emptyMap());
            myPath = fileSystem.getPath(resource);

        } else {
            myPath = Paths.get(uri);
        }
        Stream<Path> paths = Files.walk(myPath, 1);

        paths.forEach(path -> {
            String url = path.toString().substring(path.toString().lastIndexOf("/") + 1);
            InputStream in;
            File tempFile;
            try {
                if (uri.getScheme().equals("jar")) {
                    in = OverviewController.class.getResourceAsStream(path.toString());
                } else {
                    String normalURL = path.toString().substring(68);
                    in = OverviewController.class.getResourceAsStream(normalURL);
                }
                tempFile = File.createTempFile("...", "  " + url);
                tempFile.deleteOnExit();

                if (!url.equalsIgnoreCase("movieimg") && !url.equalsIgnoreCase("seriesimg")) {
                    FileUtils.copyInputStreamToFile(in, tempFile);

                    images.add(tempFile);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        if (uri.getScheme().equals("jar")) {
            fileSystem.close();
        }
        return images;
    }
}