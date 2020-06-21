package nl.saxion.stoom;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
@RequestMapping("/library")
public class LibraryController {

    private Database db = new Database();

    private ArrayList<Music> ownedMusic = db.getOwnedMusic();
    private ArrayList<Game> ownedGames = db.getOwnedGames();
    private ArrayList<Movie> ownedMovies = db.getOwnedMovies();

    @GetMapping("/{filter}")
    public String getLibrary(@PathVariable String filter, Model model, HttpSession session) {
        if (session.getAttribute("username") != null) {
            if (filter.equalsIgnoreCase("games")) {
                model.addAttribute("list", ownedGames);
                model.addAttribute("type", "games");
            } else if (filter.equalsIgnoreCase("music")) {
                model.addAttribute("list", ownedMusic);
                model.addAttribute("type", "music");
            } else if (filter.equalsIgnoreCase("movies")) {
                model.addAttribute("list", ownedMovies);
                model.addAttribute("type", "movies");
            }

            return "library";
        }

        return "redirect:/logout";
    }
}
