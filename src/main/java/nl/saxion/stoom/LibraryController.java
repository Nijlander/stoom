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
public class LibraryController extends Database{

    private ArrayList<Game> ownedGames = getOwnedGames();
    private ArrayList<Music> ownedMusic = getOwnedMusic();
    private ArrayList<Movie> ownedMovies = getOwnedMovies();

    @GetMapping("/{filter}")
    public String getLibrary(@PathVariable String filter, Model model, HttpSession session) {
        if (session.getAttribute("username") != null) {
            if (filter.equalsIgnoreCase("games")) {
                model.addAttribute("gameList", getOwnedGames());
                model.addAttribute("type", "games");
            } else if (filter.equalsIgnoreCase("music")) {
                model.addAttribute("musicList", getOwnedMusic());
                model.addAttribute("type", "music");
            } else if (filter.equalsIgnoreCase("movies")) {
                model.addAttribute("movieList", getOwnedMovies());
                model.addAttribute("type", "movies");
            }

            return "library";
        }

        return "redirect:/logout";
    }
}
