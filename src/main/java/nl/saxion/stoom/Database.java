package nl.saxion.stoom;

import java.util.ArrayList;

public class Database {

    private ArrayList<Game> games;
    private ArrayList<Game> ownedGames;

    private ArrayList<Music> music;
    private ArrayList<Music> ownedMusic;

    private ArrayList<Movie> movies;
    private ArrayList<Movie> ownedMovies;

    private ArrayList<Account> accounts;


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
                    this.games.add(new Game(i + 1, "Game " + (i + 1), "Action", "A game to test."));
                    break;
                case 2:
                    this.games.add(new Game(i + 1, "Game " + (i + 1), "Adventure", "A game to test."));
                    break;
                case 3:
                    this.games.add(new Game(i + 1, "Game " + (i + 1), "Casual", "A game to test."));
                    break;
                case 4:
                    this.games.add(new Game(i + 1, "Game " + (i + 1), "Indie", "A game to test."));
                    break;
                case 5:
                    this.games.add(new Game(i + 1, "Game " + (i + 1), "Racing", "A game to test."));
                    break;
                case 6:
                    this.games.add(new Game(i + 1, "Game " + (i + 1), "Roleplaying", "A game to test."));
                    break;
                case 7:
                    this.games.add(new Game(i + 1, "Game " + (i + 1), "Simulation", "A game to test."));
                    break;
                case 8:
                    this.games.add(new Game(i + 1, "Game " + (i + 1), "Sports", "A game to test."));
                    break;
                case 9:
                    this.games.add(new Game(i + 1, "Game " + (i + 1), "Strategy", "A game to test."));
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
                    this.music.add(new Music(i + 1, "Music title " + (i + 1), "Pop", "Rens Nijland"));
                    break;
                case 2:
                    this.music.add(new Music(i + 1, "Music title " + (i + 1), "Electronic", "Rens Nijland"));
                    break;
                case 3:
                    this.music.add(new Music(i + 1, "Music title " + (i + 1), "Hardstyle", "Rens Nijland"));
                    break;
            }
        }
    }

    private void populateMovies(int amount) {
        for (int i = 0; i < amount; i++) {
            int rand = (int) (Math.random() * 5) + 1;

            switch (rand) {
                case 1:
                    this.movies.add(new Movie(i + 1, "Movie " + (i + 1), "Adventure", "A movie to test."));
                    break;
                case 2:
                    this.movies.add(new Movie(i + 1, "Movie " + (i + 1), "Action", "A movie to test."));
                    break;
                case 3:
                    this.movies.add(new Movie(i + 1, "Movie " + (i + 1), "Drama", "A movie to test."));
                    break;
                case 4:
                    this.movies.add(new Movie(i + 1, "Movie " + (i + 1), "Comedy", "A movie to test."));
                    break;
                case 5:
                    this.movies.add(new Movie(i + 1, "Movie " + (i + 1), "Thriller", "A movie to test."));
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
        this.ownedGames.add(g);
    }

    /**
     * stores a selected song into the owned music list
     *
     * @param m song that needs to be stored
     */
    public void buyMusic(Music m) {
        this.ownedMusic.add(m);
    }

    /**
     * stores a selected movie into the owned movies list
     *
     * @param m movie that needs to be stored
     */
    public void buyMovie(Movie m) {
        this.ownedMovies.add(m);
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
