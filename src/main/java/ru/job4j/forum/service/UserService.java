package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.User;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class UserService {
    private final Map<Integer, User> users = new ConcurrentHashMap<>();
    private final AtomicInteger counter = new AtomicInteger(0);

    public UserService() {
        User admin = new User();
        admin.setUsername("Admin");
        admin.setEmail("Admin@mail.com");
        admin.setEnabled(true);
        admin.setId(1);
        admin.setPassword("123");
        users.put(counter.incrementAndGet(), admin);
    }

    public Map<Integer, User> getUsers() {
        return users;
    }

    public User save(User user) {
        user.setId(counter.incrementAndGet());
        users.put(user.getId(), user);
        return user;
    }

    public User findUserById(int id) {
        return users.get(id);
    }
}
