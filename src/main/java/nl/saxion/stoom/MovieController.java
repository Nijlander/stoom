package nl.saxion.stoom;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
@RequestMapping("/store/movies")
public class MovieController {

    private Database db = new Database();
    private ArrayList<Movie> movies = db.getMovies();
    private ArrayList<Movie> owned = db.getOwnedMovies();

    /**
     * returns all movies when the user travels to /store/movies/all
     *
     * @return list of movies
     */
    @GetMapping("/all")
    public String getMovies(Model model, HttpSession session) {
        if (session.getAttribute("username") != null) {
            model.addAttribute("filter", "All Movies");
            model.addAttribute("filterUrl", "all");
            model.addAttribute("allMovies", movies);

            return "movies";
        }

        return "redirect:/logout";
    }

    /**
     * returns all movies that fall under a certain genre when the users travels to /store/movies/{genre}
     *
     * @param genre wildcard indicating the genre that needs to be used
     * @return list of movies
     */
    @GetMapping("/{genre}")
    public String getMoviesByGenre(@PathVariable String genre, Model model, HttpSession session) {
        if (session.getAttribute("username") != null) {
            ArrayList<Movie> list = new ArrayList<>();

            for (Movie movie : movies) {
                if (movie.getGenre().equalsIgnoreCase(genre)) {
                    list.add(movie);
                }
            }

            model.addAttribute("filter", genre.substring(0, 1).toUpperCase() + genre.substring(1) + " Movies");
            model.addAttribute("filterUrl", genre.toLowerCase());
            model.addAttribute("allMovies", list);

            return "movies";
        }

        return "redirect:/logout";
    }

    /**
     * returns a game that falls under a specific genre and id when the user travels to /store/movies/{genre}/movie?id={id}
     *
     * @param id    the id of the movie that needs to be shown
     * @param genre the genre the movie falls under
     * @return the selected movie
     */
    @GetMapping("/{genre}/movie")
    public String getMovieByGenre(@RequestParam("id") int id, @PathVariable("genre") String genre, Model model, HttpSession session) {
        if (session.getAttribute("username") != null) {
            ArrayList<Movie> list = new ArrayList<>();
            Movie m = null;

            for (Movie movie : movies) {
                if (movie.getGenre().equalsIgnoreCase(genre)) {
                    list.add(movie);
                }
            }

            for (Movie movie : list) {
                if (movie.getId() == id) {
                    m = movie;
                }
            }

            model.addAttribute("movie", m);
            model.addAttribute("lastPage", genre.toLowerCase());

            return "movie";
        }

        return "redirect:/logout";
    }

    /**
     * returns a movie that falls under a specific id
     *
     * @param id the id of the movie
     * @return the specified movie
     */
    @GetMapping("/all/movie")
    public String getMovieById(@RequestParam("id") int id, Model model, HttpSession session) {
        if (session.getAttribute("username") != null) {
            Movie m = null;

            for (Movie movie : movies) {
                if (movie.getId() == id) {
                    m = movie;
                }
            }

            model.addAttribute("movie", m);
            model.addAttribute("lastPage", "all");

            return "movie";
        }

        return "redirect:/logout";
    }

    /**
     * stores a movie into the library
     *
     * @param id id of the movie that needs to be stored
     */
    @GetMapping("/buy")
    public String buyMovie(@RequestParam("id") int id, Model model, HttpSession session) {
        if (session.getAttribute("username") != null) {
            Movie m = null;

            for (Movie movie : movies) {
                if (movie.getId() == id) {
                    m = movie;
                }
            }

            db.buyMovie(m);

            model.addAttribute("productType", "movies");
            model.addAttribute("login", false);

            return "reroute";
        }

        return "redirect:/logout";
    }

    @GetMapping("/owned")
    @ResponseBody
    public String getOwnedMovies() {
        return owned.toString();
    }
}
