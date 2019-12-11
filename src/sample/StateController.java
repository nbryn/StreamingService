package sample;

public class StateController {

    public static String currentMedia;
    public static String currentUser;

    public static void setCurrentUser(String currentUser) {
        StateController.currentUser = currentUser;
    }

    public static void setCurrentMedia(String currentMedia) {
        StateController.currentMedia = currentMedia;
    }

}
