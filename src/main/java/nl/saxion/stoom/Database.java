package nl.saxion.stoom;

import java.util.ArrayList;

public class Database {

    private ArrayList<Game> games;
    private ArrayList<Game> ownedGames;

    private ArrayList<Music> music;
    private ArrayList<Music> ownedMusic;

    /**
     * constructor
     */
    public Database() {
        games = new ArrayList<>();
        ownedGames = new ArrayList<>();

        music = new ArrayList<>();
        ownedMusic = new ArrayList<>();

        populateGames(50);
        populateMusic(15);
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
                    this.games.add(new Game("Game " + (i + 1), "Action", "A game to test."));
                    break;
                case 2:
                    this.games.add(new Game("Game " + (i + 1), "Adventure", "A game to test."));
                    break;
                case 3:
                    this.games.add(new Game("Game " + (i + 1), "Casual", "A game to test."));
                    break;
                case 4:
                    this.games.add(new Game("Game " + (i + 1), "Indie", "A game to test."));
                    break;
                case 5:
                    this.games.add(new Game("Game " + (i + 1), "Racing", "A game to test."));
                    break;
                case 6:
                    this.games.add(new Game("Game " + (i + 1), "Roleplaying", "A game to test."));
                    break;
                case 7:
                    this.games.add(new Game("Game " + (i + 1), "Simulation", "A game to test."));
                    break;
                case 8:
                    this.games.add(new Game("Game " + (i + 1), "Sports", "A game to test."));
                    break;
                case 9:
                    this.games.add(new Game("Game " + (i + 1), "Strategy", "A game to test."));
                    break;
            }
        }
    }

    /**
     * Populates the database with random music
     *
     * @param amount the amount of music that needs to be stored
     */
    public void populateMusic(int amount) {
        for (int i = 0; i < amount; i++) {
            int rand = (int) (Math.random() * 3) + 1;

            switch (rand) {
                case 1:
                    this.music.add(new Music("Music title " + (i + 1), "Rens Nijland", "Pop"));
                    break;
                case 2:
                    this.music.add(new Music("Music title " + (i + 1), "Rens Nijland", "Electric"));
                    break;
                case 3:
                    this.music.add(new Music("Music title " + (i + 1), "Rens Nijland", "Hardstyle"));
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
}
