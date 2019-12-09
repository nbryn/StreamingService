package sample.data.setup;

import java.sql.*;


public class SQLDataScript {
    public static String buildTables(){

        return  "" +
                "CREATE TABLE movies(" +
                "    movie_id INTEGER PRIMARY KEY AUTO_INCREMENT," +
                "    name VARCHAR(70) NOT NULL," +
                "    release VARCHAR(50) NOT NULL," +
                "    genre VARCHAR(50) NOT NULL," +
                "    rating VARCHAR(50) NOT NULL" +
                ");" +
                "CREATE TABLE series(" +
                "    series_id int PRIMARY KEY AUTO_INCREMENT," +
                "    name VARCHAR(70) NOT NULL," +
                "    span VARCHAR(50) NOT NULL," +
                "    genre VARCHAR(50) NOT NULL," +
                "    rating VARCHAR(50) NOT NULL," +
                "    seasons VARCHAR(200) NOT NULL" +
                ");" +
                "CREATE TABLE users(" +
                "    user_id int PRIMARY KEY AUTO_INCREMENT," +
                "    username VARCHAR(50) NOT NULL UNIQUE," +
                "    password VARCHAR(50) NOT NULL," +
                "    name VARCHAR(50) NOT NULL," +
                "    birthdate VARCHAR(50) NOT NULL" +
                "" +
                ");" +
                "CREATE TABLE myMovieList(" +
                "    user_id int," +
                "    foreign key (user_id) references users(user_id)," +
                "    movie_id int," +
                "    foreign key (movie_id) references movies(movie_id));" +
                "CREATE TABLE mySeriesList(" +
                "    user_id int," +
                "    foreign key (user_id) references users(user_id)," +
                "    series_id int," +
                "    foreign key (series_id) references series(series_id)" +
                ");";
    }
    public static String buildMovies(){
        return
                "INSERT INTO movies (name,release,genre,rating) VALUES " +
                "('The Godfather', '1972', 'Crime, Drama', '9.2'),"+
                "('The Shawshank Redemption', '1994', 'Drama', '9.3'),"+
                "('Schindler´s List', '1993', 'Biography, Drama, History', '8.9'),"+
                "('Raging Bull', '1980', 'Biography, Drama, Sport', '8.2'),"+
                "('Casablanca', '1942', 'Drama, Romance, War', '8.5'),"+
                "('Citizen Kane', '1941', 'Drama, Mystery', '8.4'),"+
                "('Gone With The Wind', '1939', 'Drama, History, Romance', '8.2'),"+
                "('The Wizard Of Oz', '1939', 'Adventure, Family, Fantasy', '8.0'),"+
                "('One Flew Over The Cuckoo´s Nest', '1975', 'Drama', '8.7'),"+
                "('Lawrence Of Arabia', '1962', 'Adventure, Biography, Drama', '8.3'),"+
                "('Vertigo', '1958', 'Mystery, Romance, Thriller', '8.3'),"+
                "('Psycho', '1960', 'Horror, Mystery, Thriller', '8.5'),"+
                "('The Godfather part II', '1974', 'Crime, Drama', '9'),"+
                "('On The Waterfront', '1954', 'Crime, Drama, Thriller', '8.2'),"+
                "('Sunset Boulevard', '1950', 'Drama, Film-Noir', '8.4'),"+
                "('Forrest Gump', '1994', 'Drama, Romance', '8.8'),"+
                "('The Sound Of Music', '1965', 'Biography, Drama, Family, Musical', '8.0'),"+
                "('12 Angry Men', '1957', 'Crime, Drama', '8.9'),"+
                "('West Side Story', '1961', 'Crime, Drama', '7.6'),"+
                "('Star Wars', '1977', 'Action, Adventure, Family', '8.6'),"+
                "('2001 A Space Odyssey', '1968', 'Adventure, Sci-fi', '8.3'),"+
                "('ET', '1982', 'Family, Sci-fi', '7.9'),"+
                "('The Silence Of The Lambs', '1991', 'Crime, Drama, Thriller', '8.6'),"+
                "('Chinatown', '1974', 'Drama, Mystery, Thriller', '8.2'),"+
                "('The Bridge Over The River Kwai', '1957', 'Adventure, Drama, War', '8.2'),"+
                "('Singin´ In The Rain', '1952', 'Comedy, Musical, Romance', '8.3'),"+
                "('It´s A Wonderful Life', '1946', 'Drama, Family, Fantasy', '8.6'),"+
                "('Dr. Strangelove Or How I Learned To Stop Worrying And Love The Bomb', '1964', 'Comedy, War', '8.4'),"+
                "('Some Like It Hot', '1959', 'Comedy, Romance', '8.2'),"+
                "('Ben Hur', '1959', 'Adventure, Drama, History', '8.1'),"+
                "('Apocalypse Now', '1979', 'Drama, War', '8.5'),"+
                "('Amadeus', '1984', 'Biography, Drama, History', '8.3'),"+
                "('Lord Of The Rings - The Return Of The King', '2003', 'Action, Adventure, Drama', '8.9'),"+
                "('Gladiator', '2000', 'Action, Adventure, Drama', '8.5'),"+
                "('Titanic', '1997', 'Drama, Romance', '7.8'),"+
                "('From Here To Eternity', '1953', 'Drama, Romance, War', '7.7'),"+
                "('Saving Private Ryan', '1998', 'Drama, War', '8.6'),"+
                "('Unforgiven', '1992', 'Drama, Western', '8.2'),"+
                "('Raiders Of The Lost Ark', '1981', 'Action, Adventure', '8.5'),"+
                "('Rocky', '1976', 'Drama, Sport', '8.1'),"+
                "('A Streetcar Named Desire', '1951', 'Drama', '8.0'),"+
                "('A Philadelphia Story', '1940', 'Comedy, Romance', '8.0'),"+
                "('To Kill A Mockingbird', '1962', 'Crime, Drama', '8.3'),"+
                "('An American In Paris', '1951', 'Drama, Musical, Romance', '7.2'),"+
                "('The Best Years Of Our Lives', '1946', 'Drama, Romance, War', '8.1'),"+
                "('My Fair Lady', '1964', 'Drama, Family, Musical', '7.9'),"+
                "('A Clockwork Orange', '1971', 'Crime, Drama, Sci-fi', '8.3'),"+
                "('Doctor Zhivago', '1965', 'Drama, Romance, War', '8.0'),"+
                "('The Searchers', '1956', 'Adventure, Drama, Western', '8.0'),"+
                "('Jaws', '1975', 'Adventure, Drama, Thriller', '8.0'),"+
                "('Patton', '1970', 'Biography, Drama, War', '8.0'),"+
                "('Butch Cassidy And The Sundance Kid', '1969', 'Biography, Crime, Drama', '8.1'),"+
                "('The Treasure Of The Sierra Madre', '1948', 'Adventure, Drama, Western', '8.3'),"+
                "('The Good, The Bad And The Ugly', '1966', 'Western', '8.9'),"+
                "('The Apartment', '1960', 'Comedy, Drama, Romance', '8.3'),"+
                "('Platoon', '1986', 'Drama, War', '8.1'),"+
                "('High Noon', '1952', 'Action, Drama, Thriller', '8.0'),"+
                "('Braveheart', '1995', 'Biography, Drama, History', '8.4'),"+
                "('Dances With Wolves', '1990', 'Adventure, Drama, Western', '8.0'),"+
                "('Jurassic Park', '1993', 'Adventure, Sci-fi, Thriller', '8.1'),"+
                "('The Exorcist', '1973', 'Horror', '8.0'),"+
                "('The Pianist', '2002', 'Biography, Drama, Music', '8.5'),"+
                "('Goodfellas', '1990', 'Crime, Drama', '8.7'),"+
                "('The Deer Hunter', '1978', 'Drama, War', '8.1'),"+
                "('All Quiet On The Western Front', '1930', 'Drama, War', '8.1'),"+
                "('Bonny And Clyde', '1967', 'Action, Biography, Crime', '7.9'),"+
                "('The French Connection', '1971', 'Action, Crime, Drama', '7.8'),"+
                "('City Lights', '1931', 'Comedy, Drama, Romance', '8.5'),"+
                "('It Happened One Night', '1934', 'Comedy, Romance', '8.1'),"+
                "('A Place In The Sun', '1951', 'Drama, Romance', '7.8'),"+
                "('Midnight Cowboy', '1969', 'Drama', '7.9'),"+
                "('Mr Smith Goes To Washington', '1939', 'Comedy, Drama', '8.2'),"+
                "('Rain Man', '1988', 'Drama', '8.0'),"+
                "('Annie Hall', '1977', 'Comedy, Romance', '8.0'),"+
                "('Fargo', '1996', 'Crime, Drama, Thriller', '8.1'),"+
                "('Giant', '1956', 'Drama, Western', '7.7'),"+
                "('Shane', '1953', 'Drama, Western', '7.7'),"+
                "('Grapes Of Wrath', '1940', 'Drama, History', '8.1'),"+
                "('The Green Mile', '1999', 'Crime, Drama, Fantasy', '8.5'),"+
                "('Close Encounters', '1977', 'Drama, Sci-fi', '7.7'),"+
                "('Nashville', '1975', 'Comedy, Drama, Music', '7.8'),"+
                "('Network', '1976', 'Drama', '8.1'),"+
                "('The Graduate', '1967', 'Comedy, Drama, Romance', '8.0'),"+
                "('American Graffiti', '1973', 'Comedy, Drama', '7.5'),"+
                "('Pulp Fiction', '1994', 'Crime, Drama', '8.9'),"+
                "('Terms of Endearment', '1983', 'Comedy, Drama', '7.4'),"+
                "('Good Will Hunting', '1997', 'Drama, Romance', '8.3'),"+
                "('The African Queen', '1951', 'Adventure, Drama, Romance', '7.9'),"+
                "('Stagecoach', '1939', 'Adventure, Western', '7.9'),"+
                "('Mutiny On The Bounty', '1935', 'Adventure, Biography, Drama', '7.8'),"+
                "('The Great Dictator', '1940', 'Comedy, Drama, War', '8.5'),"+
                "('Double Indemnity', '1944', 'Crime, Drama, Film-Noir', '8.3'),"+
                "('The Maltese Falcon', '1941', 'Film-Noir, Mystery', '8.1'),"+
                "('Wuthering Heights', '1939', 'Drama, Romance', '7.7'),"+
                "('Taxi Driver', '1976', 'Crime, Drama', '8.3'),"+
                "('Rear Window', '1954', 'Mystery, Thriller', '8.5'),"+
                "('The Third Man', '1949', 'Film-Noir, Mystery, Thriller', '8.2'),"+
                "('Rebel Without A Cause', '1955', 'Drama', '7.8'),"+
                "('North By Northwest', '1959', 'Adventure, Mystery, Thriller', '8.3'),"+
                "('Yankee Doodle Dandy', '1942', 'Biography, Drama, Musical', '7.7');";

    }
    public static String buildSeries(){
        return "INSERT INTO series (name,span,genre,rating,seasons) VALUES"+
                "('Twin Peaks', '1990-1991', 'Crime, Drama, Mystery', '8.8', '1-8, 2-22'),"+
                "('The Sopranos', '1999-2007', 'Crime, Drama', '9.2', '1-13, 2-13, 3-13, 4-13, 5-13, 6-21'),"+
                "('Game Of Thrones', '2011-','Action, Adventure, Drama', '9.5', '1-10, 2-10, 3-10, 4-10, 5-10, 6-10, 7-7'),"+
                "('Breaking Bad', '2008-2013', 'Crime, Drama, Thriller', '9.5', '1-7, 2-13, 3-13, 4-13, 5-16'),"+
                "('The Larry Sanders Show', '1992-1998', 'Comedy', '8.3', '1-13, 2-18, 3-17, 4-17, 5-13, 6-12'),"+
                "('Curb Your Enthusiasm', '2000-', 'Comedy', '8.7', '1-10, 2-10, 3-10, 4-10, 5-10, 6-10, 7-10, 8-10, 9-10'),"+
                "('Lost', '2004-2010', 'Adventure, Drama, Fantasy', '8.4', '1-25, 2-24, 3-23, 4-14, 5-17, 6-18'),"+
                "('Louie', '2010-2015', 'Comedy, Drama', '8.6', '1-13, 2-13, 3-13, 4-14, 5-8'),"+
                "('Cheers', '1982-1993', 'Comedy, Drama', '7.8', '1-22, 2-22, 3-25, 4-26, 5-26, 6-25, 7-22, 8-26, 9-27, 10-26, 11-28'),"+
                "('Scener ur ett äktenskap', '1973', 'Drama', '8.5', '1-6'),"+
                "('Buffy The Vampire Slayer', '1996-2003', 'Action, Drama, Fantasy', '8.2', '1-12, 2-22, 3-22, 4-22, 5-22, 6-22, 7-22'),"+
                "('The Shield', '2002-2008', 'Crime, Drama, Thriller', '8.7', '1-13, 2-13, 3-15, 4-13, 5-11, 6-10, 7-13'),"+
                "('Deadwood', '2004-2006', 'Crime, Drama, History', '8.7', '1-12, 2-12, 3-12'),"+
                "('The Marvelous Mrs Maisel', '2017- ', 'Comedy, Drama', '8.7', '1-8'),"+
                "('Horace and Pete´s', '2016', 'Comedy, Drama', '8.6', '1-10'),"+
                "('Top Of The Lake', '2013- ', 'Crime, Drama, Mystery', '7.5', '1-7, 2-6'),"+
                "('The Simpsons', '1989- ', 'Animation, Comedy', '8.7', '1-13, 2-22, 3-24, 4-22, 5-22, 6-25, 7-25, 8-25, 9-25, 10-23, 11-22, 12-21, 13-22, 14-22, 15-22, 16-21, 17-22, 18-22, 19-20, 20-21, 21-23, 22-22, 23-22, 24-22, 25-22, 26-22, 27-22, 28-22, 29-21'),"+
                "('The Walking Dead', '2010- ', 'Drama, Horror, Sci-fi', '8.4', '1-6, 2-13, 3-16, 4-16, 5-16, 6-16, 7-16, 8-16, 9-16'),"+
                "('The Wire', '2001-2008', 'Crime, Drama, Thriller', '9.3', '1-13, 2-12, 3-12, 4-13, 5-10'),"+
                "('Welt Am Draht', '1973', 'Crime, Mystery, Sci-fi', '7.9', '1-2'),"+
                "('House Of Cards', '2013-2018', 'Drama', '8.9', '1-13, 2-13, 3-13, 4-13, 5-13, 6-8'),"+
                "('Fargo', '2014- ', 'Crime, Drama, Thriller', '9.0', '1-10, 2-10, 3-10'),"+
                "('Angel', '1999-2004', 'Action, Drama, Fantasy', '8.0', '1-22, 2-22, 3-22, 4-22, 5-22'),"+
                "('V', '1984-1985', 'Action, Adventure, Sci-fi', '7.3', '1-13'),"+
                "('Jessica Jones', '2015- ', 'Action, Crime, Drama', '8.1', '1-13, 2-13'),"+
                "('Daredevil', '2015- ', 'Action, Crime, Drama', '8.7', '1-13, 2-13, 3-13'),"+
                "('Seinfeld', '1989-1998', 'Comedy', '8.9', '1-5, 2-12, 3-23, 4-24, 5-22, 6-24, 7-24, 8-22, 9-24'),"+
                "('Slings And Arrows', '2003-2006', 'Comedy', '8.5', '1-6, 2-6, 3-6'),"+
                "('I Claudius', '1976', 'Biography, Drama, History', '8.9', '1-12'),"+
                "('Rome', '2005-2007', 'Action, Drama, History', '8.8', '1-12, 2-10'),"+
                "('Ray Donovan', '2013- ', 'Crime, Drama', '8.3', '1-12, 2-12, 3-12, 4-12, 5-12, 6-12'),"+
                "('Better Call Saul', '2015- ', 'Crime, Drama', '8.7', '1-10, 2-10, 3-10, 4-10'),"+
                "('The Honeymooners', '1955-1956', 'Comedy, Family', '8.7', '1-39'),"+
                "('Spaced', '1999-2001', 'Action, Comedy', '8.6', '1-7, 2-7'),"+
                "('The Twilight Zone', '1959-1964', 'Fantasy, Horror, Mystery', '9.0', '1-36, 2-29, 3-37, 4-18, 5-36'),"+
                "('Fraiser', '1993-2004', 'Comedy', '8.1', '1-24, 2-24, 3-24, 4-24, 5-24, 6-24, 7-24, 8-24, 9-24, 10-24, 11-24'),"+
                "('Alfred Hitchcock Presents', '1955-1962', 'Crime, Drama, Mystery', '8.6', '1-39, 2-39, 3-39, 4-36, 5-38, 6-38, 7-38'),"+
                "('I Love Lucy', '1951-1957', 'Comedy, Family', '8.3', '1-35, 2-31, 3-31, 4-30, 5-26, 6-27'),"+
                "('24', '2001-2010', 'Action, Crime, Drama', '8.4', '1-24, 2-24, 3-24, 4-24, 5-24, 6-24,7-24, 8-24'),"+
                "('The Americans', '2013-2018', 'Crime, Drama, Mystery', '8.4', '1-13, 2-13, 3-13, 4-13, 5-13, 6-10'),"+
                "('Girls', '2012-2017', 'Comedy, Drama', '7.3', '1-10, 2-10, 3-12, 4-10, 5-10, 6-10'),"+
                "('Mad Men', '2007-2015', 'Drama', '8.6', '1-13, 2-13, 3-13, 4-13, 5-13, 6-13, 7-14'),"+
                "('Northern Exposure', '1990-1995', 'Comedy, Drama, Fantasy', '8.3', '1-8, 2-7, 3-23, 4-25, 5-24, 6-23'),"+
                "('Star Trek', '1966-1969', 'Action, Adventure, Sci-fi', '8.3', '1-29, 2-26, 3-24'),"+
                "('Big Little Lies', '2017', 'Crime, Drama, Mystery', '8.6', '1-7'),"+
                "('Firefly', '2002-2003', 'Adventure, Drama, Sci-fi', '9.0', '1-14'),"+
                "('Spartacus', '2010-2013', 'Action, Adventure, Biography', '8.5', '1-13, 2-10, 3-10'),"+
                "('Mr Show With Bob And David', '1995-1998', 'Comedy', '8.3', '1-4, 2-6, 3-10, 4-10'),"+
                "('Homeland', '2011-', 'Crime, Drama, Mystery', '8.3', '1-12, 2-12, 3-12, 4-12, 5-12, 6-12, 7-12'),"+
                "('Show Me A Hero', '2015', 'Drama, History', '8.1', '1-6'),"+
                "('Crisis In Six Scenes', '2016', 'Comedy', '6.6', '1-6'),"+
                "('Batman', '1966-1968', 'Action, Adventure, Comedy', '7.5', '1-34, 2-60, 3-26'),"+
                "('Luke Cage', '2016-2018', 'Action, Crime, Drama', '7.5', '1-13, 2-13'),"+
                "('South Park', '1997-', 'Animation, Comedy', '8.7', '1-13, 2-18, 3-17, 4-17, 5-14, 6-17, 7-15, 8-14, 9-14, 10-14, 11-14, 12-14, 13-14, 14-14, 15-14, 16-14, 17-10, 18-10, 19-10 , 20-10, 21-10, 22-10'),"+
                "('Band Of Brothers', '2001', 'Action, Drama, History', '9.5', '1-10'),"+
                "('Married With Children', '1986-1997', 'Comedy', '8.1', '1-13, 2-22, 3-22, 4-23, 5-25, 6-26, 7-26, 8-26, 9-26, 10-26, 11-24'),"+
                "('Family Ties', '1982-1989', 'Comedy, Family', '7.2', '1-21, 2-22, 3-22, 4-22, 5-24, 6-24, 7-20'),"+
                "('Lonesome Dove', '1989', 'Adventure, Drama, Western', '8.7', '1-4'),"+
                "('Pride And Prejudice', '1995', 'Drama, Romance', '8.9', '1-6'),"+
                "('Flying Blind', '1992-1993', 'Comedy', '8.0', '1-22'),"+
                "('Battlestar Galactica', '2004-2009', 'Action, Adventure, Drama', '8.7', '1-13, 2-20, 3-20, 4-20'),"+
                "('Lucky Louie', '2006-2007', 'Comedy', '8.0', '1-13'),"+
                "('Dekalog', '1989-1990', 'Drama', '9.1', '1-10'),"+
                "('It´s Garry Shandling´s Show', '1986-1990', 'Comedy', '7.6', '1-16, 2-17, 3-20, 4-19'),"+
                "('On The Air', '1992', 'Comedy', '7.4', '1-7'),"+
                "('All In The Family', '1971-1979', 'Comedy, Drama', '7.4', '1-13, 2-24, 3-24, 4-24, 5-23, 6-24, 7-25, 8-24, 9-24'),"+
                "('Entourage', '2004-2011', 'Comedy, Drama', '8.5', '1-8, 2-14, 3-20, 4-12, 5-12, 6-12, 7-10, 8-8'),"+
                "('Ally McBeal', '1997-2002', 'Comedy, Drama, Fantasy', '6.8', '1-23, 2-23, 3-21, 4-23, 5-22'),"+
                "('The Strain', '2014-2017', 'Drama, Horror, Thriller', '7.4', '1-13, 2-13, 3-10, 4-10'),"+
                "('The Man In The High Castle', '2015- ', 'Drama, Sci-fi, Thriller', '8.1', '1-10, 2-10, 3-10'),"+
                "('Sons Of Anarchy', '2008-2014', 'Crime, Drama, Thriller', '8.6', '1-13, 2-13, 3-13, 4-14, 5-13, 6-13, 7-13'),"+
                "('The Punisher', '2017','Action, Adventure, Crime', '8.6', '1-13'),"+
                "('Boardwalk Empire', '2010-2014', 'Crime, Drama, History', '8.6', '1-12, 2-12, 3-12, 4-12, 5-8'),"+
                "('Damages', '2007-2012', 'Crime, Drama, Mystery', '8.1', '1-13, 2-13, 3-13, 4-10, 5-10'),"+
                "('Banshee', '2013-2016', 'Action, Crime, Drama', '8.4', '1-10, 2-10, 3-10, 4-8'),"+
                "('Planet Earth', '2006', 'Documentary', '9.4', '1-11'),"+
                "('Freaks And Geeks', '1999-2000', 'Comedy, Drama', '8.8', '1-18'),"+
                "('The Way We Live Now', '2001', 'Drama, Romance', '7.7', '1-4'),"+
                "('Justified', '2010-2015', 'Action, Crime, Drama', '8.6', '1-13, 2-13, 3-13, 4-13, 5-13, 6-13'),"+
                "('Arrested Development', '2003- ', 'Comedy', '8.9', '1-22, 2-18, 3-13, 4-22, 5-16'),"+
                "('Stranger Things', '2016- ', 'Drama, Fantasy, Horror', '8.9', '1-8, 2-9'),"+
                "('Night Court', '1984-1992', 'Comedy', '7.7', '1-13, 2-22, 3-22, 4-22, 5-22, 6-22, 7-24, 8-24, 9-22'),"+
                "('Revenge', '2011-2015', 'Drama, Mystery, Thriller', '7.9', '1-22, 2-22, 3-22, 4-23'),"+
                "('Da Ali G Show', '2003-2004', 'Comedy, Talk-show', '8.0', '1-6, 2-6, 3-6'),"+
                "('Sex & The City', '1998-2004', 'Comedy, Drama, Romance', '7.1', '1-12, 2-18, 3-18, 4-18, 5-8, 6-20'),"+
                "('Tyrant', '2014-2016', 'Action, Drama, Thriller', '7.8', '1-10, 2-12, 3-10'),"+
                "('Billions', '2016- ', 'Drama', '8.4', '1-12, 2-12, 3-12'),"+
                "('Shameless', '2011- ', 'Comedy, Drama', '8.7', '1-12, 2-12, 3-12, 4-12, 5-12, 6-12, 7-12, 8-12, 9-7'),"+
                "('Smallville', '2001-2011', 'Adventure, Drama, Romance', '7.5', '1-21, 2-23, 3-22, 4-22, 5-22, 6-22, 7-20, 8-22, 9-21, 10-22'),"+
                "('The Defenders', '2017', 'Action, Adventure, Crime', '7.5', '1-8'),"+
                "('House', '2004-2012', 'Drama, Mystery', '8.8', '1-22, 2-24, 3-24, 4-16, 5-24, 6-21, 7-23, 8-22'),"+
                "('Fear The Walking Dead', '2015-', 'Drama, Horror, Sci-fi', '7.0', '1-6, 2-15, 3-16, 4-16'),"+
                "('True Blood', '2008-2014', 'Drama, Fantasy, Mystery', '7.9', '1-12, 2-12, 3-12, 4-12, 5-12, 6-10, 7-10'),"+
                "('GLOW', '2017- ', 'Comedy, Drama, Sport', '8.2', '1-10, 2-10'),"+
                "('Doctor Thorne', '2016', 'Drama', '7.3', '1-3'),"+
                "('The Civil War', '1990', 'Documentary, History, War', '9.1', '1-9'),"+
                "('Person Of Interest', '2011-2016', 'Action, Crime, Drama', '8.4', '1-23, 2-22, 3-23, 4-22, 5-13'),"+
                "('Californication', '2007-2014', 'Comedy, Drama', '8.3', '1-12, 2-12, 3-12, 4-12, 5-12, 6-12, 7-12'),"+
                "('Three´s Company', '1976-1984', 'Comedy', '7.6', '1-6, 2-25, 3-22, 4-25, 5-22, 6-28, 7-22, 8-22'),"+
                "('Dexter', '2006-2013', 'Crime, Drama, Mystery', '8.7', '1-12, 2-12, 3-12, 4-12, 5-12, 6-12, 7-12,8-1');";
    /** */}
    public static String buildUsers(){
        return
                "INSERT INTO users (username,password,name,birthdate) " +
                        "VALUES "+
                        "('Kris','Suppe','Kristian','110996');";

    }
    public static String testQueries(){
        return
                "CREATE TABLE users(" +
                "user_id int PRIMARY KEY AUTO_INCREMENT,"+
                "username varchar(50) NOT NULL ," +
                "password varchar(50) NOT NULL);" +
                "insert into users (username, password) "+
                "VALUES ('Kris','Suppe');";
    }
}
