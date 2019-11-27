package sample.logic;

import sample.logic.entities.User;
import sample.logic.interfaces.MediaDAO;
import sample.logic.interfaces.UserDAO;

public class AppController {

    private UserDAO userDAO;
    private MediaDAO mediaDAO;

    public AppController(UserDAO userDAO, MediaDAO mediaDAO) {

        this.userDAO = userDAO;
        this.mediaDAO = mediaDAO;
    }

    public boolean validateUser(String username, String password) {

        User user = userDAO.getUser(username, password);
        if (user == null) {
            return false;
        } else {
            return true;
        }
    }
}

