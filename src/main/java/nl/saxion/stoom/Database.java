package nl.saxion.stoom;

import java.util.ArrayList;

public class Database {

    private ArrayList<Game> games;

    /**
     * constructor
     */
    public Database() {
        games = new ArrayList<>();

        populateGames(10);
    }

    /**
     * populates the database with random games
     *
     * @param amount the amount of games you want to populate the database with
     */
    private void populateGames(int amount) {
        for (int i = 0; i < amount; i++) {
            this.games.add(new Game("Game " + (i + 1), "Action", "A game to test."));
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
}
