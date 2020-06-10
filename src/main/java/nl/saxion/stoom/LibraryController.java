package nl.saxion.stoom;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/library")
public class LibraryController {

    public String testing(){
        return "Hello this is a test";
    }

}
