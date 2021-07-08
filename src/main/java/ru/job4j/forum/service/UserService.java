package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.User;
import ru.job4j.forum.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository users;

    public UserService(UserRepository users) {
        this.users = users;
    }

    public Iterable<User> getUsers() {
        return users.findAll();
    }

    public User save(User user) {
        return users.save(user);
    }

    public User findUserById(int id) {
        return users.findById(id).orElse(null);
    }

    public User findByUsername(String username) {
        return users.findByUsername(username);
    }
}