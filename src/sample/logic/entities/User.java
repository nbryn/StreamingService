package sample.logic.entities;

import java.util.ArrayList;
import java.util.List;

public class User {

    private int id;
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

    public User(int id, String name, String birthday, String username, String password) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.birthday = birthday;

        mediaList = new ArrayList<>();
    }

    public int getId() {
        return this.id;
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

    public List<Media> getUserList() {
        return this.mediaList;
    }

    public void addToList(Media media) {
        mediaList.add(media);
    }

    public void removeFromList(Media media) {
        mediaList.remove(media);
    }

}
