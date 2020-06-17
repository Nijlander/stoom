package nl.saxion.stoom;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
@RequestMapping("/store")
public class GameController {

    private final Database db = new Database();

    @GetMapping("")
    @ResponseBody
    public String getGames() {
        return db.getGames().toString();
    }

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
