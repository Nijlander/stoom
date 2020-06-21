package nl.saxion.stoom;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
@RequestMapping("/store/games")
public class GameController extends Database {

    private ArrayList<Game> owned = getOwnedGames();

    /**
     * returns all games that are stored in the database
     *
     * @param model   model for routing and data binding
     * @param session for accessibility check
     * @return
     */
    @GetMapping("/all")
    public String getGames(Model model, HttpSession session) {
        if (session.getAttribute("username") != null) {
            model.addAttribute("filter", "All Games");
            model.addAttribute("filterUrl", "all");
            model.addAttribute("allGames", getGames());

            return "games";
        }
        return "redirect:/logout";
    }

    /**
     * returns all games that fall under a specific category
     *
     * @param category category specified in the URI
     * @param model    model for routing and data binding
     * @param session  for accessibility check
     * @return
     */
    @GetMapping("/{category}")
    public String getGamesByCategory(@PathVariable String category, Model model, HttpSession session) {
        if (session.getAttribute("username") != null) {
            ArrayList<Game> list = new ArrayList<>();

            for (Game game : getGames()) {
                if (game.getCategory().equalsIgnoreCase(category)) {
                    list.add(game);
                }
            }

            model.addAttribute("filter", category.substring(0, 1).toUpperCase() + category.substring(1) + " Games");
            model.addAttribute("filterUrl", category.toLowerCase());
            model.addAttribute("allGames", list);

            return "games";
        }
        return "redirect:/logout";
    }

    /**
     * returns a game that falls under a specific id and category
     *
     * @param id       id specified in URI
     * @param category category specified in URI
     * @param model    model for routing and data binding
     * @param session  for accessibility check
     * @return
     */
    @GetMapping("/{category}/game")
    public String getGameByCategory(@RequestParam("id") int id, @PathVariable("category") String category, Model model, HttpSession session) {
        if (session.getAttribute("username") != null) {
            ArrayList<Game> list = new ArrayList<>();
            Game g = null;

            for (Game game : getGames()) {
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
        return "redirect:/logout";
    }

    /**
     * returns a game that falls under a specific id
     *
     * @param id      id specified in URI
     * @param model   model for routing and data binding
     * @param session for accessibility check
     * @return
     */
    @GetMapping("/all/game")
    public String getGameById(@RequestParam("id") int id, Model model, HttpSession session) {
        if (session.getAttribute("username") != null) {
            Game g = null;

            for (Game game : getGames()) {
                if (game.getId() == id) {
                    g = game;
                }
            }

            model.addAttribute("game", g);
            model.addAttribute("lastPage", "all");

            return "game";
        }
        return "redirect:/logout";
    }

    /**
     * stores a game into the owned games list
     *
     * @param id      id specified in URI
     * @param model   model for routing and data binding
     * @param session for accessibility check
     * @return
     */
    @GetMapping("/buy")
    public String buyGame(@RequestParam("id") int id, Model model, HttpSession session) {
        if (session.getAttribute("username") != null) {
            Game g = null;

            for (Game game : getGames()) {
                if (game.getId() == id) {
                    g = game;
                }
            }

            buyGame(g);

            model.addAttribute("productType", "games");
            model.addAttribute("login", false);

            return "reroute";
        }
        return "redirect:/logout";
    }

    /**
     * returns the add game html page
     *
     * @param session for accessibility check
     * @return
     */
    @GetMapping("/add")
    public String getAddPage(HttpSession session) {
        if (session.getAttribute("username") != null) {
            return "addgame";
        }
        return "redirect:/logout";
    }

    /**
     * adds a new game to the database containing user specified details
     *
     * @param game    game that needs to be stored
     * @param model   model for routing and data binding
     * @param session for accessibility check
     * @return
     */
    @PostMapping("/add")
    public String addGame(Game game, Model model, HttpSession session) {
        if (session.getAttribute("username") != null) {
            game.setId(getGames().get(getGames().size() - 1).getId() + 1);

            addGame(game);

            model.addAttribute("productType", "games");
            model.addAttribute("login", false);

            return "reroute";
        }
        return "redirect:/logout";
    }
}
