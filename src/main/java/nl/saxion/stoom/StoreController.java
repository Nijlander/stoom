package nl.saxion.stoom;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/store")
public class StoreController {

    /**
     * returns the store home page
     *
     * @param model   model for routing and data binding
     * @param session for accessibility check
     * @return
     */
    @GetMapping("")
    public String getStore(Model model, HttpSession session) {
        if (session.getAttribute("username") != null) {
            model.addAttribute("loggedUser", "Welcome, " + session.getAttribute("username"));

            return "store";
        }
        return "redirect:/logout";
    }
}
