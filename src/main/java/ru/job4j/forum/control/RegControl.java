package ru.job4j.forum.control;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.job4j.forum.Main;
import ru.job4j.forum.model.User;
import ru.job4j.forum.service.UserService;

import java.util.List;

@Controller
public class RegControl {
    private final PasswordEncoder encoder;
    private final UserService users;
    private final InMemoryUserDetailsManager inMemoryUserDetailsManager;

    public RegControl(PasswordEncoder encoder,
                      UserService users,
                      InMemoryUserDetailsManager inMemoryUserDetailsManager) {
        this.encoder = encoder;
        this.users = users;
        this.inMemoryUserDetailsManager = inMemoryUserDetailsManager;
    }

    @GetMapping("/reg")
    public String reg() {
        return "reg";
    }

    @PostMapping("/reg")
    public String register(@ModelAttribute User user, Model model) {
        System.out.println("RegControl trying to save user: " + user);
        user.setEnabled(true);
        user.setPassword((user.getPassword()));
        try {
            users.save(user);
        } catch (Exception e) {
            model.addAttribute("errorMessage", "User with such email already exists, please, submit different email");
            return reg();
        }
        inMemoryUserDetailsManager.createUser(
                org.springframework.security.core.userdetails.User
                        .withUsername(user.getUsername())
                        .password((user.getPassword()))
                        .roles("USER")
                        .build());

        System.out.println("User-" + user.getUsername() + " just registered, its status = " + inMemoryUserDetailsManager.userExists(user.getUsername()));
        System.out.println("All registered users: " + users.getUsers().values());
        return "redirect:/login";
    }
}
