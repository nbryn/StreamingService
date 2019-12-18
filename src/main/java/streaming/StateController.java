package streaming;

import streaming.logic.entities.Media;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class StateController {

    public static String currentMedia;
    public static String currentUser;
    public static List<File> allImages = new ArrayList<>();
    public static List<Media> currentView = new ArrayList<>();

    public static void setCurrentUser(String currentUser) {
        StateController.currentUser = currentUser;
    }

    public static void setCurrentMedia(String currentMedia) {
        StateController.currentMedia = currentMedia;
    }

    public static void setCurrentView(List<Media> currentView) {
        StateController.currentView = currentView;
    }

    public static void setImages(List<File> images) {
        allImages.addAll(images);
    }

}


