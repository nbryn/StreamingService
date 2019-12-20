package streaming.logic.entities;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String name;
    private String username;
    private String password;
    private String birthday;

    private List<Media> mediaList;

    public User(String name, String birthday, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.birthday = birthday;

        mediaList = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public String getBirthday() {
        return this.birthday;
    }



}
