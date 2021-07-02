package ru.job4j.forum.model;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Post {
    private int id;
    private String name;
    private String desc;
    private Map<User, List<Comment>> comments = new ConcurrentHashMap<>();
    private Calendar created;
    private User author;

    public static Post of(String name) {
        Post post = new Post();
        post.name = name;
        post.created = Calendar.getInstance();
        return post;
    }

    public void addComment(User author, Comment comment) {
        if (comments.containsKey(author)) {
            comments.get(author).add(comment);
        } else {
            List<Comment> list = new ArrayList<>();
            list.add(comment);
            comments.put(author, list);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Map<User, List<Comment>> getComments() {
        return comments;
    }

    public void setComments(Map<User, List<Comment>> comments) {
        this.comments = comments;
    }

    public Calendar getCreated() {
        return created;
    }

    public void setCreated(Calendar created) {
        this.created = created;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Post post = (Post) o;
        return Objects.equals(name, post.name)
                && id == post.id
                && Objects.equals(desc, post.desc)
                && Objects.equals(comments, post.comments)
                && Objects.equals(created, post.created)
                && Objects.equals(author, post.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, desc, comments, created, author);
    }
}
