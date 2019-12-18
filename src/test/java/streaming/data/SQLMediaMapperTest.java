package streaming.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import streaming.data.setup.H2Init;
import streaming.logic.entities.Media;
import streaming.logic.entities.Movie;
import streaming.logic.entities.Series;
import streaming.logic.interfaces.MediaMapper;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SQLMediaMapperTest {

    private static MediaMapper mediaMapper;

    @BeforeEach
    void setUp() {
        H2Init.initialize();
        mediaMapper = new SQLMediaMapper();
    }

    @Test
    void getAll() {
        List<Media> allMedia = mediaMapper.getAll();

        assertEquals(199, allMedia.size());
    }

    @Test
    void getMovies() {
        List<Media> movies = mediaMapper.getMovies();

        assertEquals(99, movies.size());
    }

    @Test
    void getSeries() {
        List<Media> series = mediaMapper.getSeries();

        assertEquals(100, series.size());
    }

    @Test
    void getByName() {
        List<Media> result;
        Movie movie;
        Series series;
        result = mediaMapper.getByName("Unforgiven", "Movie");

        movie = (Movie) result.get(0);

        assertEquals("Unforgiven", movie.getTitle());
        assertEquals(1992, movie.getRelease());
        assertEquals(8.2, movie.getRating());

        result.clear();

        result = mediaMapper.getByName("Lost", "Series");

        series = (Series) result.get(0);

        assertEquals("Lost", series.getTitle());
        assertEquals(2004, series.getRelease());
        assertEquals(8.4, series.getRating());
        assertEquals(6, series.getSeasons().size());
    }

    @Test
    void getByRating() {
        List<Media> result;

        result = mediaMapper.getByRating(9.2, "All");
        assertEquals(8, result.size());
        result.clear();

        result = mediaMapper.getByRating(9.0, "Movie");
        assertEquals(14, result.size());
        result.clear();

        result = mediaMapper.getByRating(8.8, "Series");
        assertEquals(21, result.size());

    }

    @Test
    void getAllFromGenre() {
        List<Media> result;

        result = mediaMapper.getAllFromGenre("History", "All");
        assertEquals(13, result.size());
        result.clear();

        result = mediaMapper.getAllFromGenre("Documentary", "Movie");
        assertEquals(2, result.size());
        result.clear();

        result = mediaMapper.getAllFromGenre("Crime", "Series");
        assertEquals(28, result.size());

    }
}