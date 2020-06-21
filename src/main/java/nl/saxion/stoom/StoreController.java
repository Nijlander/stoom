package nl.saxion.stoom;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/store")
public class StoreController {

    Database db = new Database();

    @GetMapping("")
    public String getStore(Model model, HttpSession session) {
        if (session.getAttribute("username") != null) {
            model.addAttribute("loggedUser", "Welcome, " + session.getAttribute("username"));

            return "store";
        }

        return "redirect:/logout";
    }

    public Database getDb(){
        return db;
    }

}
