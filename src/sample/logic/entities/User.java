package sample.logic.entities;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String name;
    private String username;
    private String password;
    private String birthday;
    private static int count;
    private int id;

    private List<Media> myList;

    public User(String name, String birthday, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.birthday = birthday;

        id = count++;
        myList = new ArrayList<>();
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

    public List<Media> getMyList() {
        return this.myList;
    }

    public void addToList(Media media) {
        myList.add(media);
    }

    public void removeFromList(Media media) {
        myList.remove(media);
    }

}
