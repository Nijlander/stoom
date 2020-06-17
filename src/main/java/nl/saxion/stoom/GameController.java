package nl.saxion.stoom;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

@Controller
@RequestMapping("/store/games")
public class GameController {

    private final Database db = new Database();

    @GetMapping("/all")
    @ResponseBody
    public String getGames() {
        return db.getGames().toString();
    }

    @GetMapping("/{category}")
    @ResponseBody
    public String getGamesByCategory(@PathVariable String category) {
        ArrayList<Game> list = db.getGames();
        ArrayList<Game> newList = new ArrayList<>();

        for (Game game : list) {
            if (game.getCategory().equalsIgnoreCase(category)) {
                newList.add(game);
            }
        }

        return newList.toString();
    }

//    @GetMapping("/{category}/game")
//    @ResponseBody
//    public String getGameByCategory(@PathVariable String category, RequestParam("id")
//
//    int id)
//
//    {
//        ArrayList<Game> list = db.getGames();
//        ArrayList<Game> newList = new ArrayList<>();
//
//        for (Game game : list) {
//            if(game.)
//        }
//    }

    @GetMapping("/game")
    @ResponseBody
    public String getGame(@RequestParam("id") int id) {
        ArrayList<Game> list = db.getGames();
        Game g = null;

        for (Game game : list) {
            if (game.getId() == id) {
                g = game;
            }
        }

        return g.toString();
    }


}
