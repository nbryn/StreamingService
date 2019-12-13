package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import sample.data.SQLMediaMapper;
import sample.data.SQLUserMapper;
import sample.logic.AppController;
import sample.logic.entities.Media;
import sample.logic.entities.Movie;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MediaViewController {
    private AppController appController;

    private String currentUser;

    private String mediaTitle;

    private String mediaType;

    @FXML
    private Label title;

    @FXML
    private Label rating;

    @FXML
    private Label genre;

    @FXML
    private Button addToListButton;

    @FXML
    private Button removeFromListButton;

    public MediaViewController() {
        appController = new AppController(new SQLUserMapper(), new SQLMediaMapper());
        currentUser = StateController.currentUser;
        mediaTitle = StateController.currentMedia;
    }

    public void initialize() {
        StringBuilder sb = new StringBuilder("");
        List<Media> result = appController.fetchByName(mediaTitle, "all");

        Media media = result.get(0);
        mediaType = media instanceof Movie ? "Movie" : "Series";

        title.setText(media.getTitle());
        rating.setText("Rating: " + media.getRating());
        List<String> genres = media.getGenre();
        genres.forEach(element -> sb.append(element + ", "));
        sb.deleteCharAt(sb.length() - 2);
        genre.setText("Genre: " + sb.toString());

        addToListButton.setVisible(true);

        for (String title : StateController.getUserList()) {
            if (mediaTitle.equalsIgnoreCase(title)) {
                addToListButton.setVisible(false);
                removeFromListButton.setVisible(true);
            }
        }
    }


    public void addToList(ActionEvent event)
    {

        appController.addToUserList(currentUser, mediaType, mediaTitle);
        addToListButton.setVisible(false);
        removeFromListButton.setVisible(true);

        StateController.addToList(mediaTitle);
    }

    public void removeFromList() {
        appController.removeFromUserList(currentUser, mediaType, mediaTitle);
        addToListButton.setVisible(true);
        removeFromListButton.setVisible(false);

        StateController.removeFromList(mediaTitle);
    }

    public void loadOverview() throws IOException {
        SceneController.changeScene("OverviewScene.fxml");
    }
}
