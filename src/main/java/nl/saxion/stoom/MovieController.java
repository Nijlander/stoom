package nl.saxion.stoom;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
@RequestMapping("/store/movies")
public class MovieController extends Database {

    /**
     * returns all movies that are stored in the database
     *
     * @param model   model for routing and databinding
     * @param session for accessibilty check
     * @return
     */
    @GetMapping("/all")
    public String getMovies(Model model, HttpSession session) {
        if (session.getAttribute("username") != null) {
            model.addAttribute("filter", "All Movies");
            model.addAttribute("filterUrl", "all");
            model.addAttribute("allMovies", getMovies());

            return "movies";
        }
        return "redirect:/logout";
    }

    /**
     * returns all movies that fall under a certain genre
     *
     * @param genre   genre specified in the URI
     * @param model   model for routing and data binding
     * @param session for accessibility check
     * @return
     */
    @GetMapping("/{genre}")
    public String getMoviesByGenre(@PathVariable String genre, Model model, HttpSession session) {
        if (session.getAttribute("username") != null) {
            ArrayList<Movie> list = new ArrayList<>();

            for (Movie movie : getMovies()) {
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
     * returns a movie that falls under a specific id and category
     *
     * @param id      specified in the URI
     * @param genre   specified in the URI
     * @param model   model for routing and data binding
     * @param session for accessibility check
     * @return
     */
    @GetMapping("/{genre}/movie")
    public String getMovieByGenre(@RequestParam("id") int id, @PathVariable("genre") String genre, Model model, HttpSession session) {
        if (session.getAttribute("username") != null) {
            ArrayList<Movie> list = new ArrayList<>();
            Movie m = null;

            for (Movie movie : getMovies()) {
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
     * @param id      id specified in the URI
     * @param model   model for routing and data binding
     * @param session for accessibility check
     * @return
     */
    @GetMapping("/all/movie")
    public String getMovieById(@RequestParam("id") int id, Model model, HttpSession session) {
        if (session.getAttribute("username") != null) {
            Movie m = null;

            for (Movie movie : getMovies()) {
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
     * stores a movie in the owned movies list
     *
     * @param id      id specified in the URI
     * @param model   model for routing and data binding
     * @param session for accessibility check
     * @return
     */
    @GetMapping("/buy")
    public String buyMovie(@RequestParam("id") int id, Model model, HttpSession session) {
        if (session.getAttribute("username") != null) {
            Movie m = null;

            for (Movie movie : getMovies()) {
                if (movie.getId() == id) {
                    m = movie;
                }
            }

            buyMovie(m);

            model.addAttribute("productType", "movies");
            model.addAttribute("login", false);

            return "reroute";
        }
        return "redirect:/logout";
    }

    /**
     * returns the add movie page
     *
     * @param session for accessibility check
     * @return
     */
    @GetMapping("/add")
    public String getAddPage(HttpSession session) {
        if (session.getAttribute("username") != null) {
            return "addmovie";
        }
        return "redirect:/logout";
    }

    /**
     * adds a new movie to the movies list stored in the database
     *
     * @param movie   movie that needs to be stored
     * @param model   model for routing and data binding
     * @param session for accessibility check
     * @return
     */
    @PostMapping("/add")
    public String addMovie(Movie movie, Model model, HttpSession session) {
        if (session.getAttribute("username") != null) {
            movie.setId(getMovies().get(getMovies().size() - 1).getId() + 1);

            addMovie(movie);

            model.addAttribute("productType", "movies");
            model.addAttribute("login", false);

            return "reroute";
        }
        return "redirect:/logout";
    }
}
