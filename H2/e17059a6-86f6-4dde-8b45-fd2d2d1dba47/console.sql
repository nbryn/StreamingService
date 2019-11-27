CREATE TABLE movies (
    movie_id int PRIMARY KEY AUTO_INCREMENT,
    name varchar(50) NOT NULL ,
    release varchar(50) NOT NULL ,
    genre varchar(50) NOT NULL,
    rating varchar(50) NOT NULL
)
CREATE TABLE series (
    serie_id int PRIMARY KEY AUTO_INCREMENT,
    name varchar(50) NOT NULL ,
    span varchar(50) NOT NULL ,
    genre varchar(50) NOT NULL,
    rating varchar(50) NOT NULL,
    seasons varchar(50) NOT NULL
)
CREATE TABLE users(
    user_id int PRIMARY KEY AUTO_INCREMENT,
    username varchar(50) NOT NULL,
    password varchar(50) NOT NULL

)
CREATE TABLE myList(
    movie_id int,
    foreign key (movie_id) references movies(movie_id),
    serie_id int,
    foreign key (movie_id) references series(serie_id)

)


INSERT INTO users(username, password)
VALUES
('username','password');
commit;
SELECT *FROM users
WHERE username = 'username'