package ru.job4j.forum.model;

import java.util.List;
import java.util.Objects;

public class User {
    private int id;
    private String username;
    private String password;
    private String email;
    private boolean enabled;
    private List<Post> posts;

    public static User of(String name) {
        User user = new User();
        user.username = name;
        return user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return enabled == user.enabled
                && id == user.id
                && Objects.equals(username, user.username)
                && Objects.equals(password, user.password)
                && Objects.equals(email, user.email)
                && Objects.equals(posts, user.posts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, email, enabled, posts);
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", username='" + username + '\''
                + ", password='" + password + '\'' + ", email='" + email
                + '\'' + ", enabled=" + enabled + ", posts=" + '}' + posts;
    }
}