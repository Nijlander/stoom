package nl.saxion.stoom;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/store/music")
public class MusicController {

    private final Database db = new Database();
    private ArrayList<Music> music = db.getMusic();
    private ArrayList<Music> owned = db.getOwnedMusic();

    /**
     * returns all music when the user travels to /store/music/all
     *
     * @return list of music
     */
    @GetMapping("/all")
    @ResponseBody
    public String getMusic() {
        return music.toString();
    }

    /**
     * returns all music that falls under a certain category when the users travels /store/music/{genre}
     *
     * @param genre wildcard indicating the category that needs to be used
     * @return list of music
     */
    @GetMapping("/{genre}")
    @ResponseBody
    public String getMusicByGenre(@PathVariable String genre) {
        ArrayList<Music> list = new ArrayList<>();

        for (Music music : music) {
            if (music.getGenre().equalsIgnoreCase(genre)) {
                list.add(music);
            }
        }

        return list.toString();
    }

    /**
     * returns a song that falls under a specific category and id when the user travels to /store/music/{category}/music?id={id}
     *
     * @param id    the id of the song that needs to be shown
     * @param genre the genre the song falls under
     * @return the selected song
     */
    @GetMapping("/{genre}/music")
    @ResponseBody
    public String getMusicByGenre(@RequestParam("id") int id, @PathVariable("genre") String genre) {
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

        return m.toString();
    }

    /**
     * returns a song that falls under a specific id
     *
     * @param id the id of the song
     * @return the specified song
     */
    @GetMapping("/all/music")
    @ResponseBody
    public String getMusicById(@RequestParam("id") int id) {
        Music m = null;

        for (Music music : music) {
            if (music.getId() == id) {
                m = music;
            }
        }

        return m.toString();
    }

    /**
     * stores a song into the library
     *
     * @param id id of the song that needs to be stored
     */
    @GetMapping("/buy")
    @ResponseBody
    public void buyMusic(@RequestParam("id") int id) {
        Music m = null;

        for (Music music : music) {
            if (music.getId() == id) {
                m = music;
            }
        }

        db.buyMusic(m);
    }

    @GetMapping("/owned")
    @ResponseBody
    public String getOwnedMusic() {
        return owned.toString();
    }


}
