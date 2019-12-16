package streaming.logic.entities;

public class Movie extends Media {

    public Movie(String title, int release, double rating) {
        super(title, release, rating);
    }

    @Override
    public String toString() {

        return "Movie: Name: " + super.getTitle() + " Year: " + super.getRelease() + " Genre: " + super.getGenre() + " Rating: " + super.getRating();
    }
}
