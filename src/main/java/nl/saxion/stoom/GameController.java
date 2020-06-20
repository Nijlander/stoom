package nl.saxion.stoom;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/store/games")
public class GameController {

    private Database db = new Database();
    private ArrayList<Game> games = db.getGames();
    private ArrayList<Game> owned = db.getOwnedGames();

    /**
     * returns all games when the user travels to /store/games/all
     *
     * @return list of games
     */
    @GetMapping("/all")
    public String getGames(Model model) {
        model.addAttribute("filter", "All Games");
        model.addAttribute("filterUrl", "all");
        model.addAttribute("allGames", games);

        return "games";
    }

    /**
     * returns all games that fall under a certain category when the users travels to /store/games/{category}
     *
     * @param category wildcard indicating the category that needs to be used
     * @return list of games
     */
    @GetMapping("/{category}")
    public String getGamesByCategory(@PathVariable String category, Model model) {
        ArrayList<Game> list = new ArrayList<>();

        for (Game game : games) {
            if (game.getCategory().equalsIgnoreCase(category)) {
                list.add(game);
            }
        }

        model.addAttribute("filter", category.substring(0, 1).toUpperCase() + category.substring(1) + " Games");
        model.addAttribute("filterUrl", category.toLowerCase());
        model.addAttribute("allGames", list);

        return "games";
    }

    /**
     * returns a game that falls under a specific category and id when the user travels to /store/games/{category}/game?id={id}
     *
     * @param id       the id of the game that needs to be shown
     * @param category the category the game falls under
     * @return the selected game
     */
    @GetMapping("/{category}/game")
    public String getGameByCategory(@RequestParam("id") int id, @PathVariable("category") String category, Model model) {
        ArrayList<Game> list = new ArrayList<>();
        Game g = null;

        for (Game game : games) {
            if (game.getCategory().equalsIgnoreCase(category)) {
                list.add(game);
            }
        }

        for (Game game : list) {
            if (game.getId() == id) {
                g = game;
            }
        }

        model.addAttribute("game", g);
        model.addAttribute("lastPage", category.toLowerCase());

        return "game";
    }

    /**
     * returns a game that falls under a specific id
     *
     * @param id the id of the game
     * @return the specified game
     */
    @GetMapping("/all/game")
    public String getGameById(@RequestParam("id") int id, Model model) {
        Game g = null;

        for (Game game : games) {
            if (game.getId() == id) {
                g = game;
            }
        }

        model.addAttribute("game", g);
        model.addAttribute("lastPage", "all");

        return "game";
    }

    /**
     * stores a game into the library
     *
     * @param id id of the game that needs to be stored
     */
    @GetMapping("/buy")
    public String buyGame(@RequestParam("id") int id, Model model) {
        Game g = null;

        for (Game game : games) {
            if (game.getId() == id) {
                g = game;
            }
        }

        db.buyGame(g);

        model.addAttribute("productType", "games");

        return "redirect";
    }

    @GetMapping("/owned")
    @ResponseBody
    public String getOwnedGames() {
        return owned.toString();
    }
}
