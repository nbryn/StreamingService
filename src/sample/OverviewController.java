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
    ScrollPane scrollPane;

    @FXML
    private TextField searchTextField;

    @FXML
    private VBox Selections;

    @FXML
    private AnchorPane Settings;

    public OverviewController() {
        appController = new AppController(new SQLUserMapper(), new SQLMediaMapper());
        fileList = new ArrayList<>();
        allMedia = new ArrayList<>();

    }

    public void updateView(List<Media> mediaList) {
        fileList.clear();

        gridPane.getChildren().clear();

        String os = System.getProperty("os.name");

        URL movieURL = getClass().getResource("resources/movieimg");
        URL seriesURL = getClass().getResource("resources/seriesimg");


        String moviePath = "/" + movieURL.toString().substring(6, movieURL.toString().length() - 1);
        String seriesPath = "/" + seriesURL.toString().substring(6, seriesURL.toString().length() - 1);

        File[] seriesImg = new File("D:\\Streaming\\StreamingService\\src\\sample\\resources\\seriesimg").listFiles();
        File[] moviesImg = new File("D:\\Streaming\\StreamingService\\src\\sample\\resources\\movieimg").listFiles();

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

    public void showAll(ActionEvent event) {
        List<Media> result = appController.fetchAll("all");

        allMedia = result;

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
    public void sortByRatingOverFive(ActionEvent event) {
        List<Media> result = appController.fetchRatingOver(5.00, "all");

        updateView(result);
    }


    @FXML
    public void releaseAfter2000(ActionEvent event) {
        List<Media> result = appController.fetchReleaseAfter(2000, "all");

        updateView(result);
    }

    @FXML
    public void releaseAfter2015(ActionEvent event) {
        List<Media> result = appController.fetchReleaseAfter(2015, "all");

        updateView(result);
    }

    @FXML
    public void loadAction(ActionEvent event) {
        List<Media> result = appController.fetchAllFromGenre("Action", "all");

        updateView(result);
    }

    @FXML
    public void loadAdventure(ActionEvent event) {
        List<Media> result = appController.fetchAllFromGenre("Adventure", "all");

        updateView(result);
    }

    @FXML
    public void loadCrime(ActionEvent event) {
        List<Media> result = appController.fetchAllFromGenre("Crime", "all");

        updateView(result);
    }

    @FXML
    public void loadComedy(ActionEvent event) {
        List<Media> result = appController.fetchAllFromGenre("Comedy", "all");


        updateView(result);
    }

    @FXML
    public void loadDocumentary(ActionEvent event) {
        List<Media> result = appController.fetchAllFromGenre("Documentary", "all");

        updateView(result);
    }

    @FXML
    public void loadDrama(ActionEvent event) {
        List<Media> result = appController.fetchAllFromGenre("Drama", "all");

        updateView(result);
    }



    @FXML
    public void loadHorror(ActionEvent event) {
        List<Media> result = appController.fetchAllFromGenre("Horror", "all");

        updateView(result);
    }


    @FXML
    public void loadHistory(ActionEvent event) {
        List<Media> result = appController.fetchAllFromGenre("History", "all");

        updateView(result);
    }


    @FXML
    public void loadThriller(ActionEvent event) {
        List<Media> result = appController.fetchAllFromGenre("Thriller", "all");

        updateView(result);
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

    private void generateView()
    {
        System.out.println(gridPane.getWidth());
        System.out.println(gridPane.getHeight());

        int rows = 7;
        int columns = (fileList.size() / 7) + 1;
        int index = 0;

        for (int i = 0; i < columns; i++)
        {
            for (int j = 0; j < rows; j++)
            {
                if (index < fileList.size())
                {
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
        gridPane.setPadding(new Insets(5,5,5,5));
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
                SceneController.changeScene("MediaViewTest.fxml");

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

    @FXML
    private ComboBox comboBox;

    public void initialize()
    {
        comboBox.getItems().removeAll(comboBox.getItems());
        comboBox.getItems().addAll("Movies", "Series","Release Date > 2000", "Rating > 5");
    }

    public void sort(ActionEvent event)
    {
        String sortBy = comboBox.getValue().toString();

        if(sortBy.equals("Release Date > 2000"))
        {
            releaseAfter2000(event);
        }

        if(sortBy.equals("Rating > 5"))
        {
            sortByRatingOverFive(event);
        }

        if(sortBy.equals("Series"))
        {
            showAllSeries(event);
        }

        if(sortBy.equals("Movies"))
        {
            showAllMovies(event);
        }
    }
}