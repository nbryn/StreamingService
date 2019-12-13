package sample;

import java.util.ArrayList;
import java.util.List;

public class StateController {

    public static String currentMedia;
    public static String currentUser;
    public static List<String> userList = new ArrayList<>();

    public static void setCurrentUser(String currentUser) {
        StateController.currentUser = currentUser;
    }

    public static void setCurrentMedia(String currentMedia) {
        StateController.currentMedia = currentMedia;
    }

    public static void addToList(String mediaTitle) {
        userList.add(mediaTitle);
    }

    public static void removeFromList(String mediaTitle) {
        userList.remove(mediaTitle);
    }

    public static List<String> getUserList() {
        return userList;
    }

}
