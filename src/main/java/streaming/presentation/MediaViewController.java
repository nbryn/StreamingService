package streaming.presentation;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import streaming.data.SQLMediaMapper;
import streaming.data.SQLUserMapper;
import streaming.logic.AppController;
import streaming.logic.entities.Media;
import streaming.logic.entities.Movie;
import streaming.logic.entities.Series;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class MediaViewController {

    private AppController appController;

    private String currentUser;

    private String mediaTitle;

    private String mediaType;

    @FXML
    private Label title;

    @FXML
    private Label mediaLabel;

    @FXML
    private Label rating;

    @FXML
    private Label genre;

    @FXML
    private ImageView mediaImage;

    @FXML
    private Button addToListButton;

    @FXML
    private Button removeFromListButton;

    @FXML
    private Label seasonLabel;

    @FXML
    private Label episodeLabel;

    public MediaViewController() {
        appController = new AppController(new SQLUserMapper(), new SQLMediaMapper());
        currentUser = StateController.currentUser;
        mediaTitle = StateController.currentMedia;
    }

    public void initialize() {
        List<Media> result = appController.fetchByName(mediaTitle, "all");
        Media media = result.get(0);

        setMedia(media);
        setImage();
        modifyButtonState();

        addToListButton.setVisible(true);

        onButtonHover(addToListButton);
        onButtonExit(addToListButton);
        onButtonHover(removeFromListButton);
        onButtonExit(removeFromListButton);

    }


    public void addToList(ActionEvent event) {
        appController.addToUserList(currentUser, mediaType, mediaTitle);
        addToListButton.setVisible(false);
        removeFromListButton.setVisible(true);

    }

    public void removeFromList() {
        appController.removeFromUserList(currentUser, mediaType, mediaTitle);
        addToListButton.setVisible(true);
        removeFromListButton.setVisible(false);

    }

    public void loadOverview() throws IOException {
        SceneController.changeScene("/OverviewScene.fxml");
    }

    private void setMedia(Media media) {
        StringBuilder sb = new StringBuilder("");
        mediaType = media instanceof Movie ? "Movie" : "Series";

        if (mediaType.equalsIgnoreCase("Series")) {
            mediaLabel.setText("Media: Series");
            seasonLabel.setVisible(true);
            episodeLabel.setVisible(true);
            Series series = (Series) media;
            int seasons = 0;
            int episodes = 0;
            for (Integer key : series.getSeasons().keySet()) {
                seasons ++;
                episodes += series.getSeasons().get(key);

            }
            seasonLabel.setText("Seasons: " + seasons);
            episodeLabel.setText("Episodes: " + episodes);

        } else {
            seasonLabel.setVisible(false);
            episodeLabel.setVisible(false);
            seasonLabel.setManaged(false);
            episodeLabel.setManaged(false);
        }

        title.setText(media.getTitle());
        rating.setText("Rating: " + media.getRating());
        List<String> genres = media.getGenre();
        genres.forEach(element -> sb.append(element + ", "));
        sb.deleteCharAt(sb.length() - 2);
        genre.setText("Genre: " + sb.toString());
    }

    private void setImage() {
        List<File> images = StateController.allImages;

        images.forEach(img -> {
            String path = img.getPath();
            if (mediaTitle.equalsIgnoreCase(path.substring(path.lastIndexOf("  ") + 2, path.length() - 4))) {
                Image image = new Image(img.toURI().toString());
                mediaImage.setImage(image);
            }
        });
    }

    private void modifyButtonState() {
        List<Media> userList = appController.fetchUserList(currentUser);

        userList.forEach(element -> {
            if (mediaTitle.equalsIgnoreCase(element.getTitle())) {
                addToListButton.setVisible(false);
                removeFromListButton.setVisible(true);
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
}
