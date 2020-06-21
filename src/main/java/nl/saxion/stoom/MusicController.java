package nl.saxion.stoom;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
@RequestMapping("/store/music")
public class MusicController extends Database {

    private ArrayList<Music> music = getMusic();
    private ArrayList<Music> owned = getOwnedMusic();

    /**
     * returns all music when the user travels to /store/music/all
     *
     * @return list of music
     */
    @GetMapping("/all")
    public String getMusic(Model model, HttpSession session) {
        if (session.getAttribute("username") != null) {
            model.addAttribute("filter", "All Music");
            model.addAttribute("filterUrl", "all");
            model.addAttribute("allMusic", music);

            return "music";
        }

        return "redirect:/logout";
    }

    /**
     * returns all music that falls under a certain category when the users travels /store/music/{genre}
     *
     * @param genre wildcard indicating the category that needs to be used
     * @return list of music
     */
    @GetMapping("/{genre}")
    public String getMusicByGenre(@PathVariable String genre, Model model, HttpSession session) {
        if (session.getAttribute("username") != null) {
            ArrayList<Music> list = new ArrayList<>();

            for (Music music : music) {
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
     * returns a song that falls under a specific category and id when the user travels to /store/music/{category}/music?id={id}
     *
     * @param id    the id of the song that needs to be shown
     * @param genre the genre the song falls under
     * @return the selected song
     */
    @GetMapping("/{genre}/music")
    public String getMusicByGenre(@RequestParam("id") int id, @PathVariable("genre") String genre, Model model, HttpSession session) {
        if (session.getAttribute("username") != null) {
            ArrayList<Music> list = new ArrayList<>();
            Music m = null;

            for (Music music : music) {
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
     * @param id the id of the song
     * @return the specified song
     */
    @GetMapping("/all/music")
    public String getMusicById(@RequestParam("id") int id, Model model, HttpSession session) {
        if (session.getAttribute("username") != null) {
            Music m = null;

            for (Music music : music) {
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
     * stores a song into the library
     *
     * @param id id of the song that needs to be stored
     */
    @GetMapping("/buy")
    public String buyMusic(@RequestParam("id") int id, Model model, HttpSession session) {
        if (session.getAttribute("username") != null) {
            Music m = null;

            for (Music music : music) {
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
     * @return page that needs to be shown
     */
    @GetMapping("/add")
    public String getAddPage(HttpSession session) {
        if (session.getAttribute("username") != null) {
            return "addmusic";
        }

        return "redirect:/logout";
    }

    /**
     * adds the entered information into a song and saves it to the database
     *
     * @param song    song that needs to be saved
     * @param model   model needed for routing purposes
     * @param session session needed for authentication
     * @return
     */
    @PostMapping("/add")
    public String addMusic(Music song, Model model, HttpSession session) {
        if (session.getAttribute("username") != null) {
            song.setId(music.get(music.size() - 1).getId() + 1);

            addMusic(song);

            model.addAttribute("productType", "music");
            model.addAttribute("login", false);

            return "reroute";
        }

        return "redirect:/logout";
    }

    @GetMapping("/owned")
    @ResponseBody
    public String getGeOwnedMusic() {
        return owned.toString();
    }


}
