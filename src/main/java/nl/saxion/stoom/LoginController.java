package nl.saxion.stoom;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
@RequestMapping("")
public class LoginController extends Database {


    private ArrayList<Account> accounts = getAccounts();

    @GetMapping("")
    public String getLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String login(Account filledCredentials, Model model, HttpSession session) {

        for (Account a : accounts) {
            if (a.getUsername().equals(filledCredentials.getUsername()) && a.getPassword().equals(filledCredentials.getPassword())) {

                session.setAttribute("username", a.getUsername());

                model.addAttribute("productType", "games");
                model.addAttribute("login", true);

                return "reroute";
            }
        }

        return "login";
    }

    @GetMapping("logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

}
