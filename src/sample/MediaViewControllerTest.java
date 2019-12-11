package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import sample.data.SQLMediaMapper;
import sample.data.SQLUserMapper;
import sample.logic.AppController;
import sample.logic.entities.Media;

import java.util.List;

public class MediaViewControllerTest {

    private AppController appController;

    @FXML
    private Label title;

    @FXML
    private Label rating;

    @FXML
    private TextArea genre;

    @FXML
    private Button addToList;

    public MediaViewControllerTest() {
        appController = new AppController(new SQLUserMapper(), new SQLMediaMapper());

    }

    public void initialize() {
        StringBuilder sb = new StringBuilder("");
        String mediaTitle = MediaViewHelper.mediaToShow;

        List<Media> result = appController.fetchByName(mediaTitle, "all");

        Media media = result.get(0);


        title.setText(media.getTitle());
        rating.setText(String.valueOf(media.getRating()));
        List<String> genres = media.getGenre();
        genres.forEach(element -> sb.append(element + "\n"));
        genre.setText(sb.toString());
    }

    public void addToList() {

    }
}
