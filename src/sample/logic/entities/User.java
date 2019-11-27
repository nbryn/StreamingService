package sample.logic.entities;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String name;
    private String username;
    private int year;

    private List<Media> myList;

    public User(String name, int year, String username) {
        this.name = name;
        this.username = username;
        this.year = year;

        myList = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public String getUsername() {
        return this.username;
    }

    public int getYear() {
        return this.year;
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
