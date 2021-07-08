package ru.job4j.forum.control;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.forum.model.Comment;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.model.User;
import ru.job4j.forum.service.AuthorityService;
import ru.job4j.forum.service.PostService;
import ru.job4j.forum.service.UserService;

@Controller
public class PostControl {
    private final PostService posts;
    private final UserService users;

    public PostControl(PostService posts, UserService users) {
        this.posts = posts;
        this.users = users;
    }

    private User findUserByPrincipal() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        org.springframework.security.core.userdetails.User springUser =
                (org.springframework.security.core.userdetails.User) auth.getPrincipal();

        return users.findByUsername(springUser.getUsername());
    }

    @GetMapping("/post")
    public String post(@RequestParam(value = "id") int id, Model model) {
        Post post = posts.findPostById(id);
        model.addAttribute("post", post);
        return "post";
    }

    @GetMapping("/create")
    public String edit() {
        return "edit";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Post post) {
        User user = findUserByPrincipal();
        user.addPost(post);
        post.setAuthor(user);
        posts.save(post);
        return "redirect:/";
    }

    @PostMapping("/comment")
    public String leaveComment(@ModelAttribute Comment comment,
                               @RequestParam(name = "postId") int postId,
                               Model model) {
        Post post = posts.findPostById(postId);
        User user = findUserByPrincipal();
        comment.setAuthor(user);
        post.addComment(comment);
        posts.save(post);
        model.addAttribute("post", post);
        return "post";
    }
}
