package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import sample.data.SQLMediaMapper;
import sample.data.SQLUserMapper;
import sample.logic.AppController;
import sample.logic.entities.Media;
import sample.logic.entities.Movie;

import java.util.List;

public class MediaViewControllerTest {

    private AppController appController;

    private String currentUser;

    private String mediaTitle;

    private String mediaType;

    @FXML
    private Label title;

    @FXML
    private Label rating;

    @FXML
    private TextArea genre;

    public MediaViewControllerTest() {
        appController = new AppController(new SQLUserMapper(), new SQLMediaMapper());
        currentUser = StateController.currentUser;
        mediaTitle = StateController.currentMedia;

    }

    public void initialize() {
        StringBuilder sb = new StringBuilder("");
        List<Media> result = appController.fetchByName(mediaTitle, "all");

        Media media = result.get(0);
        mediaType = media instanceof Movie ? "Movie" :  "Series";

        title.setText(media.getTitle());
        rating.setText(String.valueOf(media.getRating()));
        List<String> genres = media.getGenre();
        genres.forEach(element -> sb.append(element + "\n"));
        String s = sb.toString();
        String current = s.substring(0, s.length() - 1);
        System.out.println(current);
        genre.setText(sb.toString());
    }

    public void addToList() {
        appController.addToUserList(currentUser, mediaType, mediaTitle);

    }

    public void removeFromList() {
        appController.removeFromUserList(currentUser, mediaType, mediaTitle);

    }
}
