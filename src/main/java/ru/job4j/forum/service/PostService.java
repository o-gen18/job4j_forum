package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Comment;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.model.User;
import ru.job4j.forum.repository.PostRepository;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PostService {
    private final PostRepository posts;

    public PostService(PostRepository posts) {
        this.posts = posts;
    }

    public Iterable<Post> getAll() {
        return posts.findAll();
    }

    public void addComment(String comment) {

    }

    public Post save(Post post) {
        return posts.save(post);
    }

    public Post findPostById(int id) {
        return posts.findById(id).orElse(null);
    }
}