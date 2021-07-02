package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Comment;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.model.User;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class PostService {
    private final Map<Integer, Post> posts = new ConcurrentHashMap<>();
    private final AtomicInteger counter = new AtomicInteger(0);

    public PostService() {
        User author = new User();
        author.setUsername("Petr");
        Post post = Post.of("I sell the car Lada");
        post.setDesc("5 year-old car. The car has always been well-maintained. No damages at all. ");
        post.setAuthor(author);
        User commenter = User.of("Michael");
        User commenter2 = User.of("Tom");
        post.setComments(Map.of(commenter, List.of(Comment.of("First comment", commenter)),
                                commenter2, List.of(Comment.of("Tom comments the text", commenter2))));
        save(post);
    }

    public Collection<Post> getAll() {
        return posts.values();
    }

    public void addComment(String comment) {

    }

    public Post save(Post post) {
        post.setId(counter.incrementAndGet());
        posts.put(post.getId(), post);
        return post;
    }

    public Post findPostById(int id) {
        return posts.get(id);
    }

    public List<Comment> getCommentsForPostAsList(Post post) {
        return post.getComments().values()
                .stream()
                .flatMap(List::stream)
                .sorted(Comparator.comparing(Comment::getCreated))
                .collect(Collectors.toList());
    }
}