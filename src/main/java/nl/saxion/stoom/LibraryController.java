package nl.saxion.stoom;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/library")
public class LibraryController extends Database {

    /**
     * filter controls that determine what type of products are visible
     *
     * @param filter  filter specified in URI
     * @param model   model for routing and data binding
     * @param session for accessibility check
     * @return
     */
    @GetMapping("/{filter}")
    public String getLibrary(@PathVariable String filter, Model model, HttpSession session) {
        if (session.getAttribute("username") != null) {
            if (filter.equalsIgnoreCase("games")) {
                model.addAttribute("gameList", getOwnedGames());
                model.addAttribute("type", "games");
                model.addAttribute("headerTitle", "Your owned games");
            } else if (filter.equalsIgnoreCase("music")) {
                model.addAttribute("musicList", getOwnedMusic());
                model.addAttribute("type", "music");
                model.addAttribute("headerTitle", "Your owned music");
            } else if (filter.equalsIgnoreCase("movies")) {
                model.addAttribute("movieList", getOwnedMovies());
                model.addAttribute("type", "movies");
                model.addAttribute("headerTitle", "Your owned movies");
            }

            return "library";
        }
        return "redirect:/logout";
    }
}
