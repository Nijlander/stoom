package nl.saxion.stoom;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("")
public class LoginController extends Database {

    /**
     * returns the login page
     *
     * @return
     */
    @GetMapping("")
    public String getLogin() {
        return "login";
    }

    /**
     * logs the user in based on credentials that are compared to the ones in the database
     *
     * @param filledCredentials credentials filled by the user
     * @param model             model for routing and data binding
     * @param session           for accessibility check
     * @return
     */
    @PostMapping("/login")
    public String login(Account filledCredentials, Model model, HttpSession session) {
        for (Account a : getAccounts()) {
            if (a.getUsername().equals(filledCredentials.getUsername()) && a.getPassword().equals(filledCredentials.getPassword())) {
                session.setAttribute("username", a.getUsername());

                model.addAttribute("productType", "games");
                model.addAttribute("login", true);

                return "reroute";
            }
        }
        return "login";
    }

    /**
     * logs the user out of its session
     *
     * @param session to invalidate the session on logout
     * @return
     */
    @GetMapping("logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

}
