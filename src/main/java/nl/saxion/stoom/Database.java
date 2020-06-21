package nl.saxion.stoom;

import java.util.ArrayList;

public class Database {

    private static ArrayList<Game> games;
    private static ArrayList<Game> ownedGames;

    private static ArrayList<Music> music;
    private static ArrayList<Music> ownedMusic;

    private static ArrayList<Movie> movies;
    private static ArrayList<Movie> ownedMovies;

    private static ArrayList<Account> accounts;


    /**
     * constructor
     */
    public Database() {
        games = new ArrayList<>();
        ownedGames = new ArrayList<>();

        music = new ArrayList<>();
        ownedMusic = new ArrayList<>();

        movies = new ArrayList<>();
        ownedMovies = new ArrayList<>();

        accounts = new ArrayList<>();

        populateGames(50);
        populateMusic(50);
        populateMovies(50);

        accounts.add(new Account("RensNijland", "Test123"));
        accounts.add(new Account("ThijsVoshaar", "Test123"));
    }

    /**
     * populates the database with random games
     *
     * @param amount the amount of games you want to populate the database with
     */
    private void populateGames(int amount) {
        for (int i = 0; i < amount; i++) {
            int rand = (int) (Math.random() * 9) + 1;

            switch (rand) {
                case 1:
                    games.add(new Game(i + 1, "Game " + (i + 1), "Action", "A game to test."));
                    break;
                case 2:
                    games.add(new Game(i + 1, "Game " + (i + 1), "Adventure", "A game to test."));
                    break;
                case 3:
                    games.add(new Game(i + 1, "Game " + (i + 1), "Casual", "A game to test."));
                    break;
                case 4:
                    games.add(new Game(i + 1, "Game " + (i + 1), "Indie", "A game to test."));
                    break;
                case 5:
                    games.add(new Game(i + 1, "Game " + (i + 1), "Racing", "A game to test."));
                    break;
                case 6:
                    games.add(new Game(i + 1, "Game " + (i + 1), "Roleplaying", "A game to test."));
                    break;
                case 7:
                    games.add(new Game(i + 1, "Game " + (i + 1), "Simulation", "A game to test."));
                    break;
                case 8:
                    games.add(new Game(i + 1, "Game " + (i + 1), "Sports", "A game to test."));
                    break;
                case 9:
                    games.add(new Game(i + 1, "Game " + (i + 1), "Strategy", "A game to test."));
                    break;
            }
        }
    }

    /**
     * Populates the database with random music
     *
     * @param amount the amount of music that needs to be stored
     */
    private void populateMusic(int amount) {
        for (int i = 0; i < amount; i++) {
            int rand = (int) (Math.random() * 3) + 1;

            switch (rand) {
                case 1:
                    music.add(new Music(i + 1, "Music title " + (i + 1), "Pop", "Rens Nijland"));
                    break;
                case 2:
                    music.add(new Music(i + 1, "Music title " + (i + 1), "Electronic", "Rens Nijland"));
                    break;
                case 3:
                    music.add(new Music(i + 1, "Music title " + (i + 1), "Hardstyle", "Rens Nijland"));
                    break;
            }
        }
    }

    private void populateMovies(int amount) {
        for (int i = 0; i < amount; i++) {
            int rand = (int) (Math.random() * 5) + 1;

            switch (rand) {
                case 1:
                    movies.add(new Movie(i + 1, "Movie " + (i + 1), "Adventure", "A movie to test."));
                    break;
                case 2:
                    movies.add(new Movie(i + 1, "Movie " + (i + 1), "Action", "A movie to test."));
                    break;
                case 3:
                    movies.add(new Movie(i + 1, "Movie " + (i + 1), "Drama", "A movie to test."));
                    break;
                case 4:
                    movies.add(new Movie(i + 1, "Movie " + (i + 1), "Comedy", "A movie to test."));
                    break;
                case 5:
                    movies.add(new Movie(i + 1, "Movie " + (i + 1), "Thriller", "A movie to test."));
                    break;
            }
        }
    }

    /**
     * gets all games stored in the database
     *
     * @return list of games
     */
    public ArrayList<Game> getGames() {
        return games;
    }

    /**
     * gets all games which the user owns
     *
     * @return list of games
     */
    public ArrayList<Game> getOwnedGames() {
        return ownedGames;
    }

    /**
     * gets all music stored in the database
     *
     * @return list of music
     */
    public ArrayList<Music> getMusic() {
        return music;
    }

    /**
     * gets all music which the user owns
     *
     * @return list of music
     */
    public ArrayList<Music> getOwnedMusic() {
        return ownedMusic;
    }

    /**
     * gets all movies stored in the database
     *
     * @return list of movies
     */
    public ArrayList<Movie> getMovies() {
        return movies;
    }

    /**
     * gets all the movies which the user owns
     *
     * @return list of movies
     */
    public ArrayList<Movie> getOwnedMovies() {
        return ownedMovies;
    }

    /**
     * stores a selected game into the owned games list
     *
     * @param g game that needs to be stored
     */
    public void buyGame(Game g) {
        ownedGames.add(g);
    }

    /**
     * stores a selected song into the owned music list
     *
     * @param m song that needs to be stored
     */
    public void buyMusic(Music m) {
        ownedMusic.add(m);
    }

    /**
     * stores a selected movie into the owned movies list
     *
     * @param m movie that needs to be stored
     */
    public void buyMovie(Movie m) {
        ownedMovies.add(m);
    }

    /**
     * returns all accounts currently stored in the database
     *
     * @return list of accounts
     */
    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    /**
     * saves a game to the store list
     *
     * @param g game that needs to be saved
     */
    public void addGame(Game g) {
        games.add(g);
    }

    /**
     * saves a song to the store list
     *
     * @param m song that needs to be saved
     */
    public void addMusic(Music m) {
        music.add(m);
    }

    /**
     * saves a movie to the store list
     *
     * @param m movie that needs to be saved
     */
    public void addMovie(Movie m) {
        movies.add(m);
    }
}
