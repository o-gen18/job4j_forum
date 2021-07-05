package ru.job4j.forum.model;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @OneToMany
    private List<Comment> comments;

    @Temporal(TemporalType.TIMESTAMP)
    private Calendar created;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "USER_ID_FK"))
    private User author;

    public Post() {
        this.created = Calendar.getInstance();
    }

    public static Post of(String name) {
        Post post = new Post();
        post.name = name;
        post.created = Calendar.getInstance();
        return post;
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public boolean removeComment(Comment comment) {
        return comments.remove(comment);
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String desc) {
        this.description = desc;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
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
                && Objects.equals(description, post.description)
                && Objects.equals(comments, post.comments)
                && Objects.equals(created, post.created)
                && Objects.equals(author, post.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, comments, created, author);
    }
}
