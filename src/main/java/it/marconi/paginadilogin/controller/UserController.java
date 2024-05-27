package it.marconi.paginadilogin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/utente")
public class UserController {

    @GetMapping
    public String showForm(@RequestParam String type, Model model) {
        if ("new".equalsIgnoreCase(type)) {
            model.addAttribute("titolo", "Registrazione Nuovo Utente");
            return "register";
        } else if ("login".equalsIgnoreCase(type)) {
            model.addAttribute("titolo", "Login Utente");
            return "login";
      
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String nickname, @RequestParam String email, @RequestParam String password, Model model) {
        model.addAttribute("nickname", nickname);
        model.addAttribute("email", email);
        return "recap";
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam String nickname, @RequestParam String password, Model model) {
        model.addAttribute("nickname", nickname);
        return "recap";
    }
}
}
