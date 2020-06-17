package nl.saxion.stoom;

import java.util.ArrayList;

public class Database {

    private ArrayList<Game> games;
    private ArrayList<Game> ownedGames;

    /**
     * constructor
     */
    public Database() {
        games = new ArrayList<>();
        ownedGames = new ArrayList<>();

        populateGames(100);
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

    public void buyGame(Game g) {
        this.ownedGames.add(g);
    }
}
