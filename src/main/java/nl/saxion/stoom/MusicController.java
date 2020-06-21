package nl.saxion.stoom;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
@RequestMapping("/store/music")
public class MusicController extends Database {

    /**
     * returns all the music stored in the database
     *
     * @param model   model for routing and data binding
     * @param session for accessibility check
     * @return
     */
    @GetMapping("/all")
    public String getMusic(Model model, HttpSession session) {
        if (session.getAttribute("username") != null) {
            model.addAttribute("filter", "All Music");
            model.addAttribute("filterUrl", "all");
            model.addAttribute("allMusic", getMusic());

            return "music";
        }
        return "redirect:/logout";
    }

    /**
     * returns all the music that falls under a specific genre
     *
     * @param genre   genre specified in URI
     * @param model   model for routing and data binding
     * @param session for accessibility check
     * @return
     */
    @GetMapping("/{genre}")
    public String getMusicByGenre(@PathVariable String genre, Model model, HttpSession session) {
        if (session.getAttribute("username") != null) {
            ArrayList<Music> list = new ArrayList<>();

            for (Music music : getMusic()) {
                if (music.getGenre().equalsIgnoreCase(genre)) {
                    list.add(music);
                }
            }

            model.addAttribute("filter", genre.substring(0, 1).toUpperCase() + genre.substring(1));
            model.addAttribute("filterUrl", genre.toLowerCase());
            model.addAttribute("allMusic", list);

            return "music";
        }
        return "redirect:/logout";
    }

    /**
     * returns a song that falls under a specific genre and id
     *
     * @param id      id specified in the URI
     * @param genre   genre specified in the URI
     * @param model   model for routing and data binding
     * @param session for accessibility check
     * @return
     */
    @GetMapping("/{genre}/music")
    public String getMusicByGenre(@RequestParam("id") int id, @PathVariable("genre") String genre, Model model, HttpSession session) {
        if (session.getAttribute("username") != null) {
            ArrayList<Music> list = new ArrayList<>();
            Music m = null;

            for (Music music : getMusic()) {
                if (music.getGenre().equalsIgnoreCase(genre)) {
                    list.add(music);
                }
            }

            for (Music music : list) {
                if (music.getId() == id) {
                    m = music;
                }
            }

            model.addAttribute("music", m);
            model.addAttribute("lastPage", genre.toLowerCase());

            return "song";
        }
        return "redirect:/logout";
    }

    /**
     * returns a song that falls under a specific id
     *
     * @param id      id specified in the URI
     * @param model   model for routing and data binding
     * @param session for accessibility check
     * @return
     */
    @GetMapping("/all/music")
    public String getMusicById(@RequestParam("id") int id, Model model, HttpSession session) {
        if (session.getAttribute("username") != null) {
            Music m = null;

            for (Music music : getMusic()) {
                if (music.getId() == id) {
                    m = music;
                }
            }

            model.addAttribute("music", m);
            model.addAttribute("lastPage", "all");

            return "song";
        }
        return "redirect:/logout";
    }

    /**
     * stores a song into the owned songs list
     *
     * @param id      id specified in the URI
     * @param model   model for routing and data binding
     * @param session for accessibility check
     * @return
     */
    @GetMapping("/buy")
    public String buyMusic(@RequestParam("id") int id, Model model, HttpSession session) {
        if (session.getAttribute("username") != null) {
            Music m = null;

            for (Music music : getMusic()) {
                if (music.getId() == id) {
                    m = music;
                }
            }

            buyMusic(m);

            model.addAttribute("productType", "music");
            model.addAttribute("login", false);

            return "reroute";
        }
        return "redirect:/logout";
    }

    /**
     * returns the add music page
     *
     * @param session for accessibility check
     * @return
     */
    @GetMapping("/add")
    public String getAddPage(HttpSession session) {
        if (session.getAttribute("username") != null) {
            return "addmusic";
        }
        return "redirect:/logout";
    }

    /**
     * adds a new song into the music list stored in the database
     *
     * @param song    song that needs to be stored
     * @param model   model for routing and data binding
     * @param session for accessibility check
     * @return
     */
    @PostMapping("/add")
    public String addMusic(Music song, Model model, HttpSession session) {
        if (session.getAttribute("username") != null) {
            song.setId(getMusic().get(getMusic().size() - 1).getId() + 1);

            addMusic(song);

            model.addAttribute("productType", "music");
            model.addAttribute("login", false);

            return "reroute";
        }
        return "redirect:/logout";
    }
}
