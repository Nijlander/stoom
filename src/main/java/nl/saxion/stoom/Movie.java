package nl.saxion.stoom;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/store/movie")
public class Movie {

    @GetMapping("")
    public String movies(Model model){
        model.addAttribute("movie", "test");
        return "store";
    }
}
