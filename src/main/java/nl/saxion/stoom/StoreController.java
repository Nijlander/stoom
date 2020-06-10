package nl.saxion.stoom;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/store")
public class StoreController {

    @GetMapping("/product")
    @ResponseBody
    public String getProduct(@RequestParam("id") String id) {
        return "Game " + id + " is geselecteerd.";
    }


}
